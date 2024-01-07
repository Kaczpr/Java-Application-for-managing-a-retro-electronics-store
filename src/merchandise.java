public class merchandise extends product{
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

}
