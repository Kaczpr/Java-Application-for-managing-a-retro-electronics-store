public abstract class item implements Comparable<item>{
    int ID;
    int price; // wartosc całkowita, cena jest przechowywana w groszach
    date admissionDate;

    public int getID(){
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

    public abstract boolean equals(product product);
}
