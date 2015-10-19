"use strict";	
window.addEventListener('load',	function() {
		var files;
		var sender;
		var size;
		var index;
		var processStatus;
		var XHR;
		var batchURL;
		var filesIdentified;
		//var intervalHandle;
		var identificationLength = document.getElementById("identificationLength").value;
		var headLength = 0;
		var headStart;
		var tailLength = 0;
		var tailStart;
		var createStartDate;
		
		function abortIdentification(msg) {
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
			document.getElementById("progress-text").innerHTML = "identification cancleled at " + Date() + " " + msg;
			alert(msg);
			processStatus = "IDLE";
		}
		
		function cancelIdentification() {
			abortIdentification("Identification canceled by user.");
		}
				
		function progressHandler(evt) {
			try {
				var identificationResponse = JSON.parse(evt.target.responseText);
				update(identificationResponse);
			}
			catch(err) {
				abortIdentification("Results reading failed " + err.message);
			}
		}
		
		function update(identificationResponse) {
			var identificationsTable = document.getElementById("identificationsTable");
			// create identifications table if such does not exist
			if (identificationsTable == null) {
				createIdentificationTable();
			}
			
			addIdentificationRows(identificationResponse);
			
			filesIdentified += identificationResponse.results.length;
			
			var percentComplete = Math.round(filesIdentified * 100 / files.length);
		    // Increase the progress bar length.
		    if (percentComplete < 100) {
		    	document.getElementById("progress-text").innerHTML = "identification started at " + createStartDate + " files uploaded " + identificationResponse.uploaded + ", files identified " + filesIdentified;
				document.getElementById("progress-bar").innerHTML = percentComplete + '%';
				document.getElementById("progress-bar").setAttribute("aria-valuenow", percentComplete);
				document.getElementById("progress-bar").style.width = percentComplete + "%";
		    }
		    else {
		    	var createEndDate = new Date();
		    	var seconds = (createEndDate.getTime() - createStartDate.getTime())/1000;
		    	document.getElementById("progress-text").innerHTML = "identification completed at " + createEndDate + ", identification took " + seconds + " seconds";
		    	document.getElementById("progressBarContainer").style.visibility='hidden';
		    }
		}
		
		function status() {
			jQuery.ajax({
		         url:    batchURL
		                  + '?operation=read&from=' + filesIdentified,
		         success: function(identificationResponse) {
		        	 		  update(identificationResponse);
		                      //if(filesIdentified == files.length) {
		                      //    clearInterval(intervalHandle);
		                      //    intervalHandle = null;
		                      //    creating = false;
		                      //}
		                  },
		         async:   false
		    });     
		}
		
		function createIdentificationTable() {
			var identificationsTable = document.createElement("table");
			identificationsTable.className = "table table-bordered table-condensed";
			identificationsTable.id = "identificationsTable";
			var header = identificationsTable.createTHead();
		    var row = header.insertRow(0);
		    var cell1 = row.insertCell(0);
		    var cell2 = row.insertCell(1);
		    var cell3 = row.insertCell(2);
		    var cell4 = row.insertCell(3);
		    cell1.innerHTML = "File";
		    cell2.innerHTML = "Format";
		    cell3.innerHTML = "Probability";
		    cell4.innerHTML = "Classifier";
		    var identificationsTbody = document.createElement("tbody");
		    identificationsTbody.id = "identificationsBody";
		    identificationsTable.appendChild(identificationsTbody);
			var identificationsContainer = document.getElementById("identificationsContainer");
			identificationsContainer.appendChild(identificationsTable);
		}
		
		function addIdentificationRows(identificationResponse) {
			var identificationBody = document.getElementById("identificationsBody");
			batchURL = identificationResponse.batchURL;
			for (var i = 0; i < identificationResponse.results.length; i++) {
			    var fileName = identificationResponse.results[i].fileName;
			    var classifierName = identificationResponse.results[i].classifierName;
			    var classifierURL = identificationResponse.results[i].classifierURL;
			    for (var j = 0; j < identificationResponse.results[i].identifications.length; j++) {
			    	var row = identificationBody.insertRow(-1);
			    	var cell1 = row.insertCell(0);
			    	var cell2 = row.insertCell(1);
				    var cell3 = row.insertCell(2);
				    var cell4 = row.insertCell(3);
				    if (j == 0) {
			    		cell1.innerHTML = fileName;
				    }
			    	var formatLink = document.createElement('a');
			    	var linkText = document.createTextNode(identificationResponse.results[i].identifications[j].formatName);
			    	formatLink.appendChild(linkText);
			    	formatLink.href = identificationResponse.results[i].identifications[j].formatURL;
			    	cell2.appendChild(formatLink);
			    	cell3.innerHTML = Math.round(identificationResponse.results[i].identifications[j].probability * 100) / 100;
			    	var classifierLink = document.createElement('a');
			    	var classifierText = document.createTextNode(classifierName);
			    	classifierLink.appendChild(classifierText);
			    	classifierLink.href = classifierURL;
			    	cell4.appendChild(classifierLink);
			    }
			    // file was not identified
			    if (identificationResponse.results[i].identifications.length == 0) {
			    	row = identificationBody.insertRow(-1);
			    	cell1 = row.insertCell(0);
			    	var cell2 = row.insertCell(1);
				    var cell3 = row.insertCell(2);
				    var cell4 = row.insertCell(3);
			    	cell1.innerHTML = fileName;
			    	var classifierLink = document.createElement('a');
			    	var classifierText = document.createTextNode(classifierName);
			    	classifierLink.appendChild(classifierText);
			    	classifierLink.href = classifierURL;
			    	cell4.appendChild(classifierLink);			    	
			    }			    
			}
		}
						
		function uploadCompleteHandler(evt) {
			progressHandler(evt);
			if (index == files.length) {
				if (filesIdentified < files.length) {
					XHR = null;
					
					(function next() {
					    if (filesIdentified == files.length || processStatus == "IDLE") {
					    	if (filesIdentified == files.length) {
					    		processStatus = "IDLE";
					    	}
					    	return;
					    }

					    setTimeout(function() {
					        status();
					        next();
					    }, 1000);
					})();

					//intervalHandle = setInterval(function () {status();}, 1000);
				}
				else {
					processStatus = "IDLE";
				}
			}
			else {
				if (processStatus == "RUNNING") {
					sendData();
				}
			}
		}

		function uploadFailedHandler(evt) {
		  abortIdentification("An error occurred while transferring files with error status " + evt.target.status);
		}
		
		function headReadEndHandler() {
			sender.readFile(tailStart, tailStart + tailLength, readEndHandler, abortIdentification);
		}
		
		function readEndHandler() {			
			size += sender.bytes.length;
			sender.appendData();
			index++;
				
			if (size > 1024 * 1024 || index == files.length) {
				XHR = new XMLHttpRequest();
					
				XHR.addEventListener("load", uploadCompleteHandler, false);
				XHR.addEventListener("error", uploadFailedHandler, false);

				// We setup our request
				var url;
				if (batchURL == null) {
					url = document.getElementById("identificationsCreateForm").action;
				}
				else {
					url = batchURL + '?operation=update&from=' + filesIdentified;
				}

				sender.sendData(XHR, url);
				
				size = 0;
			}
			else {
				sendData();
			}
		}
		
		function sendData() {
			try {
				if (index == files.length) {
					return;
				}
				
				sender.setFile(files[index]);
				console.log("reading file " + sender.getFile().name);
				
				
				headStart = 0;
				tailStart = null;
				
				if (sender.getFile().size >= identificationLength) {
					headLength = identificationLength / 2;
					tailLength = identificationLength - headLength;
					tailStart = sender.getFile().size - tailLength;
				}
				else {
					headLength = sender.getFile().size;
					tailLength = 0;
				}
	

				if (tailLength > 0) {
					sender.readFile(headStart, headStart + headLength, headReadEndHandler, abortIdentification);
				}
				else {
					sender.readFile(headStart, headStart + headLength, readEndHandler, abortIdentification);
				}
				
			}
			catch(err) {
				abortIdentification("File reading failed " + err.message);
			}
		}
		
		// At least, We need to access our form
		var form = document.getElementById("identificationsCreateForm");
		
		// make progress invisible
		var progressContainer = document.getElementById("progressContainer");
		progressContainer.style.visibility='hidden';
		
		document.getElementById("cancel").addEventListener("click", cancelIdentification);

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
						
			filesIdentified = 0;
			
			var identificationsBody = document.getElementById("identificationsBody");
			if (identificationsBody != null) {
				identificationsBody.innerHTML = "";
			}
			batchURL = null;
			createStartDate = new Date();
			document.getElementById("progress-bar").innerHTML = '0%';
			document.getElementById("progress-text").innerHTML = "identification started at " + createStartDate;
			document.getElementById("progress-bar").setAttribute("aria-valuenow", 0);
			document.getElementById("progress-bar").style.width = "0%";
			
			
			//if (intervalHandle != null) {
			//	clearInterval(intervalHandle);
			//}
			
			var progressContainer = document.getElementById("progressContainer");
			progressContainer.style.visibility='visible';
			document.getElementById("progressBarContainer").style.visibility='visible';
			
			sender = new blobSender();
			
			sendData();
		});
	});