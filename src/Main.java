import java.io.IOException;

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


        storage s1 = new storage();
        //s1.storageInfo();
        System.out.println(chronoTrigger2.compareTo(chronoTrigger1));

    }




}