public class ItemNotInCatalogException extends Exception {
  public ItemNotInCatalogException() {
    super("Ordered item does not exist in the catalog");
  }
}