package util;

public class Util {

    /**
     * converts a string containing 2 words to title case
     * @param strIn the in put string
     * @return the string in title case
     */
    public static String toTitleCase(String strIn) {
        if (strIn == null || strIn.isEmpty()) {
            return strIn;
        }

        int idx = strIn.indexOf(' ');
        String firstWord = strIn.substring(0, idx);
        String secondWord = strIn.substring(idx + 1);
        String fLetterFWord = firstWord.substring(0, 1).toUpperCase();
        String restFWord = firstWord.substring(1).toLowerCase();
        String fLetterSWord = secondWord.substring(0, 1).toUpperCase();
        String restSWord = secondWord.substring(1).toLowerCase();

        return String.format("%s%s %s%s", fLetterFWord, restFWord, fLetterSWord, restSWord);
    }
}
