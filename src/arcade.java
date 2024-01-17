import java.util.Objects;

public class arcade extends machine{

    private int maxCoinCapacity; //max number of coins that can be stored inside
    private String controller; //dancing mat, "fishing rods", buttons, pistols, steering wheels

    public arcade() throws dateException {
        super();
        maxCoinCapacity = 0;
        controller = "noData";
    }
    public arcade(int ID, int price, date admissionDate, String name, String category,
                  String producer, date productionDate, String CPU, String soundChip, String graphics,
                  int maxCoinCapacity, String controller) throws dateException{
        super(ID, price, admissionDate, name, category, producer, productionDate, CPU, soundChip, graphics);
        this.maxCoinCapacity = maxCoinCapacity;
        this.controller = controller;
    }
    public arcade(int ID, int price, String admissionDate, String name, String category,
                  String producer, String productionDate, String CPU, String soundChip, String graphics,
                  int maxCoinCapacity, String controller) throws dateException{
        super(ID, price, admissionDate, name, category, producer, productionDate, CPU, soundChip, graphics);
        this.maxCoinCapacity = maxCoinCapacity;
        this.controller = controller;
    }
    public arcade(arcade arcade) throws dateException{
        super(arcade);
        this.maxCoinCapacity = arcade.getMaxCoinCapacity();
        this.controller = arcade.getController();
    }

    public int getMaxCoinCapacity (){
        return this.maxCoinCapacity;
    }
    public String getController (){
        return this.controller;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        arcade arcade = (arcade) obj;
        return  Objects.equals(this.getCategory(), arcade.getCategory()) &&
                Objects.equals(this.getName(), arcade.getName());
    }
    @Override
    public int hashCode(){
        int toReturn = 13;
        toReturn = 31 * toReturn * this.getCategory().hashCode();
        toReturn = 31 * toReturn * this.getName().hashCode();
        return toReturn;
    }

}
