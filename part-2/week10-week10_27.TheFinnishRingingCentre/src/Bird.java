
public class Bird {

    private String name;
    private String latinName;
    private int ringingYear;

    public Bird(String name, String latinName, int ringingYear) {
        this.name = name;
        this.latinName = latinName;
        this.ringingYear = ringingYear;
    }


    @Override
    public String toString() {
        return this.latinName + " (" + this.ringingYear + ")";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Bird b = (Bird) obj;
        if (b.latinName.equals(this.latinName) && this.ringingYear == b.ringingYear) {
            return true;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return this.latinName.hashCode() + this.ringingYear;
    }
}


