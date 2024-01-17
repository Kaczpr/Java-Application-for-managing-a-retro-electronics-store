public class bag extends mug implements Comparable<item>{

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

    public String getMaterial(){
        return this.material;
    }



}
