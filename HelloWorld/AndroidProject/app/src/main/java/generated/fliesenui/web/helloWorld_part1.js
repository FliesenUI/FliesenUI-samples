
var helloWorld$controllerReady = false;
var helloWorld$logDebugBuffer = "";
var helloWorld$parameterDTO;

app.controller("helloWorld_Ctrl", function($scope, $mdToast, $mdDialog, $http) {
    helloWorld$setInitialValues();
    $scope.http = $http;

    $scope.showMessage = function (message) {
     if (message.typeID == 201){
             $mdToast.show($mdToast.simple().textContent(message.text).hideDelay(3000));
     } else if (message.typeID == 101) {
         $mdDialog.show(
                   $mdDialog.alert()
                     .parent(angular.element(document.querySelector('screenHelloWorldPanel')))
                     .clickOutsideToClose(true)
                     .title(message.title)
                     .textContent(message.text)
                     .ariaLabel('Info Dialog' + message.title + ", " + message.text)
                     .ok('OK')
                 );
     } else if (message.typeID == 102) {
         $mdDialog.show(
                 $mdDialog.alert()
                 .parent(angular.element(document.querySelector('screenHelloWorldPanel')))
                 .clickOutsideToClose(true)
                 .title("WARNING: " + message.title)
                 .textContent(message.text)
                 .ariaLabel('Warning Dialog' + message.title + ", " + message.text)
                 .ok('OK')
         );
     } else if (message.typeID == 103) {
         $mdDialog.show(
                 $mdDialog.alert()
                 .parent(angular.element(document.querySelector('screenHelloWorldPanel')))
                 .clickOutsideToClose(true)
                 .title("ERROR: " + message.title)
                 .textContent(message.text)
                 .ariaLabel('Warning Dialog' + message.title + ", " + message.text)
                 .ok('OK')
         );
     }
    }
    $scope.showInputDialog = function(referenceID, title, textContent, label, initialValueText, okText, cancelText) {
        var confirm = $mdDialog.prompt()
          .title(title)
          .textContent(textContent)
          .placeholder(label)
          .ariaLabel(label)
          .initialValue(initialValueText)
          .ok(okText)
          .cancel(cancelText);

        $mdDialog.show(confirm).then(function(result) {
            var request = helloWorld$createRequest("onInputDialogResult");
            request.parameters["referenceID"] = referenceID;
            if (typeof result != "undefined"){
                request.parameters["result"] = result;
                helloWorld$executeRequest(request);
            } else {
                request.parameters["result"] = "";
                helloWorld$executeRequest(request);
            }
        }, function() {
            var request = helloWorld$createRequest("onInputDialogResult");
            request.parameters["referenceID"] = referenceID;
            helloWorld$executeRequest(request);
        });
    };

    $scope.showConfirm = function(referenceID, title, textContent, okText, cancelText) {
        var confirm = $mdDialog.confirm()
              .title(title)
              .textContent(textContent)
              .ariaLabel(title)
              .ok(okText)
              .cancel(cancelText);

        $mdDialog.show(confirm).then(function() {
            var request = helloWorld$createRequest("onConfirmDialogResult");
            request.parameters["referenceID"] = referenceID;
            request.parameters["result"] = true;
            helloWorld$executeRequest(request);
        }, function() {
            var request = helloWorld$createRequest("onConfirmDialogResult");
            request.parameters["referenceID"] = referenceID;
            request.parameters["result"] = false;
            helloWorld$executeRequest(request);
        });
    };


    $scope.helloWorld_widgetButtonGreetButtonClicked = function () {
        var request = helloWorld$createRequest("widgetButtonGreetButtonClicked");
        request.parameters["nameTextFieldText"] = $scope.helloWorld_nameTextField_propertyText;
        helloWorld$executeRequest(request);
    }

    setTimeout(function() {if (("WebBrowser" == browserMode) && (!singlePageApp)){helloWorld$executeOnLoadRequest();}}, 0);
    setTimeout(function() {
        if (typeof previewWindow != "undefined") {
            previewWindow.initForPreview();
        } else {
        }
        
        }, 0);

    $scope.imageAssetIDToName = helloWorld$createImageAssetIDToNameMap();
    helloWorld$controllerReady = true;

});

var helloWorld$setInitialValues = function(){
    var scope = angular.element(document.getElementById('screenHelloWorldPanel')).scope();
    scope.helloWorld_titleLabel_propertyText = "Hello World";
    scope.helloWorld_titleLabel_propertyVisible = true;
    scope.helloWorld_nameTextField_propertyText = "";
    scope.helloWorld_nameTextField_propertyLabel = "Your name";
    scope.helloWorld_nameTextField_propertyVisible = true;
    scope.helloWorld_greetButton_propertyText = "Greet";
    scope.helloWorld_greetButton_propertyVisible = true;
    scope.helloWorld_greetingLabel_propertyText = "";
    scope.helloWorld_greetingLabel_propertyVisible = true;
}

var helloWorld$createImageAssetIDToNameMap = function(){
    result = new Object();
    return result;
}

var helloWorld$logDebug = function(message){
//	if (helloWorld$logDebugBuffer.length > 0){
//		console.log("buffered messages:\n" + helloWorld$logDebugBuffer + "\n}");
//	}
//	helloWorld$logDebugBuffer = helloWorld$logDebugBuffer + message + "\n";
    console.log(message);
}

var helloWorld$fromURLParameter = function(urlParameter){
	if (typeof urlParameter != "undefined"){
		if (urlParameter == null){
			return null;
		}
		var objectBase64String = urlParameter.replace(new RegExp("-", 'g'), "+").replace(new RegExp("_", 'g'), "/").replace(new RegExp("~", 'g'), "=");
		var jsonString = atob(objectBase64String);
		return JSON.parse(jsonString);
	} else {
		return null;
	}
}

helloWorld$executeOnLoadRequest = function(){
    var request = helloWorld$createRequest("onLoaded");
    request.parameters["_ClientProperties"] = getClientProperties();
    helloWorld$executeRequest(request);
}

/** called in JavaFX mode by web view when the screen object has been set. Wait until the Angular JS controller is ready and then call onLoad in the listener*/
helloWorld$executeOnLoadWhenControllerIsReady = function(){
    helloWorld$logDebug("executeOnLoadWhenControllerIsReady: helloWorld$controllerReady = " + helloWorld$controllerReady);
    if (helloWorld$controllerReady){
        helloWorld$logDebug("executeOnLoadWhenControllerIsReady: ready");
        helloWorld$executeOnLoadRequest();
        helloWorld$logDebug("executeOnLoadWhenControllerIsReady: called onLoaded");
    } else {
        helloWorld$logDebug("executeOnLoadWhenControllerIsReady: waiting");
        setTimeout(helloWorld$executeOnLoadWhenControllerIsReady(), 200);
    }
}
helloWorld$createRequest = function(actionName){
    request = new Object();
    request.action = actionName;
    request.screenID = "helloWorld";
    request.parameters = new Object();
    return request;
};

helloWorld$executeRequest = function(request){
    //later: add server call and process request here...
    if (browserMode == 'JavaFX'){
        screenManager.onRequest(JSON.stringify(request), null, null);
    } else {
        var scope = angular.element(document.getElementById('screenHelloWorldPanel')).scope();
        scope.http.post("/request", request).then(function (response) {
            if ((response.data != null) && (typeof response.data != "undefined")){
                helloWorld$processReply(JSON.stringify(response.data));
            }
        });
    }
};


helloWorld$setTitleLabel_widgetText = function(text){
    var scope = angular.element(document.getElementById('screenHelloWorldPanel')).scope();
    scope.$apply(function(){
        scope.helloWorld_titleLabel_propertyText = text;
    });
};
helloWorld$getTitleLabel_widgetText = function(){
    var scope = angular.element(document.getElementById('screenHelloWorldPanel')).scope();
    return scope.helloWorld_titleLabel_propertyText;
};


helloWorld$setNameTextField_widgetText = function(text){
    var scope = angular.element(document.getElementById('screenHelloWorldPanel')).scope();
    scope.$apply(function(){
        scope.helloWorld_nameTextField_propertyText = text;
    });
};
helloWorld$getNameTextField_widgetText = function(){
    var scope = angular.element(document.getElementById('screenHelloWorldPanel')).scope();
    return scope.helloWorld_nameTextField_propertyText;
};


helloWorld$setGreetingLabel_widgetText = function(text){
    var scope = angular.element(document.getElementById('screenHelloWorldPanel')).scope();
    scope.$apply(function(){
        scope.helloWorld_greetingLabel_propertyText = text;
    });
};
helloWorld$getGreetingLabel_widgetText = function(){
    var scope = angular.element(document.getElementById('screenHelloWorldPanel')).scope();
    return scope.helloWorld_greetingLabel_propertyText;
};




helloWorld$initForPreview = function(){
    console.log('helloWorld:executing initForPreview in JS!');
    var scope = angular.element(document.getElementById('screenHelloWorldPanel')).scope();
    setTimeout(function() {scope.$digest();}, 0);
}


var helloWorld$findItemWithID = function(scope, variableName, id){
    var list = null;
    var fieldName = null;
    if (list == null){
        return null;
    }
    var length = list.length;
    for (var i = 0; i < length; i++) {
        if (list[i][fieldName] == id){
            return list[i]; 
        }
    }
    return null;
}
var helloWorld$openScreen = function(screenToOpen, openParameter){
    if (singlePageApp) {
        setTimeout(function() {openScreenSinglePageApp(screenToOpen, openParameter);}, 0);
    } else {
        helloWorld$openScreenMultiPageApp(screenToOpen, openParameter);
    }
}
var helloWorld$openScreenMultiPageApp = function(screenToOpen, openParameter){
    var screenToOpenURL = screenToOpen + "_" + htmlFileSuffix + ".html";
    if (typeof openParameter != "undefined") {
        var jsonString = JSON.stringify(openParameter);
        var base64String = btoa(jsonString);
            var urlParameterString = base64String.replace(new RegExp("\\+", 'g'), "-").replace(new RegExp("/", 'g'), "_").replace(new RegExp("=", 'g'), "~");
            var screenToOpenURL = screenToOpenURL + "?parameterDTO=" + urlParameterString;
            console.log("screenToOpenURL via screenToOpen and openParameter = >>" + screenToOpenURL + "<<");
    }
    window.open(screenToOpenURL, "_self");
}

helloWorld$processReply = function(jsonString){
    var reply = JSON.parse(jsonString);
    var scope = angular.element(document.getElementById('screenHelloWorldPanel')).scope();
    for (i = 0, len = reply.dtosToSet.length; i < len; i++) {
        var dtoValue = reply.dtoValues[reply.dtosToSet[i]];
        scope[reply.dtosToSet[i]] = dtoValue;
    }
    for (i = 0, len = reply.objectsToSetValue.length; i < len; i++) {
        var valueToSet = reply.objectSetValueValues[reply.objectsToSetValue[i]];
        this[reply.objectsToSetValue[i]].setValue(valueToSet);
    }
    for (i = 0, len = reply.variablesToSet.length; i < len; i++) { 
        scope[reply.variablesToSet[i]] = reply.variableValues[reply.variablesToSet[i]];
    }
    for (key in reply.selectBoxSelectedIDs) {
        scope[key] = helloWorld$findItemWithID(scope, key, reply.selectBoxSelectedIDs[key]);
    }
    if (reply.message != null){
        scope.showMessage(reply.message);
    }
    for (textEditorName in reply.textHighlighting){
        var lastCursorPos = this[textEditorName].getCursor(); //: clear highlighting
        this[textEditorName].setValue(this[textEditorName].getValue()); //: clear highlighting
        this[textEditorName].setCursor(lastCursorPos); //: clear highlighting
        for (highlightingItemKey in reply.textHighlighting[textEditorName]){
            highlightingItem = reply.textHighlighting[textEditorName][highlightingItemKey];
            this[textEditorName].markText({line:highlightingItem.startLine,ch:highlightingItem.startPosInLine},{line:highlightingItem.endLine,ch:highlightingItem.endPosInLine},{className:highlightingItem.style})
        }
    }
    for (textEditorName in reply.cursorPosValues){
        cursorPosItem = reply.cursorPosValues[textEditorName];
        this[textEditorName].setCursor(cursorPosItem.line, cursorPosItem.posInLine);
        this[textEditorName].focus();
    }

    for (textEditorName in reply.contextAssists){
        contextAssistItem = reply.contextAssists[textEditorName];
        console.log("context assist: contextAssistItem = " + JSON.stringify(contextAssistItem));
        var hintValue = {}
        hintValue.from = {line:contextAssistItem.replaceFrom.line,ch:contextAssistItem.replaceFrom.posInLine};
        hintValue.to = {line:contextAssistItem.replaceTo.line,ch:contextAssistItem.replaceTo.posInLine};
        hintValue.selectedHint = contextAssistItem.selectedItem;
        hintValue.list = [];
        var arrayLength = contextAssistItem.choices.length;
        for (var i = 0; i < arrayLength; i++) {
            var choice = contextAssistItem.choices[i];
            hintValue.list[i] = {displayText: choice.label, text: choice.text}
        }
        console.log("context assist: options = " + JSON.stringify(hintValue));
        this[textEditorName].showHint({hint:function(){return hintValue;}});
    }

    var screenToOpen = reply.screenToOpen;
    if (typeof screenToOpen != "undefined") {
        helloWorld$openScreen(screenToOpen, reply.openParameter);
    }
    var urlToOpen = reply.urlToOpen;
    if (typeof urlToOpen != "undefined") {
        if (browserMode == 'JavaFX') {
            webView.openURL(urlToOpen, reply.openURLInNewWindow);
        } else {
            var target = "_self";
            if (reply.openURLInNewWindow){
                target = "_blank";
            }
            window.open(urlToOpen, target);
        }
    }

    var downloadFileStreamID = reply.downloadFileStreamID;
    if (typeof downloadFileStreamID != "undefined") {
        if (browserMode == 'JavaFX') {
            webView.downloadFile(downloadFileStreamID);
        } else {
            window.open("download/" + downloadFileStreamID, "_blank");
        }
    }

    var inputDialogParameters = reply.inputDialogParameters;
    if (typeof inputDialogParameters != "undefined") {
        scope.showInputDialog(inputDialogParameters.referenceID, inputDialogParameters.title, inputDialogParameters.textContent, inputDialogParameters.label, inputDialogParameters.initialValueText, inputDialogParameters.okText, inputDialogParameters.cancelText);
    }

    var confirmDialogParameters = reply.confirmDialogParameters;
    if (typeof confirmDialogParameters != "undefined") {
        scope.showConfirm(confirmDialogParameters.referenceID, confirmDialogParameters.title, confirmDialogParameters.textContent, confirmDialogParameters.okText, confirmDialogParameters.cancelText);
    }
    setTimeout(function() {scope.$digest();}, 0);

};
