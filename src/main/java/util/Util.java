package util;

public class Util {
    public String toTitleCase(String strIn) {
        if (strIn == null || strIn.isEmpty()) {
            return strIn;
        }

        int idx = strIn.indexOf(' ');
        String firstWord = strIn.substring(0, idx);
        String secondWord = strIn.substring(idx + 1);
        String fLetterFWord = firstWord.substring(0, 1).toUpperCase();
        String restFWord = firstWord.substring(1, idx).toLowerCase();
        String fLetterSWord = secondWord.substring(idx + 1, idx + 2).toUpperCase();
        String restSWord = secondWord.substring(idx + 2).toLowerCase();

        return String.format("%s%s %s%s", fLetterFWord, restFWord, fLetterSWord, restSWord);
    }
}
