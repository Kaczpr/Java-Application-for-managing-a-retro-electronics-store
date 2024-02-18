/**
 * Interface do porównywania objektów ze względiu na date produkcji, ID, cenę
 * @param <product> product
 */
public interface customComparable<product>{
    public product productionDateCompareTo(product product) throws dateException;
    public product idCompareTo(product product);
    public product priceCompareTo(product product);
}
