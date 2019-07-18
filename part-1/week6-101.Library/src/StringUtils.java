public class StringUtils {
    public static boolean included(String word, String searched) {
        if (word == null || searched == null) {
            return false;
        }
        String wordCleaned = word.toLowerCase().trim();
        String searchedCleaned = searched.toLowerCase().trim();
        if (wordCleaned.contains(searchedCleaned)) {
            return true;
        } else {
            return false;
        }
    }
}
