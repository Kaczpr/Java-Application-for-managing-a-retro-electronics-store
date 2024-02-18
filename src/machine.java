import java.util.Objects;

/**
 * Ta klasa przedstawia maszynę (Konsole i Automaty mają swoją własną klasę)
 */
public class machine extends product{
    private String CPU;
    private String soundChip;
    private String graphics;

    /**
     * Konstruktor domyślny, wpisujący noData do każdego pola.
     * @throws dateException Zgłasza wyjątek związany z datą.
     */
    public machine() throws dateException {
        super();
        CPU = "noData";
        soundChip = "noData";
        graphics = "noData";
    }

    /**
     * Konstruktor przyjmujący wszystkie parametry, w tym daty będące instancjami klasy Date.
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
     * @throws dateException Zgłasza wyjątek związany z datą.
     */
    public machine(int ID, int price, date admissionDate, String name, String category, String producer, date productionDate, String CPU, String soundChip, String graphics) throws dateException{
        super(ID, price, admissionDate, name, category, producer, productionDate);
        this.CPU = CPU;
        this.soundChip = soundChip;
        this.graphics = graphics;
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
     * @throws dateException Zgłasza wyjątek związany z datą.
     */
    public machine(int ID, int price, String admissionDate, String name, String category, String producer, String productionDate, String CPU, String soundChip, String graphics) throws dateException{
        super(ID, price, admissionDate, name, category, producer, productionDate);
        this.CPU = CPU;
        this.soundChip = soundChip;
        this.graphics = graphics;
    }

    /**
     * Konstruktor kopiujący.
     * @param machine objekt klasy machine, który kopiujemy.
     * @throws dateException Zgłasza wyjątek związany z datą.
     */
   public machine (machine machine) throws dateException {
        super(machine);
       this.CPU = machine.getCPU();
       this.soundChip = machine.getSoundChip();
       this.graphics = machine.getGraphics();
   }

    /**
     * Getter dla pola CPU.
     * @return CPU
     */
    public String getCPU(){
        return this.CPU;
    }
    /**
     * Getter dla pola soundChip.
     * @return soundChip
     */
    public String getSoundChip(){
        return this.soundChip;
    }
    /**
     * Getter dla pola graphics.
     * @return graphics
     */
    public String getGraphics(){
        return this.graphics;
    }

    /**
     * Przeciążenie metody equals.
     * @param obj Objekt do którego porównujemy.
     * @return true, jeśli objekty są takie same. Rozumiemy przez to że mają tę samą: kategorie, producenta, CPU, Czip dźwiękowy i grafikę.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        machine machine = (machine) obj;
        return  Objects.equals(this.getCategory(), machine.getCategory()) &&
                Objects.equals(this.getProducer(), machine.getProducer()) &&
                Objects.equals(this.getCPU(), machine.getCPU()) &&
                Objects.equals(this.getSoundChip(), machine.getSoundChip()) &&
                Objects.equals(this.getGraphics(), machine.getGraphics());
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
        toReturn = 31 * toReturn * this.getCPU().hashCode();
        toReturn = 31 * toReturn * this.getSoundChip().hashCode();
        toReturn = 31 * toReturn * this.getGraphics().hashCode();
        return toReturn;
    }
}