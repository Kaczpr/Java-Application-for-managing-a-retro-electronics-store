public abstract class item implements Comparable<item>{
    int ID;
    int price; // wartosc całkowita, cena jest przechowywana w groszach
    date admissionDate;

    public Integer getID(){
        return this.ID;
    }
    public int getPrice(){
        return this.price;
    }
    public String getAdmissionDate() throws dateException {
        return this.admissionDate.dateToString();
    }
    @Override
    public int compareTo(item item){
        return Integer.compare(this.getPrice(), item.getPrice());
    }
    @Override
    public int hashCode(){
        int toReturn = 17;
        toReturn = 31*toReturn + this.ID;
        toReturn = 31*toReturn + this.price;
        toReturn = 31*toReturn + this.admissionDate.hashCode();
        return toReturn;
    }

}
