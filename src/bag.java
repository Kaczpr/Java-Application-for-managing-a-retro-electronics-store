import java.util.Objects;

public final class bag extends mug{

    private String material;

    public bag() throws dateException {
        super();
        this.material = "noData";
    }

    public bag(int ID, int price, String admissionDate, String name, String category, String producer, String productionDate,
               String brand, int volume, String material) throws dateException {
        super(ID, price, admissionDate, name, category, producer, productionDate, brand, volume);
        this.material = material;
    }
    public bag(bag bag) throws dateException{
        super(bag);
        this.material = bag.getMaterial();
    }

    public String getMaterial(){
        return this.material;
    }

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
