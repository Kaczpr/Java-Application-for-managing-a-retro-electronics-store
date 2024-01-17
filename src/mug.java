import java.util.Objects;

public class mug extends merchandise implements Comparable<item>{
    private int volume;

    public mug() throws dateException {
        super();
        this.volume = 0;
    }

    public mug(int ID, int price, String admissionDate, String name, String category, String producer, String productionDate,
                 String brand, int volume) throws dateException {
        super(ID, price, admissionDate, name, category, producer, productionDate, brand);
        this.volume = volume;
    }

    public int getVolume(){
        return this.volume;
    }

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
}
