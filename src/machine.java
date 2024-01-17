public class machine extends product{
    private String CPU;
    private String soundChip;
    private String graphics;

    public machine() throws dateException {
        super();
        CPU = "noData";
        soundChip = "noData";
        graphics = "noData";
    }
    public machine(int ID, int price, date admissionDate, String name, String category, String producer, date productionDate, String CPU, String soundChip, String graphics) throws dateException{
        super(ID, price, admissionDate, name, category, producer, productionDate);
        this.CPU = CPU;
        this.soundChip = soundChip;
        this.graphics = graphics;
    }
    public machine(int ID, int price, String admissionDate, String name, String category, String producer, String productionDate, String CPU, String soundChip, String graphics) throws dateException{
        super(ID, price, admissionDate, name, category, producer, productionDate);
        this.CPU = CPU;
        this.soundChip = soundChip;
        this.graphics = graphics;
    }

    public String getCPU(){
        return this.CPU;
    }
    public String getSoundChip(){
        return this.soundChip;
    }
    public String getGraphics(){
        return this.graphics;
    }


}