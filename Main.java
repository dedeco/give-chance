import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Arrays;

class Main {
  // write your solution in this function
  public static double GiveChange(CatalogItem[] catalogItems, OrderedItem[] orderedItems, double moneyProvided) throws IllegalArgumentException, ItemNotInCatalogException, InsufficientFundsException {

  if (moneyProvided < 0)
    throw new IllegalArgumentException();

  if ( orderedItems == null 
      || (catalogItems == null && orderedItems == null)
     )
    return moneyProvided;
    
  if (catalogItems == null)
    throw new ItemNotInCatalogException();

  Map<Integer, Double> map = new HashMap<>();
 
  for(OrderedItem item: orderedItems){
    if (item == null)
      break;
    
    if (!map.containsKey(item.getId())){
      CatalogItem cat = Arrays
        .stream(catalogItems)
        .filter(catalogItem -> catalogItem.getId() == item.getId())
        .findAny()
        .orElse(null);
      
      if (cat == null)
        throw new ItemNotInCatalogException();
      
      map.put(item.getId(), cat.getPrice() * item.getQuantity());
    }  
  }
    
  double charge = map.values().stream().reduce(0.0, Double::sum);
  double chance = moneyProvided - charge;

  if (chance < 0)
    throw new InsufficientFundsException();
    
  return chance;
}

  // do not change the following code
  public static void main(String[] args) {
    TestRunner tr = new TestRunner();
    tr.main();
  }
}