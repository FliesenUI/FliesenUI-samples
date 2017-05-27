/*Generated! Do not modify!*/ package generated.fliesenui.screen;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIClientPropertiesDTO;
/*Generated! Do not modify!*/ import java.io.InputStream;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ public interface HelloWorldListener{
/*Generated! Do not modify!*/     void onLoaded(HelloWorldReply reply, FLUIClientPropertiesDTO clientProperties);
/*Generated! Do not modify!*/     void onInputDialogResult(HelloWorldReply reply, String referenceID, String dialogResult);
/*Generated! Do not modify!*/     void onConfirmDialogResult(HelloWorldReply reply, String referenceID, boolean confirmed);
/*Generated! Do not modify!*/     void onListChooserResult(HelloWorldReply reply, String referenceID, java.util.List<String> selectedIDs);
/*Generated! Do not modify!*/     void onGreetButtonClicked(HelloWorldReply reply, String nameTextFieldText);
/*Generated! Do not modify!*/ }