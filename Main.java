

class Main {
  // write your solution in this function
  public static double GiveChange(CatalogItem[] catalogItems, OrderedItem[] orderedItems, double moneyProvided) throws IllegalArgumentException, ItemNotInCatalogException, InsufficientFundsException {

  HashMap<Integer, Double> map = new HashMap<>();
    
  for(OrderedItem item: orderedItems){
    if (!map.containsKey(item.id)){
      price = catalogItems.stream()
        .filter(catalog -> (catalog.getId() == item.getId()))
        .findAny()
        .orElse(0.0);
      map.put(item.id, price * item.quantity);
    }  
  }
  return map.values().stream().mapToDouble(Double::parseDouble).sum();;
}

  // do not change the following code
  public static void main(String[] args) {
    TestRunner tr = new TestRunner();
    tr.main();
  }
}