import java.io.*;
import java.util.Objects;

public class console extends machine {
    private int generation;
    private String media;
    private String videoOutput;

    public console() throws dateException {
        super();
        generation = 0;
        media = "noData";
        videoOutput = "noData";
    }

    public console(int ID, int price, String admissionDate, String name, String category,
                   String producer, String productionDate, String CPU, String soundChip,
                   String graphics, int generation, String media, String videoOutput) throws dateException {
        super(ID, price, admissionDate, name, category, producer, productionDate, CPU, soundChip, graphics);
        this.generation = generation;
        this.media = media;
        this.videoOutput = videoOutput;
    }
    public console(console console) throws dateException{
        super(console);
        this.generation = console.getGen();
        this.media = console.getMedia();
        this.videoOutput = console.getVideoOutput();
    }

    public int getGen(){
        return this.generation;
    }
    public String getMedia(){
        return this.media;
    }
    public String getVideoOutput(){
        return this.videoOutput;
    }

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

