public class game extends product{
    String console;
    String[] gameModes;//single/multi/co-op
    String[] genres;

    public game() throws dateException {
        super();
        console = "noData";
        gameModes = new String[]{"noData"};
        genres = new String[]{"noData"};
    }

    public game(int ID, int price, String admissionDate, String category, String producer, String productionDate,
                String console, String[] gameModes, String[] genres) throws dateException{
        super(ID, price, admissionDate, category, producer, productionDate);
        this.console = console;
        this.gameModes = gameModes;
        this.genres = genres;
    }

}
