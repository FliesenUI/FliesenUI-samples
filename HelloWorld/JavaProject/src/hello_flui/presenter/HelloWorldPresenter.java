package hello_flui.presenter;

import java.util.List;

import generated.fliesenui.core.FLUIClientPropertiesDTO;
import generated.fliesenui.screen.HelloWorldListener;
import generated.fliesenui.screen.HelloWorldReply;

public class HelloWorldPresenter implements HelloWorldListener {

	@Override
	public void onGreetButtonClicked(HelloWorldReply reply, String nameTextFieldText) {
		if (nameTextFieldText.isEmpty()){
			reply.setInfoToast("Please enter a name");
			return;
		}
		reply.setGreetingLabelText("Hello " + nameTextFieldText + "!");
	}
	
	@Override
	public void onLoaded(HelloWorldReply reply, FLUIClientPropertiesDTO clientProperties) {
	}

	@Override
	public void onInputDialogResult(HelloWorldReply reply, String referenceID, String dialogResult) {
	}

	@Override
	public void onConfirmDialogResult(HelloWorldReply reply, String referenceID, boolean confirmed) {
	}

	@Override
	public void onListChooserResult(HelloWorldReply reply, String referenceID, List<String> selectedIDs) {
	}

}
