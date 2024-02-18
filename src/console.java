import java.io.*;
import java.util.Objects;

/**
 * Ta klasa przedstawia konsole do gier.
 */
public final class console extends machine {
    private int generation;
    private String media;
    private String videoOutput;

    public console() throws dateException {
        super();
        generation = 0;
        media = "noData";
        videoOutput = "noData";
    }

    /**
     * Konstrukor przyjmujący wszystkie parametry, w tym datę będącą Stringiem w formacie "dd-mm-yyyy".
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
     * @param generation Do której generacji należy konsola
     * @param media jakie jest medium, na którym znajdują się gry, np. Cartridge, CD-ROM etc.
     * @param videoOutput Wyjście video
     * @throws dateException Zgłasza wyjątek związany z datą.
     */
    public console(int ID, int price, String admissionDate, String name, String category,
                   String producer, String productionDate, String CPU, String soundChip,
                   String graphics, int generation, String media, String videoOutput) throws dateException {
        super(ID, price, admissionDate, name, category, producer, productionDate, CPU, soundChip, graphics);
        this.generation = generation;
        this.media = media;
        this.videoOutput = videoOutput;
    }
    /**
     * Konstruktor kopiujący.
     * @param console Objekt klasy console, który kopiujemy.
     * @throws dateException Zgłasza wyjątek związany z datą.
     */
    public console(console console) throws dateException{
        super(console);
        this.generation = console.getGen();
        this.media = console.getMedia();
        this.videoOutput = console.getVideoOutput();
    }

    /**
     * Getter dla pola generation.
     * @return generation.
     */
    public int getGen(){
        return this.generation;
    }
    /**
     * Getter dla pola media.
     * @return media.
     */
    public String getMedia(){
        return this.media;
    }
    /**
     * Getter dla pola videoOutput.
     * @return videoOutput.
     */
    public String getVideoOutput(){
        return this.videoOutput;
    }
    /**
     * Przeciążenie metody equals.
     * @param obj Objekt do którego porównujemy.
     * @return true, jeśli objekty są takie same. Rozumiemy przez to że mają tę samą: kategorie, nazwę, producenta, generacje, nośnik gier.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        console console = (console) obj;
        return  Objects.equals(this.getCategory(), console.getCategory()) &&
                Objects.equals(this.getName(), console.getName()) &&
                Objects.equals(this.getProducer(), console.getProducer()) &&
                Objects.equals(this.getGen(), console.getGen()) &&
                Objects.equals(this.getMedia(), console.getMedia());
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
        toReturn = 31 * toReturn * this.getProducer().hashCode();
        toReturn = 31 * toReturn * this.getGen();
        toReturn = 31 * toReturn * this.getMedia().hashCode();
        return toReturn;
    }
}

