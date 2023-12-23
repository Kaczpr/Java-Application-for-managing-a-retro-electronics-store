public class product extends item{

    String name;
    String category;
    String producer;
    date productionDate;


    public product() throws dateException {
        ID = 0;
        price = 0;
        admissionDate = new date(1,1,1970);
        name = "noData";
        category = "noData";
        producer = "noData";
        productionDate = new date(1,1,1970);
    } //default constructor - noData and zeros;
    public product(int ID, int price, date admissionDate, String name, String category, String producer, date productionDate){
        this.ID = ID;
        this.price = price;
        this.admissionDate = admissionDate;
        this.name = "noData";
        this.category = category;
        this.producer = producer;
        this.productionDate = productionDate;
    }
    public product(int ID, int price, String admissionDate, String name, String category, String producer, String productionDate) throws dateException {
        this.ID = ID;
        this.price = price;
        this.admissionDate = new date(admissionDate);
        this.name = "noData";
        this.category = category;
        this.producer = producer;
        this.productionDate = new date(productionDate);
    }

}
