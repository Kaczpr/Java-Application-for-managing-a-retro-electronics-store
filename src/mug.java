public class mug extends merchandise implements Comparable<item>{
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

    public int getVolume(){
        return this.volume;
    }

    public boolean equals(mug mug){
        return (this.getVolume() == mug.getVolume() && this.getBrand().equals(mug.getBrand()));
    }

}
