package generated.fliesenui.core;

public class FLUIImageAssets {

public enum ImageAsset {
        COLLEAGUE("colleague", "colleague.svg")
      , COMPANY("company", "company.svg")
      , FAMILY("family", "family.svg")
      , FRIEND("friend", "friend.svg")
      , LANGUAGE_DE("languageDE", "languageDE.png")
      , LANGUAGE_EN("languageEN", "languageEN.svg")
      , MUSIC("music", "music.png");

        private String id;
        private String filename;

        ImageAsset(String id, String filename) {
            this.id = id;
            this.filename = filename;
        }

        public String getID() {
            return id;
        }

        public String getFilename() {
            return filename;
        }
    }

}
