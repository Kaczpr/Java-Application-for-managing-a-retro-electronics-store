public class arcade extends  machine{

    int maxCoinCapacity; //max number of coins that can be stored inside
    String controller; //dancing mat, "fishing rods", buttons, pistols, steering wheels

    public arcade() throws dateException {
        super();
        maxCoinCapacity = 0;
        controller = "noData";
    }
    public arcade(int ID, int price, date admissionDate, String category,
                  String producer, date productionDate, String CPU, String soundChip, String graphics,
                  int maxCoinCapacity, String controller) throws dateException{
        super(ID, price, admissionDate, category, producer, productionDate, CPU, soundChip, graphics);
        this.maxCoinCapacity = maxCoinCapacity;
        this.controller = controller;
    }
    public arcade(int ID, int price, String admissionDate, String category,
                  String producer, String productionDate, String CPU, String soundChip, String graphics,
                  int maxCoinCapacity, String controller) throws dateException{
        super(ID, price, admissionDate, category, producer, productionDate, CPU, soundChip, graphics);
        this.maxCoinCapacity = maxCoinCapacity;
        this.controller = controller;
    }

}
