package mattern.william;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by williammattern on 2/11/17.
 */
public class PossibileLeetspeakDuplicateTest {
    PossibileLeetspeakDuplicate cookies;
    String cookiesString;

    @Before
    public void setUp(){
        cookiesString = "cookies";
        cookies = new PossibleLeetspeakDuplicateBuilder().setFirstChar('c').setLastChar('*').setLength(7).setSourceString(cookiesString).createPossibleLeetspeakDuplicate();
        cookies.setLeetspeakPattern();
}

    @Test
    public void buildLeetspeakPattern() throws Exception {
        String expected = "((?i)(c.{5}s))";
        String actual = cookies.buildLeetspeakPattern();
        assertEquals(expected,actual);

    }

    @Test
    public void setLeetspeakPattern() throws Exception {
        String expected = "((?i)(c.{5}[s|@]+))";
        String actual = cookies.leetspeakPattern;
        assertEquals(expected,actual);
    }
}