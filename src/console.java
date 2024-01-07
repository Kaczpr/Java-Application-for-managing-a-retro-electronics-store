import java.io.*;

public class console extends  machine {
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

    public int getGen(){
        return this.generation;
    }
    public String getMedia(){
        return this.media;
    }
    public String getVideoOutput(){
        return this.videoOutput;
    }
}

