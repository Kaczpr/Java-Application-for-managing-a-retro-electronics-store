/**
 * Obsługa wyjątków dla klasy storage.
 */
public class storageException extends Exception{
    /**
     * Ta metoda zgłasza wyjątek i wypisuje komunikat (param message) a następnie humorystyczny komunikat o autodestrukcji komputera.
     * @param message Komunikat
     */
    public storageException(String message){
        super(message + " Computer will now precede to explode, please stand back");
    }
}
