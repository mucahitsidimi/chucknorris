package mucahitsidimi.chucknorris.com.ext;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mucahit on 19/02/2017.
 */

public class TextUtils {

    public static boolean isTextValid(String text) {
        return (text != null) && !(text.trim().contentEquals(""));
    }

    public static String getWordsCount(String text) {

        if (TextUtils.isTextValid(text)) {
            HashMap<String, Integer> wordHashMap = new HashMap<>();

            String[] words = text.split(" ");

            for (String word : words) {
                word = word.toLowerCase();

                if (wordHashMap.containsKey(word)) {
                    wordHashMap.put(word, wordHashMap.get(word) + 1);
                } else {
                    wordHashMap.put(word, 1);
                }
            }

            return wordHashMap.toString();
        }

        return "";
    }

    public static String getLettersCount(String text) {
        if (isTextValid(text)) {
            HashMap<Character, Integer> chracterHashMap = new HashMap<>();

            char[] charArray = text.toCharArray();

            Pattern patternAlphaNumericCheck = Pattern.compile("^[a-zA-Z0-9]+$");

            for (Character character : charArray) {
                Matcher m = patternAlphaNumericCheck.matcher(character.toString());
                if (m.find()) {
                    if (chracterHashMap.containsKey(character)) {
                        chracterHashMap.put(character, chracterHashMap.get(character) + 1);
                    } else {
                        chracterHashMap.put(character, 1);
                    }
                }
            }

            return chracterHashMap.toString();
        }
        return "";
    }

}
