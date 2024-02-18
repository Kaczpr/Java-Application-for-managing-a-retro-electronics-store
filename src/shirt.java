import java.util.Objects;

/**
 * Ta klasa reprezentuje koszulki.
 */
public final class shirt extends merchandise{
    private String size;
    private String material;

    /**
     * Konstruktor domyślny uzupełniający pola wartościami noData i 0.
     * @throws dateException Zgłasza wyjątek związany z datą.
     */
    public shirt() throws dateException {
        super();
        this.size = "noData";
        this.material = "noData";
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
     * @param size rozmiar
     * @param material materiał
     * @throws dateException Zgłasza wyjątek związany z datą.
     */
    public shirt(int ID, int price, String admissionDate, String name, String category, String producer, String productionDate,
                 String brand, String size, String material) throws dateException {
        super(ID, price, admissionDate, name, category, producer, productionDate, brand);
        this.size = size;
        this.material = material;
    }

    /**
     * Konstruktor kopiujący.
     * @param shirt objekt klasy shirt, który kopiujemy.
     * @throws dateException Zgłasza wyjątek związany z datą.
     */
    public shirt(shirt shirt) throws dateException{
        super(shirt);
        this.size = shirt.getSize();
        this.material = shirt.getMaterial();
    }

    /**
     * Getter dla pola size
     * @return size
     */
    public String getSize(){
        return this.size;
    }

    /**
     * Getter dla pola material
     * @return material
     */
    public String getMaterial(){
        return this.material;
    }
    /**
     * Przeciążenie metody equals.
     * @param obj Objekt do którego porównujemy.
     * @return true, jeśli objekty są takie same. Rozumiemy przez to że mają tę samą: kategorie, producenta, markę, rozmiar, materiał.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        shirt shirt = (shirt) obj;
        return  Objects.equals(this.getCategory(), shirt.getCategory()) &&
                Objects.equals(this.getProducer(), shirt.getProducer()) &&
                Objects.equals(this.getBrand(), shirt.getBrand()) &&
                Objects.equals(this.getSize(), shirt.getSize()) &&
                Objects.equals(this.getMaterial(), shirt.getMaterial());

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
        toReturn = 31 * toReturn * this.getSize().hashCode();
        toReturn = 31 * toReturn * this.getMaterial().hashCode();
        return toReturn;
    }
}
