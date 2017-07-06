/*Generated! Do not modify!*/ package generated.fliesenui.core;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import generated.fliesenui.screen.DetailsLargeReply;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.DetailsSmallReply;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.OverviewLargeReply;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.OverviewSmallReply;
/*Generated! Do not modify!*/ import java.util.Collection;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ public class FLUIReplyUtil {
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static void showInputDialog(FLUIAbstractReplyContainer reply, String referenceID, String title, String textContent, String label, String initialValueText, String okText, String cancelText){
/*Generated! Do not modify!*/         switch (reply.getClass().getName()){
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.DetailsLargeReply":
/*Generated! Do not modify!*/             ((DetailsLargeReply)reply).showInputDialog(referenceID, title, textContent, label, initialValueText, okText, cancelText);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.DetailsSmallReply":
/*Generated! Do not modify!*/             ((DetailsSmallReply)reply).showInputDialog(referenceID, title, textContent, label, initialValueText, okText, cancelText);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.OverviewLargeReply":
/*Generated! Do not modify!*/             ((OverviewLargeReply)reply).showInputDialog(referenceID, title, textContent, label, initialValueText, okText, cancelText);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.OverviewSmallReply":
/*Generated! Do not modify!*/             ((OverviewSmallReply)reply).showInputDialog(referenceID, title, textContent, label, initialValueText, okText, cancelText);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/     public static void showConfirmDialog(FLUIAbstractReplyContainer reply, String referenceID, String title, String textContent, String okText, String cancelText){
/*Generated! Do not modify!*/         switch (reply.getClass().getName()){
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.DetailsLargeReply":
/*Generated! Do not modify!*/             ((DetailsLargeReply)reply).showConfirmDialog(referenceID, title, textContent, okText, cancelText);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.DetailsSmallReply":
/*Generated! Do not modify!*/             ((DetailsSmallReply)reply).showConfirmDialog(referenceID, title, textContent, okText, cancelText);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.OverviewLargeReply":
/*Generated! Do not modify!*/             ((OverviewLargeReply)reply).showConfirmDialog(referenceID, title, textContent, okText, cancelText);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.OverviewSmallReply":
/*Generated! Do not modify!*/             ((OverviewSmallReply)reply).showConfirmDialog(referenceID, title, textContent, okText, cancelText);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/     public static void showListChooser(FLUIAbstractReplyContainer reply, String referenceID, boolean multiSelect, boolean showFilter, String title, IDLabelImageAssetList items, Collection<String> selectedIDs){
/*Generated! Do not modify!*/         switch (reply.getClass().getName()){
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.DetailsLargeReply":
/*Generated! Do not modify!*/             ((DetailsLargeReply)reply).showListChooser(referenceID, multiSelect, showFilter, title, items, selectedIDs);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.DetailsSmallReply":
/*Generated! Do not modify!*/             ((DetailsSmallReply)reply).showListChooser(referenceID, multiSelect, showFilter, title, items, selectedIDs);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.OverviewLargeReply":
/*Generated! Do not modify!*/             ((OverviewLargeReply)reply).showListChooser(referenceID, multiSelect, showFilter, title, items, selectedIDs);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.OverviewSmallReply":
/*Generated! Do not modify!*/             ((OverviewSmallReply)reply).showListChooser(referenceID, multiSelect, showFilter, title, items, selectedIDs);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/     public static void showListChooser(FLUIAbstractReplyContainer reply, String referenceID, boolean multiSelect, boolean showFilter, String title, IDLabelList items, Collection<String> selectedIDs){
/*Generated! Do not modify!*/         switch (reply.getClass().getName()){
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.DetailsLargeReply":
/*Generated! Do not modify!*/             ((DetailsLargeReply)reply).showListChooser(referenceID, multiSelect, showFilter, title, items, selectedIDs);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.DetailsSmallReply":
/*Generated! Do not modify!*/             ((DetailsSmallReply)reply).showListChooser(referenceID, multiSelect, showFilter, title, items, selectedIDs);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.OverviewLargeReply":
/*Generated! Do not modify!*/             ((OverviewLargeReply)reply).showListChooser(referenceID, multiSelect, showFilter, title, items, selectedIDs);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.OverviewSmallReply":
/*Generated! Do not modify!*/             ((OverviewSmallReply)reply).showListChooser(referenceID, multiSelect, showFilter, title, items, selectedIDs);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/     public static void showListChooser(FLUIAbstractReplyContainer reply, String referenceID, boolean multiSelect, boolean showFilter, String title, String okText, String cancelText, IDLabelImageAssetList items, Collection<String> selectedIDs){
/*Generated! Do not modify!*/         switch (reply.getClass().getName()){
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.DetailsLargeReply":
/*Generated! Do not modify!*/             ((DetailsLargeReply)reply).showListChooser(referenceID, multiSelect, showFilter, title, okText, cancelText, items, selectedIDs);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.DetailsSmallReply":
/*Generated! Do not modify!*/             ((DetailsSmallReply)reply).showListChooser(referenceID, multiSelect, showFilter, title, okText, cancelText, items, selectedIDs);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.OverviewLargeReply":
/*Generated! Do not modify!*/             ((OverviewLargeReply)reply).showListChooser(referenceID, multiSelect, showFilter, title, okText, cancelText, items, selectedIDs);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.OverviewSmallReply":
/*Generated! Do not modify!*/             ((OverviewSmallReply)reply).showListChooser(referenceID, multiSelect, showFilter, title, okText, cancelText, items, selectedIDs);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/     public static void showListChooser(FLUIAbstractReplyContainer reply, String referenceID, boolean multiSelect, boolean showFilter, String title, String okText, String cancelText, IDLabelList items, Collection<String> selectedIDs){
/*Generated! Do not modify!*/         switch (reply.getClass().getName()){
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.DetailsLargeReply":
/*Generated! Do not modify!*/             ((DetailsLargeReply)reply).showListChooser(referenceID, multiSelect, showFilter, title, okText, cancelText, items, selectedIDs);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.DetailsSmallReply":
/*Generated! Do not modify!*/             ((DetailsSmallReply)reply).showListChooser(referenceID, multiSelect, showFilter, title, okText, cancelText, items, selectedIDs);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.OverviewLargeReply":
/*Generated! Do not modify!*/             ((OverviewLargeReply)reply).showListChooser(referenceID, multiSelect, showFilter, title, okText, cancelText, items, selectedIDs);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.OverviewSmallReply":
/*Generated! Do not modify!*/             ((OverviewSmallReply)reply).showListChooser(referenceID, multiSelect, showFilter, title, okText, cancelText, items, selectedIDs);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ }