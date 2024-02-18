import java.util.Objects;

/**
 * Ta klasa przedstawia obrandowaną torbę.
 */
public final class bag extends mug{

    private String material;

    /**
     * Konstruktr bazowy uzupełniający automatycznie wszystkie pola jako NoData.
     * @throws dateException Zgłasza wyjątek związany z datą.
     */
    public bag() throws dateException {
        super();
        this.material = "noData";
    }

    /**
     * Konstruktor przyjmujący wszystkie parametry, w tym datę będącą Stringiem w formie "dd-mm-yyyy".
     * @param ID ID unikatowe dla każdego produktu.
     * @param price cena produktu (podawana w GROSZACH!).
     * @param admissionDate data przyjęcia do magazynu.
     * @param name nazwa produktu.
     * @param category kategoria produktu.
     * @param producer producent.
     * @param productionDate data wyprodukowania.
     * @param brand Marka.
     * @param volume Objętość.
     * @param material Materiał.
     * @throws dateException Zgłasza wyjątek związany z datą.
     */
    public bag(int ID, int price, String admissionDate, String name, String category, String producer, String productionDate,
               String brand, int volume, String material) throws dateException {
        super(ID, price, admissionDate, name, category, producer, productionDate, brand, volume);
        this.material = material;
    }

    /**
     * Konstruktor kopiujący.
     * @param bag Objekt klasy bag, który kopiujemy.
     * @throws dateException Zgłasza wyjątek związany z datą.
     */
    public bag(bag bag) throws dateException{
        super(bag);
        this.material = bag.getMaterial();
    }

    /**
     * Getter dla pola material.
     * @return material.
     */
    public String getMaterial(){
        return this.material;
    }

    /**
     * Przeciążenie metody equals.
     * @param obj Objekt do którego porównujemy.
     * @return true, jeśli objekty są takie same. Rozumiemy przez to że mają tę samą: kategorie, producenta, marke, objętość, materiał.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        bag bag = (bag) obj;
        return  Objects.equals(this.getCategory(), bag.getCategory()) &&
                Objects.equals(this.getProducer(), bag.getProducer()) &&
                Objects.equals(this.getBrand(), bag.getBrand()) &&
                Objects.equals(this.getVolume(), bag.getVolume()) &&
                Objects.equals(this.getMaterial(), bag.getMaterial());
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
        toReturn = 31 * toReturn * this.getVolume();
        toReturn = 31 * toReturn * this.getMaterial().hashCode();
        return toReturn;
    }

}
