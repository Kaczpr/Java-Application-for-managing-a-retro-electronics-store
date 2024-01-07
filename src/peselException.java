public class peselException extends Exception {
    public peselException (String message){
        super(message + " Please do NOT try to defraud the government");
    }
}
