import java.util.Objects;

public class merchandise extends product implements Comparable<item>{
    private String brand;

    public merchandise() throws dateException {
        super();
        brand = "noData";
    }
    public merchandise(int ID, int price, String admissionDate, String name, String category, String producer, String productionDate, String brand) throws dateException{
        super(ID, price, admissionDate, name, category, producer, productionDate);
        this.brand = brand;
    }

    public String getBrand(){
        return this.brand;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        merchandise merchandise = (merchandise) obj;
        return  Objects.equals(this.getCategory(), merchandise.getCategory()) &&
                Objects.equals(this.getProducer(), merchandise.getProducer()) &&
                Objects.equals(this.getBrand(), merchandise.getBrand());

    }
    @Override
    public int hashCode(){
        int toReturn = 13;
        toReturn = 31 * toReturn * this.getCategory().hashCode();
        toReturn = 31 * toReturn * this.getProducer().hashCode();
        toReturn = 31 * toReturn * this.getBrand().hashCode();
        return toReturn;
    }

}
