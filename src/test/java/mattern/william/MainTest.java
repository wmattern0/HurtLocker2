package mattern.william;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by williammattern on 2/11/17.
 */
public class MainTest {
    Main main;
    String rawInput = "cookies,c00kIes,cha!r,chair,flair,fla!r,p!pe,pipe,pope,type,typ@@@@@@@@,hook,hawk,h@#k";


    @Test
    public void splitter() throws Exception {
        String[] actual = main.splitter(rawInput);
        String[] expected = new String[14] ;
        assertArrayEquals(expected, actual);
    }

}