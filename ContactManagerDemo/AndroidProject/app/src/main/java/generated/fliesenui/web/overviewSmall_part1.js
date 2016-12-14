
var overviewSmall$controllerReady = false;
var overviewSmall$logDebugBuffer = "";
var overviewSmall$parameterDTO;

app.controller("overviewSmall_Ctrl", function($scope, $mdToast, $mdDialog, $http) {
    overviewSmall$setInitialValues();
    $scope.http = $http;

    $scope.showMessage = function (message) {
     if (message.typeID == 201){
             $mdToast.show($mdToast.simple().textContent(message.text).hideDelay(3000));
     } else if (message.typeID == 101) {
         $mdDialog.show(
                   $mdDialog.alert()
                     .parent(angular.element(document.querySelector('screenOverviewSmallPanel')))
                     .clickOutsideToClose(true)
                     .title(message.title)
                     .textContent(message.text)
                     .ariaLabel('Info Dialog' + message.title + ", " + message.text)
                     .ok('OK')
                 );
     } else if (message.typeID == 102) {
         $mdDialog.show(
                 $mdDialog.alert()
                 .parent(angular.element(document.querySelector('screenOverviewSmallPanel')))
                 .clickOutsideToClose(true)
                 .title("WARNING: " + message.title)
                 .textContent(message.text)
                 .ariaLabel('Warning Dialog' + message.title + ", " + message.text)
                 .ok('OK')
         );
     } else if (message.typeID == 103) {
         $mdDialog.show(
                 $mdDialog.alert()
                 .parent(angular.element(document.querySelector('screenOverviewSmallPanel')))
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
            var request = overviewSmall$createRequest("onInputDialogResult");
            request.parameters["referenceID"] = referenceID;
            if (typeof result != "undefined"){
                request.parameters["result"] = result;
                overviewSmall$executeRequest(request);
            } else {
                request.parameters["result"] = "";
                overviewSmall$executeRequest(request);
            }
        }, function() {
            var request = overviewSmall$createRequest("onInputDialogResult");
            request.parameters["referenceID"] = referenceID;
            overviewSmall$executeRequest(request);
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
            var request = overviewSmall$createRequest("onConfirmDialogResult");
            request.parameters["referenceID"] = referenceID;
            request.parameters["result"] = true;
            overviewSmall$executeRequest(request);
        }, function() {
            var request = overviewSmall$createRequest("onConfirmDialogResult");
            request.parameters["referenceID"] = referenceID;
            request.parameters["result"] = false;
            overviewSmall$executeRequest(request);
        });
    };


    $scope.overviewSmall_widgetButtonNewButtonClicked = function () {
        var request = overviewSmall$createRequest("widgetButtonNewButtonClicked");
        overviewSmall$executeRequest(request);
    }

    $scope.overviewSmall_widgetButtonExportButtonClicked = function () {
        var request = overviewSmall$createRequest("widgetButtonExportButtonClicked");
        overviewSmall$executeRequest(request);
    }

    $scope.overviewSmall_widgetButtonSearchButtonClicked = function () {
        var request = overviewSmall$createRequest("widgetButtonSearchButtonClicked");
        request.parameters["searchNameTextFieldText"] = $scope.overviewSmall_searchNameTextField_propertyText;
        overviewSmall$executeRequest(request);
    }

    $scope.overviewSmall_widgetButtonEditButtonClicked = function () {
        var request = overviewSmall$createRequest("widgetButtonEditButtonClicked");
        request.parameters["selectedContact"] = overviewSmall$getSelectedContact_dto();
        overviewSmall$executeRequest(request);
    }

    $scope.overviewSmall_widgetButtonDeleteButtonClicked = function () {
        var request = overviewSmall$createRequest("widgetButtonDeleteButtonClicked");
        request.parameters["selectedContact"] = overviewSmall$getSelectedContact_dto();
        overviewSmall$executeRequest(request);
    }

    $scope.overviewSmall_widgetButtonCancelButtonClicked = function () {
        var request = overviewSmall$createRequest("widgetButtonCancelButtonClicked");
        overviewSmall$executeRequest(request);
    }

    $scope.overviewSmall_tableContactsTableRowClicked = function (index, event) {
        if (!event.defaultPrevented) {
            var request = overviewSmall$createRequest("onContactsTableRowClicked");
            request.parameters["rowID"] = $scope.contacts.items[index].id;
            overviewSmall$executeRequest(request);
        }
    }
    setTimeout(function() {if (("WebBrowser" == browserMode) && (!singlePageApp)){overviewSmall$executeOnLoadRequest();}}, 0);
    setTimeout(function() {
        if (typeof previewWindow != "undefined") {
            previewWindow.initForPreview();
        } else {
        }
        
        }, 0);

    $scope.imageAssetIDToName = overviewSmall$createImageAssetIDToNameMap();
    overviewSmall$controllerReady = true;

});

var overviewSmall$setInitialValues = function(){
    var scope = angular.element(document.getElementById('screenOverviewSmallPanel')).scope();
    scope.overviewSmall_info_propertyText = "Contact Manager Demo (small screen)";
    scope.overviewSmall_info_propertyVisible = true;
    scope.overviewSmall_newButton_propertyText = "New Contact";
    scope.overviewSmall_newButton_propertyVisible = true;
    scope.overviewSmall_exportButton_propertyText = "Export data";
    scope.overviewSmall_exportButton_propertyVisible = true;
    scope.overviewSmall_searchNameTextField_propertyText = "";
    scope.overviewSmall_searchNameTextField_propertyLabel = "Search name";
    scope.overviewSmall_searchNameTextField_propertyVisible = true;
    scope.overviewSmall_searchButton_propertyText = "Search";
    scope.overviewSmall_searchButton_propertyVisible = true;
    scope.overviewSmall_actionItemInfo_propertyText = "selectedItem";
    scope.overviewSmall_actionItemInfo_propertyVisible = true;
    scope.overviewSmall_editButton_propertyText = "Edit";
    scope.overviewSmall_editButton_propertyVisible = true;
    scope.overviewSmall_deleteButton_propertyText = "Delete";
    scope.overviewSmall_deleteButton_propertyVisible = true;
    scope.overviewSmall_cancelButton_propertyText = "Cancel";
    scope.overviewSmall_cancelButton_propertyVisible = true;
    scope.overviewSmall_tableBar_propertyVisible = true;
    scope.overviewSmall_selectedItemBar_propertyVisible = false;
    scope.overviewSmall_itemActionBar_propertyVisible = false;
}

var overviewSmall$createImageAssetIDToNameMap = function(){
    result = new Object();
    result["colleague"] = "colleague.svg";
    result["company"] = "company.svg";
    result["family"] = "family.svg";
    result["friend"] = "friend.svg";
    return result;
}

var overviewSmall$logDebug = function(message){
//	if (overviewSmall$logDebugBuffer.length > 0){
//		console.log("buffered messages:\n" + overviewSmall$logDebugBuffer + "\n}");
//	}
//	overviewSmall$logDebugBuffer = overviewSmall$logDebugBuffer + message + "\n";
    console.log(message);
}

var overviewSmall$fromURLParameter = function(urlParameter){
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

overviewSmall$executeOnLoadRequest = function(){
    var request = overviewSmall$createRequest("onLoaded");
    request.parameters["_ClientProperties"] = getClientProperties();
    overviewSmall$executeRequest(request);
}

/** called in JavaFX mode by web view when the screen object has been set. Wait until the Angular JS controller is ready and then call onLoad in the listener*/
overviewSmall$executeOnLoadWhenControllerIsReady = function(){
    overviewSmall$logDebug("executeOnLoadWhenControllerIsReady: overviewSmall$controllerReady = " + overviewSmall$controllerReady);
    if (overviewSmall$controllerReady){
        overviewSmall$logDebug("executeOnLoadWhenControllerIsReady: ready");
        overviewSmall$executeOnLoadRequest();
        overviewSmall$logDebug("executeOnLoadWhenControllerIsReady: called onLoaded");
    } else {
        overviewSmall$logDebug("executeOnLoadWhenControllerIsReady: waiting");
        setTimeout(overviewSmall$executeOnLoadWhenControllerIsReady(), 200);
    }
}
overviewSmall$createRequest = function(actionName){
    request = new Object();
    request.action = actionName;
    request.screenID = "overviewSmall";
    request.parameters = new Object();
    return request;
};

overviewSmall$executeRequest = function(request){
    //later: add server call and process request here...
    if (browserMode == 'JavaFX'){
        screenManager.onRequest(JSON.stringify(request), null, null);
    } else {
        var scope = angular.element(document.getElementById('screenOverviewSmallPanel')).scope();
        scope.http.post("/request", request).then(function (response) {
            if ((response.data != null) && (typeof response.data != "undefined")){
                overviewSmall$processReply(JSON.stringify(response.data));
            }
        });
    }
};


overviewSmall$setInfo_widgetText = function(text){
    var scope = angular.element(document.getElementById('screenOverviewSmallPanel')).scope();
    scope.$apply(function(){
        scope.overviewSmall_info_propertyText = text;
    });
};
overviewSmall$getInfo_widgetText = function(){
    var scope = angular.element(document.getElementById('screenOverviewSmallPanel')).scope();
    return scope.overviewSmall_info_propertyText;
};


overviewSmall$setSearchNameTextField_widgetText = function(text){
    var scope = angular.element(document.getElementById('screenOverviewSmallPanel')).scope();
    scope.$apply(function(){
        scope.overviewSmall_searchNameTextField_propertyText = text;
    });
};
overviewSmall$getSearchNameTextField_widgetText = function(){
    var scope = angular.element(document.getElementById('screenOverviewSmallPanel')).scope();
    return scope.overviewSmall_searchNameTextField_propertyText;
};


overviewSmall$setActionItemInfo_widgetText = function(text){
    var scope = angular.element(document.getElementById('screenOverviewSmallPanel')).scope();
    scope.$apply(function(){
        scope.overviewSmall_actionItemInfo_propertyText = text;
    });
};
overviewSmall$getActionItemInfo_widgetText = function(){
    var scope = angular.element(document.getElementById('screenOverviewSmallPanel')).scope();
    return scope.overviewSmall_actionItemInfo_propertyText;
};



overviewSmall$setContacts_dto = function(jsonString){
    var paramObject = JSON.parse(jsonString);
    var scope = angular.element(document.getElementById('screenOverviewSmallPanel')).scope();
    scope.$apply(function(){
        scope.contacts = paramObject;
    });
};
overviewSmall$getContacts_dto = function(){
    var scope = angular.element(document.getElementById('screenOverviewSmallPanel')).scope();
    var result = new Object();
    if (scope.contacts != null){
        result = JSON.parse(JSON.stringify(scope.contacts));
    }
    return JSON.stringify(result);
};
overviewSmall$setSelectedContact_dto = function(jsonString){
    var paramObject = JSON.parse(jsonString);
    var scope = angular.element(document.getElementById('screenOverviewSmallPanel')).scope();
    scope.$apply(function(){
        scope.selectedContact = paramObject;
    });
};
overviewSmall$getSelectedContact_dto = function(){
    var scope = angular.element(document.getElementById('screenOverviewSmallPanel')).scope();
    var result = new Object();
    if (scope.selectedContact != null){
        result = JSON.parse(JSON.stringify(scope.selectedContact));
    }
    return JSON.stringify(result);
};

overviewSmall$initDTOTypeContactForPreview = function(index){
    var result = new Object();
    result.id = "ID" + "(" + index + ")";
    result.typeID = "type1" + "(" + index + ")";
    result.profileImage = "type1" + "(" + index + ")";
    result.typeImageAsset = "family" + "(" + index + ")";
    result.firstname = "John" + "(" + index + ")";
    result.lastname = "Doe" + "(" + index + ")";
    result.phone = "+49 123 12345" + "(" + index + ")";
    result.mobile = "+49 888 12345" + "(" + index + ")";
    result.street = "Mystreet" + "(" + index + ")";
    result.country = "Myland" + "(" + index + ")";
    result.state = "Mystate" + "(" + index + ")";
    result.city = "Mycity" + "(" + index + ")";
    result.postalCode = "1234" + "(" + index + ")";
    result.webSite = "http://www.wikipedia.com" + "(" + index + ")";
    return result;
};
overviewSmall$initDTOTypeContactListForPreview = function(index){
    var result = new Object();
    result.items = [];
    result.items[0] = overviewSmall$initDTOTypeContactForPreview(0);
    result.items[1] = overviewSmall$initDTOTypeContactForPreview(1);
    result.items[2] = overviewSmall$initDTOTypeContactForPreview(2);
    result.items[3] = overviewSmall$initDTOTypeContactForPreview(3);
    result.items[4] = overviewSmall$initDTOTypeContactForPreview(4);
    result.items[5] = overviewSmall$initDTOTypeContactForPreview(5);
    result.items[6] = overviewSmall$initDTOTypeContactForPreview(6);
    result.items[7] = overviewSmall$initDTOTypeContactForPreview(7);
    result.items[8] = overviewSmall$initDTOTypeContactForPreview(8);
    result.items[9] = overviewSmall$initDTOTypeContactForPreview(9);
    return result;
};
overviewSmall$initDTOTypeContactTypeForPreview = function(index){
    var result = new Object();
    result.id = "1" + "(" + index + ")";
    result.label = "type xyz" + "(" + index + ")";
    result.imageAssetID = "myimage" + "(" + index + ")";
    return result;
};
overviewSmall$initDTOTypeContactTypeListForPreview = function(index){
    var result = new Object();
    result.items = [];
    result.items[0] = overviewSmall$initDTOTypeContactTypeForPreview(0);
    result.items[1] = overviewSmall$initDTOTypeContactTypeForPreview(1);
    result.items[2] = overviewSmall$initDTOTypeContactTypeForPreview(2);
    result.items[3] = overviewSmall$initDTOTypeContactTypeForPreview(3);
    result.items[4] = overviewSmall$initDTOTypeContactTypeForPreview(4);
    result.items[5] = overviewSmall$initDTOTypeContactTypeForPreview(5);
    result.items[6] = overviewSmall$initDTOTypeContactTypeForPreview(6);
    result.items[7] = overviewSmall$initDTOTypeContactTypeForPreview(7);
    result.items[8] = overviewSmall$initDTOTypeContactTypeForPreview(8);
    result.items[9] = overviewSmall$initDTOTypeContactTypeForPreview(9);
    return result;
};

overviewSmall$initForPreview = function(){
    console.log('overviewSmall:executing initForPreview in JS!');
    var scope = angular.element(document.getElementById('screenOverviewSmallPanel')).scope();
    scope.contacts = overviewSmall$initDTOTypeContactListForPreview(0);
    scope.selectedContact = overviewSmall$initDTOTypeContactForPreview(0);
    setTimeout(function() {scope.$digest();}, 0);
}


var overviewSmall$findItemWithID = function(scope, variableName, id){
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
var overviewSmall$openScreen = function(screenToOpen, openParameter){
    if (singlePageApp) {
        setTimeout(function() {openScreenSinglePageApp(screenToOpen, openParameter);}, 0);
    } else {
        overviewSmall$openScreenMultiPageApp(screenToOpen, openParameter);
    }
}
var overviewSmall$openScreenMultiPageApp = function(screenToOpen, openParameter){
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

overviewSmall$processReply = function(jsonString){
    var reply = JSON.parse(jsonString);
    var scope = angular.element(document.getElementById('screenOverviewSmallPanel')).scope();
    for (i = 0, len = reply.dtosToSet.length; i < len; i++) {
        var dtoValue = reply.dtoValues[reply.dtosToSet[i]];
        scope[reply.dtosToSet[i]] = dtoValue;
        if (reply.dtosToSet[i] == 'contacts'){
        }
        if (reply.dtosToSet[i] == 'selectedContact'){
        }
    }
    for (i = 0, len = reply.dtosToSet.length; i < len; i++) {
        var dtoValue = reply.dtoValues[reply.dtosToSet[i]];
        if (reply.dtosToSet[i] == 'contacts'){
        }
        if (reply.dtosToSet[i] == 'selectedContact'){
        }
    }
    for (i = 0, len = reply.objectsToSetValue.length; i < len; i++) {
        var valueToSet = reply.objectSetValueValues[reply.objectsToSetValue[i]];
        this[reply.objectsToSetValue[i]].setValue(valueToSet);
    }
    for (i = 0, len = reply.variablesToSet.length; i < len; i++) { 
        scope[reply.variablesToSet[i]] = reply.variableValues[reply.variablesToSet[i]];
    }
    for (key in reply.selectBoxSelectedIDs) {
        scope[key] = overviewSmall$findItemWithID(scope, key, reply.selectBoxSelectedIDs[key]);
    }

    for (key in reply.markdownViewTexts) {
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
        overviewSmall$openScreen(screenToOpen, reply.openParameter);
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
