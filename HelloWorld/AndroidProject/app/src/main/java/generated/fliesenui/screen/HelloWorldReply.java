/*Generated! Do not modify!*/ package generated.fliesenui.screen;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import java.util.List;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIAbstractReply;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIUtil;
/*Generated! Do not modify!*/ import generated.fliesenui.core.TextHighlighting;
/*Generated! Do not modify!*/ import generated.fliesenui.core.CursorPos;
/*Generated! Do not modify!*/ import generated.fliesenui.core.ContextAssist;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ public class HelloWorldReply extends FLUIAbstractReply {
/*Generated! Do not modify!*/     protected String getJSON() {
/*Generated! Do not modify!*/         return gson.toJson(replyDTO);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setTitleLabelText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("helloWorld_titleLabel_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("helloWorld_titleLabel_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("helloWorld_titleLabel_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setTitleLabelVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("helloWorld_titleLabel_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("helloWorld_titleLabel_propertyVisible", visible);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setNameTextFieldText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("helloWorld_nameTextField_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("helloWorld_nameTextField_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("helloWorld_nameTextField_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setNameTextFieldVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("helloWorld_nameTextField_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("helloWorld_nameTextField_propertyVisible", visible);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setGreetButtonText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("helloWorld_greetButton_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("helloWorld_greetButton_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("helloWorld_greetButton_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setGreetButtonVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("helloWorld_greetButton_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("helloWorld_greetButton_propertyVisible", visible);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setGreetingLabelText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("helloWorld_greetingLabel_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("helloWorld_greetingLabel_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("helloWorld_greetingLabel_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setGreetingLabelVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("helloWorld_greetingLabel_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("helloWorld_greetingLabel_propertyVisible", visible);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void openScreenHelloWorld() {
/*Generated! Do not modify!*/         replyDTO.setScreenToOpen("helloWorld");
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ }