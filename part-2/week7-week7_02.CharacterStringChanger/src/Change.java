public class Change {
    private char fromCharacter;
    private char toCharacter;
    
    public Change(char fromCharacter, char toCharacter) {
        this.fromCharacter = fromCharacter;
        this.toCharacter = toCharacter;
    }
    
    public String change(String characterString) {
        char[] chars = characterString.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == fromCharacter) {
                chars[i] = toCharacter;
            }
        }
        return new String(chars);
    }
}
