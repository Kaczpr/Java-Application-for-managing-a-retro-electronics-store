/**
 * Ta klasa obsługuje daty w kalendarzu gregoriańskim. Jej jedynym parametrem jest ilość dni od 1-1-1970.
 */
public class date implements Comparable<date>{
    private int days; //days since 1970
    dateTools tool = new dateTools();

    /**
     * Konstruktor domyślny. Tworzy date 1-1-1990.
     */
    //Constructors
    public date(){ //default constructor
        this.days = 0;
    } //default constructor

    /**
     * Konstruktor przyjmujący jeden parametr - ilosc dni od 1-1-1990
     * @param d ilosc dni
     * @throws dateException Zgłasza wyjątek związany z datą.
     */
    public date(int d) throws dateException {
        if(d<0) throw new dateException("Invalid number of days!");
        this.days = d;
    } //constructor with one int, give it amount of days since 1.1.1970;

    /**
     * Konstruktor przyjmuje 3 parametry.
     * @param d Numer dnia.
     * @param m Numer miesiąca.
     * @param y Numer roku.
     * @throws dateException Zgłasza wyjątek związany z datą.
     */
    public date(int d, int m, int y) throws dateException {
        tool.validateDaysInMonth(d,m, y);
        tool.validateMonth(m);
        tool.validateYear(y);
        if(d<0) throw new dateException("Invalid number of days!");
        if(d>tool.howManyDaysInThisMonth(m,y)) throw new dateException("Invalid number of days!");
        this.days = d;
        this.days += tool.daysInThisYearFirstOfTheMonth(m,y);
        this.days += tool.daysUpToThisYear(y);
        this.days--;
    }//constructor with 3 ints, give int for day, month and year

    /**
     * Konstruktor przyjmujący String w formacie "dd-mm-yyyy".
     * @param stringData String w formacie "dd-mm-yyyy".
     * @throws dateException Zgłasza wyjątek związany z datą.
     */
    public date(String stringData) throws dateException {
        String[] st = stringData.split("-");
        int d = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);
        int y = Integer.parseInt(st[2]);
        tool.validateDaysInMonth(d,m, y);
        tool.validateMonth(m);
        tool.validateYear(y);
        if(d<0) throw new dateException("Invalid number of days!");
        this.days = d;
        this.days += tool.daysInThisYearFirstOfTheMonth(m,y);
        this.days += tool.daysUpToThisYear(y);
        this.days--;

    }//constructor with String, separates string with -.

    //getters

    /**
     * Getter dla pola days.
     * @return days.
     */
    public int getDays(){
        return this.days;
    }//returns attribute 'days'

    /**
     * Metoda zwraca tablice Integerów, w której [0] to numer aktualnego dnia, [1] numer aktualnego miesiąca, [2] rok.
     * @return Tablica dat.
     * @throws dateException Zgłasza wyjątek związany z datą.
     */
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

    /**
     * Setter dla pola days.
     * @param d days.
     */
    public void setDays(int d){
        this.days = d;
    }//sets attribute 'days'

    /**
     * Metoda wypisuje pełną datę w formacie: DzienTygodnia: dd-mm-yyyy.
     * @throws dateException Zgłasza wyjątek związany z datą.
     */
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


    /**
     * Metoda zwraca String w formacie "dd-mm-yyyy"
     * @return String w formacie "dd-mm-yyyy"
     * @throws dateException Zgłasza wyjątek związany z datą.
     */
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

        return new String(currentDay.toString() + "-" + currentMonth.toString() +
                "-" + currentYear.toString());

    }

    /**
     * Metoda podmienia date na taką, jaka byłaby dzień później.
     */
    public void tomorrow(){
        this.days++;
    }

    /**
     * Metoda podmienai date na taką, jaka byłaby dzień wcześniej.
     */
    public void yesterday(){
        this.days--;
    }

    /**
     * Metoda podmienia date na taką, jaka byłaby tydzien później.
     */
    public void in_aWeek(){
        this.days +=7;
    }

    /**
     * Metoda podmienia datę na taką, jaka byłaby tydzien wcześniej.
     */
    public void aWeekAgo(){
        this.days -= 7;
    } //self-explanatory

    /**
     * Metoda zwraca dzien tygodnia dla daty.
     * @return String będący dniem tygodnia.
     */
    public String dayOfTheWeek(){
        // String[] names = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        String[] names ={"Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday"};
        //1.1.1970 was Thursday
        return names[this.days%7];
    }
    /**
     * Generujemy hashcode dla objektu.
     * @return Hashcode.
     */
    @Override
    public int hashCode(){
        return this.days;
    }

    /**
     * Przeciążenie metody compareTo, porownujące daty.
     * @param date objekt do którego porównujemy.
     * @return 1 jeśli data, do której porówujemy jest wcześniejsza. -1 jeśli data, do której porówujemy jest późniejsza. 0 jeśli są równe.
     */
    @Override
    public int compareTo(date date) {
        if(this.days > date.days) return 1;
        else if(this.days < date.getDays()) return -1;
        else return 0;
    }

    /**
     * Przeciążenie metody toString, korzystające z metody dateToString.
     * @return String będący aktualną datą w dormacie "dd-mm-yyyy"
     */
    @Override
    public String toString(){
        try {
            return this.dateToString();
        } catch (dateException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Przeciążenie metody equals. true, jeśli daty są jednakowe.
     * @param obj data, do ktorej porównujemy.
     * @return True, jeśli daty są jednakowe.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        date otherDate = (date) obj;
        return this.days == otherDate.days;
    }

}