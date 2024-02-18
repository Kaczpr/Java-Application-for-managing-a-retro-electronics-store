import java.util.Objects;
/**
 * Ta klasa przedstawia automat do gier typu arcade, np. MidwayT Unit.
 */
public final class arcade extends machine{


    private int maxCoinCapacity; //max number of coins that can be stored inside
    private String controller; //dancing mat, "fishing rods", buttons, pistols, steering wheels

    public arcade() throws dateException {
        super();
        maxCoinCapacity = 0;
        controller = "noData";
    }

    /**
     * Konstruktor przyjmujący wszystkie parametry, w tym daty będące obiektami klasy date.
     * @param ID ID unikatowe dla każdego produktu.
     * @param price cena produktu (podawana w GROSZACH!).
     * @param admissionDate data przyjęcia do magazynu.
     * @param name nazwa produktu.
     * @param category kategoria produktu.
     * @param producer producent.
     * @param productionDate data wyprodukowania.
     * @param CPU Central Processing Unit.
     * @param soundChip chip dźwiękowy.
     * @param graphics karta graficzna (może być zintegrowana).
     * @param maxCoinCapacity maksymalna pojemnosc monet (sztuki).
     * @param controller sposób sterowania np. przyciski, mata etc.
     * @throws dateException Zgłasza wyjątek związany z datą.
     */
    public arcade(int ID, int price, date admissionDate, String name, String category,
                  String producer, date productionDate, String CPU, String soundChip, String graphics,
                  int maxCoinCapacity, String controller) throws dateException{
        super(ID, price, admissionDate, name, category, producer, productionDate, CPU, soundChip, graphics);
        this.maxCoinCapacity = maxCoinCapacity;
        this.controller = controller;
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
     * @param CPU Central Processing Unit.
     * @param soundChip chip dźwiękowy.
     * @param graphics karta graficzna (może być zintegrowana).
     * @param maxCoinCapacity maksymalna pojemnosc monet (sztuki).
     * @param controller sposób sterowania np. przyciski, mata etc.
     * @throws dateException Zgłasza wyjątek związany z datą.
     */
    public arcade(int ID, int price, String admissionDate, String name, String category,
                  String producer, String productionDate, String CPU, String soundChip, String graphics,
                  int maxCoinCapacity, String controller) throws dateException{
        super(ID, price, admissionDate, name, category, producer, productionDate, CPU, soundChip, graphics);
        this.maxCoinCapacity = maxCoinCapacity;
        this.controller = controller;
    }

    /**
     * Konstruktor kopiujący.
     * @param arcade instancja klasy arcade, którą skopiujemy do nowego obiektu.
     * @throws dateException Zgłasza wyjątek związany z klasą Date.
     */
    public arcade(arcade arcade) throws dateException{
        super(arcade);
        this.maxCoinCapacity = arcade.getMaxCoinCapacity();
        this.controller = arcade.getController();
    }

    /**
     * Getter dla pola maxCoinCapasity.
     * @return Zwraca pole maxCoinCapasity.
     */
    public int getMaxCoinCapacity (){
        return this.maxCoinCapacity;
    }

    /**
     * Getter dla pola controller.
     * @return zwraca pole controller.
     */
    public String getController (){
        return this.controller;
    }

    /**
     * Przeciążenie metody equals.
     * @param obj Objekt który porównujemy.
     * @return true jeśli objekty są takie same. Takie same, znaczy mają te same: ketegorie i nazwy.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        arcade arcade = (arcade) obj;
        return  Objects.equals(this.getCategory(), arcade.getCategory()) &&
                Objects.equals(this.getName(), arcade.getName());
    }

    /**
     * Generujemy hashcode dla objektu.
     * @return Hashcode.
     */
    @Override
    public int hashCode(){
        int toReturn = 13;
        toReturn = 31 * toReturn * this.getCategory().hashCode();
        toReturn = 31 * toReturn * this.getName().hashCode();
        return toReturn;
    }

}
