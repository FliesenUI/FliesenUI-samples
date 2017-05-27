
var detailsLarge$controllerReady = false;
var detailsLarge$logDebugBuffer = "";
var detailsLarge$parameterDTO;

app.controller("detailsLarge_Ctrl", function($scope, $mdToast, $mdDialog, $http) {
    detailsLarge$setInitialValues();
    $scope.http = $http;

    $scope.showMessage = function (message) {
     if (message.typeID == 201){
             $mdToast.show($mdToast.simple().textContent(message.text).hideDelay(3000));
     } else if (message.typeID == 101) {
         $mdDialog.show(
                   $mdDialog.alert()
                     .parent(angular.element(document.querySelector('screenDetailsLargePanel')))
                     .clickOutsideToClose(true)
                     .title(message.title)
                     .textContent(message.text)
                     .ariaLabel('Info Dialog' + message.title + ", " + message.text)
                     .ok('OK')
                 );
     } else if (message.typeID == 102) {
         $mdDialog.show(
                 $mdDialog.alert()
                 .parent(angular.element(document.querySelector('screenDetailsLargePanel')))
                 .clickOutsideToClose(true)
                 .title("WARNING: " + message.title)
                 .textContent(message.text)
                 .ariaLabel('Warning Dialog' + message.title + ", " + message.text)
                 .ok('OK')
         );
     } else if (message.typeID == 103) {
         $mdDialog.show(
                 $mdDialog.alert()
                 .parent(angular.element(document.querySelector('screenDetailsLargePanel')))
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
            var request = detailsLarge$createRequest("onInputDialogResult");
            request.parameters["referenceID"] = referenceID;
            if (typeof result != "undefined"){
                request.parameters["result"] = result;
                detailsLarge$executeRequest(request);
            } else {
                request.parameters["result"] = "";
                detailsLarge$executeRequest(request);
            }
        }, function() {
            var request = detailsLarge$createRequest("onInputDialogResult");
            request.parameters["referenceID"] = referenceID;
            detailsLarge$executeRequest(request);
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
            var request = detailsLarge$createRequest("onConfirmDialogResult");
            request.parameters["referenceID"] = referenceID;
            request.parameters["result"] = true;
            detailsLarge$executeRequest(request);
        }, function() {
            var request = detailsLarge$createRequest("onConfirmDialogResult");
            request.parameters["referenceID"] = referenceID;
            request.parameters["result"] = false;
            detailsLarge$executeRequest(request);
        });
    };

    $scope.showListChooser = function(parameter){
    	$scope.listChooserReferenceID = parameter.referenceID;
    	$scope.listChooserTitle = parameter.title;
    	$scope.listChooserMultiselect = parameter.multiSelect;
    	$scope.listChooserShowIcons = parameter.showIcons;
    	$scope.listChooserOKText = parameter.okText;
    	$scope.listChooserCancelText = parameter.cancelText;
    	$scope.listChooserItems = parameter.items;
    	$scope.listChooserShowFilter = parameter.showFilter;
        $scope.listChooserFilter = "";
    	
        $mdDialog.show({
            controller: ListChooserDialogController,
            parent: angular.element(document.body),
            scope: $scope,
            preserveScope: true, 
            clickOutsideToClose:true,
            template:
			     '<md-dialog aria-label="{{listChooserTitle}}" style="width: 80%;height: 80%;">'
               + '  <form ng-cloak>'
               + '    <md-toolbar>'
               + '      <div class="md-toolbar-tools">'
               + '        <h2>{{listChooserTitle}}</h2>'
               + '      </div>'
               + '    </md-toolbar>'
               + '    <md-dialog-content>'
               + '      <div class="md-dialog-content">'
               + '	    <span ng-show="listChooserShowFilter" > '
               + '			<md-input-container class="md-block" flex-gt-sm>'
               + '				<label>Search</label>'
               + '				<input ng-model="listChooserFilter" style="width:99%">'
               + '			  </md-input-container>'
               + '		</span>'
               + '		<table style="width:100%; overflow-y: scroll;">'
               + '			<tr ng-repeat="i in listChooserItems | filter : {\'label\' : listChooserFilter}" '
               + '			    ng-click="listChooser_rowClicked($event, i.id, i)" '
               + '			    style="border-color:#999999;border-bottom-style: solid;border-width: 1px; background-color:{{rowBackgroundColor}}" '
               + '			    layout="row" '
               + '			    layout-wrap="" '
               + '			    ng-init="rowBackgroundColor=\'white\';" '
               + '			    ng-mouseleave="rowHover=false;rowBackgroundColor=\'white\';"'
               + '			    ng-mouseover="rowHover=true;rowBackgroundColor=\'#f3f3f3\';">'
               + '			    <td ng-if="listChooserMultiselect && i.selected"  style="min-height:60px; padding-left:15px; padding-top:15px;"><img src="img/_checkbox_checked.png"   width="20"/></td>'
               + '			    <td ng-if="listChooserMultiselect && !i.selected" style="min-height:60px; padding-left:15px; padding-top:15px;"><img src="img/_checkbox_unchecked.png" width="20"/></td>'
               + '			    <td ng-if="listChooserShowIcons" style="min-height:60px; padding-left:15px; padding-top:15px;"><img ng-src="img/{{imageAssetIDToName[i.imageAssetID]}}" width="40px" height="40px"/></td>'
               + '				<td style="word-wrap: break-word;min-height:60px; padding-left:15px; padding-top:15px;">{{i.label}}</td>'
               + '			</tr>'
               + '		</table>'
               + '      </div>'
               + '    </md-dialog-content>'
               + ''
               + '    <md-dialog-actions layout="row">'
               + '      <span flex></span>'
               + '      <md-button ng-click="cancel();">'
               + '       {{listChooserCancelText}}'
               + '      </md-button>'
               + '      <md-button ng-click="listChooser_okClicked();hide();" ng-visible="listChooserMultiselect">'
               + '        {{listChooserOKText}}'
               + '      </md-button>'
               + '    </md-dialog-actions>'
               + '  </form>'
               + '</md-dialog>'
        })
        .then(function(answer) {
        }, function() {
              $scope.listChooser_cancelled();
        });
    }
      
    function ListChooserDialogController($scope, $mdDialog) {
        $scope.hide = function() {
    	    $mdDialog.hide();
    	};
    	$scope.cancel = function() {
    	    $mdDialog.cancel();
    	};
        $scope.answer = function(answer) {
    	    $mdDialog.hide(answer);
    	};
    	    
    	$scope.listChooser_rowClicked = function (event, itemID, item) {
    	    if (!event.defaultPrevented) {
    	        console.log("clicked row with itemID = " + itemID + ", old selected = " + item.selected);
                if ($scope.listChooserMultiselect){
    	            item.selected = !item.selected;
    	        	console.log("new selected = " + item.selected);
    	        } else if (!$scope.listChooserMultiselect){
    	            //:clear old selection
    	        	for (i = 0; i < $scope.listChooserItems.length; i++){
    	        	    $scope.listChooserItems[i].selected = false;
    	            }
    	            //: select item
        	        item.selected = !item.selected;
        	        	  
        	        $scope.listChooser_okClicked();        		  
    	        	$mdDialog.hide("");
    	        }
    	    }
        };
    } 
      
    $scope.listChooser_okClicked = function () {
        console.log("clicked ok");
        var selectedIDs = [];
	       for (i = 0; i < $scope.listChooserItems.length; i++){
            var item = $scope.listChooserItems[i];
            if (item.selected){
//			    console.log("selected id: " + item.id);
            selectedIDs.push(item.id);
            }
        }
        console.log("selected ids: " + selectedIDs);
        var request = detailsLarge$createRequest("onListChooserResult");
        request.parameters["referenceID"] = $scope.listChooserReferenceID;
        request.parameters["selectedIDs"] = selectedIDs;
        detailsLarge$executeRequest(request);
    }

    $scope.listChooser_cancelled = function () {
	    console.log("list chooser: cancelled");
        var request = detailsLarge$createRequest("onListChooserResult");
        request.parameters["referenceID"] = $scope.listChooserReferenceID;
        request.parameters["selectedIDs"] = null;
        detailsLarge$executeRequest(request);
    }
      

    $scope.detailsLarge_widgetButtonOpenWebSiteButtonClicked = function () {
        var request = detailsLarge$createRequest("widgetButtonOpenWebSiteButtonClicked");
        request.parameters["contact"] = detailsLarge$getContact_dto();
        detailsLarge$executeRequest(request);
    }

    $scope.detailsLarge_widgetButtonSetPreferredMusicButtonClicked = function () {
        var request = detailsLarge$createRequest("widgetButtonSetPreferredMusicButtonClicked");
        request.parameters["contact"] = detailsLarge$getContact_dto();
        detailsLarge$executeRequest(request);
    }

    $scope.detailsLarge_widgetButtonSaveButtonClicked = function () {
        var request = detailsLarge$createRequest("widgetButtonSaveButtonClicked");
        request.parameters["contact"] = detailsLarge$getContact_dto();
        request.parameters["typeSelectBoxSelectedID"] = detailsLarge_getTypeSelectBoxSelectedID();
        detailsLarge$executeRequest(request);
    }

    $scope.detailsLarge_widgetButtonCancelButtonClicked = function () {
        var request = detailsLarge$createRequest("widgetButtonCancelButtonClicked");
        detailsLarge$executeRequest(request);
    }

    if (!singlePageApp){
        var queryDict = {}
        location.search.substr(1).split("&").forEach(function(item) {queryDict[item.split("=")[0]] = item.split("=")[1]})
    detailsLarge$parameterDTO = detailsLarge$fromURLParameter(queryDict["parameterDTO"]);
        if (typeof detailsLarge$parameterDTO == "undefined"){
            detailsLarge$parameterDTO = null;
        } else if (detailsLarge$parameterDTO != null){
            $scope.detailsLarge_firstnameTextField_propertyText = detailsLarge$parameterDTO.firstname;
            $scope.detailsLarge_lastnameTextField_propertyText = detailsLarge$parameterDTO.lastname;
            $scope.detailsLarge_phoneTextField_propertyText = detailsLarge$parameterDTO.phone;
            $scope.detailsLarge_mobileTextField_propertyText = detailsLarge$parameterDTO.mobile;
            $scope.detailsLarge_streetTextField_propertyText = detailsLarge$parameterDTO.street;
            $scope.detailsLarge_cityTextField_propertyText = detailsLarge$parameterDTO.city;
            $scope.detailsLarge_postalCodeTextField_propertyText = detailsLarge$parameterDTO.postalCode;
            $scope.detailsLarge_countryTextField_propertyText = detailsLarge$parameterDTO.country;
            $scope.detailsLarge_stateTextField_propertyText = detailsLarge$parameterDTO.state;
            $scope.detailsLarge_webSiteTextField_propertyText = detailsLarge$parameterDTO.webSite;
        }
        $scope.contact = detailsLarge$parameterDTO;
    }

    detailsLarge_setTypeSelectBoxSelectedID = function(selectedID){
        var scope = angular.element(document.getElementById('screenDetailsLargePanel')).scope();
        scope.detailsLarge_typeSelectBox_selectedItem = detailsLarge$findItemWithID(scope, "detailsLarge_typeSelectBox_selectedItem", selectedID);
    }

    detailsLarge_getTypeSelectBoxSelectedID = function(){
        var scope = angular.element(document.getElementById('screenDetailsLargePanel')).scope();
        return (typeof scope.detailsLarge_typeSelectBox_selectedItem == "undefined") ? null : scope.detailsLarge_typeSelectBox_selectedItem.id;
    }

    $scope.detailsLarge_typeSelectBox_changed = function (id){
        var request = detailsLarge$createRequest("onTypeSelectBoxChanged");
        request.parameters["rowID"] = id;
        detailsLarge$executeRequest(request);
    }
    setTimeout(function() {if (("WebBrowser" == browserMode) && (!singlePageApp)){detailsLarge$executeOnLoadRequest();}}, 0);
    setTimeout(function() {
        if (typeof previewWindow != "undefined") {
            previewWindow.initForPreview();
        } else {
        }
        
        }, 0);

    $scope.imageAssetIDToName = detailsLarge$createImageAssetIDToNameMap();
    detailsLarge$controllerReady = true;

});

var detailsLarge$setInitialValues = function(){
    var scope = angular.element(document.getElementById('screenDetailsLargePanel')).scope();
    scope.detailsLarge_info_propertyText = "Contact Details";
    scope.detailsLarge_info_propertyVisible = true;
    scope.detailsLarge_typeLabel_propertyText = "Type:";
    scope.detailsLarge_typeLabel_propertyVisible = true;
    scope.detailsLarge_null_propertyVisible = true;
    scope.detailsLarge_firstnameTextField_propertyText = "first";
    scope.detailsLarge_firstnameTextField_propertyLabel = "Firstname:";
    scope.detailsLarge_firstnameTextField_propertyBackgroundColor = "";
    scope.detailsLarge_firstnameTextField_propertyVisible = true;
    scope.detailsLarge_lastnameTextField_propertyText = "last";
    scope.detailsLarge_lastnameTextField_propertyLabel = "Firstname:";
    scope.detailsLarge_lastnameTextField_propertyBackgroundColor = "";
    scope.detailsLarge_lastnameTextField_propertyVisible = true;
    scope.detailsLarge_profileImageFileUpload_propertyText = "Upload profile image";
    scope.detailsLarge_profileImageFileUpload_propertyVisible = false;
    scope.detailsLarge_profileImage_propertyVisible = true;
    scope.detailsLarge_phoneTextField_propertyText = "phone";
    scope.detailsLarge_phoneTextField_propertyLabel = "Phone:";
    scope.detailsLarge_phoneTextField_propertyBackgroundColor = "";
    scope.detailsLarge_phoneTextField_propertyVisible = true;
    scope.detailsLarge_mobileTextField_propertyText = "mobile";
    scope.detailsLarge_mobileTextField_propertyLabel = "Mobile:";
    scope.detailsLarge_mobileTextField_propertyBackgroundColor = "";
    scope.detailsLarge_mobileTextField_propertyVisible = true;
    scope.detailsLarge_streetTextField_propertyText = "street";
    scope.detailsLarge_streetTextField_propertyLabel = "Street:";
    scope.detailsLarge_streetTextField_propertyBackgroundColor = "";
    scope.detailsLarge_streetTextField_propertyVisible = true;
    scope.detailsLarge_cityTextField_propertyText = "city";
    scope.detailsLarge_cityTextField_propertyLabel = "City:";
    scope.detailsLarge_cityTextField_propertyBackgroundColor = "";
    scope.detailsLarge_cityTextField_propertyVisible = true;
    scope.detailsLarge_postalCodeTextField_propertyText = "postalCode";
    scope.detailsLarge_postalCodeTextField_propertyLabel = "Postal Code:";
    scope.detailsLarge_postalCodeTextField_propertyBackgroundColor = "";
    scope.detailsLarge_postalCodeTextField_propertyVisible = true;
    scope.detailsLarge_countryTextField_propertyText = "country";
    scope.detailsLarge_countryTextField_propertyLabel = "Country:";
    scope.detailsLarge_countryTextField_propertyBackgroundColor = "";
    scope.detailsLarge_countryTextField_propertyVisible = true;
    scope.detailsLarge_stateTextField_propertyText = "state";
    scope.detailsLarge_stateTextField_propertyLabel = "State:";
    scope.detailsLarge_stateTextField_propertyBackgroundColor = "";
    scope.detailsLarge_stateTextField_propertyVisible = true;
    scope.detailsLarge_webSiteTextField_propertyText = "web site";
    scope.detailsLarge_webSiteTextField_propertyLabel = "Web Site:";
    scope.detailsLarge_webSiteTextField_propertyBackgroundColor = "";
    scope.detailsLarge_webSiteTextField_propertyVisible = true;
    scope.detailsLarge_openWebSiteButton_propertyText = "open";
    scope.detailsLarge_openWebSiteButton_propertyVisible = true;
    scope.detailsLarge_preferredMusicTitleLabel_propertyText = "Preferred Music:";
    scope.detailsLarge_preferredMusicTitleLabel_propertyVisible = true;
    scope.detailsLarge_preferredMusicContentLabel_propertyText = "preferred music";
    scope.detailsLarge_preferredMusicContentLabel_propertyVisible = true;
    scope.detailsLarge_setPreferredMusicButton_propertyText = "Choose";
    scope.detailsLarge_setPreferredMusicButton_propertyVisible = true;
    scope.detailsLarge_saveButton_propertyText = "save";
    scope.detailsLarge_saveButton_propertyVisible = true;
    scope.detailsLarge_cancelButton_propertyText = "cancel";
    scope.detailsLarge_cancelButton_propertyVisible = true;
    scope.detailsLarge_profileImage_propertyImageSource = "";
}

var detailsLarge$createImageAssetIDToNameMap = function(){
    result = new Object();
    result["colleague"] = "colleague.svg";
    result["company"] = "company.svg";
    result["family"] = "family.svg";
    result["friend"] = "friend.svg";
    result["languageDE"] = "languageDE.png";
    result["languageEN"] = "languageEN.svg";
    result["music"] = "music.png";
    return result;
}

var detailsLarge$logDebug = function(message){
//	if (detailsLarge$logDebugBuffer.length > 0){
//		console.log("buffered messages:\n" + detailsLarge$logDebugBuffer + "\n}");
//	}
//	detailsLarge$logDebugBuffer = detailsLarge$logDebugBuffer + message + "\n";
    console.log(message);
}

var detailsLarge$fromURLParameter = function(urlParameter){
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

detailsLarge$executeOnLoadRequest = function(){
    var request = detailsLarge$createRequest("onLoaded");
    request.parameters["_ClientProperties"] = getClientProperties();
    request.parameters["contact"] = detailsLarge$getContact_dto();
    detailsLarge$executeRequest(request);
}

/** called in JavaFX mode by web view when the screen object has been set. Wait until the Angular JS controller is ready and then call onLoad in the listener*/
detailsLarge$executeOnLoadWhenControllerIsReady = function(){
    detailsLarge$logDebug("executeOnLoadWhenControllerIsReady: detailsLarge$controllerReady = " + detailsLarge$controllerReady);
    if (detailsLarge$controllerReady){
        detailsLarge$logDebug("executeOnLoadWhenControllerIsReady: ready");
        detailsLarge$executeOnLoadRequest();
        detailsLarge$logDebug("executeOnLoadWhenControllerIsReady: called onLoaded");
    } else {
        detailsLarge$logDebug("executeOnLoadWhenControllerIsReady: waiting");
        setTimeout(detailsLarge$executeOnLoadWhenControllerIsReady(), 200);
    }
}
detailsLarge$createRequest = function(actionName){
    request = new Object();
    request.action = actionName;
    request.currentLanguage = currentLanguage;
    request.screenID = "detailsLarge";
    request.parameters = new Object();
    return request;
};

detailsLarge$executeRequest = function(request){
    //later: add server call and process request here...
    if (browserMode == 'JavaFX'){
        screenManager.onRequest(JSON.stringify(request), null, null);
    } else {
        var scope = angular.element(document.getElementById('screenDetailsLargePanel')).scope();
        scope.http.post("/request", request).then(function (response) {
            if ((response.data != null) && (typeof response.data != "undefined")){
                detailsLarge$processReply(JSON.stringify(response.data));
            }
        });
    }
};


detailsLarge$setInfo_widgetText = function(text){
    var scope = angular.element(document.getElementById('screenDetailsLargePanel')).scope();
    scope.$apply(function(){
        scope.detailsLarge_info_propertyText = text;
    });
};
detailsLarge$getInfo_widgetText = function(){
    var scope = angular.element(document.getElementById('screenDetailsLargePanel')).scope();
    return scope.detailsLarge_info_propertyText;
};


detailsLarge$setTypeLabel_widgetText = function(text){
    var scope = angular.element(document.getElementById('screenDetailsLargePanel')).scope();
    scope.$apply(function(){
        scope.detailsLarge_typeLabel_propertyText = text;
    });
};
detailsLarge$getTypeLabel_widgetText = function(){
    var scope = angular.element(document.getElementById('screenDetailsLargePanel')).scope();
    return scope.detailsLarge_typeLabel_propertyText;
};


detailsLarge$setFirstnameTextField_widgetText = function(text){
    var scope = angular.element(document.getElementById('screenDetailsLargePanel')).scope();
    scope.$apply(function(){
        scope.detailsLarge_firstnameTextField_propertyText = text;
    });
};
detailsLarge$getFirstnameTextField_widgetText = function(){
    var scope = angular.element(document.getElementById('screenDetailsLargePanel')).scope();
    return scope.detailsLarge_firstnameTextField_propertyText;
};


detailsLarge$setLastnameTextField_widgetText = function(text){
    var scope = angular.element(document.getElementById('screenDetailsLargePanel')).scope();
    scope.$apply(function(){
        scope.detailsLarge_lastnameTextField_propertyText = text;
    });
};
detailsLarge$getLastnameTextField_widgetText = function(){
    var scope = angular.element(document.getElementById('screenDetailsLargePanel')).scope();
    return scope.detailsLarge_lastnameTextField_propertyText;
};


detailsLarge$setPhoneTextField_widgetText = function(text){
    var scope = angular.element(document.getElementById('screenDetailsLargePanel')).scope();
    scope.$apply(function(){
        scope.detailsLarge_phoneTextField_propertyText = text;
    });
};
detailsLarge$getPhoneTextField_widgetText = function(){
    var scope = angular.element(document.getElementById('screenDetailsLargePanel')).scope();
    return scope.detailsLarge_phoneTextField_propertyText;
};


detailsLarge$setMobileTextField_widgetText = function(text){
    var scope = angular.element(document.getElementById('screenDetailsLargePanel')).scope();
    scope.$apply(function(){
        scope.detailsLarge_mobileTextField_propertyText = text;
    });
};
detailsLarge$getMobileTextField_widgetText = function(){
    var scope = angular.element(document.getElementById('screenDetailsLargePanel')).scope();
    return scope.detailsLarge_mobileTextField_propertyText;
};


detailsLarge$setStreetTextField_widgetText = function(text){
    var scope = angular.element(document.getElementById('screenDetailsLargePanel')).scope();
    scope.$apply(function(){
        scope.detailsLarge_streetTextField_propertyText = text;
    });
};
detailsLarge$getStreetTextField_widgetText = function(){
    var scope = angular.element(document.getElementById('screenDetailsLargePanel')).scope();
    return scope.detailsLarge_streetTextField_propertyText;
};


detailsLarge$setCityTextField_widgetText = function(text){
    var scope = angular.element(document.getElementById('screenDetailsLargePanel')).scope();
    scope.$apply(function(){
        scope.detailsLarge_cityTextField_propertyText = text;
    });
};
detailsLarge$getCityTextField_widgetText = function(){
    var scope = angular.element(document.getElementById('screenDetailsLargePanel')).scope();
    return scope.detailsLarge_cityTextField_propertyText;
};


detailsLarge$setPostalCodeTextField_widgetText = function(text){
    var scope = angular.element(document.getElementById('screenDetailsLargePanel')).scope();
    scope.$apply(function(){
        scope.detailsLarge_postalCodeTextField_propertyText = text;
    });
};
detailsLarge$getPostalCodeTextField_widgetText = function(){
    var scope = angular.element(document.getElementById('screenDetailsLargePanel')).scope();
    return scope.detailsLarge_postalCodeTextField_propertyText;
};


detailsLarge$setCountryTextField_widgetText = function(text){
    var scope = angular.element(document.getElementById('screenDetailsLargePanel')).scope();
    scope.$apply(function(){
        scope.detailsLarge_countryTextField_propertyText = text;
    });
};
detailsLarge$getCountryTextField_widgetText = function(){
    var scope = angular.element(document.getElementById('screenDetailsLargePanel')).scope();
    return scope.detailsLarge_countryTextField_propertyText;
};


detailsLarge$setStateTextField_widgetText = function(text){
    var scope = angular.element(document.getElementById('screenDetailsLargePanel')).scope();
    scope.$apply(function(){
        scope.detailsLarge_stateTextField_propertyText = text;
    });
};
detailsLarge$getStateTextField_widgetText = function(){
    var scope = angular.element(document.getElementById('screenDetailsLargePanel')).scope();
    return scope.detailsLarge_stateTextField_propertyText;
};


detailsLarge$setWebSiteTextField_widgetText = function(text){
    var scope = angular.element(document.getElementById('screenDetailsLargePanel')).scope();
    scope.$apply(function(){
        scope.detailsLarge_webSiteTextField_propertyText = text;
    });
};
detailsLarge$getWebSiteTextField_widgetText = function(){
    var scope = angular.element(document.getElementById('screenDetailsLargePanel')).scope();
    return scope.detailsLarge_webSiteTextField_propertyText;
};


detailsLarge$setPreferredMusicTitleLabel_widgetText = function(text){
    var scope = angular.element(document.getElementById('screenDetailsLargePanel')).scope();
    scope.$apply(function(){
        scope.detailsLarge_preferredMusicTitleLabel_propertyText = text;
    });
};
detailsLarge$getPreferredMusicTitleLabel_widgetText = function(){
    var scope = angular.element(document.getElementById('screenDetailsLargePanel')).scope();
    return scope.detailsLarge_preferredMusicTitleLabel_propertyText;
};


detailsLarge$setPreferredMusicContentLabel_widgetText = function(text){
    var scope = angular.element(document.getElementById('screenDetailsLargePanel')).scope();
    scope.$apply(function(){
        scope.detailsLarge_preferredMusicContentLabel_propertyText = text;
    });
};
detailsLarge$getPreferredMusicContentLabel_widgetText = function(){
    var scope = angular.element(document.getElementById('screenDetailsLargePanel')).scope();
    return scope.detailsLarge_preferredMusicContentLabel_propertyText;
};



detailsLarge$setContact_dto = function(jsonString){
    var paramObject = JSON.parse(jsonString);
    var scope = angular.element(document.getElementById('screenDetailsLargePanel')).scope();
    scope.$apply(function(){
        scope.contact = paramObject;
        scope.detailsLarge_firstnameTextField_propertyText = paramObject.firstname;
        scope.detailsLarge_lastnameTextField_propertyText = paramObject.lastname;
        scope.detailsLarge_phoneTextField_propertyText = paramObject.phone;
        scope.detailsLarge_mobileTextField_propertyText = paramObject.mobile;
        scope.detailsLarge_streetTextField_propertyText = paramObject.street;
        scope.detailsLarge_cityTextField_propertyText = paramObject.city;
        scope.detailsLarge_postalCodeTextField_propertyText = paramObject.postalCode;
        scope.detailsLarge_countryTextField_propertyText = paramObject.country;
        scope.detailsLarge_stateTextField_propertyText = paramObject.state;
        scope.detailsLarge_webSiteTextField_propertyText = paramObject.webSite;
    });
};
detailsLarge$getContact_dto = function(){
    var scope = angular.element(document.getElementById('screenDetailsLargePanel')).scope();
    var result = new Object();
    if (scope.contact != null){
        result = JSON.parse(JSON.stringify(scope.contact));
    }
    result.firstname = scope.detailsLarge_firstnameTextField_propertyText;
    result.lastname = scope.detailsLarge_lastnameTextField_propertyText;
    result.phone = scope.detailsLarge_phoneTextField_propertyText;
    result.mobile = scope.detailsLarge_mobileTextField_propertyText;
    result.street = scope.detailsLarge_streetTextField_propertyText;
    result.city = scope.detailsLarge_cityTextField_propertyText;
    result.postalCode = scope.detailsLarge_postalCodeTextField_propertyText;
    result.country = scope.detailsLarge_countryTextField_propertyText;
    result.state = scope.detailsLarge_stateTextField_propertyText;
    result.webSite = scope.detailsLarge_webSiteTextField_propertyText;
    return JSON.stringify(result);
};
detailsLarge$setTypes_dto = function(jsonString){
    var paramObject = JSON.parse(jsonString);
    var scope = angular.element(document.getElementById('screenDetailsLargePanel')).scope();
    scope.$apply(function(){
        scope.types = paramObject;
    });
};
detailsLarge$getTypes_dto = function(){
    var scope = angular.element(document.getElementById('screenDetailsLargePanel')).scope();
    var result = new Object();
    if (scope.types != null){
        result = JSON.parse(JSON.stringify(scope.types));
    }
    return JSON.stringify(result);
};

detailsLarge$initDTOTypeContactForPreview = function(index){
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
    result.preferredMusic = [];
    result.preferredMusic[0] = "(preview string preferredMusic)" + "(" + index + ")";
    result.preferredMusic[1] = "(preview string preferredMusic)" + "(" + index + ")";
    result.preferredMusic[2] = "(preview string preferredMusic)" + "(" + index + ")";
    result.preferredMusic[3] = "(preview string preferredMusic)" + "(" + index + ")";
    result.preferredMusic[4] = "(preview string preferredMusic)" + "(" + index + ")";
    result.preferredMusic[5] = "(preview string preferredMusic)" + "(" + index + ")";
    result.preferredMusic[6] = "(preview string preferredMusic)" + "(" + index + ")";
    result.preferredMusic[7] = "(preview string preferredMusic)" + "(" + index + ")";
    result.preferredMusic[8] = "(preview string preferredMusic)" + "(" + index + ")";
    result.preferredMusic[9] = "(preview string preferredMusic)" + "(" + index + ")";
    return result;
};
detailsLarge$initDTOTypeContactListForPreview = function(index){
    var result = new Object();
    result.items = [];
    result.items[0] = detailsLarge$initDTOTypeContactForPreview(0);
    result.items[1] = detailsLarge$initDTOTypeContactForPreview(1);
    result.items[2] = detailsLarge$initDTOTypeContactForPreview(2);
    result.items[3] = detailsLarge$initDTOTypeContactForPreview(3);
    result.items[4] = detailsLarge$initDTOTypeContactForPreview(4);
    result.items[5] = detailsLarge$initDTOTypeContactForPreview(5);
    result.items[6] = detailsLarge$initDTOTypeContactForPreview(6);
    result.items[7] = detailsLarge$initDTOTypeContactForPreview(7);
    result.items[8] = detailsLarge$initDTOTypeContactForPreview(8);
    result.items[9] = detailsLarge$initDTOTypeContactForPreview(9);
    return result;
};
detailsLarge$initDTOTypeContactTypeForPreview = function(index){
    var result = new Object();
    result.id = "1" + "(" + index + ")";
    result.label = "type xyz" + "(" + index + ")";
    result.imageAssetID = "myimage" + "(" + index + ")";
    return result;
};
detailsLarge$initDTOTypeContactTypeListForPreview = function(index){
    var result = new Object();
    result.items = [];
    result.items[0] = detailsLarge$initDTOTypeContactTypeForPreview(0);
    result.items[1] = detailsLarge$initDTOTypeContactTypeForPreview(1);
    result.items[2] = detailsLarge$initDTOTypeContactTypeForPreview(2);
    result.items[3] = detailsLarge$initDTOTypeContactTypeForPreview(3);
    result.items[4] = detailsLarge$initDTOTypeContactTypeForPreview(4);
    result.items[5] = detailsLarge$initDTOTypeContactTypeForPreview(5);
    result.items[6] = detailsLarge$initDTOTypeContactTypeForPreview(6);
    result.items[7] = detailsLarge$initDTOTypeContactTypeForPreview(7);
    result.items[8] = detailsLarge$initDTOTypeContactTypeForPreview(8);
    result.items[9] = detailsLarge$initDTOTypeContactTypeForPreview(9);
    return result;
};

detailsLarge$initForPreview = function(){
    console.log('detailsLarge:executing initForPreview in JS!');
    var scope = angular.element(document.getElementById('screenDetailsLargePanel')).scope();
    scope.contact = detailsLarge$initDTOTypeContactForPreview(0);
    scope.types = detailsLarge$initDTOTypeContactTypeListForPreview(0);
    setTimeout(function() {scope.$digest();}, 0);
}


var detailsLarge$findItemWithID = function(scope, variableName, id){
    var list = null;
    var fieldName = null;
    if (variableName == "detailsLarge_typeSelectBox_selectedItem"){
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
var detailsLarge$fileSelectedToUploadProfileImageFileUpload = function(selection){
    var scope = angular.element(document.getElementById('screenDetailsLargePanel')).scope();
    scope.$apply(function(){
        scope.selectedFile = selection;
        var request = detailsLarge$createRequest("onProfileImageFileUploadFileUpload");
        request.parameters["contact"] = detailsLarge$getContact_dto();
        document.getElementById('detailsLarge_uploadFormEventDataProfileImageFileUpload').value = JSON.stringify(request);
        document.getElementById('detailsLarge_uploadFormProfileImageFileUpload').submit();
    });
}

var detailsLarge$uploadIFrameProfileImageFileUploadLoaded = function(){
    var scope = angular.element(document.getElementById('screenDetailsLargePanel')).scope();
    scope.$apply(function(){
        if (scope.firstIFrameLoadProfileImageFileUpload == false){
            var request = detailsLarge$createRequest("onProfileImageFileUploadFileUploadFinished");
        request.parameters["contact"] = detailsLarge$getContact_dto();
            detailsLarge$executeRequest(request);
        }
        scope.firstIFrameLoadProfileImageFileUpload = false;
    });
}

var detailsLarge$javaFXUploadFileProfileImageFileUpload = function(){
    var scope = angular.element(document.getElementById('screenDetailsLargePanel')).scope();
    scope.$apply(function(){
        var request = detailsLarge$createRequest("onProfileImageFileUploadFileUpload");
        request.parameters["contact"] = detailsLarge$getContact_dto();
        var uploadRequest = request;
        request = detailsLarge$createRequest("onProfileImageFileUploadFileUploadFinished");
        request.parameters["contact"] = detailsLarge$getContact_dto();
        var uploadFinishedRequest = request;
        webView.fileUpload(JSON.stringify(uploadRequest), JSON.stringify(uploadFinishedRequest));
    });
}

var detailsLarge$openScreen = function(screenToOpen, openParameter){
    if (singlePageApp) {
        setTimeout(function() {openScreenSinglePageApp(screenToOpen, openParameter);}, 0);
    } else {
        detailsLarge$openScreenMultiPageApp(screenToOpen, openParameter);
    }
}
var detailsLarge$openScreenMultiPageApp = function(screenToOpen, openParameter){
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

detailsLarge$backButtonPressed = function(){
    console.log("Screen detailsLarge: Back pressed.");
    var $scope = angular.element(document.getElementById('screenDetailsLargePanel')).scope();
    var request = detailsLarge$createRequest("onBackPressed");
    detailsLarge$executeRequest(request);
};

detailsLarge$updateViews = function(){
};

detailsLarge$processReply = function(jsonString){
    var reply = JSON.parse(jsonString);
    if (typeof reply.languageToSet != "undefined") {
        currentLanguage = reply.languageToSet;
    }
    var scope = angular.element(document.getElementById('screenDetailsLargePanel')).scope();
    for (i = 0, len = reply.dtosToSet.length; i < len; i++) {
        var dtoValue = reply.dtoValues[reply.dtosToSet[i]];
        scope[reply.dtosToSet[i]] = dtoValue;
        if (reply.dtosToSet[i] == 'contact'){
            scope.detailsLarge_firstnameTextField_propertyText = dtoValue.firstname;
            scope.detailsLarge_lastnameTextField_propertyText = dtoValue.lastname;
            scope.detailsLarge_phoneTextField_propertyText = dtoValue.phone;
            scope.detailsLarge_mobileTextField_propertyText = dtoValue.mobile;
            scope.detailsLarge_streetTextField_propertyText = dtoValue.street;
            scope.detailsLarge_cityTextField_propertyText = dtoValue.city;
            scope.detailsLarge_postalCodeTextField_propertyText = dtoValue.postalCode;
            scope.detailsLarge_countryTextField_propertyText = dtoValue.country;
            scope.detailsLarge_stateTextField_propertyText = dtoValue.state;
            scope.detailsLarge_webSiteTextField_propertyText = dtoValue.webSite;
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
        scope[key] = detailsLarge$findItemWithID(scope, key, reply.selectBoxSelectedIDs[key]);
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

    for (key in reply.tableCheckedRowIDs){
        scope[key] = new Object();
        for (i in reply.tableCheckedRowIDs[key]){
            scope[key][reply.tableCheckedRowIDs[key][i]] = true;
        }
    }

    var screenToOpen = reply.screenToOpen;
    if (typeof screenToOpen != "undefined") {
        detailsLarge$openScreen(screenToOpen, reply.openParameter);
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
    if (typeof reply.listChooserParameters != "undefined") {
        scope.showListChooser(reply.listChooserParameters);
    }
    setTimeout(function() {scope.$digest();detailsLarge$updateViews();}, 0);

};
