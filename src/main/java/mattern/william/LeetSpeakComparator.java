package mattern.william;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by williammattern on 2/11/17.
 */
public class LeetSpeakComparator implements Comparator<String> {


    public int compare(String regex, String arrayItem) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(arrayItem);
        if (matcher.find())
            return 0;
        else
            return -1;
    }
}
