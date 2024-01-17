import java.util.Objects;

public class mug extends merchandise{
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
    public mug(mug mug) throws dateException{
        super(mug);
        this.volume = mug.getVolume();
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
