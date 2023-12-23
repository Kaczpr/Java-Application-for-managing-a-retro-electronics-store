public class game extends product{
    String console;
    String[] gameModes;//single/multi/co-op
    String[] genres;
    String language;
    String medium;

    public game() throws dateException {
        super();
        console = "noData";
        gameModes = new String[]{"noData"};
        genres = new String[]{"noData"};
        this.language = "noData";
    }

    public game(int ID, int price, String admissionDate, String name, String category, String producer, String productionDate,
                String console, String[] gameModes, String[] genres, String language, String medium) throws dateException{
        super(ID, price, admissionDate, name, category, producer, productionDate);
        this.console = console;
        this.gameModes = gameModes;
        this.genres = genres;
        this.language = language;
        this.medium = medium;
    }

}
