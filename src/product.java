
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class product extends item implements customComparable<product>{
    private final String name;
    private final String category;
    private final String producer;
    private final date productionDate;


    public void writeToIDCollection(){
        try (Writer writer = new OutputStreamWriter(Files.newOutputStream(
                Paths.get("/home/kaczpr/IdeaProjects/semestrialProject/IDs/IDs.csv"),
                StandardOpenOption.CREATE, StandardOpenOption.APPEND),
                StandardCharsets.UTF_8)) {
            String id = String.valueOf(this.getID());
            writer.write(id);
            writer.write(",");
            System.out.println("Product saved in storage - ID saved into IDs.csv");
        } catch (IOException e){
            System.out.println("An error occurred while writing to IDs.csv file");
        }
    }
    public void Validation() throws productException {
        List<String> list = new ArrayList<>();
        String StringID;

        try (BufferedReader reader = new BufferedReader(new FileReader("/home/kaczpr/IdeaProjects/semestrialProject/IDs/IDs.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] idArray = line.split(",");
                Collections.addAll(list, idArray);
            }
        }catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
        for (String s : list) {
            try {
                StringID = s;
                if (this.getID() == Integer.parseInt(StringID))
                    throw new productException("This ID is already used, ID is Primary Key and therefor has to be unique");
            } catch (NumberFormatException e) {
                System.out.println("An error occurred while parsing int");
            }
        }

        if(this.getPrice() < 0) throw new productException("Price cannot be negative!");
        if(this.getID() < 0) throw new productException("ID cannot be negative");
    }


    public product() throws dateException {
        ID = 0;
        price = 0;
        admissionDate = new date(1, 1, 1970);
        name = "noData";
        category = "noData";
        producer = "noData";
        productionDate = new date(1, 1, 1970);
    } //default constructor - noData and zeros;

    public product(int ID, int price, date admissionDate, String name, String category, String producer, date productionDate) {
        this.ID = ID;
        this.price = price;
        this.admissionDate = admissionDate;
        this.name = name;
        this.category = category;
        this.producer = producer;
        this.productionDate = productionDate;
    }

    public product(int ID, int price, String admissionDate, String name, String category, String producer, String productionDate) throws dateException {
        this.ID = ID;
        this.price = price;
        this.admissionDate = new date(admissionDate);
        this.name = name;
        this.category = category;
        this.producer = producer;
        this.productionDate = new date(productionDate);
    }
    public product(product product) throws  dateException{
        this.ID = product.getID();
        this.price = product.getPrice();
        this.admissionDate = new date(product.admissionDate.dateToString());
        this.name = product.getName();
        this.category = product.getCategory();
        this.producer = product.getProducer();
        this.productionDate = new date(product.productionDate.dateToString());
    }

    public String getName() {
        return this.name;
    }

    public String getCategory() {
        return this.category;
    }

    public String getProducer() {
        return this.producer;
    }

    public String getProductionDate() throws dateException {
        return this.productionDate.toString();
    }

    @Override
    public String toString() {
        return this.name;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) { //lepiej uzyc instanceOf
            return false;
        }
        product product = (product) obj;
        return  Objects.equals(this.getName(), product.getName()) &&
                Objects.equals(this.getCategory(), product.getCategory()) &&
                Objects.equals(this.getProducer(), product.getProducer());
    }

    @Override
    public int hashCode(){
        int toReturn = 13;
        toReturn = 31 * toReturn * this.getName().hashCode();
        toReturn = 31 * toReturn * this.getCategory().hashCode();
        toReturn = 31 * toReturn * this.getProducer().hashCode();
        return toReturn;
    }
    @Override
    public product productionDateCompareTo(product product2) throws dateException {
        if(this.getProductionDate().compareTo(product2.getProductionDate()) > 0) return this;
        else if (this.getProductionDate().compareTo(product2.getProductionDate()) < 0) return product2;
        else return this;
    }
    @Override public product priceCompareTo(product product2){
        if (this.compareTo(product2) > 0) return this;
        else return product2;
    }
    @Override public product idCompareTo(product product2){
        if(Integer.compare(this.getID(), product2.getID()) > 0) return this;
        else return product2;

    }


}
