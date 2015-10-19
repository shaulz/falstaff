"use strict";
window.addEventListener('load',	function() {
		var files;
		var sender;
		var size;
		var index;
		var processStatus;
		var XHR;
		var createStartDate;
		
		function abortCreate(msg) {
			if (sender != null && sender.fileReader != null) {
				sender.fileReader.onerror = null;
				sender.fileReader.onload = null;
			}
			if (sender != null && sender.fileReader != null && sender.fileReader.readyState == FileReader.LOADING) {
				sender.fileReader.abort();
			}
			if (XHR != null) {
				XHR.removeEventListener("load", uploadCompleteHandler, false);
				XHR.removeEventListener("error", uploadFailedHandler, false);
				XHR.abort();
			}
			document.getElementById("progress-text").innerHTML = "Samples create cancleled at " + Date() + " " + msg;
			alert(msg);
			processStatus = "IDLE";
		}
		
		function cancelCreate() {
			abortCreate("Create samples canceled by user.");
		}
				
		function uploadCompleteHandler(evt) {
			if (index == files.length) {
				document.open("text/html","replace");
				document.write(evt.target.responseText);
				document.close();
			}
			else {
				var percentComplete = Math.round(index * 100 / files.length);
				if (percentComplete < 100) {
				    document.getElementById("progress-bar").innerHTML = percentComplete + '%';
				    document.getElementById("progress-text").innerHTML = "create samples started at " + createStartDate + " uploaded files " + index;
				    document.getElementById("progress-bar").setAttribute("aria-valuenow", percentComplete);
				    document.getElementById("progress-bar").style.width = percentComplete + "%";
				}
				
				sendData();
			}
		}

		function uploadFailedHandler(evt) {
			abortCreate("An error occurred while transferring files with error status " + evt.target.status);
		}

		function uploadCanceledHandler(evt) {
			abortCreate("The transfer has been canceled by the user.");
		}
		
		function readEndHandler() {	
			try {				
				size += sender.bytes.length;
				sender.appendData();
				index++;
				
				if (size > 5 * 1024 * 1024 || index == files.length) {
					XHR = new XMLHttpRequest();
				
					XHR.addEventListener("load", uploadCompleteHandler, false);
					XHR.addEventListener("error", uploadFailedHandler, false);

					// We setup our request
					sender.sendData(XHR, document.getElementById("samplesCreateForm").action);
				
					size = 0;
				}
				else {
					sendData();
				}
			}
			catch(err) {
					abortCreate("File upload failed " + err.message);
    		}
		}
		
		function sendData() {
			try {
				if (index == files.length) {
					return;
				}
			
				sender.setFile(files[index]);
				console.log("reading file " + sender.getFile().name);
								    		       
				sender.readFile(0, sender.getFile().size, readEndHandler, abortCreate);	
			}
			catch(err) {
				abortCreate("File reading failed " + err.message);
			}
		}
		
		// At least, We need to access our form
		var form = document.getElementById("samplesCreateForm");
		
		document.getElementById("cancel").addEventListener("click", cancelCreate);

		// to take over the submit event
		form.addEventListener('submit', function(event) {
			event.preventDefault();
			if (processStatus == "RUNNING") {
				alert("another identifications create process is already running.");
				return;
			}
			
			processStatus = "RUNNING";
			
			files = document.getElementById("files").files;
						    
			size = 0;
			index = 0;
						
			createStartDate = new Date();
			document.getElementById("progress-bar").innerHTML = '0%';
			document.getElementById("progress-text").innerHTML = "create samples started at " + createStartDate;
			document.getElementById("progress-bar").setAttribute("aria-valuenow", 0);
			document.getElementById("progress-bar").style.width = "0%";

			var progressContainer = document.getElementById("progressContainer");
			progressContainer.style.visibility='visible';
			document.getElementById("progressBarContainer").style.visibility='visible';

			sender = new blobSender();
			
			sendData();
		});
	});