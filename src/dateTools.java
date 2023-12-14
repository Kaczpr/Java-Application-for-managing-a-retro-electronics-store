
public class dateTools {

    public void validateMonth(int month) throws dateException {
        if(month>12 || month<0) throw new dateException("Invalid number of month!!");
    } //checks if month isn't something like 13 or -5
    public void validateDaysInMonth(int days, int month, int year) throws dateException {
        if(days > howManyDaysInThisMonth(month, year)||days<0) throw new dateException("Invalid number of days!");
    } //checks if number of days isn't too big or negative
    public void validateYear(int year) throws dateException {
        if(year<1970) throw new dateException("Invalid Year!");
    }

    public Integer controlNumber(int[] pesel){
        int controlNumberToReuturn = 0;
        int [] wages = {1,3,7,9,1,3,7,9,1,3};
        for(int i = 0; i<10; i++){
            controlNumberToReuturn += wages[i] + pesel[i];
        }
        return controlNumberToReuturn;
    }

    public void validatePESEL(char[] peselNumber, date birth, char sex) throws dateException, peselException {
        if(birth.getSpecific()[2] < 2000 && birth.getSpecific()[2] >1899) {
            if (peselNumber[0] != birth.getSpecific()[2].toString().charAt(2))
                throw new peselException("Invalid PESEL number! dd");
            else if (peselNumber[1] != birth.getSpecific()[2].toString().charAt(3))
                throw new peselException("Invalid PESEL number! DD");
            else if (peselNumber[2] != birth.getSpecific()[1].toString().charAt(0))
                throw new peselException("Invalid PESEL number! MM");
            else if (peselNumber[3] != birth.getSpecific()[1].toString().charAt(1))
                throw new peselException("Invalid PESEL number! MM");
            else if (peselNumber[4] != birth.getSpecific()[0].toString().charAt(0))
                throw new peselException("Invalid PESEL number! YY");
            else if (peselNumber[5] != birth.getSpecific()[0].toString().charAt(1))
                throw new peselException("Invalid PESEL number! YY");
            else if (peselNumber[9] % 2 == 0 && sex == 'm') throw new peselException("Invalid PESEL number! SEX");
            else if (peselNumber[9] % 2 == 1 && sex == 'k') throw new peselException("Invalid PESEL number! SEX");
        }
        if(birth.getSpecific()[2] > 2000) {
            if (peselNumber[0] != birth.getSpecific()[2].toString().charAt(2))
                throw new peselException("Invalid PESEL number! D");
            else if (peselNumber[1] != birth.getSpecific()[2].toString().charAt(3))
                throw new peselException("Invalid PESEL number! D");
            else if (peselNumber[4] != birth.getSpecific()[0].toString().charAt(0))
                throw new peselException("Invalid PESEL number! Y");
            else if (peselNumber[5] != birth.getSpecific()[0].toString().charAt(1))
                throw new peselException("Invalid PESEL number! Y");
            else if (peselNumber[9] % 2 == 0 && sex == 'm') throw new peselException("Invalid PESEL number! SEX!");
            else if (peselNumber[9] % 2 == 1 && sex == 'k') throw new peselException("Invalid PESEL number! SEX!");

            if(birth.getSpecific()[1] == 1){
                if (peselNumber[2] != 2)
                    throw new peselException("Invalid PESEL number! MM");
                else if (peselNumber[3] != 1)
                    throw new peselException("Invalid PESEL number! MM");
            }

            if(birth.getSpecific()[1] == 2){
                if (peselNumber[2] != '2')
                    throw new peselException("Invalid PESEL number! MM");
                else if (peselNumber[3] != '2')
                    throw new peselException("Invalid PESEL number! MM");
            }

            if(birth.getSpecific()[1] == 3){
                if (peselNumber[2] != '2')
                    throw new peselException("Invalid PESEL number! MM");
                else if (peselNumber[3] != '3')
                    throw new peselException("Invalid PESEL number! MM");
            }

            if(birth.getSpecific()[1] == 4){
                if (peselNumber[2] != '2')
                    throw new peselException("Invalid PESEL number! MM");
                else if (peselNumber[3] != '4')
                    throw new peselException("Invalid PESEL number! MM");
            }

            if(birth.getSpecific()[1] == 5){
                if (peselNumber[2] != '2')
                    throw new peselException("Invalid PESEL number! MM");
                else if (peselNumber[3] != '5')
                    throw new peselException("Invalid PESEL number! MM");
            }

            if(birth.getSpecific()[1] == 6){
                if (peselNumber[2] != '2')
                    throw new peselException("Invalid PESEL number! MM");
                else if (peselNumber[3] != '6')
                    throw new peselException("Invalid PESEL number! MM");
            }

            if(birth.getSpecific()[1] == 7){
                if (peselNumber[2] != '2')
                    throw new peselException("Invalid PESEL number! MM");
                else if (peselNumber[3] != '7')
                    throw new peselException("Invalid PESEL number! MM");
            }

            if(birth.getSpecific()[1] == 8){
                if (peselNumber[2] != '2')
                    throw new peselException("Invalid PESEL number! MM");
                else if (peselNumber[3] != '8')
                    throw new peselException("Invalid PESEL number! MM");
            }

            if(birth.getSpecific()[1] == 9){
                if (peselNumber[2] != '2')
                    throw new peselException("Invalid PESEL number! MM");
                else if (peselNumber[3] != '9')
                    throw new peselException("Invalid PESEL number! MM");
            }

            if(birth.getSpecific()[1] == 10){
                if (peselNumber[2] != '3')
                    throw new peselException("Invalid PESEL number! MM");
                else if (peselNumber[3] != '0')
                    throw new peselException("Invalid PESEL number! MM");
            }

            if(birth.getSpecific()[1] == 11){
                if (peselNumber[2] != '3')
                    throw new peselException("Invalid PESEL number! MM");
                else if (peselNumber[3] != '1')
                    throw new peselException("Invalid PESEL number! MM");
            }

            if(birth.getSpecific()[1] == 12){
                if (peselNumber[2] != '3'){
                    throw new peselException("Invalid PESEL number! MM");}
                else if (peselNumber[3] != '2'){
                    throw new peselException("Invalid PESEL number! MM");}
            }

            int[] numericPeselNumber = new int[11];
            for(int i = 0; i<11; i++){
                numericPeselNumber[i] = Character.getNumericValue(peselNumber[i]);
            }

            if(controlNumber(numericPeselNumber)<11){
                if (peselNumber[10] != controlNumber(numericPeselNumber)) throw new peselException("Wrong control number");
            }
            if(controlNumber(numericPeselNumber)>10) {
                if (peselNumber[10] != controlNumber(numericPeselNumber).toString().charAt(1))
                    throw new peselException("Wrong control number");
            }


        }

    }

    public int daysInThisYearFirstOfTheMonth(int month, int year) throws dateException {//counting days in this year, assumes its 1st of this month
        validateMonth(month);
        int daysToReturn = 0;
        for(int i = 1; i<(month); i++){
            daysToReturn += howManyDaysInThisMonth(i, year);
        }
        return daysToReturn;
    }//counting days in this year, assumes its 1st of this month

    public int daysSinceBeginningOfTheYear(int day, int month, int year) throws dateException {
        validateYear(year);
        validateMonth(month);
        int daysToReturn = 0;
        for(int i = 1; i<(month); i++){
            daysToReturn += howManyDaysInThisMonth(i, year);
        }
        validateDaysInMonth(daysToReturn, month, year);
        return daysToReturn;

    }//counting days in this year, takes info of particular day in the month

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

    public Boolean isLeapYear(int year) throws dateException {
        validateYear(year);
        if(year%4!=0) return false;
        if(year%100==0 && year%400==0) return true;
        else if (year%100==0 && year%400!=0) return false;


        return true;
    }//checks if year is a leap year

    public int daysInThisYear(int year) throws dateException {
        validateYear(year);
        if(isLeapYear(year)) return 366;
        else return 365;
    }//returns number of days in given year, includes leap years

    public int daysUpToThisYear(int year) throws dateException {
        validateYear(year);
        int days = 0;
        for(int i = 1970; i<year; i++){
            if(isLeapYear(i)) days+=366;
            else days +=365;
        }
        return days;
    }//returns sum of days since 1970 assuming its 1.1.givenYear

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
