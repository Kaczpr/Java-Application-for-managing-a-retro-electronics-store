public class date {
    private int days; //days since 1970
    dateTools tool = new dateTools();

    //Constructors
    public date(){ //default constructor
        this.days = 0;
    } //default constructor

    public date(int d) throws dateException {
        if(d<0) throw new dateException("Invalid number of days!");
        this.days = d;
    } //constructor with one int, give it amount of days since 1.1.1970;

    public date(int d, int m, int y) throws dateException {
        tool.validateMonth(m);
        tool.validateYear(y);
        if(d<0) throw new dateException("Invalid number of days!");
        if(d>tool.howManyDaysInThisMonth(m,y)) throw new dateException("Invalid number of days!");
        this.days = d;
        this.days += tool.daysInThisYearFirstOfTheMonth(m,y);
        this.days += tool.daysUpToThisYear(y);
        this.days--;
    }//constructor with 3 ints, give int for day, month and year

    public date(String stringData) throws dateException {
        String[] st = stringData.split("-");
        int d = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);
        int y = Integer.parseInt(st[2]);
        tool.validateMonth(m);
        tool.validateYear(y);
        if(d<0) throw new dateException("Invalid number of days!");
        this.days = d;
        this.days += tool.daysInThisYearFirstOfTheMonth(m,y);
        this.days += tool.daysUpToThisYear(y);
        this.days--;

    }//constructor with String, separates string with - , and ;

    //getters
    public int getDaysSince(){
        return this.days;
    }//returns attribute 'days'
    public Integer [] getSpecific() throws dateException {
        int currentDay = 0;
        int currentMonth = 0;
        int currentYear = 0;
        currentYear = tool.whatYearIsIt(this.days)[0];
        currentMonth = tool.whatMonthIsIt(tool.whatYearIsIt(this.days)[1], currentYear)[0];
        currentDay = tool.whatMonthIsIt(tool.whatYearIsIt(this.days)[1], currentYear)[1] + 1;

        //sekcja wstydu a więc okropne if'y. Są bardzo niezgrabne ale rozwiązują problemy z wypisywaniem dat.
        //A DAY MAY COME WHEN znajde pomysł jak to rozwiązać. BUT IT IS NOT THIS DAY!
        if (currentDay == 32) {
            currentDay = 1;
            currentMonth++;
        }
        if (currentDay == 31 && tool.howManyDaysInThisMonth(currentMonth, currentYear) == 30) {
            currentDay = 1;
            currentMonth++;
        }
        if((currentDay==1 && currentMonth==13)){
            currentMonth = 1;
            currentYear++;
        }
        if(currentDay==29 && currentMonth==2){
            currentDay=1;
            currentMonth=3;
        }
        Integer [] answer = {1,2,3};
        answer[0] = currentDay;
        answer[1] = currentMonth;
        answer[2] = currentYear;
        return answer;
    }//function based on printDate function. returns day - [0], month - [1], year - [2];

    //setters
    public void setDays(int d){
        this.days = d;
    }//sets attribute 'days'

    public void printFUllDate() throws dateException {
        int currentDay = 0;
        int currentMonth = 0;
        int currentYear = 0;
        currentYear = tool.whatYearIsIt(this.days)[0];
        currentMonth = tool.whatMonthIsIt(tool.whatYearIsIt(this.days)[1], currentYear)[0];
        currentDay = tool.whatMonthIsIt(tool.whatYearIsIt(this.days)[1], currentYear)[1] + 1;

        //sekcja wstydu a więc okropne if'y. Są bardzo niezgrabne ale rozwiązują problemy z wypisywaniem dat.
        //A DAY MAY COME WHEN znajde pomysł jak to rozwiązać. BUT IT IS NOT THIS DAY!
        if (currentDay == 32) {
            currentDay = 1;
            currentMonth++;
        }
        if (currentDay == 31 && tool.howManyDaysInThisMonth(currentMonth, currentYear) == 30) {
            currentDay = 1;
            currentMonth++;
        }
        if((currentDay==1 && currentMonth==13)){
            currentMonth = 1;
            currentYear++;
        }
        if(currentDay==29 && currentMonth==2){
            currentDay=1;
            currentMonth=3;
        }


        System.out.println(this.dayOfTheWeek() + ": " + currentDay + "-" + currentMonth + "-" + currentYear);

    } //Prints current date in nice format :>

    public String dateToString() throws dateException {
        Integer currentDay = 0;
        Integer currentMonth = 0;
        Integer currentYear = 0;
        currentYear = tool.whatYearIsIt(this.days)[0];
        currentMonth = tool.whatMonthIsIt(tool.whatYearIsIt(this.days)[1], currentYear)[0];
        currentDay = tool.whatMonthIsIt(tool.whatYearIsIt(this.days)[1], currentYear)[1] + 1;

        //sekcja wstydu a więc okropne if'y. Są bardzo niezgrabne ale rozwiązują problemy z wypisywaniem dat.
        //A DAY MAY COME WHEN znajde pomysł jak to rozwiązać. BUT IT IS NOT THIS DAY!
        if (currentDay == 32) {
            currentDay = 1;
            currentMonth++;
        }
        if (currentDay == 31 && tool.howManyDaysInThisMonth(currentMonth, currentYear) == 30) {
            currentDay = 1;
            currentMonth++;
        }
        if((currentDay==1 && currentMonth==13)){
            currentMonth = 1;
            currentYear++;
        }
        if(currentDay==29 && currentMonth==2){
            currentDay=1;
            currentMonth=3;
        }

        return new String(currentDay.toString() + "." + currentMonth.toString() +
                "." + currentYear.toString());

    }

    public Boolean compare (date x) throws dateException {
        if(this.days> x.days){
            System.out.print("Date: ");
            this.dateToString();
            System.out.print(" is an later date in comparison to date: ");
            x.dateToString();
            return true;
        }
        else{
            System.out.print("Date: ");
            x.dateToString();
            System.out.print(" is an later date in comparison to date: ");
            this.dateToString();
            return false;
        }
    }//compares 2 dates

    public void tomorrow(){
        this.days++;
    }
    public void yesterday(){
        this.days--;
    }
    public void in_aWeek(){
        this.days +=7;
    }
    public void aWeekAgo(){
        this.days -= 7;
    } //self-explanatory

    public String dayOfTheWeek(){
        // String[] names = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        String[] names ={"Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday"};
        //1.1.1970 was Thursday


        return names[this.days%7];
    }

    @Override
    public int hashCode(){
        return this.days;
    }


}