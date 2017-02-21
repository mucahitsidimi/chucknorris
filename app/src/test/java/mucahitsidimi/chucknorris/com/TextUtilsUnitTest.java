package mucahitsidimi.chucknorris.com;

import org.junit.Test;

import mucahitsidimi.chucknorris.com.ext.TextUtils;

import static org.junit.Assert.assertEquals;

/**
 * Created by mucahit on 19/02/2017.
 */

public class TextUtilsUnitTest {

    @Test
    public void getLettersCount_isCorrect() throws Exception {
        String string = TextUtils.getLettersCount("a, bb, ccc , dddd, efg");
        assertEquals(string, "{a=1, b=2, c=3, d=4, e=1, f=1, g=1}");
    }

    @Test
    public void getWordsCount_isCorrect() throws Exception {
        String string = TextUtils.getWordsCount("mucahit sidimi deneme deneme");
        assertEquals(string, "{mucahit=1, sidimi=1, deneme=2}");
    }
}
