import java.util.Objects;

/**
 * Klasa reprezentuje towar obrandowany marką związaną z retro grami (kubki, torby i koszulki mają swoją własną klase).
 */
public class merchandise extends product{
    private String brand;

    /**
     * Konstruktor domyślny, wpisujący noData do każdego pola.
     * @throws dateException Zgłasza wyjątek związany z datą.
     */
    public merchandise() throws dateException {
        super();
        brand = "noData";
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
     * @param brand marka
     * @throws dateException Zgłasza wyjątek związany z datą.
     */
    public merchandise(int ID, int price, String admissionDate, String name, String category, String producer, String productionDate, String brand) throws dateException{
        super(ID, price, admissionDate, name, category, producer, productionDate);
        this.brand = brand;
    }
    /**
     * Konstruktor kopiujący.
     * @param merchandise objekt klasy merchandise, który kopiujemy.
     * @throws dateException Zgłasza wyjątek związany z datą.
     */
    public merchandise(merchandise merchandise) throws dateException{
        super(merchandise);
        this.brand = merchandise.getBrand();
    }

    /**
     * Getter dla pola brand.
     * @return brand.
     */
    public String getBrand(){
        return this.brand;
    }

    /**
     * Przeciążenie metody equals.
     * @param obj Objekt do którego porównujemy.
     * @return true, jeśli objekty są takie same. Rozumiemy przez to że mają tę samą: kategorie, producenta, markę.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        merchandise merchandise = (merchandise) obj;
        return  Objects.equals(this.getCategory(), merchandise.getCategory()) &&
                Objects.equals(this.getProducer(), merchandise.getProducer()) &&
                Objects.equals(this.getBrand(), merchandise.getBrand());

    }
    /**
     * Generujemy hashcode dla objektu.
     * @return Hashcode.
     */
    @Override
    public int hashCode(){
        int toReturn = 13;
        toReturn = 31 * toReturn * this.getCategory().hashCode();
        toReturn = 31 * toReturn * this.getProducer().hashCode();
        toReturn = 31 * toReturn * this.getBrand().hashCode();
        return toReturn;
    }

}
