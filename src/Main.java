import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String [] args) throws dateException, IOException {

        arcade midwayT = new arcade (3, 68160, "13-12-2021", "Midway T-Unit", "Arcade", "Midway", "3-5-1994", " TMS34010", " Motorola 6809", "TMS34010",
        1000, "Buttons");

        regLockGame chronoTrigger1 = new regLockGame(10, 10000, "02-01-2024", "Chrono Trigger", "RegLock Game", "Square Enix", "11-03-1995",
                "Super Nintendo Entertainment System (SNES)", new String[]{"Single Player", "Multiplayer"},
                new String[]{"Role-Playing Game (RPG)", "Adventure"}, "English", "Cartridge", "North America", "NTSC");

        regLockGame chronoTrigger2 = new regLockGame(10, 9765, "02-01-2024", "Chrono Trigger", "RegLock Game", "Square Enix", "11-03-1995",
                "Super Nintendo Entertainment System (SNES)", new String[]{"Single Player", "Multiplayer"},
                new String[]{"Role-Playing Game (RPG)", "Adventure"}, "English", "Cartridge", "Europe", "PAL");
        regLockGame chronoTrigger3 = new regLockGame(10, 9765, "02-01-2222", "Chrono Trigger", "RegLock Game", "Square Enix", "11-03-1995",
                "Super Nintendo Entertainment System (SNES)", new String[]{"XDDD", "Multiplayer"},
                new String[]{"Role-Playing Game (RPG)", "Adventure"}, "English", "Cartridge", "Europe", "PAL");
        arcade midwayT2 = new arcade(midwayT);

        //storage.createNewStorage("testStorage");
        //storage testStorage = new storage("testStorage.csv");
        //testStorage.writeToCSV(midwayT2);
        //testStorage.storageInfo();
        //storage.createNewStorage("123");

        //nie wiem czy nie lepiej zamienic metody compareTo tak zeby poprostu porownywala hashcody.
        //wydaje mi sie ze nie, wydaje mi sie ze dwa obiekty mogą mieć te same hashcody ale byc rozne, ale lepiej doptać

        //jak zrobić implementacje dodatkowych komparatorów (metody compare())?
        //interfejsami chyba

        date data = new date("50-10-1990");
        data.printFUllDate();




    }




}