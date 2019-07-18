package reader.criteria;

public class Not implements Criterion {
    private Criterion c;
    
    public Not(Criterion criterion) {
        this.c = criterion;
    }
    
    @Override
    public boolean complies(String line) {
        return !c.complies(line);
    }
}
