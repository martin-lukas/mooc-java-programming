public class MyDate {
    private int day;
    private int month;
    private int year;
    
    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    public MyDate afterNumberOfDays(int days) {
        MyDate newDate = new MyDate(day, month, year);
        newDate.advance(days);
        return newDate;
    }
    
    public void advance() {
        if (day == 30) {
            day = 1;
        } else {
            day++;
        }
        if (day == 1) {
            if (month == 12) {
                month = 1;
            } else {
                month++;
            }
            if (month == 1) {
                year++;
            }
        }
    }
    
    public void advance(int numberOfDays) {
        for (int i = 0; i < numberOfDays; i++) {
            advance();
        }
    }
    
    public String toString() {
        return this.day + "." + this.month + "." + this.year;
    }
    
    public boolean earlier(MyDate compared) {
        // first we'll compare years
        if ( this.year < compared.year ) {
            return true;
        }
        
        // if the years are the same, we'll compare the months
        if ( this.year == compared.year && this.month < compared.month ) {
            return true;
        }
        
        // years and months the same, we'll compare the days
        if ( this.year == compared.year && this.month == compared.month &&
                this.day < compared.day ) {
            return true;
        }
        
        return false;
    }
}