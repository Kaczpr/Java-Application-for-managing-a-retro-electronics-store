public class shirt extends merchandise{
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

    public String getSize(){
        return this.size;
    }
    public String getMaterial(){
        return this.material;
    }


}
