import java.util.Objects;

/**
 * Ta klasa reprezentuje grę bez blokady regionalnej.
 */
public class game extends product{
    private String console;
    private String[] gameModes;//single/multi/co-op
    private String[] genres;
    private String language;
    private String medium;

    /**
     * Domyślny konstruktor uzupełniający wszystkie pola NoData.
     * @throws dateException Zgłasza wyjątek związany z datą.
     */
    public game() throws dateException {
        super();
        console = "noData";
        gameModes = new String[]{"noData", "SAS", "XDD"};
        genres = new String[]{"noData"};
        this.language = "noData";
    }

    /**
     * Konstruktor przyjmujący wszystkie parametry, w tym daty będące Stringami w formacie "dd-mm-yyyy".
     * @param ID ID unikatowe dla każdego produktu.
     * @param price cena produktu (podawana w GROSZACH!).
     * @param admissionDate data przyjęcia do magazynu.
     * @param name nazwa produktu.
     * @param category kategoria produktu.
     * @param producer producent.
     * @param productionDate data wyprodukowania.
     * @param console konsola, na która została wydana gra
     * @param gameModes Tryby gry
     * @param genres Gatunki
     * @param language język gry
     * @param medium jakie jest medium, na którym znajdują się gry, np. Cartridge, CD-ROM etc.
     * @throws dateException Zgłasza wyjątek związany z datą.
     */
    public game(int ID, int price, String admissionDate, String name, String category, String producer, String productionDate,
                String console, String[] gameModes, String[] genres, String language, String medium) throws dateException{
        super(ID, price, admissionDate, name, category, producer, productionDate);
        this.console = console;
        this.gameModes = gameModes;
        this.genres = genres;
        this.language = language;
        this.medium = medium;
    }

    /**
     * Konstruktor kopiujący
     * @param game gra, którą kopiujemy.
     * @throws dateException Zgłasza wyjątek związany z datą.
     */
    public game(game game) throws dateException{
        super(game);
        this.console = game.console;
        this.gameModes = game.gameModes;
        this.genres = game.genres;
        this.language = game.language;
        this.medium = game.medium;
    }

    /**
     * Getter do pola console.
     * @return console
     */
    public String getConsole(){
        return this.console;
    }
    /**
     * Getter do pola gameModes.
     * @return gameModes
     */
    public String[] getGameModes(){
        return this.gameModes;
    }
    /**
     * Getter do pola genres.
     * @return genres
     */
    public String[] getGenres(){
        return this.genres;
    }
    /**
     * Getter do pola language.
     * @return language
     */
    public String getLanguage(){
        return this.language;
    }
    /**
     * Getter do pola medium.
     * @return medium
     */
    public String getMedium(){
        return this.medium;
    }
    /**
     * Przeciążenie metody equals.
     * @param obj Objekt do którego porównujemy.
     * @return true, jeśli objekty są takie same. Rozumiemy przez to że mają tę samą: kategorie, nazwę, producenta, język, medium.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        game game = (game) obj;
        return  Objects.equals(this.getName(), game.getName()) &&
                Objects.equals(this.getCategory(), game.getCategory()) &&
                Objects.equals(this.getProducer(), game.getProducer()) &&
                Objects.equals(this.getLanguage(), game.getLanguage()) &&
                Objects.equals(this.getMedium(), game.getMedium());
    }
    /**
     * Generujemy hashcode dla objektu.
     * @return Hashcode.
     */
    @Override
    public int hashCode(){
        int toReturn = 13;
        toReturn = 31 * toReturn * this.getName().hashCode();
        toReturn = 31 * toReturn * this.getCategory().hashCode();
        toReturn = 31 * toReturn * this.getProducer().hashCode();
        toReturn = 31 * toReturn * this.getLanguage().hashCode();
        toReturn = 31 * toReturn * this.getMedium().hashCode();
        return toReturn;
    }

}
