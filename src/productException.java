/**
 * Obsługa wyjątków klasy Product.
 */
public class productException extends Exception{ //poprawnosc zostaje sprawdzona w momencie zapisania produktu do magazynu, powolac mozemy instancje z np ujemnym ID, z powtarzającym sie ID itd, jednak zapisac do magazynu nie mozemy
    /**
     * Ta metoda zgłasza wyjątek i wypisuje komunikat (param message) a następnie humorystyczny komunikat o autodestrukcji komputera.
     * @param message Komunikat
     */
    public productException(String message){
        super(message + " Computer will now precede to explode, please stand back");
    }
}
