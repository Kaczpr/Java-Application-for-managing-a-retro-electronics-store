import java.util.Objects;

/**
 * Ta klasa remrezentuje kubki.
 */
public class mug extends merchandise{
    private int volume;

    /**
     * Konstruktor domyślny, wpisujący noData do każdego pola.
     * @throws dateException Zgłasza wyjątek związany z datą.
     */
    public mug() throws dateException {
        super();
        this.volume = 0;
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
     * @param volume objetność.
     * @throws dateException Zgłasza wyjątek związany z datą.
     */
    public mug(int ID, int price, String admissionDate, String name, String category, String producer, String productionDate,
                 String brand, int volume) throws dateException {
        super(ID, price, admissionDate, name, category, producer, productionDate, brand);
        this.volume = volume;
    }
    /**
     * Konstruktor kopiujący.
     * @param mug objekt klasy mug, który kopiujemy.
     * @throws dateException Zgłasza wyjątek związany z datą.
     */
    public mug(mug mug) throws dateException{
        super(mug);
        this.volume = mug.getVolume();
    }

    /**
     * Getter dla pola Volume.
     * @return Volume.
     */
    public int getVolume(){
        return this.volume;
    }
    /**
     * Przeciążenie metody equals.
     * @param obj Objekt do którego porównujemy.
     * @return true, jeśli objekty są takie same. Rozumiemy przez to że mają tę samą: kategorie, producenta, markę, objętość.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        mug mug = (mug) obj;
        return  Objects.equals(this.getCategory(), mug.getCategory()) &&
                Objects.equals(this.getProducer(), mug.getProducer()) &&
                Objects.equals(this.getBrand(), mug.getBrand()) &&
                Objects.equals(this.getVolume(), mug.getVolume());
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
        return toReturn;
    }
}
