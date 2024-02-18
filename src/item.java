/**
 * Abstrakcyjna klasa reprezentująca przedmiot.
 */
public abstract class item implements Comparable<item>{
    int ID;
    int price; // wartosc całkowita, cena jest przechowywana w groszach
    date admissionDate;

    /**
     * Getter dla pola ID
     * @return ID
     */
    public Integer getID(){
        return this.ID;
    }
    /**
     * Getter dla pola price
     * @return price
     */
    public int getPrice(){
        return this.price;
    }
    /**
     * Getter dla pola admissionDate
     * @return admissionDate
     */
    public String getAdmissionDate() {
        return this.admissionDate.toString();
    }

    /**
     * Przeciążenie metody compareTo.
     * @param item objekt, do którego porównujemy.
     * @return true, jeśli obiekty są jednakowe.
     */
    @Override
    public int compareTo(item item){
        return Integer.compare(this.getPrice(), item.getPrice());
    }
    /**
     * Generujemy hashcode dla objektu.
     * @return Hashcode.
     */
    @Override
    public int hashCode(){
        int toReturn = 17;
        toReturn = 31*toReturn + this.ID;
        toReturn = 31*toReturn + this.price;
        toReturn = 31*toReturn + this.admissionDate.hashCode();
        return toReturn;
    }

}
