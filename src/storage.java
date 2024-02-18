import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

/**
 * Ta klasa reprezentuje magazyn, w którym przechowywane są produkty.
 */
public final class storage {


    private List<String> productList;

    private final int maxSize;
    private int currentSize;
    private final String name;

    /**
     * Metoda liczy ile miejsca jest zajętego w magazynie
     * @param file nazwa magazynu
     * @throws IOException Zgłasza wyjątek wejścia i wyjścia
     */
    public void currentSize(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("/home/kaczpr/IdeaProjects/semestrialProject/storages/" + file) );
        int lines = 0;
        while (reader.readLine() != null) lines++;
        reader.close();
        this.currentSize = lines;
    }

    /**
     * Getter dla pola currentSize
     * @return currentSize
     */
    public int getCurrentSize(){
        return this.currentSize;
    }
    /**
     * Getter dla pola maxSize
     * @return maxSize
     */
    public int getMaxSize(){
        return this.maxSize;
    }
    /**
     * Getter dla pola name
     * @return name
     */
    public String getName(){return this.name;}

    /**
     * Getter dla pola productList
     * @return productList
     */
    public List<String> getProductList(){
        return this.productList;
    }

    /**
     * Setter dla pola productList
     * @param newList nowa lista, która zamieni starą liste
     */
    public void setProductList(List<String> newList){
        this.productList = newList;
    }

    /**
     * Konstruktor przyjmujący nazwę i automatycznie alokujący ilośc miejsca w magazynie na 100.
     * @param file nazwa magazynu
     * @throws IOException Zgłasza wyjątek wejścia i wyjścia
     */
    public storage(String file) throws IOException {
        this.maxSize = 100;
        currentSize(file);
        this.name = file;
        this.productList = Arrays.asList(readFromCSV(file));
    }

    /**
     * Konstruktor przyjmujący nazwę i maksymalny rozmiar magazynu.
     * @param maxSize maksymalnnyn rozmiar
     * @param name nazwa
     * @throws storageException Zgłasza wyjatek magazynu.
     */
    public storage(int maxSize, String name) throws storageException {
        this.name = name;
        this.maxSize = maxSize;
        if (maxSize < 0) throw new storageException("Size cannot be negtive");
    }

    //StringBuilder is an array of characters

    /**
     * Metoda tworzy linie, w której zawierane są wszystkie informacje o produkcie, a którą można zapisać w pliku .csv.
     * @param product produkt
     * @return Sttring będący linią do zapisania w pliku .csv.
     * @throws dateException Zgłasza wyjątek związany z datą.
     */
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

    /**
     * Metoda zapisuje do magazynu linie csv z informacjami o produkcie.
     * @param product produkt.
     * @throws dateException Zgłasza wyjątek związany z datą.
     * @throws productException Zgłasza wyjątek związany z produktem.
     */
    public void writeToCSV(product product) throws dateException, productException {
        product.Validation();
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
        product.writeToIDCollection();
    }

    /**
     * Metoda czyta z pliku csv linia po linii.
     * @param file nazwa magazynu.
     * @return Tablice z liniami z pliku csv.
     */
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

    /**
     * Wyświetla informacje o zawartości magazynu
     * @throws storageException Zgłasza wyjątek związany z magazynem.
     */
    public void storageInfo() throws storageException {
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
                    throw new storageException("Wrong line format!");
            }
            System.out.print("\n");
        }
    }

    /**
     * Tworzy nowy magazyn
     * @param name nazwa magazynu
     * @throws IOException Zgłasza wyjątek wejscia/wyjścia
     */
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

    /**
     * Usuwa dane ID z listy wykorzystanych ID
     * @param ID ID
     * @throws IOException Zgłasza wyjątek wejscia/wyjścia
     */
    public void deleteFromIdCollection(Integer ID) throws IOException {
        String id = ID.toString();
        String oldFile1 = "/home/kaczpr/IdeaProjects/semestrialProject/IDs/IDs.csv";
        String newFile1 = "temp.csv";
        File oldFile = new File (oldFile1);
        File newFile = new File (newFile1);
        String currentLine;
        boolean isDeleted = false;

        try(FileWriter fw = new FileWriter(newFile1, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            FileReader fr = new FileReader(oldFile1);
            BufferedReader br = new BufferedReader((fr))){
            if ((currentLine = br.readLine()) != null){
                String[] IDs = currentLine.split(",");
                List<String> list = new ArrayList<String>();
                list = Arrays.asList(IDs);
                for(int i = 0; i < IDs.length; i++){
                    if (!list.get(i).equals(id)) {
                        bw.write(list.get(i));
                        bw.write(",");
                    }
                    else isDeleted = true;
                }
            }
            pw.flush();
            pw.close();
            fr.close();
            br.close();
            bw.close();
            fw.close();
            oldFile.delete();
            File dump = new File(oldFile1);
            newFile.renameTo(dump);
            if(isDeleted) System.out.println("ID: " + id + " deleted from IDs.csv.");
            else System.out.println("ID: " + id + " has NOT been deleted from IDs.csv.");


        } catch (IOException e){
            System.out.println("Error occurred while updating IDs.csv. " + e.getMessage());
        }

    }

    /**
     * Sprzedaje, a więc usuwa towar o danym ID z mgazynu
     * @param ID ID
     */
    public void sellingByID(int ID){
        String IDToDelete = String.valueOf(ID);
        String filePath = "/home/kaczpr/IdeaProjects/semestrialProject/storages/" + this.getName();
        String tempFIle = "temp.csv";
        File oldFile = new File(filePath);
        File newFile = new File(tempFIle);
        String currentLine;
        boolean wasDeleted = false;
        try(FileWriter fw = new FileWriter(tempFIle, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader((fr))){
            while((currentLine = br.readLine()) != null){
                String[] info = currentLine.split(",");
                if(!Objects.equals(info[0], IDToDelete)){
                    pw.println(currentLine);
                }
                if(Objects.equals(info[0], IDToDelete)){
                    System.out.println("Product with ID: " + IDToDelete + " has been sold");
                    wasDeleted = true;
                }
            }
            pw.flush();
            pw.close();
            fr.close();
            br.close();
            bw.close();
            fw.close();
            oldFile.delete();
            File dump = new File(filePath);
            newFile.renameTo(dump);
            if(!wasDeleted) throw new storageException("No such product!");
            else {
                System.out.println("Product with ID: " + IDToDelete + " has been deleted");
                deleteFromIdCollection(ID);
            }

        } catch (IOException e){
            System.out.println("An error occurred while overwriting a file " + e.getMessage());
        } catch (storageException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Dodaje do magazynu produkty o danych podanych w pliku .csv.
     * @param file nazwa pliku
     */
    public void addToStorageFromFile(String file) {
        String firstFile = "/home/kaczpr/IdeaProjects/semestrialProject/addingQueue/" + file;
        String storage = "/home/kaczpr/IdeaProjects/semestrialProject/storages/" + this.getName();
        String line;
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(storage, true));
            BufferedReader br = new BufferedReader(new FileReader(firstFile))){
            while((line = br.readLine()) != null){
                bw.write(line);
                bw.write("\n");
            }
            bw.write("\n");
            br.close();
            bw.close();
        } catch (IOException e){
            System.out.println("An error occurred while appending storage file. " + e.getMessage());
        }
    }

    /**
     * Usuwa produkty o danych w pliku .csv ID.
     * @param file nazwa pliku.
     */
    public void deleteFromStorageFromFile(String file){
        String firstFile = "/home/kaczpr/IdeaProjects/semestrialProject/deletingQueue/" + file;
        String storage = "/home/kaczpr/IdeaProjects/semestrialProject/storages/" + this.getName();
        String line;
        List<Integer> toDeleteList = new ArrayList<>();
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(storage, true));
            BufferedReader br = new BufferedReader(new FileReader(firstFile))){

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                for (String value : values) {
                    toDeleteList.add(Integer.parseInt(value.trim()));
                }
            }
            for (Integer number : toDeleteList) {
                sellingByID(number);
            }
            }catch (IOException e){
            System.out.println("An error occurred while appending storage file. " + e.getMessage());
        }

    }

}







