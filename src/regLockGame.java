import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        regLockGame regLockGame = (regLockGame) obj;
        return  Objects.equals(this.getName(), regLockGame.getName()) &&
                Objects.equals(this.getCategory(), regLockGame.getCategory()) &&
                Objects.equals(this.getProducer(), regLockGame.getProducer()) &&
                Objects.equals(this.getLanguage(), regLockGame.getLanguage()) &&
                Objects.equals(this.getRegion(), regLockGame.getRegion()) &&
                Objects.equals(this.getRegLock(), regLockGame.getRegLock()) &&
                Objects.equals(this.getMedium(), regLockGame.getMedium());
    }
}
