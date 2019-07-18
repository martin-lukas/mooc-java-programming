public class MyDate {
    private int day;
    private int month;
    private int year;

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    public MyDate(MyDate date) {
        this.day = date.day;
        this.month = date.month;
        this.year = date.year;
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
    
    public int differenceInYears(MyDate comparedDate) {
        int counter = 0;
        
        MyDate earlierDate;
        MyDate laterDate;
        if (this.earlier(comparedDate)) {
            earlierDate = new MyDate(this);
            laterDate = new MyDate(comparedDate);
        } else {
            earlierDate = new MyDate(comparedDate);
            laterDate = new MyDate(this);
        }
        while (!earlierDate.equals(laterDate)) {
            earlierDate.advance();
            counter++;
        }
        return counter / 360;
    }
    
    public boolean equals(MyDate date) {
        if (this.year == date.year && this.month == date.month && this.day == date.day) {
            return true;
        }
        return false;
    }

    public String toString() {
        return this.day + "." + this.month + "." + this.year;
    }

    public boolean earlier(MyDate compared) {
        if (this.year < compared.year) {
            return true;
        }

        if (this.year == compared.year && this.month < compared.month) {
            return true;
        }

        if (this.year == compared.year && this.month == compared.month
                && this.day < compared.day) {
            return true;
        }

        return false;
    }

}
