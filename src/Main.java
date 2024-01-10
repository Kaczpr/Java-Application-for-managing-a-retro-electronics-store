public class Main {
    public static void main(String [] args) throws dateException {
        game rockman = new game (1, 1000, "20-10-2000", "Rock-man", "Game", "Nintendo", "20-12-1990",
                "NES", new String[]{"SinglePlayer"}, new String[]{"Platformer", "Adventure"},
                "Japanese", "Cartridge");
        game contra = new game (2, 9999, "20-10-2000", "Contra", "Game", "Nintendo", "20-10-1990",
                "NES", new String[]{"SinglePlayer"}, new String[]{"Platformer", "Adventure"},
                "English", "Cartridge");

        String[] games = new String[2];
        games[0] = storage.readFromCSV()[0];
        System.out.println(games[0]);

    }


}