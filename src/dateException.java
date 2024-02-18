/**
 * Obsługa wyjątków dla klasy date.
 */
public class dateException extends Exception {
    /**
     * Ta metoda zgłasza wyjątek i wypisuje komunikat (param message) a następnie humorystyczny komunikat o autodestrukcji komputera.
     * @param message Komunikat
     */
    public dateException(String message){
        super(message + " Computer will now precede to explode, please stand back");
    }
}
