
var overviewLarge$controllerReady = false;
var overviewLarge$logDebugBuffer = "";
var overviewLarge$parameterDTO;
var overviewLarge$tableContactsTableTopItemIndex = null;
var overviewLarge$tableContactsTableFilteredIDs = null;

overviewLarge_tableContactsTableFilterTextOnKeyDown = function (event) {
    if (event.keyCode == 13){
        var scope = angular.element(document.getElementById('screenOverviewLargePanel')).scope();
        if (overviewLarge$tableContactsTableTopItemIndex != null){
            scope.overviewLarge_tableContactsTableRowClicked(0, event);
        }
        return;
    }

    if ((event.keyCode != 32) || (!event.ctrlKey)){
        return;
    }
    event.preventDefault();
    var inputField = document.getElementById("overviewLarge_tableContactsTableFilterTextInputField");
    var currentText = inputField.value;
    var cursorPos = inputField.selectionStart;
    var scope = angular.element(document.getElementById('screenOverviewLargePanel')).scope();
    var columnNames = [scope.overviewLarge_contactsTableColumn0Text
                     , scope.overviewLarge_contactsTableColumn1Text
                     , scope.overviewLarge_contactsTableColumn2Text
                     , scope.overviewLarge_contactsTableColumn3Text
                     , scope.overviewLarge_contactsTableColumn4Text];
    try{
        var updatedTextAndCursor = updateTextAndCursorToNextColumn(currentText, cursorPos, columnNames);

        inputField.value = updatedTextAndCursor.text;
        inputField.selectionStart = updatedTextAndCursor.cursorPos;
        inputField.selectionEnd = updatedTextAndCursor.cursorPos;

        scope["overviewLarge_contactsTableFilterText"] = updatedTextAndCursor.text;
        setTimeout(function() {scope.$digest();}, 0);
    } catch (e){
        console.log("error: " + e + ", " + JSON.stringify(e));
    }
}
app.filter('overviewLarge_tableContactsTableFilter', function () {
    return function (dataArray, filterTextRaw) {
        if (!dataArray) return;
        /* when term is cleared, return full array*/
        if (!filterTextRaw) {
            overviewLarge$tableContactsTableTopItemIndex = null;
            overviewLarge$tableContactsTableFilteredIDs = null;
            return dataArray
        }
        var filterText = filterTextRaw.trim().toLowerCase();
        if (filterText.length == 0){
            overviewLarge$tableContactsTableTopItemIndex = null;
            overviewLarge$tableContactsTableFilteredIDs = null;
            return dataArray
        }
        var scope = angular.element(document.getElementById('screenOverviewLargePanel')).scope();
        var columnNames = [scope.overviewLarge_contactsTableColumn0Text
                         , scope.overviewLarge_contactsTableColumn1Text
                         , scope.overviewLarge_contactsTableColumn2Text
                         , scope.overviewLarge_contactsTableColumn3Text
                         , scope.overviewLarge_contactsTableColumn4Text];
        var searchTermsMap = createSearchTermsMap(filterText, columnNames);

        var result = dataArray.filter(function(item){
            existingItems = new Object();
            existingItems["c0"] = "";
            existingItems["c1"] = item.firstname;
            existingItems["c2"] = item.lastname;
            existingItems["c3"] = item.mobile;
            existingItems["c4"] = "";

            if (filterBySearchTerms(existingItems, searchTermsMap)){
                return true;
            } else {
                return false;
            }
        });
        if ((result != null) && (result.length != 0)){
            overviewLarge$tableContactsTableTopItemIndex = findIndex(dataArray, result[0].id, "id");
            overviewLarge$tableContactsTableFilteredIDs = createListFromProperty(result, "id");
        } else {
            overviewLarge$tableContactsTableTopItemIndex = null;
            id = null;
        }
        return result;
    }
});
app.controller("overviewLarge_Ctrl", function($scope, $mdToast, $mdDialog, $http) {
    overviewLarge$setInitialValues();
    $scope.http = $http;

    $scope.showMessage = function (message) {
     if (message.typeID == 201){
             $mdToast.show($mdToast.simple().textContent(message.text).hideDelay(3000));
     } else if (message.typeID == 101) {
         $mdDialog.show(
                   $mdDialog.alert()
                     .parent(angular.element(document.querySelector('screenOverviewLargePanel')))
                     .clickOutsideToClose(true)
                     .title(message.title)
                     .textContent(message.text)
                     .ariaLabel('Info Dialog' + message.title + ", " + message.text)
                     .ok('OK')
                 );
     } else if (message.typeID == 102) {
         $mdDialog.show(
                 $mdDialog.alert()
                 .parent(angular.element(document.querySelector('screenOverviewLargePanel')))
                 .clickOutsideToClose(true)
                 .title("WARNING: " + message.title)
                 .textContent(message.text)
                 .ariaLabel('Warning Dialog' + message.title + ", " + message.text)
                 .ok('OK')
         );
     } else if (message.typeID == 103) {
         $mdDialog.show(
                 $mdDialog.alert()
                 .parent(angular.element(document.querySelector('screenOverviewLargePanel')))
                 .clickOutsideToClose(true)
                 .title("ERROR: " + message.title)
                 .textContent(message.text)
                 .ariaLabel('Warning Dialog' + message.title + ", " + message.text)
                 .ok('OK')
         );
     }
    }
    $scope.showInputDialog = function(referenceID, callbackData, title, textContent, label, initialValueText, okText, cancelText) {
        var confirm = $mdDialog.prompt()
          .title(title)
          .textContent(textContent)
          .placeholder(label)
          .ariaLabel(label)
          .initialValue(initialValueText)
          .ok(okText)
          .cancel(cancelText);

        $mdDialog.show(confirm).then(function(result) {
            var request = overviewLarge$createRequest("onInputDialogResult");
            request.parameters["referenceID"] = referenceID;
            request.parameters["callbackData"] = callbackData;
            if (typeof result != "undefined"){
                request.parameters["result"] = result;
                overviewLarge$executeRequest(request);
            } else {
                request.parameters["result"] = "";
                overviewLarge$executeRequest(request);
            }
        }, function() {
            var request = overviewLarge$createRequest("onInputDialogResult");
            request.parameters["referenceID"] = referenceID;
            request.parameters["callbackData"] = callbackData;
            overviewLarge$executeRequest(request);
        });
    };

    $scope.showConfirm = function(referenceID, callbackData, title, textContent, okText, cancelText) {
        var confirm = $mdDialog.confirm()
              .title(title)
              .textContent(textContent)
              .ariaLabel(title)
              .ok(okText)
              .cancel(cancelText);

        $mdDialog.show(confirm).then(function() {
            var request = overviewLarge$createRequest("onConfirmDialogResult");
            request.parameters["referenceID"] = referenceID;
            request.parameters["result"] = true;
            request.parameters["callbackData"] = callbackData;
            overviewLarge$executeRequest(request);
        }, function() {
            var request = overviewLarge$createRequest("onConfirmDialogResult");
            request.parameters["referenceID"] = referenceID;
            request.parameters["result"] = false;
            request.parameters["callbackData"] = callbackData;
            overviewLarge$executeRequest(request);
        });
    };

    $scope.showListChooser = function(parameter){
    	$scope.listChooserReferenceID = parameter.referenceID;
    	$scope.listChooserCallbackData = parameter.callbackData;
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
               + '      <md-button ng-click="hide();listChooser_okClicked();" ng-visible="listChooserMultiselect">'
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
        	        	  
    	        	$mdDialog.hide("");
        	        $scope.listChooser_okClicked();        		  
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
        var request = overviewLarge$createRequest("onListChooserResult");
        request.parameters["referenceID"] = $scope.listChooserReferenceID;
        request.parameters["callbackData"] = $scope.listChooserCallbackData;
        request.parameters["selectedIDs"] = selectedIDs;
        overviewLarge$executeRequest(request);
    }

    $scope.listChooser_cancelled = function () {
	    console.log("list chooser: cancelled");
        var request = overviewLarge$createRequest("onListChooserResult");
        request.parameters["referenceID"] = $scope.listChooserReferenceID;
        request.parameters["callbackData"] = $scope.listChooserCallbackData;
        request.parameters["selectedIDs"] = null;
        overviewLarge$executeRequest(request);
    }
      

    $scope.overviewLarge_widgetButtonLanguageEnglishButtonClicked = function () {
        var request = overviewLarge$createRequest("widgetButtonLanguageEnglishButtonClicked");
        overviewLarge$executeRequest(request);
    }

    $scope.overviewLarge_widgetButtonLanguageGermanButtonClicked = function () {
        var request = overviewLarge$createRequest("widgetButtonLanguageGermanButtonClicked");
        overviewLarge$executeRequest(request);
    }

    $scope.overviewLarge_widgetButtonNewButtonClicked = function () {
        var request = overviewLarge$createRequest("widgetButtonNewButtonClicked");
        overviewLarge$executeRequest(request);
    }

    $scope.overviewLarge_widgetButtonExportButtonClicked = function () {
        var request = overviewLarge$createRequest("widgetButtonExportButtonClicked");
        overviewLarge$executeRequest(request);
    }

    $scope.overviewLarge_widgetButtonSearchButtonClicked = function () {
        var request = overviewLarge$createRequest("widgetButtonSearchButtonClicked");
        request.parameters["searchNameTextFieldText"] = $scope.overviewLarge_searchNameTextField_propertyText;
        overviewLarge$executeRequest(request);
    }

    $scope.overviewLarge_tableContactsTableOnInfoButtonClicked = function () {
        var message = new Object();
        message.typeID = 101;
        message.title = "Quick Filter Info";
        message.text = "Type any text to filter. Add preciding '-' to filter out.  Add column name and ':' like 'myColumn:x' to filter in a column.  ";
        message.text += "Use quotes (\") for spaces in column name or texts.  Press enter to select(click) first item in table.  ";
        message.text += "Press ctrl+space for auto-complete of column names or next column name.";

        $scope.showMessage(message);
    }

    $scope.overviewLarge_tableContactsTableButtonEditButtonClicked = function (index, event) {
        event.preventDefault();
        var request = overviewLarge$createRequest("onContactsTableEditButtonClicked");
        if (overviewLarge$tableContactsTableFilteredIDs != null){
            request.parameters["rowID"] = overviewLarge$tableContactsTableFilteredIDs[index];
        } else {
            request.parameters["rowID"] = $scope.contacts.items[index].id;
        }
        overviewLarge$executeRequest(request);
    }
    $scope.overviewLarge_tableContactsTableButtonDeleteButtonClicked = function (index, event) {
        event.preventDefault();
        var request = overviewLarge$createRequest("onContactsTableDeleteButtonClicked");
        if (overviewLarge$tableContactsTableFilteredIDs != null){
            request.parameters["rowID"] = overviewLarge$tableContactsTableFilteredIDs[index];
        } else {
            request.parameters["rowID"] = $scope.contacts.items[index].id;
        }
        overviewLarge$executeRequest(request);
    }
    $scope.overviewLarge_tableContactsTableRowClicked = function (index, event) {
        if (!event.defaultPrevented) {
            var request = overviewLarge$createRequest("onContactsTableRowClicked");
            if (overviewLarge$tableContactsTableFilteredIDs != null){
                request.parameters["rowID"] = overviewLarge$tableContactsTableFilteredIDs[index];
            } else {
                request.parameters["rowID"] = $scope.contacts.items[index].id;
            }
            overviewLarge$executeRequest(request);
        }
    }
    setTimeout(function() {if (("WebBrowser" == browserMode) && (!singlePageApp)){overviewLarge$executeOnLoadRequest();}}, 0);
    setTimeout(function() {
        if (typeof previewWindow != "undefined") {
            previewWindow.initForPreview();
        } else {
        }
        
        }, 0);

    $scope.imageAssetIDToName = overviewLarge$createImageAssetIDToNameMap();
    overviewLarge$controllerReady = true;

});

var overviewLarge$setInitialValues = function(){
    var scope = angular.element(document.getElementById('screenOverviewLargePanel')).scope();
    scope.overviewLarge_info_propertyText = getText("contact_manager_demo");
    scope.overviewLarge_info_propertyVisible = true;
    scope.overviewLarge_languageEnglishButton_propertyVisible = true;
    scope.overviewLarge_languageGermanButton_propertyVisible = true;
    scope.overviewLarge_newButton_propertyText = getText("new_contact");
    scope.overviewLarge_newButton_propertyVisible = true;
    scope.overviewLarge_exportButton_propertyText = getText("export_data");
    scope.overviewLarge_exportButton_propertyVisible = true;
    scope.overviewLarge_searchNameTextField_propertyText = "";
    scope.overviewLarge_searchNameTextField_propertyLabel = getText("search_name");
    scope.overviewLarge_searchNameTextField_propertyBackgroundColor = "";
    scope.overviewLarge_searchNameTextField_propertyVisible = true;
    scope.overviewLarge_searchButton_propertyText = getText("search");
    scope.overviewLarge_searchButton_propertyVisible = true;
    scope.overviewLarge_languageEnglishButton_propertyImageSource = "languageEN.svg";
    scope.overviewLarge_languageGermanButton_propertyImageSource = "languageDE.png";
    scope.overviewLarge_contactsTableColumn0Text = getText("type");
    scope.overviewLarge_contactsTableColumn1Text = getText("firstname");
    scope.overviewLarge_contactsTableColumn2Text = getText("lastname");
    scope.overviewLarge_contactsTableColumn3Text = getText("mobile");
    scope.overviewLarge_contactsTableColumn4Text = getText("actions");
    scope.overviewLarge_contactsTableWidgetEditButtonText = getText("edit");
    scope.overviewLarge_contactsTableWidgetDeleteButtonText = getText("delete");
}

var overviewLarge$createImageAssetIDToNameMap = function(){
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

var overviewLarge$logDebug = function(message){
//	if (overviewLarge$logDebugBuffer.length > 0){
//		console.log("buffered messages:\n" + overviewLarge$logDebugBuffer + "\n}");
//	}
//	overviewLarge$logDebugBuffer = overviewLarge$logDebugBuffer + message + "\n";
    console.log(message);
}

var overviewLarge$fromURLParameter = function(urlParameter){
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

overviewLarge$executeOnLoadRequest = function(){
    var request = overviewLarge$createRequest("onLoaded");
    request.parameters["_ClientProperties"] = getClientProperties();
    overviewLarge$executeRequest(request);
}

/** called in JavaFX mode by web view when the screen object has been set. Wait until the Angular JS controller is ready and then call onLoad in the listener*/
overviewLarge$executeOnLoadWhenControllerIsReady = function(){
    overviewLarge$logDebug("executeOnLoadWhenControllerIsReady: overviewLarge$controllerReady = " + overviewLarge$controllerReady);
    if (overviewLarge$controllerReady){
        overviewLarge$logDebug("executeOnLoadWhenControllerIsReady: ready");
        overviewLarge$executeOnLoadRequest();
        overviewLarge$logDebug("executeOnLoadWhenControllerIsReady: called onLoaded");
    } else {
        overviewLarge$logDebug("executeOnLoadWhenControllerIsReady: waiting");
        setTimeout(overviewLarge$executeOnLoadWhenControllerIsReady(), 200);
    }
}
overviewLarge$createRequest = function(actionName){
    request = new Object();
    request.action = actionName;
    request.currentLanguage = currentLanguage;
    request.screenID = "overviewLarge";
    request.parameters = new Object();
    return request;
};

overviewLarge$executeRequest = function(request){
    //later: add server call and process request here...
    if (browserMode == 'JavaFX'){
        screenManager.onRequest(JSON.stringify(request), null, null);
    } else {
        var scope = angular.element(document.getElementById('screenOverviewLargePanel')).scope();
        scope.http.post("/request", request).then(function (response) {
            if ((response.data != null) && (typeof response.data != "undefined")){
                overviewLarge$processReply(JSON.stringify(response.data));
            }
        });
    }
};


overviewLarge$setInfo_widgetText = function(text){
    var scope = angular.element(document.getElementById('screenOverviewLargePanel')).scope();
    scope.$apply(function(){
        scope.overviewLarge_info_propertyText = text;
    });
};
overviewLarge$getInfo_widgetText = function(){
    var scope = angular.element(document.getElementById('screenOverviewLargePanel')).scope();
    return scope.overviewLarge_info_propertyText;
};


overviewLarge$setSearchNameTextField_widgetText = function(text){
    var scope = angular.element(document.getElementById('screenOverviewLargePanel')).scope();
    scope.$apply(function(){
        scope.overviewLarge_searchNameTextField_propertyText = text;
    });
};
overviewLarge$getSearchNameTextField_widgetText = function(){
    var scope = angular.element(document.getElementById('screenOverviewLargePanel')).scope();
    return scope.overviewLarge_searchNameTextField_propertyText;
};



overviewLarge$setContacts_dto = function(jsonString){
    var paramObject = JSON.parse(jsonString);
    var scope = angular.element(document.getElementById('screenOverviewLargePanel')).scope();
    scope.$apply(function(){
        scope.contacts = paramObject;
    });
};
overviewLarge$getContacts_dto = function(){
    var scope = angular.element(document.getElementById('screenOverviewLargePanel')).scope();
    var result = new Object();
    if (scope.contacts != null){
        result = JSON.parse(JSON.stringify(scope.contacts));
    }
    return JSON.stringify(result);
};

overviewLarge$initDTOTypeContactForPreview = function(index){
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
overviewLarge$initDTOTypeContactListForPreview = function(index){
    var result = new Object();
    result.items = [];
    result.items[0] = overviewLarge$initDTOTypeContactForPreview(0);
    result.items[1] = overviewLarge$initDTOTypeContactForPreview(1);
    result.items[2] = overviewLarge$initDTOTypeContactForPreview(2);
    result.items[3] = overviewLarge$initDTOTypeContactForPreview(3);
    result.items[4] = overviewLarge$initDTOTypeContactForPreview(4);
    result.items[5] = overviewLarge$initDTOTypeContactForPreview(5);
    result.items[6] = overviewLarge$initDTOTypeContactForPreview(6);
    result.items[7] = overviewLarge$initDTOTypeContactForPreview(7);
    result.items[8] = overviewLarge$initDTOTypeContactForPreview(8);
    result.items[9] = overviewLarge$initDTOTypeContactForPreview(9);
    return result;
};
overviewLarge$initDTOTypeContactListListForPreview = function(index){
    var result = new Object();
    result.items = [];
    result.items[0] = overviewLarge$initDTOTypeContactListForPreview(0);
    result.items[1] = overviewLarge$initDTOTypeContactListForPreview(1);
    result.items[2] = overviewLarge$initDTOTypeContactListForPreview(2);
    result.items[3] = overviewLarge$initDTOTypeContactListForPreview(3);
    result.items[4] = overviewLarge$initDTOTypeContactListForPreview(4);
    result.items[5] = overviewLarge$initDTOTypeContactListForPreview(5);
    result.items[6] = overviewLarge$initDTOTypeContactListForPreview(6);
    result.items[7] = overviewLarge$initDTOTypeContactListForPreview(7);
    result.items[8] = overviewLarge$initDTOTypeContactListForPreview(8);
    result.items[9] = overviewLarge$initDTOTypeContactListForPreview(9);
    return result;
};
overviewLarge$initDTOTypeContactTypeForPreview = function(index){
    var result = new Object();
    result.id = "1" + "(" + index + ")";
    result.label = "type xyz" + "(" + index + ")";
    result.imageAssetID = "myimage" + "(" + index + ")";
    return result;
};
overviewLarge$initDTOTypeContactTypeListForPreview = function(index){
    var result = new Object();
    result.items = [];
    result.items[0] = overviewLarge$initDTOTypeContactTypeForPreview(0);
    result.items[1] = overviewLarge$initDTOTypeContactTypeForPreview(1);
    result.items[2] = overviewLarge$initDTOTypeContactTypeForPreview(2);
    result.items[3] = overviewLarge$initDTOTypeContactTypeForPreview(3);
    result.items[4] = overviewLarge$initDTOTypeContactTypeForPreview(4);
    result.items[5] = overviewLarge$initDTOTypeContactTypeForPreview(5);
    result.items[6] = overviewLarge$initDTOTypeContactTypeForPreview(6);
    result.items[7] = overviewLarge$initDTOTypeContactTypeForPreview(7);
    result.items[8] = overviewLarge$initDTOTypeContactTypeForPreview(8);
    result.items[9] = overviewLarge$initDTOTypeContactTypeForPreview(9);
    return result;
};
overviewLarge$initDTOTypeContactTypeListListForPreview = function(index){
    var result = new Object();
    result.items = [];
    result.items[0] = overviewLarge$initDTOTypeContactTypeListForPreview(0);
    result.items[1] = overviewLarge$initDTOTypeContactTypeListForPreview(1);
    result.items[2] = overviewLarge$initDTOTypeContactTypeListForPreview(2);
    result.items[3] = overviewLarge$initDTOTypeContactTypeListForPreview(3);
    result.items[4] = overviewLarge$initDTOTypeContactTypeListForPreview(4);
    result.items[5] = overviewLarge$initDTOTypeContactTypeListForPreview(5);
    result.items[6] = overviewLarge$initDTOTypeContactTypeListForPreview(6);
    result.items[7] = overviewLarge$initDTOTypeContactTypeListForPreview(7);
    result.items[8] = overviewLarge$initDTOTypeContactTypeListForPreview(8);
    result.items[9] = overviewLarge$initDTOTypeContactTypeListForPreview(9);
    return result;
};

overviewLarge$initForPreview = function(){
    console.log('overviewLarge:executing initForPreview in JS!');
    var scope = angular.element(document.getElementById('screenOverviewLargePanel')).scope();
    scope.contacts = overviewLarge$initDTOTypeContactListForPreview(0);
    setTimeout(function() {scope.$digest();}, 0);
}


var overviewLarge$findItemWithID = function(scope, variableName, id){
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
var overviewLarge$openScreen = function(screenToOpen, openParameter){
    if (singlePageApp) {
        setTimeout(function() {openScreenSinglePageApp(screenToOpen, openParameter);}, 0);
    } else {
        overviewLarge$openScreenMultiPageApp(screenToOpen, openParameter);
    }
}
var overviewLarge$openScreenMultiPageApp = function(screenToOpen, openParameter){
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

overviewLarge$backButtonPressed = function(){
    console.log("Screen overviewLarge: Back pressed.");
};

overviewLarge$updateViews = function(){
};

overviewLarge$processReply = function(jsonString){
    var reply = JSON.parse(jsonString);
    if (typeof reply.languageToSet != "undefined") {
        currentLanguage = reply.languageToSet;
    }
    var scope = angular.element(document.getElementById('screenOverviewLargePanel')).scope();
    for (i = 0, len = reply.dtosToSet.length; i < len; i++) {
        var dtoValue = reply.dtoValues[reply.dtosToSet[i]];
        scope[reply.dtosToSet[i]] = dtoValue;
        if (reply.dtosToSet[i] == 'contacts'){
        }
    }
    for (i = 0, len = reply.dtosToSet.length; i < len; i++) {
        var dtoValue = reply.dtoValues[reply.dtosToSet[i]];
        if (reply.dtosToSet[i] == 'contacts'){
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
        scope[key] = overviewLarge$findItemWithID(scope, key, reply.selectBoxSelectedIDs[key]);
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
        overviewLarge$openScreen(screenToOpen, reply.openParameter);
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
        scope.showInputDialog(inputDialogParameters.referenceID, inputDialogParameters.callbackData, inputDialogParameters.title, inputDialogParameters.textContent, inputDialogParameters.label, inputDialogParameters.initialValueText, inputDialogParameters.okText, inputDialogParameters.cancelText);
    }

    var confirmDialogParameters = reply.confirmDialogParameters;
    if (typeof confirmDialogParameters != "undefined") {
        scope.showConfirm(confirmDialogParameters.referenceID, confirmDialogParameters.callbackData, confirmDialogParameters.title, confirmDialogParameters.textContent, confirmDialogParameters.okText, confirmDialogParameters.cancelText);
    }
    if (typeof reply.listChooserParameters != "undefined") {
        scope.showListChooser(reply.listChooserParameters);
    }
    setTimeout(function() {scope.$digest();overviewLarge$updateViews();}, 0);

};
