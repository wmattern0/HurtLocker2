package mattern.william;

public class PossibileLeetspeakDuplicate {
    String sourceString;
    char firstChar;
    char lastChar;
    int length;
    String leetspeakPattern;

    public PossibileLeetspeakDuplicate(String sourceString, char firstChar, char lastChar, int length, String leetspeakPattern) {
        this.sourceString = sourceString;
        this.firstChar = firstChar;
        this.lastChar = lastChar;
        this.length = length;
        this.leetspeakPattern = leetspeakPattern;
    }

    String buildLeetspeakPattern(){
        StringBuilder pattern = new StringBuilder();
        return pattern.append("((?i)(").append(firstChar).append(".{").append(length-2).append("}").append(lastChar).append("))").toString();
    }

    public void setLeetspeakPattern(){
        this.leetspeakPattern = buildLeetspeakPattern();
    }

    public String getLeetspeakPattern() {
        return leetspeakPattern;
    }

    @Override
    public String toString(){
        return sourceString;
    }
}
