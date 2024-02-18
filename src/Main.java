
import java.io.IOException;
public class Main {

    public static void main(String [] args) throws dateException, IOException, productException {


        arcade midwayT = new arcade(3, 68160, "13-12-2021", "Midway T-Unit", "Arcade", "Midway", "3-5-1994", " TMS34010", " Motorola 6809", "TMS34010",
                1000, "Buttons");
        regLockGame chronoTrigger1 = new regLockGame(2323, 10000, "02-01-2024", "Chrono Trigger", "RegLock Game", "Square Enix", "11-03-1995",
                "Super Nintendo Entertainment System (SNES)", new String[]{"Single Player", "Multiplayer"},
                new String[]{"Role-Playing Game (RPG)", "Adventure"}, "English", "Cartridge", "North America", "NTSC");

        regLockGame chronoTrigger2 = new regLockGame(99, 9765, "02-01-2024", "Chrono Trigger", "RegLock Game", "Square Enix", "11-03-1995",
                "Super Nintendo Entertainment System (SNES)", new String[]{"Single Player", "Multiplayer"},
                new String[]{"Role-Playing Game (RPG)", "Adventure"}, "English", "Cartridge", "Europe", "PAL");
        regLockGame chronoTrigger3 = new regLockGame(111, 9765, "02-01-2222", "Chrono Trigger", "RegLock Game", "Square Enix", "11-03-1995",
                "Super Nintendo Entertainment System (SNES)", new String[]{"XDDD", "Multiplayer"},
                new String[]{"Role-Playing Game (RPG)", "Adventure"}, "English", "Cartridge", "Europe", "PAL");
        arcade midwayT2 = new arcade(midwayT);

        storage storage = new storage("storage2.csv");



    }
}