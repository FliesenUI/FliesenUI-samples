/*Generated! Do not modify!*/ package generated.fliesenui.core;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import java.util.Map;
/*Generated! Do not modify!*/ import java.util.HashMap;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ public class FLUIString{
/*Generated! Do not modify!*/     private static final Map<String, String> STRINGS = createStringsMap();
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static String getString(StringLanguage language, StringID id){
/*Generated! Do not modify!*/         String result = STRINGS.get(language + ":" + id);
/*Generated! Do not modify!*/         if (result == null){
/*Generated! Do not modify!*/             result = STRINGS.get("DEFAULT:" + id);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         return result;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     /** @param formatArgs are used just like in String.format */
/*Generated! Do not modify!*/     public static String getString(StringLanguage language, StringID id, Object... formatArgs){
/*Generated! Do not modify!*/         String result = getString(language, id);
/*Generated! Do not modify!*/         if (result == null){
/*Generated! Do not modify!*/             return null;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         return String.format(result, formatArgs);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static String getString(FLUIAbstractReply reply, StringID id){
/*Generated! Do not modify!*/         return getString(reply.getCurrentLanguage(), id);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     /** @param formatArgs are used just like in String.format */
/*Generated! Do not modify!*/     public static String getString(FLUIAbstractReply reply, StringID id, Object... formatArgs){
/*Generated! Do not modify!*/         return getString(reply.getCurrentLanguage(), id, formatArgs);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public enum StringLanguage{DE, DEFAULT}
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public enum StringID{
/*Generated! Do not modify!*/           ACTIONS
/*Generated! Do not modify!*/         , APP_NAME
/*Generated! Do not modify!*/         , CANCEL
/*Generated! Do not modify!*/         , CONTACT
/*Generated! Do not modify!*/         , CONTACT_MANAGER_DEMO
/*Generated! Do not modify!*/         , CONTACT_MANAGER_DEMO_SMALL
/*Generated! Do not modify!*/         , DELETE
/*Generated! Do not modify!*/         , EDIT
/*Generated! Do not modify!*/         , EXPORT_DATA
/*Generated! Do not modify!*/         , FIRSTNAME
/*Generated! Do not modify!*/         , LASTNAME
/*Generated! Do not modify!*/         , MOBILE
/*Generated! Do not modify!*/         , NEW_CONTACT
/*Generated! Do not modify!*/         , SEARCH
/*Generated! Do not modify!*/         , SEARCH_NAME
/*Generated! Do not modify!*/         , TEST
/*Generated! Do not modify!*/         , TYPE    }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private static Map<String, String> createStringsMap(){
/*Generated! Do not modify!*/         Map<String, String> m = new HashMap<String, String>();
/*Generated! Do not modify!*/         m.put("DE:ACTIONS", "Aktionen");
/*Generated! Do not modify!*/         m.put("DE:APP_NAME", "FLUI Demo");
/*Generated! Do not modify!*/         m.put("DE:CANCEL", "Abbrechen");
/*Generated! Do not modify!*/         m.put("DE:CONTACT", "Kontakt");
/*Generated! Do not modify!*/         m.put("DE:CONTACT_MANAGER_DEMO", "Kontakteverwaltung-Demo");
/*Generated! Do not modify!*/         m.put("DE:CONTACT_MANAGER_DEMO_SMALL", "Kontakteverwaltung-Demo (Kleiner Bildschirm)");
/*Generated! Do not modify!*/         m.put("DE:DELETE", "Löschen");
/*Generated! Do not modify!*/         m.put("DE:EDIT", "Bearbeiten");
/*Generated! Do not modify!*/         m.put("DE:EXPORT_DATA", "Daten exportieren");
/*Generated! Do not modify!*/         m.put("DE:FIRSTNAME", "Vorname");
/*Generated! Do not modify!*/         m.put("DE:LASTNAME", "Nachname");
/*Generated! Do not modify!*/         m.put("DE:MOBILE", "Mobil");
/*Generated! Do not modify!*/         m.put("DE:NEW_CONTACT", "Neuer Kontakt");
/*Generated! Do not modify!*/         m.put("DE:SEARCH", "Suchen");
/*Generated! Do not modify!*/         m.put("DE:SEARCH_NAME", "Namen suchen");
/*Generated! Do not modify!*/         m.put("DE:TEST", "Dies ist eine Test-Zeichenkette.");
/*Generated! Do not modify!*/         m.put("DE:TYPE", "Typ");
/*Generated! Do not modify!*/         m.put("DEFAULT:ACTIONS", "Actions");
/*Generated! Do not modify!*/         m.put("DEFAULT:APP_NAME", "FLUI Demo");
/*Generated! Do not modify!*/         m.put("DEFAULT:CANCEL", "Cancel");
/*Generated! Do not modify!*/         m.put("DEFAULT:CONTACT", "Contact");
/*Generated! Do not modify!*/         m.put("DEFAULT:CONTACT_MANAGER_DEMO", "Contact Manager Demo");
/*Generated! Do not modify!*/         m.put("DEFAULT:CONTACT_MANAGER_DEMO_SMALL", "Contact Manager Demo (Small Screen)");
/*Generated! Do not modify!*/         m.put("DEFAULT:DELETE", "Delete");
/*Generated! Do not modify!*/         m.put("DEFAULT:EDIT", "Edit");
/*Generated! Do not modify!*/         m.put("DEFAULT:EXPORT_DATA", "Export data");
/*Generated! Do not modify!*/         m.put("DEFAULT:FIRSTNAME", "Firstname");
/*Generated! Do not modify!*/         m.put("DEFAULT:LASTNAME", "Lastname");
/*Generated! Do not modify!*/         m.put("DEFAULT:MOBILE", "Mobile");
/*Generated! Do not modify!*/         m.put("DEFAULT:NEW_CONTACT", "New Contact");
/*Generated! Do not modify!*/         m.put("DEFAULT:SEARCH", "Search");
/*Generated! Do not modify!*/         m.put("DEFAULT:SEARCH_NAME", "Search name");
/*Generated! Do not modify!*/         m.put("DEFAULT:TEST", "This is a test string.");
/*Generated! Do not modify!*/         m.put("DEFAULT:TYPE", "Type");
/*Generated! Do not modify!*/         return m;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ }
/*Generated! Do not modify!*/ 