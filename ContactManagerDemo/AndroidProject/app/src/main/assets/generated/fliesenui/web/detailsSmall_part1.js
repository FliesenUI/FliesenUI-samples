
var detailsSmall$controllerReady = false;
var detailsSmall$logDebugBuffer = "";
var detailsSmall$parameterDTO;

app.controller("detailsSmall_Ctrl", function($scope, $mdToast, $mdDialog, $http) {
    detailsSmall$setInitialValues();
    $scope.http = $http;

    $scope.showMessage = function (message) {
     if (message.typeID == 201){
             $mdToast.show($mdToast.simple().textContent(message.text).hideDelay(3000));
     } else if (message.typeID == 101) {
         $mdDialog.show(
                   $mdDialog.alert()
                     .parent(angular.element(document.querySelector('screenDetailsSmallPanel')))
                     .clickOutsideToClose(true)
                     .title(message.title)
                     .textContent(message.text)
                     .ariaLabel('Info Dialog' + message.title + ", " + message.text)
                     .ok('OK')
                 );
     } else if (message.typeID == 102) {
         $mdDialog.show(
                 $mdDialog.alert()
                 .parent(angular.element(document.querySelector('screenDetailsSmallPanel')))
                 .clickOutsideToClose(true)
                 .title("WARNING: " + message.title)
                 .textContent(message.text)
                 .ariaLabel('Warning Dialog' + message.title + ", " + message.text)
                 .ok('OK')
         );
     } else if (message.typeID == 103) {
         $mdDialog.show(
                 $mdDialog.alert()
                 .parent(angular.element(document.querySelector('screenDetailsSmallPanel')))
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
            var request = detailsSmall$createRequest("onInputDialogResult");
            request.parameters["referenceID"] = referenceID;
            if (typeof result != "undefined"){
                request.parameters["result"] = result;
                detailsSmall$executeRequest(request);
            } else {
                request.parameters["result"] = "";
                detailsSmall$executeRequest(request);
            }
        }, function() {
            var request = detailsSmall$createRequest("onInputDialogResult");
            request.parameters["referenceID"] = referenceID;
            detailsSmall$executeRequest(request);
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
            var request = detailsSmall$createRequest("onConfirmDialogResult");
            request.parameters["referenceID"] = referenceID;
            request.parameters["result"] = true;
            detailsSmall$executeRequest(request);
        }, function() {
            var request = detailsSmall$createRequest("onConfirmDialogResult");
            request.parameters["referenceID"] = referenceID;
            request.parameters["result"] = false;
            detailsSmall$executeRequest(request);
        });
    };


    $scope.detailsSmall_widgetButtonOpenWebSiteButtonClicked = function () {
        var request = detailsSmall$createRequest("widgetButtonOpenWebSiteButtonClicked");
        request.parameters["contact"] = detailsSmall$getContact_dto();
        detailsSmall$executeRequest(request);
    }

    $scope.detailsSmall_widgetButtonSaveButtonClicked = function () {
        var request = detailsSmall$createRequest("widgetButtonSaveButtonClicked");
        request.parameters["contact"] = detailsSmall$getContact_dto();
        request.parameters["typeSelectBoxSelectedID"] = detailsSmall_getTypeSelectBoxSelectedID();
        detailsSmall$executeRequest(request);
    }

    $scope.detailsSmall_widgetButtonCancelButtonClicked = function () {
        var request = detailsSmall$createRequest("widgetButtonCancelButtonClicked");
        detailsSmall$executeRequest(request);
    }

    if (!singlePageApp){
        var queryDict = {}
        location.search.substr(1).split("&").forEach(function(item) {queryDict[item.split("=")[0]] = item.split("=")[1]})
    detailsSmall$parameterDTO = detailsSmall$fromURLParameter(queryDict["parameterDTO"]);
        if (typeof detailsSmall$parameterDTO == "undefined"){
            detailsSmall$parameterDTO = null;
        } else if (detailsSmall$parameterDTO != null){
            $scope.detailsSmall_firstnameTextField_propertyText = detailsSmall$parameterDTO.firstname;
            $scope.detailsSmall_lastnameTextField_propertyText = detailsSmall$parameterDTO.lastname;
            $scope.detailsSmall_phoneTextField_propertyText = detailsSmall$parameterDTO.phone;
            $scope.detailsSmall_mobileTextField_propertyText = detailsSmall$parameterDTO.mobile;
            $scope.detailsSmall_streetTextField_propertyText = detailsSmall$parameterDTO.street;
            $scope.detailsSmall_cityTextField_propertyText = detailsSmall$parameterDTO.city;
            $scope.detailsSmall_postalCodeTextField_propertyText = detailsSmall$parameterDTO.postalCode;
            $scope.detailsSmall_countryTextField_propertyText = detailsSmall$parameterDTO.country;
            $scope.detailsSmall_stateTextField_propertyText = detailsSmall$parameterDTO.state;
            $scope.detailsSmall_webSiteTextField_propertyText = detailsSmall$parameterDTO.webSite;
        }
        $scope.contact = detailsSmall$parameterDTO;
    }

    detailsSmall_setTypeSelectBoxSelectedID = function(selectedID){
        var scope = angular.element(document.getElementById('screenDetailsSmallPanel')).scope();
        scope.detailsSmall_typeSelectBox_selectedItem = detailsSmall$findItemWithID(scope, "detailsSmall_typeSelectBox_selectedItem", selectedID);
    }

    detailsSmall_getTypeSelectBoxSelectedID = function(){
        var scope = angular.element(document.getElementById('screenDetailsSmallPanel')).scope();
        return (typeof scope.detailsSmall_typeSelectBox_selectedItem == "undefined") ? null : scope.detailsSmall_typeSelectBox_selectedItem.id;
    }

    $scope.detailsSmall_typeSelectBox_changed = function (id){
        var request = detailsSmall$createRequest("onTypeSelectBoxChanged");
        request.parameters["rowID"] = id;
        detailsSmall$executeRequest(request);
    }
    setTimeout(function() {if (("WebBrowser" == browserMode) && (!singlePageApp)){detailsSmall$executeOnLoadRequest();}}, 0);
    setTimeout(function() {
        if (typeof previewWindow != "undefined") {
            previewWindow.initForPreview();
        } else {
        }
        
        }, 0);

    $scope.imageAssetIDToName = detailsSmall$createImageAssetIDToNameMap();
    detailsSmall$controllerReady = true;

});

var detailsSmall$setInitialValues = function(){
    var scope = angular.element(document.getElementById('screenDetailsSmallPanel')).scope();
    scope.detailsSmall_info_propertyText = "Contact Details";
    scope.detailsSmall_info_propertyVisible = true;
    scope.detailsSmall_profileImage_propertyVisible = true;
    scope.detailsSmall_typeLabel_propertyText = "Type:";
    scope.detailsSmall_typeLabel_propertyVisible = true;
    scope.detailsSmall_null_propertyVisible = true;
    scope.detailsSmall_firstnameTextField_propertyText = "first";
    scope.detailsSmall_firstnameTextField_propertyLabel = "Firstname:";
    scope.detailsSmall_firstnameTextField_propertyVisible = true;
    scope.detailsSmall_lastnameTextField_propertyText = "last";
    scope.detailsSmall_lastnameTextField_propertyLabel = "Firstname:";
    scope.detailsSmall_lastnameTextField_propertyVisible = true;
    scope.detailsSmall_phoneTextField_propertyText = "phone";
    scope.detailsSmall_phoneTextField_propertyLabel = "Phone:";
    scope.detailsSmall_phoneTextField_propertyVisible = true;
    scope.detailsSmall_mobileTextField_propertyText = "mobile";
    scope.detailsSmall_mobileTextField_propertyLabel = "Mobile:";
    scope.detailsSmall_mobileTextField_propertyVisible = true;
    scope.detailsSmall_streetTextField_propertyText = "street";
    scope.detailsSmall_streetTextField_propertyLabel = "Street:";
    scope.detailsSmall_streetTextField_propertyVisible = true;
    scope.detailsSmall_cityTextField_propertyText = "city";
    scope.detailsSmall_cityTextField_propertyLabel = "City:";
    scope.detailsSmall_cityTextField_propertyVisible = true;
    scope.detailsSmall_postalCodeTextField_propertyText = "postalCode";
    scope.detailsSmall_postalCodeTextField_propertyLabel = "Postal Code:";
    scope.detailsSmall_postalCodeTextField_propertyVisible = true;
    scope.detailsSmall_countryTextField_propertyText = "country";
    scope.detailsSmall_countryTextField_propertyLabel = "Country:";
    scope.detailsSmall_countryTextField_propertyVisible = true;
    scope.detailsSmall_stateTextField_propertyText = "state";
    scope.detailsSmall_stateTextField_propertyLabel = "State:";
    scope.detailsSmall_stateTextField_propertyVisible = true;
    scope.detailsSmall_webSiteTextField_propertyText = "web site";
    scope.detailsSmall_webSiteTextField_propertyLabel = "Web Site:";
    scope.detailsSmall_webSiteTextField_propertyVisible = true;
    scope.detailsSmall_openWebSiteButton_propertyText = "open";
    scope.detailsSmall_openWebSiteButton_propertyVisible = true;
    scope.detailsSmall_saveButton_propertyText = "save";
    scope.detailsSmall_saveButton_propertyVisible = true;
    scope.detailsSmall_cancelButton_propertyText = "cancel";
    scope.detailsSmall_cancelButton_propertyVisible = true;
    scope.detailsSmall_profileImageFileUpload_propertyText = "Upload profile image";
    scope.detailsSmall_profileImageFileUpload_propertyVisible = false;
    scope.detailsSmall_profileImage_propertyImageSource = "";
}

var detailsSmall$createImageAssetIDToNameMap = function(){
    result = new Object();
    result["colleague"] = "colleague.svg";
    result["company"] = "company.svg";
    result["family"] = "family.svg";
    result["friend"] = "friend.svg";
    return result;
}

var detailsSmall$logDebug = function(message){
//	if (detailsSmall$logDebugBuffer.length > 0){
//		console.log("buffered messages:\n" + detailsSmall$logDebugBuffer + "\n}");
//	}
//	detailsSmall$logDebugBuffer = detailsSmall$logDebugBuffer + message + "\n";
    console.log(message);
}

var detailsSmall$fromURLParameter = function(urlParameter){
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

detailsSmall$executeOnLoadRequest = function(){
    var request = detailsSmall$createRequest("onLoaded");
    request.parameters["_ClientProperties"] = getClientProperties();
    request.parameters["contact"] = detailsSmall$getContact_dto();
    detailsSmall$executeRequest(request);
}

/** called in JavaFX mode by web view when the screen object has been set. Wait until the Angular JS controller is ready and then call onLoad in the listener*/
detailsSmall$executeOnLoadWhenControllerIsReady = function(){
    detailsSmall$logDebug("executeOnLoadWhenControllerIsReady: detailsSmall$controllerReady = " + detailsSmall$controllerReady);
    if (detailsSmall$controllerReady){
        detailsSmall$logDebug("executeOnLoadWhenControllerIsReady: ready");
        detailsSmall$executeOnLoadRequest();
        detailsSmall$logDebug("executeOnLoadWhenControllerIsReady: called onLoaded");
    } else {
        detailsSmall$logDebug("executeOnLoadWhenControllerIsReady: waiting");
        setTimeout(detailsSmall$executeOnLoadWhenControllerIsReady(), 200);
    }
}
detailsSmall$createRequest = function(actionName){
    request = new Object();
    request.action = actionName;
    request.screenID = "detailsSmall";
    request.parameters = new Object();
    return request;
};

detailsSmall$executeRequest = function(request){
    //later: add server call and process request here...
    if (browserMode == 'JavaFX'){
        screenManager.onRequest(JSON.stringify(request), null, null);
    } else {
        var scope = angular.element(document.getElementById('screenDetailsSmallPanel')).scope();
        scope.http.post("/request", request).then(function (response) {
            if ((response.data != null) && (typeof response.data != "undefined")){
                detailsSmall$processReply(JSON.stringify(response.data));
            }
        });
    }
};


detailsSmall$setInfo_widgetText = function(text){
    var scope = angular.element(document.getElementById('screenDetailsSmallPanel')).scope();
    scope.$apply(function(){
        scope.detailsSmall_info_propertyText = text;
    });
};
detailsSmall$getInfo_widgetText = function(){
    var scope = angular.element(document.getElementById('screenDetailsSmallPanel')).scope();
    return scope.detailsSmall_info_propertyText;
};


detailsSmall$setTypeLabel_widgetText = function(text){
    var scope = angular.element(document.getElementById('screenDetailsSmallPanel')).scope();
    scope.$apply(function(){
        scope.detailsSmall_typeLabel_propertyText = text;
    });
};
detailsSmall$getTypeLabel_widgetText = function(){
    var scope = angular.element(document.getElementById('screenDetailsSmallPanel')).scope();
    return scope.detailsSmall_typeLabel_propertyText;
};


detailsSmall$setFirstnameTextField_widgetText = function(text){
    var scope = angular.element(document.getElementById('screenDetailsSmallPanel')).scope();
    scope.$apply(function(){
        scope.detailsSmall_firstnameTextField_propertyText = text;
    });
};
detailsSmall$getFirstnameTextField_widgetText = function(){
    var scope = angular.element(document.getElementById('screenDetailsSmallPanel')).scope();
    return scope.detailsSmall_firstnameTextField_propertyText;
};


detailsSmall$setLastnameTextField_widgetText = function(text){
    var scope = angular.element(document.getElementById('screenDetailsSmallPanel')).scope();
    scope.$apply(function(){
        scope.detailsSmall_lastnameTextField_propertyText = text;
    });
};
detailsSmall$getLastnameTextField_widgetText = function(){
    var scope = angular.element(document.getElementById('screenDetailsSmallPanel')).scope();
    return scope.detailsSmall_lastnameTextField_propertyText;
};


detailsSmall$setPhoneTextField_widgetText = function(text){
    var scope = angular.element(document.getElementById('screenDetailsSmallPanel')).scope();
    scope.$apply(function(){
        scope.detailsSmall_phoneTextField_propertyText = text;
    });
};
detailsSmall$getPhoneTextField_widgetText = function(){
    var scope = angular.element(document.getElementById('screenDetailsSmallPanel')).scope();
    return scope.detailsSmall_phoneTextField_propertyText;
};


detailsSmall$setMobileTextField_widgetText = function(text){
    var scope = angular.element(document.getElementById('screenDetailsSmallPanel')).scope();
    scope.$apply(function(){
        scope.detailsSmall_mobileTextField_propertyText = text;
    });
};
detailsSmall$getMobileTextField_widgetText = function(){
    var scope = angular.element(document.getElementById('screenDetailsSmallPanel')).scope();
    return scope.detailsSmall_mobileTextField_propertyText;
};


detailsSmall$setStreetTextField_widgetText = function(text){
    var scope = angular.element(document.getElementById('screenDetailsSmallPanel')).scope();
    scope.$apply(function(){
        scope.detailsSmall_streetTextField_propertyText = text;
    });
};
detailsSmall$getStreetTextField_widgetText = function(){
    var scope = angular.element(document.getElementById('screenDetailsSmallPanel')).scope();
    return scope.detailsSmall_streetTextField_propertyText;
};


detailsSmall$setCityTextField_widgetText = function(text){
    var scope = angular.element(document.getElementById('screenDetailsSmallPanel')).scope();
    scope.$apply(function(){
        scope.detailsSmall_cityTextField_propertyText = text;
    });
};
detailsSmall$getCityTextField_widgetText = function(){
    var scope = angular.element(document.getElementById('screenDetailsSmallPanel')).scope();
    return scope.detailsSmall_cityTextField_propertyText;
};


detailsSmall$setPostalCodeTextField_widgetText = function(text){
    var scope = angular.element(document.getElementById('screenDetailsSmallPanel')).scope();
    scope.$apply(function(){
        scope.detailsSmall_postalCodeTextField_propertyText = text;
    });
};
detailsSmall$getPostalCodeTextField_widgetText = function(){
    var scope = angular.element(document.getElementById('screenDetailsSmallPanel')).scope();
    return scope.detailsSmall_postalCodeTextField_propertyText;
};


detailsSmall$setCountryTextField_widgetText = function(text){
    var scope = angular.element(document.getElementById('screenDetailsSmallPanel')).scope();
    scope.$apply(function(){
        scope.detailsSmall_countryTextField_propertyText = text;
    });
};
detailsSmall$getCountryTextField_widgetText = function(){
    var scope = angular.element(document.getElementById('screenDetailsSmallPanel')).scope();
    return scope.detailsSmall_countryTextField_propertyText;
};


detailsSmall$setStateTextField_widgetText = function(text){
    var scope = angular.element(document.getElementById('screenDetailsSmallPanel')).scope();
    scope.$apply(function(){
        scope.detailsSmall_stateTextField_propertyText = text;
    });
};
detailsSmall$getStateTextField_widgetText = function(){
    var scope = angular.element(document.getElementById('screenDetailsSmallPanel')).scope();
    return scope.detailsSmall_stateTextField_propertyText;
};


detailsSmall$setWebSiteTextField_widgetText = function(text){
    var scope = angular.element(document.getElementById('screenDetailsSmallPanel')).scope();
    scope.$apply(function(){
        scope.detailsSmall_webSiteTextField_propertyText = text;
    });
};
detailsSmall$getWebSiteTextField_widgetText = function(){
    var scope = angular.element(document.getElementById('screenDetailsSmallPanel')).scope();
    return scope.detailsSmall_webSiteTextField_propertyText;
};



detailsSmall$setContact_dto = function(jsonString){
    var paramObject = JSON.parse(jsonString);
    var scope = angular.element(document.getElementById('screenDetailsSmallPanel')).scope();
    scope.$apply(function(){
        scope.contact = paramObject;
        scope.detailsSmall_firstnameTextField_propertyText = paramObject.firstname;
        scope.detailsSmall_lastnameTextField_propertyText = paramObject.lastname;
        scope.detailsSmall_phoneTextField_propertyText = paramObject.phone;
        scope.detailsSmall_mobileTextField_propertyText = paramObject.mobile;
        scope.detailsSmall_streetTextField_propertyText = paramObject.street;
        scope.detailsSmall_cityTextField_propertyText = paramObject.city;
        scope.detailsSmall_postalCodeTextField_propertyText = paramObject.postalCode;
        scope.detailsSmall_countryTextField_propertyText = paramObject.country;
        scope.detailsSmall_stateTextField_propertyText = paramObject.state;
        scope.detailsSmall_webSiteTextField_propertyText = paramObject.webSite;
    });
};
detailsSmall$getContact_dto = function(){
    var scope = angular.element(document.getElementById('screenDetailsSmallPanel')).scope();
    var result = new Object();
    if (scope.contact != null){
        result = JSON.parse(JSON.stringify(scope.contact));
    }
    result.firstname = scope.detailsSmall_firstnameTextField_propertyText;
    result.lastname = scope.detailsSmall_lastnameTextField_propertyText;
    result.phone = scope.detailsSmall_phoneTextField_propertyText;
    result.mobile = scope.detailsSmall_mobileTextField_propertyText;
    result.street = scope.detailsSmall_streetTextField_propertyText;
    result.city = scope.detailsSmall_cityTextField_propertyText;
    result.postalCode = scope.detailsSmall_postalCodeTextField_propertyText;
    result.country = scope.detailsSmall_countryTextField_propertyText;
    result.state = scope.detailsSmall_stateTextField_propertyText;
    result.webSite = scope.detailsSmall_webSiteTextField_propertyText;
    return JSON.stringify(result);
};
detailsSmall$setTypes_dto = function(jsonString){
    var paramObject = JSON.parse(jsonString);
    var scope = angular.element(document.getElementById('screenDetailsSmallPanel')).scope();
    scope.$apply(function(){
        scope.types = paramObject;
    });
};
detailsSmall$getTypes_dto = function(){
    var scope = angular.element(document.getElementById('screenDetailsSmallPanel')).scope();
    var result = new Object();
    if (scope.types != null){
        result = JSON.parse(JSON.stringify(scope.types));
    }
    return JSON.stringify(result);
};

detailsSmall$initDTOTypeContactForPreview = function(index){
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
detailsSmall$initDTOTypeContactListForPreview = function(index){
    var result = new Object();
    result.items = [];
    result.items[0] = detailsSmall$initDTOTypeContactForPreview(0);
    result.items[1] = detailsSmall$initDTOTypeContactForPreview(1);
    result.items[2] = detailsSmall$initDTOTypeContactForPreview(2);
    result.items[3] = detailsSmall$initDTOTypeContactForPreview(3);
    result.items[4] = detailsSmall$initDTOTypeContactForPreview(4);
    result.items[5] = detailsSmall$initDTOTypeContactForPreview(5);
    result.items[6] = detailsSmall$initDTOTypeContactForPreview(6);
    result.items[7] = detailsSmall$initDTOTypeContactForPreview(7);
    result.items[8] = detailsSmall$initDTOTypeContactForPreview(8);
    result.items[9] = detailsSmall$initDTOTypeContactForPreview(9);
    return result;
};
detailsSmall$initDTOTypeContactTypeForPreview = function(index){
    var result = new Object();
    result.id = "1" + "(" + index + ")";
    result.label = "type xyz" + "(" + index + ")";
    result.imageAssetID = "myimage" + "(" + index + ")";
    return result;
};
detailsSmall$initDTOTypeContactTypeListForPreview = function(index){
    var result = new Object();
    result.items = [];
    result.items[0] = detailsSmall$initDTOTypeContactTypeForPreview(0);
    result.items[1] = detailsSmall$initDTOTypeContactTypeForPreview(1);
    result.items[2] = detailsSmall$initDTOTypeContactTypeForPreview(2);
    result.items[3] = detailsSmall$initDTOTypeContactTypeForPreview(3);
    result.items[4] = detailsSmall$initDTOTypeContactTypeForPreview(4);
    result.items[5] = detailsSmall$initDTOTypeContactTypeForPreview(5);
    result.items[6] = detailsSmall$initDTOTypeContactTypeForPreview(6);
    result.items[7] = detailsSmall$initDTOTypeContactTypeForPreview(7);
    result.items[8] = detailsSmall$initDTOTypeContactTypeForPreview(8);
    result.items[9] = detailsSmall$initDTOTypeContactTypeForPreview(9);
    return result;
};

detailsSmall$initForPreview = function(){
    console.log('detailsSmall:executing initForPreview in JS!');
    var scope = angular.element(document.getElementById('screenDetailsSmallPanel')).scope();
    scope.contact = detailsSmall$initDTOTypeContactForPreview(0);
    scope.types = detailsSmall$initDTOTypeContactTypeListForPreview(0);
    setTimeout(function() {scope.$digest();}, 0);
}


var detailsSmall$findItemWithID = function(scope, variableName, id){
    var list = null;
    var fieldName = null;
    if (variableName == "detailsSmall_typeSelectBox_selectedItem"){
        list = scope.types.items;
        fieldName = "id";
    }
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
var detailsSmall$fileSelectedToUploadProfileImageFileUpload = function(selection){
    var scope = angular.element(document.getElementById('screenDetailsSmallPanel')).scope();
    scope.$apply(function(){
        scope.selectedFile = selection;
        var request = detailsSmall$createRequest("onProfileImageFileUploadFileUpload");
        request.parameters["contact"] = detailsSmall$getContact_dto();
        document.getElementById('detailsSmall_uploadFormEventDataProfileImageFileUpload').value = JSON.stringify(request);
        document.getElementById('detailsSmall_uploadFormProfileImageFileUpload').submit();
    });
}

var detailsSmall$uploadIFrameProfileImageFileUploadLoaded = function(){
    var scope = angular.element(document.getElementById('screenDetailsSmallPanel')).scope();
    scope.$apply(function(){
        if (scope.firstIFrameLoadProfileImageFileUpload == false){
            var request = detailsSmall$createRequest("onProfileImageFileUploadFileUploadFinished");
        request.parameters["contact"] = detailsSmall$getContact_dto();
            detailsSmall$executeRequest(request);
        }
        scope.firstIFrameLoadProfileImageFileUpload = false;
    });
}

var detailsSmall$javaFXUploadFileProfileImageFileUpload = function(){
    var scope = angular.element(document.getElementById('screenDetailsSmallPanel')).scope();
    scope.$apply(function(){
        var request = detailsSmall$createRequest("onProfileImageFileUploadFileUpload");
        request.parameters["contact"] = detailsSmall$getContact_dto();
        var uploadRequest = request;
        request = detailsSmall$createRequest("onProfileImageFileUploadFileUploadFinished");
        request.parameters["contact"] = detailsSmall$getContact_dto();
        var uploadFinishedRequest = request;
        webView.fileUpload(JSON.stringify(uploadRequest), JSON.stringify(uploadFinishedRequest));
    });
}

var detailsSmall$openScreen = function(screenToOpen, openParameter){
    if (singlePageApp) {
        setTimeout(function() {openScreenSinglePageApp(screenToOpen, openParameter);}, 0);
    } else {
        detailsSmall$openScreenMultiPageApp(screenToOpen, openParameter);
    }
}
var detailsSmall$openScreenMultiPageApp = function(screenToOpen, openParameter){
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

detailsSmall$processReply = function(jsonString){
    var reply = JSON.parse(jsonString);
    var scope = angular.element(document.getElementById('screenDetailsSmallPanel')).scope();
    for (i = 0, len = reply.dtosToSet.length; i < len; i++) {
        var dtoValue = reply.dtoValues[reply.dtosToSet[i]];
        scope[reply.dtosToSet[i]] = dtoValue;
        if (reply.dtosToSet[i] == 'contact'){
            scope.detailsSmall_firstnameTextField_propertyText = dtoValue.firstname;
            scope.detailsSmall_lastnameTextField_propertyText = dtoValue.lastname;
            scope.detailsSmall_phoneTextField_propertyText = dtoValue.phone;
            scope.detailsSmall_mobileTextField_propertyText = dtoValue.mobile;
            scope.detailsSmall_streetTextField_propertyText = dtoValue.street;
            scope.detailsSmall_cityTextField_propertyText = dtoValue.city;
            scope.detailsSmall_postalCodeTextField_propertyText = dtoValue.postalCode;
            scope.detailsSmall_countryTextField_propertyText = dtoValue.country;
            scope.detailsSmall_stateTextField_propertyText = dtoValue.state;
            scope.detailsSmall_webSiteTextField_propertyText = dtoValue.webSite;
        }
        if (reply.dtosToSet[i] == 'types'){
        }
    }
    for (i = 0, len = reply.dtosToSet.length; i < len; i++) {
        var dtoValue = reply.dtoValues[reply.dtosToSet[i]];
        if (reply.dtosToSet[i] == 'contact'){
        }
        if (reply.dtosToSet[i] == 'types'){
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
        scope[key] = detailsSmall$findItemWithID(scope, key, reply.selectBoxSelectedIDs[key]);
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
        detailsSmall$openScreen(screenToOpen, reply.openParameter);
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
