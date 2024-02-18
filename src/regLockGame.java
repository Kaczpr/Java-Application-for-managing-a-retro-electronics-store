import java.util.Objects;

/**
 * Ta klasa reprezentuje gry z blokadą reginalną
 */
public final class regLockGame extends game{
    private String region;
    private String regLock;

    /**
     * Konstruktor domyślny uzupełniający pola wartościami noData i 0.
     * @throws dateException Zgłasza wyjątek związany z datą.
     */
    public regLockGame() throws dateException{
        super();
        region = "noData";
        regLock = "noData";
    }

    /**
     * Konstruktor przyjmujący wszystkie parametry, w tym daty będące Stringami w formacie "dd-mm-yyyy".
     * @param ID ID unikatowe dla każdego produktu.
     * @param price cena produktu (podawana w GROSZACH!).
     * @param admissionDate data przyjęcia do magazynu.
     * @param name nazwa produktu.
     * @param category kategoria produktu.
     * @param producer producent.
     * @param productionDate data wyprodukowania.
     * @param console konsola, na która została wydana gra
     * @param gameModes Tryby gry
     * @param genres Gatunki
     * @param language język gry
     * @param medium jakie jest medium, na którym znajdują się gry, np. Cartridge, CD-ROM etc.
     * @param region region
     * @param regLock blokada regionalna PAL/NTSC
     * @throws dateException Zgłasza wyjątek związany z datą.
     */
    public regLockGame(int ID, int price, String admissionDate, String name, String category, String producer, String productionDate,
                String console, String[] gameModes, String[] genres, String language, String medium,
                String region, String regLock) throws dateException{
        super(ID, price, admissionDate, name, category, producer, productionDate, console, gameModes, genres, language, medium);
        this.region = region;
        this.regLock = regLock;
    }

    /**
     * Konstruktor kopiujący.
     * @param regLockGame objekt klasy regLockGame, który kopiujemy.
     * @throws dateException Zgłasza wyjątek związany z datą.
     */
    public regLockGame(regLockGame regLockGame) throws dateException{
        super(regLockGame);
        this.region = regLockGame.getRegion();
        this.regLock = regLockGame.getRegLock();
    }

    /**
     * Getter dla pola region
     * @return region
     */
    public String getRegion(){
        return this.region;
    }

    /**
     * Getter dla pola regLock
     * @return regLock
     */
    public String getRegLock(){
        return this.regLock;
    }
    /**
     * Przeciążenie metody equals.
     * @param obj Objekt do którego porównujemy.
     * @return true, jeśli objekty są takie same. Rozumiemy przez to że mają tę samą: kategorie, producenta, język, region, blokadę regionalną, medium.
     */
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
    /**
     * Generujemy hashcode dla objektu.
     * @return Hashcode.
     */
    @Override
    public int hashCode(){
        int toReturn = 13;
        toReturn = 31 * toReturn * this.getName().hashCode();
        toReturn = 31 * toReturn * this.getCategory().hashCode();
        toReturn = 31 * toReturn * this.getProducer().hashCode();
        toReturn = 31 * toReturn * this.getLanguage().hashCode();
        toReturn = 31 * toReturn * this.getMedium().hashCode();
        toReturn = 31 * toReturn * this.getRegion().hashCode();
        toReturn = 31 * toReturn * this.getRegLock().hashCode();
        return toReturn;
    }
}
