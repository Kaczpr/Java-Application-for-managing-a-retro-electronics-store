public class productException extends Exception{ //poprawnosc zostaje sprawdzona w momencie zapisania produktu do magazynu, powolac mozemy instancje z np ujemnym ID, z powtarzającym sie ID itd, jednak zapisac do magazynu nie mozemy
    public productException(String message){
        super(message + " Computer will now precede to explode, please stand back");
    }
}
