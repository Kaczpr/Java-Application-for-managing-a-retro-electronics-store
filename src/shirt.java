import java.util.Objects;

public final class shirt extends merchandise{
    private String size;
    private String material;

    public shirt() throws dateException {
        super();
        this.size = "noData";
        this.material = "noData";
    }

    public shirt(int ID, int price, String admissionDate, String name, String category, String producer, String productionDate,
                 String brand, String size, String material) throws dateException {
        super(ID, price, admissionDate, name, category, producer, productionDate, brand);
        this.size = size;
        this.material = material;
    }
    public shirt(shirt shirt) throws dateException{
        super(shirt);
        this.size = shirt.getSize();
        this.material = shirt.getMaterial();
    }

    public String getSize(){
        return this.size;
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
        shirt shirt = (shirt) obj;
        return  Objects.equals(this.getCategory(), shirt.getCategory()) &&
                Objects.equals(this.getProducer(), shirt.getProducer()) &&
                Objects.equals(this.getBrand(), shirt.getBrand()) &&
                Objects.equals(this.getSize(), shirt.getSize()) &&
                Objects.equals(this.getMaterial(), shirt.getMaterial());

    }
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
