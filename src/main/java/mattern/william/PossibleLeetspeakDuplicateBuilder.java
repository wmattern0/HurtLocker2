package mattern.william;

/**
 * Created by williammattern on 2/11/17.
 */
public class PossibleLeetspeakDuplicateBuilder {
    String sourceString;
    char firstChar;
    char lastChar;
    int length;
    String leetspeakPattern;

    public PossibleLeetspeakDuplicateBuilder setSourceString(String sourceString){
        this.sourceString = sourceString;
        return this;
    }

    public PossibleLeetspeakDuplicateBuilder setLastChar(char lastChar) {
        this.lastChar = lastChar;
        return this;
    }

    public PossibleLeetspeakDuplicateBuilder setFirstChar(char firstChar){
        this.firstChar = firstChar;
        return this;
    }

    public PossibleLeetspeakDuplicateBuilder setLength(int length){
        this.length = length;
        return this;
    }

    public PossibleLeetspeakDuplicateBuilder setLeetspeakPattern(String leetspeakPattern){
        this.leetspeakPattern = leetspeakPattern;
        return this;
    }

    public PossibileLeetspeakDuplicate createPossibleLeetspeakDuplicate(){
        return new PossibileLeetspeakDuplicate(sourceString, firstChar, lastChar, length, leetspeakPattern);
    }
}

