public interface customComparable<product>{
    public product productionDateCompareTo(product product) throws dateException;
    public product idCompareTo(product product);
    public product priceCompareTo(product product);
}
