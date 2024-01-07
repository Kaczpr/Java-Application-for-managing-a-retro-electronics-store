public class Main {
    public static void main(String [] args) throws dateException {
        game rockman = new game (1, 1000, "20-10-2000", "Rockman", "Game", "Nintendo", "20-12-1990",
                "NES", new String[]{"SinglePlayer"}, new String[]{"Platformer", "Adventure"},
                "Japanese", "Cartridge");
        storage s1 = new storage();
        System.out.println(s1.createCSV_Line(rockman));

    }


}