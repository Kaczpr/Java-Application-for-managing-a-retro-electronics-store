public class regLockGame extends  game{
    private String region;
    private String regLock;

    public regLockGame() throws dateException{
        super();
        region = "noData";
        regLock = "noData";
    }
    public regLockGame(int ID, int price, String admissionDate, String name, String category, String producer, String productionDate,
                String console, String[] gameModes, String[] genres, String language, String medium,
                String region, String regLock) throws dateException{
        super(ID, price, admissionDate, name, category, producer, productionDate, console, gameModes, genres, language, medium);
        this.region = region;
        this.regLock = regLock;
    }

    public String getRegion(){
        return this.region;
    }
    public String getRegLock(){
        return this.regLock;
    }

    public boolean equals(regLockGame regLockGame){
        return (this.getName().equals(regLockGame.getName()) && this.getProducer().equals(regLockGame.getProducer()) && this.getLanguage().equals(regLockGame.getLanguage()) && this.getMedium().equals(regLockGame.getMedium()) && this.getConsole().equals(regLockGame.getConsole()) && this.getRegion().equals(regLockGame.getRegion()) && this.getRegLock().equals(regLockGame.getRegLock()));
    }

}
