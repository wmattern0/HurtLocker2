package mattern.william;

import org.apache.commons.io.IOUtils;

import java.util.*;
import java.util.regex.Pattern;


public class Main {
    static Map<String, Integer> mapOfStrings = new HashMap<String, Integer>();
    static Map<PossibileLeetspeakDuplicate, Integer> mapOfLeetspeakItems = new HashMap<PossibileLeetspeakDuplicate, Integer>();
    static String[] individualLeetspeakStrings;
    static Pattern pattern;
    static LeetSpeakComparator leetSpeakComparator;


    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception {
        try {
            leetSpeakComparator = new LeetSpeakComparator();
            String rawInput = (new Main()).readRawDataToString();
            individualLeetspeakStrings = splitter(rawInput);
            System.out.println(Arrays.toString(splitter(rawInput)));
            for (String s : individualLeetspeakStrings) {
                if (mapOfLeetspeakItems.isEmpty()) {
                    PossibileLeetspeakDuplicate newLeetSpeakItem = new PossibleLeetspeakDuplicateBuilder().setFirstChar(s.charAt(0))
                            .setLastChar(s.charAt(s.length() - 1)).setLength(s.length()).setSourceString(s).createPossibleLeetspeakDuplicate();
                    newLeetSpeakItem.setLeetspeakPattern();
                    mapOfLeetspeakItems.put(newLeetSpeakItem, 1);
                } else {
                    boolean matchMet = false;
                    //check new string agains existing possibleDup's
                    for (PossibileLeetspeakDuplicate possibleDup : mapOfLeetspeakItems.keySet()) {
                        if (leetSpeakComparator.compare(possibleDup.getLeetspeakPattern(), s) == 0) {
                            matchMet = true;
                            mapOfLeetspeakItems.put(possibleDup, (mapOfLeetspeakItems.get(possibleDup) + 1));
                        }
                    }
                    if (!matchMet) {//if matchMet is still false
                        PossibileLeetspeakDuplicate newLeetSpeakItem = new PossibleLeetspeakDuplicateBuilder().setFirstChar(s.charAt(0))
                                .setLastChar(s.charAt(s.length() - 1)).setLength(s.length()).setSourceString(s).createPossibleLeetspeakDuplicate();
                        newLeetSpeakItem.setLeetspeakPattern();
                        mapOfLeetspeakItems.put(newLeetSpeakItem, 1);
                    }
                }
            }
            System.out.println(mapOfStrings.toString());

        } catch (WildcardException e){}
        System.out.println(mapOfLeetspeakItems.toString());
    }

    static public String[] splitter(String rawInput){
        return rawInput.split(",");
    }
}
