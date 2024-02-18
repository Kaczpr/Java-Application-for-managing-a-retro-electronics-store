/**
 * Klasa przydatna do pracowania z datami.
 */
public class dateTools {
    /**
     * Walidacja, a więc sprawdzenie poprawności miesiąca.
     * @param month Miesiąc, który sprawdzamy.
     * @throws dateException Zgłasza wyjątek związany z datą.
     */
    public void validateMonth(int month) throws dateException {
        if(month>12 || month<0) throw new dateException("Invalid number of month!!");
    } //checks if month isn't something like 13 or -5

    /**
     * Walidacja, a więc sprawdzenie ilości dni w danym miesiący w danym roku
     * @param days ilosc dni.
     * @param month miesiac.
     * @param year rok.
     * @throws dateException Zgłasza wyjątek związany z datą.
     */
    public void validateDaysInMonth(int days, int month, int year) throws dateException {
        if(days > howManyDaysInThisMonth(month, year)||days<0) throw new dateException("Invalid number of days!");
    } //checks if number of days isn't too big or negative

    /**
     * Walidacja, a więc sprawdzenie roku.
     * @param year rok.
     * @throws dateException Zgłasza wyjątek związany z datą.
     */
    public void validateYear(int year) throws dateException {
        if(year<1970) throw new dateException("Invalid Year!");
    }

    /**
     * Metoda mówi ile dni mięło od początku roku do pierwszego dnia tego miesiąca w danym roku.
     * @param month miesiac.
     * @param year rok
     * @return ilosc dni.
     * @throws dateException Zgłasza wyjątek związany z datą.
     */

    public int daysInThisYearFirstOfTheMonth(int month, int year) throws dateException {//counting days in this year, assumes its 1st of this month
        validateMonth(month);
        int daysToReturn = 0;
        for(int i = 1; i<(month); i++){
            daysToReturn += howManyDaysInThisMonth(i, year);
        }
        return daysToReturn;
    }//counting days in this year, assumes its 1st of this month

    /**
     * Sprawdza ile dni ma dany miesiąć w danym roku
     * @param month miesiac.
     * @param year rok.
     * @return ilosc dni.
     * @throws dateException Zgłasza wyjątek związany z datą.
     */
    public int howManyDaysInThisMonth(int month, int year) throws dateException {
        validateMonth(month);
        validateYear(year);
        if (month == 2 && !isLeapYear(year)) return 28;
        if (month == 2 && isLeapYear(year)) return 29;

        if(month<8 && month!=2) {
            if(month%2==1)return 31;
            else return 30;
        }
        else if (month >=8){
            if(month%2==1)return 30;
            else return 31;
        }
        return 0;
    }//says how many days are in this month\

    /**
     * Sprawdza, czy rok jest przestępyny.
     * @param year rok.
     * @return True, jeśli rok jest przestępny, false jeśli nie.
     * @throws dateException Zgłasza wyjątek związany z datą.
     */
    public Boolean isLeapYear(int year) throws dateException {
        validateYear(year);
        if(year%4!=0) return false;
        if(year%100==0 && year%400==0) return true;
        else if (year%100==0 && year%400!=0) return false;


        return true;
    }//checks if year is a leap year

    /**
     * Liczy ilosc dni od 1-1-1970 do pierwszego dnia danego roku.
     * @param year rok.
     * @return ilość dni.
     * @throws dateException Zgłasza wyjątek związany z datą.
     */
    public int daysUpToThisYear(int year) throws dateException {
        validateYear(year);
        int days = 0;
        for(int i = 1970; i<year; i++){
            if(isLeapYear(i)) days+=366;
            else days +=365;
        }
        return days;
    }//returns sum of days since 1970 assuming its 1.1.givenYear

    /**
     * Podaje aktualny rok na podstawie ilości dni od 1-1-1970.
     * @param days Ilosc dni.
     * @return Tablica, gdzie [0] aktualny rok, [1] ilosc pozostałych dni.
     * @throws dateException Zgłasza wyjątek związany z datą.
     */
    public int[] whatYearIsIt(int days) throws dateException {
        int [] answer = new int[2];
        answer[0] = 1970;
        int counter = 0;
        for (int i = 0; i < days; i++) {
            if (!isLeapYear(answer[0]) && counter == 365) {
                answer[0]++;
                counter = 0;
            } else if (isLeapYear(answer[0]) && counter == 366) {
                answer[0]++;
                counter = 0;
            }
            counter++;
            answer[1] = counter;
        }
        return answer;
    }//takes number of days since 1.1.1970, returns answer. answer[0] = year, answer[1] = remaining days

    /**
     * Podaje miesiąc na podstawie dni od 1-1-danego roku
     * @param days dni.
     * @param year rok.
     * @return aktualny miesiąc.
     * @throws dateException Zgłasza wyjątek związany z datą.
     */
    public int [] whatMonthIsIt(int days, int year) throws dateException {
        int[] answer = new int[2];
        answer[0] = 1; // month
        int counter = 0;
        for(int i = 0; i<days; i++){
            if(counter == howManyDaysInThisMonth(answer[0], year)){
                answer[0]++;
                counter=0;
            }
            counter++;
            answer[1] = counter;
        }

        return answer;
    }//takes number of days since 1.january and current year - returns month

}
