package reader.criteria;

public class EndsWithQuestionOrExclamationMark implements Criterion {
    @Override
    public boolean complies(String line) {
        int lastIndex = line.length() - 1;
        if (lastIndex >= 0) {
            char lastChar = line.charAt(lastIndex);
            return (lastChar == '?' || lastChar == '!');
        }
        return false;
    }
}
