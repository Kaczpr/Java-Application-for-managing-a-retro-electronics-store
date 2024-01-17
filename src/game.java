public class game extends product{
    private String console;
    private String[] gameModes;//single/multi/co-op
    private String[] genres;
    private String language;
    private String medium;

    public game() throws dateException {
        super();
        console = "noData";
        gameModes = new String[]{"noData", "SAS", "XDD"};
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

    public String getConsole(){
        return this.console;
    }
    public String[] getGameModes(){
        return this.gameModes;
    }
    public String[] getGenres(){
        return this.genres;
    }
    public String getLanguage(){
        return this.language;
    }
    public String getMedium(){
        return this.medium;
    }



}
