import java.util.Objects;

public class product extends item implements customComparable<product>{
    private final String name;
    private final String category;
    private final String producer;
    private final date productionDate;


    public product() throws dateException {
        ID = 0;
        price = 0;
        admissionDate = new date(1, 1, 1970);
        name = "noData";
        category = "noData";
        producer = "noData";
        productionDate = new date(1, 1, 1970);
    } //default constructor - noData and zeros;

    public product(int ID, int price, date admissionDate, String name, String category, String producer, date productionDate) {
        this.ID = ID;
        this.price = price;
        this.admissionDate = admissionDate;
        this.name = name;
        this.category = category;
        this.producer = producer;
        this.productionDate = productionDate;
    }

    public product(int ID, int price, String admissionDate, String name, String category, String producer, String productionDate) throws dateException {
        this.ID = ID;
        this.price = price;
        this.admissionDate = new date(admissionDate);
        this.name = name;
        this.category = category;
        this.producer = producer;
        this.productionDate = new date(productionDate);
    }
    public product(product product) throws  dateException{
        this.ID = product.getID();
        this.price = product.getPrice();
        this.admissionDate = new date(product.admissionDate.dateToString());
        this.name = product.getName();
        this.category = product.getCategory();
        this.producer = product.getProducer();
        this.productionDate = new date(product.productionDate.dateToString());
    }

    public String getName() {
        return this.name;
    }

    public String getCategory() {
        return this.category;
    }

    public String getProducer() {
        return this.producer;
    }

    public String getProductionDate() throws dateException {
        return this.productionDate.toString();
    }

    @Override
    public String toString() {
        return this.name;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) { //lepiej uzyc instanceOf
            return false;
        }
        product product = (product) obj;
        return  Objects.equals(this.getName(), product.getName()) &&
                Objects.equals(this.getCategory(), product.getCategory()) &&
                Objects.equals(this.getProducer(), product.getProducer());
    }

    @Override
    public int hashCode(){
        int toReturn = 13;
        toReturn = 31 * toReturn * this.getName().hashCode();
        toReturn = 31 * toReturn * this.getCategory().hashCode();
        toReturn = 31 * toReturn * this.getProducer().hashCode();
        return toReturn;
    }
    @Override
    public product productionDateCompareTo(product product2) throws dateException {
        if(this.getProductionDate().compareTo(product2.getProductionDate()) > 0) return this;
        else if (this.getProductionDate().compareTo(product2.getProductionDate()) < 0) return product2;
        else return this;
    }
    @Override public product priceCompareTo(product product2){
        if (this.compareTo(product2) > 0) return this;
        else return product2;
    }
    @Override public product idCompareTo(product product2){
        if(Integer.compare(this.getID(), product2.getID()) > 0) return this;
        else return product2;

    }


}
