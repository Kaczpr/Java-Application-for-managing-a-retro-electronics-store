import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class storage {


    //StringBuilder is an array of characters
    public static StringBuilder createCSV_Line(product product) throws dateException {
        StringBuilder toReturn = new StringBuilder(20);
        toReturn.append(product.getID()).append(",");
        toReturn.append(product.getPrice()).append(",");
        toReturn.append(product.getAdmissionDate()).append(",");
        toReturn.append(product.getName()).append(",");
        toReturn.append(product.getCategory()).append(",");
        toReturn.append(product.getCategory()).append(",");
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

    public static void writeToCLV(StringBuilder toWrite){
        try (Writer writer = new OutputStreamWriter(Files.newOutputStream(
                Paths.get("/home/kaczpr/IdeaProjects/semestrialProject/src/storage.csv"),
                StandardOpenOption.CREATE, StandardOpenOption.APPEND),
                StandardCharsets.UTF_8)) {

            writer.write(String.valueOf(toWrite));
            writer.write("\n");
            System.out.println("CSV file saved");
        } catch (IOException e){
            System.out.println("An error occurred while writing CSV file");
        }
    }

    public static String[] readFromCSV() {
        List<String> lines = new ArrayList<>();
        File storage = new File("/home/kaczpr/IdeaProjects/semestrialProject/src/storage.csv");
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

    }




