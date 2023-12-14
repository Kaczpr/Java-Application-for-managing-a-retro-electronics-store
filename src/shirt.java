public class shirt extends merchandise{
    String size;
    String material;

    public shirt() throws dateException {
        super();
        this.size = "noData";
        this.material = "noData";
    }

    public shirt(int ID, int price, String admissionDate, String category, String producer, String productionDate,
                 String brand, String size, String material) throws dateException {
        super(ID, price, admissionDate, category, producer, productionDate, brand);
        this.size = size;
        this.material = material;
    }
}
