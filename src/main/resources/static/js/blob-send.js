"use strict";

XMLHttpRequest.prototype.sendAsBinary = function(datastr) {
	//function byteValue(x) {
	//	return x.charCodeAt(0) & 0xff;
	//}
	//var ords = Array.prototype.map.call(datastr, byteValue);
	//var ui8a = new Uint8Array(ords);
	var buf = new ArrayBuffer(datastr.length); 
	var bufView = new Uint8Array(buf);
	for (var i = 0, strLen = datastr.length; i < strLen; i++) {
	     bufView[i] = datastr.charCodeAt(i) & 0xff;
	}
	this.send(bufView.buffer);
}

function ab2str(buf) {
	var ab = new Uint8Array(buf);
	return String.fromCharCode.apply(null, ab);
}

function encodeUtf8(s) {
	return unescape(encodeURIComponent(s));
}

function decodeUtf8(s) {
	return decodeURIComponent(escape(s));
}

function blobSender() {
	this.boundary = "blob";
	this.fileIndex = 0;
	this.bytes = "";
	this.data = "";
	this.chunkSize = 17 * 1024;
	
	this.appendBuffer = function(ab) {
		this.bytes += ab2str(ab);
	}
	
	this.appendData = function() {
		var name = "files" + this.fileIndex;
		
		// We start a new part in our body's request
		this.data += "--" + this.boundary + "\r\n";

		// We said it's form data (it could be something else)
		this.data += 'content-disposition: form-data; '
		// We define the name of the form data
		+ 'name="' + name + '"; '
		// We provide the real name of the file
		+ 'filename="' + encodeUtf8(this.file.name) + '"\r\n';
		// We provide the mime type of the file
		// data += 'Content-Type: ' + identificationFile.dom.files[0].type + '\r\n';
		this.data += 'Content-Type: '
				+ 'application/octet-stream; charset=UTF-8' + '\r\n';
		// There is always a blank line between the meta-data and the data
		this.data += '\r\n';
		
		this.data += this.bytes;
		
		this.data += '\r\n';
		
		// For text data, it's simpler
		// We start a new part in our body's request
		this.data += "--" + this.boundary + "\r\n";

		// We said it's form data and give it a name
		this.data += 'content-disposition: form-data; name="' + name + '.modificationDate' + '"\r\n';
		// There is always a blank line between the meta-data and the data
		this.data += '\r\n';

		// We happen the text data to our body's request
		this.data += this.file.lastModifiedDate.getTime() + "\r\n";
		
		// We start a new part in our body's request
		this.data += "--" + this.boundary + "\r\n";
		
		// We said it's form data and give it a name
		this.data += 'content-disposition: form-data; name="' + name + '.originalSize' + '"\r\n';
		// There is always a blank line between the meta-data and the data
		this.data += '\r\n';

		// We happen the text data to our body's request
		this.data += this.file.size + "\r\n";		
	}
	
	this.setFile = function(file) {
		this.fileIndex++;
		this.file = file;
		this.bytes = "";
	}
		
	this.readFile = function(fileStart, fileEnd, readEndHandler, readErrorHandler) {
		if (this.file.size == 0) {
			readEndHandler();
			return;
		}
		var sliceStart = fileStart;
		var sliceEnd = Math.min(sliceStart + this.chunkSize, fileEnd);
		var blob = this.file.slice(sliceStart, sliceEnd);
		var readArray = new Array();
		this.fileReader = new FileReader();
		var _this = this;
		
		this.fileReader.onerror = function readError(evt) {
			var msg = "";
		    switch(evt.target.error.code) {
		      case evt.target.error.NOT_FOUND_ERR:
		    	msg = "File " + _this.file.name + " not found.";
		        break;
		      case evt.target.error.NOT_READABLE_ERR:
		        msg = "File " + _this.file.name + " is not readable.";
		        break;
		      case evt.target.error.ABORT_ERR:
		    	msg = "File " + _this.file.name + " read aborted.";
		        break; // noop
		      default:
		        msg = "An error occurred reading " + _this.file.name + " file.";
		    };
		    readErrorHandler(msg);
		    return;
		 };
		
		this.fileReader.onload = function() {
			var arrayBuffer = _this.fileReader.result;
		    readArray[readArray.length] = ab2str(arrayBuffer);
		    sliceStart = sliceEnd;
		    console.log("reading slice " + sliceStart);
		    if (sliceStart == fileEnd) {
		    	_this.bytes += readArray.join("");
		    	_this.fileReader = null;
		    	readArray = null;
		    	readEndHandler();
		    	return;
		    }
		    sliceEnd = Math.min(sliceStart + _this.chunkSize, fileEnd);
		    blob = _this.file.slice(sliceStart, sliceEnd);
		    _this.fileReader.readAsArrayBuffer(blob);
		};
		this.fileReader.readAsArrayBuffer(blob);
	}
	
	this.getFile = function() {
		return this.file;
	}
	
	this.sendData = function(xhr,url) {
		this.data += "--" + this.boundary + "--";
		xhr.open('POST',url);
		// We add the required HTTP header to handle a multipart form data POST request
		xhr.setRequestHeader('Content-Type','multipart/form-data; charset=UTF-8; boundary=' + this.boundary);
		xhr.setRequestHeader('Content-Length', this.data.length);

		// And finally, We send our data.
		// Due to Firefox's bug 416178, it's required to use sendAsBinary() instead of send()
		xhr.sendAsBinary(this.data);
		
		this.fileIndex = 0;
		this.bytes = "";
		this.data = "";
		this.file = null;
	}
}

