import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class storage {


    private List<String> productList;

    private final int maxSize;
    private int currentSize;
    private final String name;

    public void currentSize(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("/home/kaczpr/IdeaProjects/semestrialProject/storages/" + file) );
        int lines = 0;
        while (reader.readLine() != null) lines++;
        reader.close();
        this.currentSize = lines;
    }

    public int getCurrentSize(){
        return this.currentSize;
    }
    public int getMaxSize(){
        return this.maxSize;
    }
    public String getName(){return this.name;}
    public List<String> getProductList(){
        return this.productList;
    }

    public storage(String file) throws IOException {
        this.maxSize = 100;
        currentSize(file);
        this.name = file;
        this.productList = Arrays.asList(readFromCSV(file));
    }
    public storage(int maxSize, String name){
        this.name = name;
        this.maxSize = maxSize;
    }

    //StringBuilder is an array of characters
    public static StringBuilder createCSV_Line(product product) throws dateException {
        StringBuilder toReturn = new StringBuilder(20);
        toReturn.append(product.getID()).append(",");
        toReturn.append(product.getPrice()).append(",");
        toReturn.append(product.getAdmissionDate()).append(",");
        toReturn.append(product.getName()).append(",");
        toReturn.append(product.getCategory()).append(",");
        toReturn.append(product.getProducer()).append(",");
        toReturn.append(product.getProductionDate()).append(",");

        if(product instanceof machine){
            machine machine = (machine) product;
            toReturn.append(machine.getCPU()).append(",");
            toReturn.append(machine.getSoundChip()).append(",");
            toReturn.append(machine.getGraphics()).append(",");
            if(product instanceof console){
                console console = (console) product;
                toReturn.append(console.getGen()).append(",");
                toReturn.append(console.getMedia()).append(",");
                toReturn.append(console.getVideoOutput()).append(",");
            }
            else if (product instanceof arcade){
                arcade arcade = (arcade) product;
                toReturn.append(arcade.getMaxCoinCapacity()).append(",");
                toReturn.append(arcade.getController()).append(",");
            }
        }
        else if (product instanceof merchandise){
            merchandise merchandise = (merchandise) product;
            toReturn.append(merchandise.getBrand()).append(",");
            if(merchandise instanceof shirt){
                shirt shirt = (shirt) product;
                toReturn.append(shirt.getSize()).append(",");
                toReturn.append(shirt.getMaterial()).append(",");
            }
            else if(merchandise instanceof mug){
                mug mug = (mug) product;
                toReturn.append(mug.getVolume()).append(",");
                if(mug instanceof bag){
                    bag bag = (bag) product;
                    toReturn.append(bag.getMaterial()).append(",");
                }
            }
        }
        else if(product instanceof game){
            game game = (game) product;
            toReturn.append(game.getConsole()).append(",");
            toReturn.append(Arrays.toString(game.getGameModes())).append(",");
            toReturn.append(Arrays.toString(game.getGenres())).append(",");
            toReturn.append(game.getLanguage()).append(",");
            toReturn.append(game.getMedium()).append(",");
            if(game instanceof regLockGame){
                regLockGame regLockGame = (regLockGame) product;
                toReturn.append(regLockGame.getRegion()).append(",");
                toReturn.append(regLockGame.getRegLock()).append(",");
            }
        }
        toReturn.deleteCharAt(toReturn.length() - 1);
        return toReturn;


    }

    public static void writeToCSV(StringBuilder toWrite, String file){
        try (Writer writer = new OutputStreamWriter(Files.newOutputStream(
                Paths.get("/home/kaczpr/IdeaProjects/semestrialProject/storages/" + file),
                StandardOpenOption.CREATE, StandardOpenOption.APPEND),
                StandardCharsets.UTF_8)) {

            writer.write(String.valueOf(toWrite));
            writer.write("\n");
            System.out.println("CSV file saved");
        } catch (IOException e){
            System.out.println("An error occurred while writing CSV file");
        }
    }

    public void writeToCSV(product product) throws dateException {
        StringBuilder toWrite = storage.createCSV_Line(product);
        try (Writer writer = new OutputStreamWriter(Files.newOutputStream(
                Paths.get("/home/kaczpr/IdeaProjects/semestrialProject/storages/" + this.getName()),
                StandardOpenOption.CREATE, StandardOpenOption.APPEND),
                StandardCharsets.UTF_8)) {

            writer.write(String.valueOf(toWrite));
            writer.write("\n");
            System.out.println("CSV file saved");
        } catch (IOException e){
            System.out.println("An error occurred while writing CSV file");
        }
    }

    public static String[] readFromCSV(String file) {
        List<String> lines = new ArrayList<>();
        File storage = new File("/home/kaczpr/IdeaProjects/semestrialProject/storages/" + file);
        try (BufferedReader reader = new BufferedReader(new FileReader(storage))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }

        return lines.toArray(new String[0]);
    }

    public void storageInfo(){
        System.out.println("STORAGE INFO:");
        String[] products = new String[this.maxSize];

        for(int i = 0; i<this.currentSize; i++){
            String[] info = readFromCSV(this.getName())[i].split(",");
            System.out.println("Product nr." + (i+1) + ":");
            double intPrice = Integer.parseInt(info[1]);
            System.out.printf("ID: %s; Price: %sPLN; Admission date: ",info[0], intPrice/100);
            System.out.printf(info[2]);
            System.out.printf("; Name: %s; Producer: %s; Production date: ", info[3], info[5]);
            System.out.printf(info[6]);
            System.out.print(" Category: ");
            switch(info[4]){
                case "Console":
                    System.out.printf("Console; CPU: %s; Sound chip: %s; Graphics: %s; Generation: %s; Media: %s; Video output: %s",
                            info[7], info[8], info[9], info[10], info[11], info[12]);
                    break;
                case "Arcade":
                    System.out.printf("Arcade; CPU: %s; Sound chip: %s; Graphics: %s; Max coin capacity: %s; Controller: %s",
                            info[7], info[8], info[9], info[10], info[11]);
                    break;
                case "Merchandise":
                    System.out.printf("Merchandise; Brand: %s; ", info[7]);
                    break;
                case "Mug":
                    System.out.printf("Mug; Brand: %s; Volume: %s", info[7], info[8]);
                    break;
                case "Bag":
                    System.out.printf("Bag; Brand: %s; Volume: %s; Material: %s", info[7], info[8], info[9]);
                    break;
                case "Shirt":
                    System.out.printf("Shirt; Brand: %s; Size: %s; Material: %s", info[7], info[8], info[9]);
                    break;
                case "Game":
                    System.out.printf("Game; Console: %s; Game modes: %s; Genres: %s; Language: %s; Medium: %s",
                            info[7], info[8], info[9], info[10], info[11]);
                    break;
                case "RegLock Game":
                    System.out.printf("RegLock Game; Console: %s; Game modes: %s; Genres: %s; Language: %s; Medium: %s, Region: %s; Standard: %s",
                            info[7], info[8], info[9], info[10], info[11], info[12], info[13]);
                    break;
                default:
                    System.out.println("Couldn't find product class.");
            }
            System.out.print("\n");
        }
    }

    public static void createNewStorage(String name) throws IOException {
        File file = new File("/home/kaczpr/IdeaProjects/semestrialProject/storages/" + name + ".csv");
        if (!file.exists()) {
            if (file.createNewFile()) {
                System.out.println("Storage is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }
    }


    }





