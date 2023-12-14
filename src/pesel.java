public class pesel {
    dateTools tool = new dateTools();
    char[] peselNumber = new char[11];
    public pesel(String number, date birth, char sex) throws peselException, dateException {
        for(int i =0; i<11; i++){
            peselNumber[i] = number.charAt(i);
        }
        tool.validatePESEL(peselNumber, birth, sex);
    }
    public void wypisz(){
        for(int i =0; i<11; i++){
            System.out.print(peselNumber[i]);
        }
    }
}
