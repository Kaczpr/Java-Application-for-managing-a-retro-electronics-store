import java.util.Objects;

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
   public machine (machine machine) throws dateException {
        super(machine);
       this.CPU = machine.getCPU();
       this.soundChip = machine.getSoundChip();
       this.graphics = machine.getGraphics();
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


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        machine machine = (machine) obj;
        return  Objects.equals(this.getCategory(), machine.getCategory()) &&
                Objects.equals(this.getProducer(), machine.getProducer()) &&
                Objects.equals(this.getCPU(), machine.getCPU()) &&
                Objects.equals(this.getSoundChip(), machine.getSoundChip()) &&
                Objects.equals(this.getGraphics(), machine.getGraphics());
    }


    @Override
    public int hashCode(){
        int toReturn = 13;
        toReturn = 31 * toReturn * this.getCategory().hashCode();
        toReturn = 31 * toReturn * this.getProducer().hashCode();
        toReturn = 31 * toReturn * this.getCPU().hashCode();
        toReturn = 31 * toReturn * this.getSoundChip().hashCode();
        toReturn = 31 * toReturn * this.getGraphics().hashCode();
        return toReturn;
    }
}