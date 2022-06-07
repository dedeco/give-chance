import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJunit {
  @Test
  public void BasicTest1() throws IllegalArgumentException, ItemNotInCatalogException, InsufficientFundsException {
    CatalogItem[] catalogItems = new CatalogItem[5];
    catalogItems[0] = new CatalogItem(1, "Apple", 1.00);
    catalogItems[1] = new CatalogItem(2, "Orange", 1.25);
    catalogItems[2] = new CatalogItem(3, "Mango", 1.75);
    catalogItems[3] = new CatalogItem(4, "Kiwi", 1.50);
    catalogItems[4] = new CatalogItem(5, "Box of Strawberries", 5.00);

    OrderedItem[] orderedItems = new OrderedItem[2];
    orderedItems[0] = new OrderedItem(1, 1);
    orderedItems[1] = new OrderedItem(5, 1);

    double moneyProvided = 10.00;
    double changeExpected = 4.00;

    double changeReceived = Main.GiveChange(catalogItems, orderedItems, moneyProvided);

    assertEquals(changeExpected, changeReceived, 0);
  }

  @Test
  public void BasicTest2() throws IllegalArgumentException, ItemNotInCatalogException, InsufficientFundsException {
    CatalogItem[] catalogItems = new CatalogItem[5];
    catalogItems[0] = new CatalogItem(1, "Apple", 1.00);
    catalogItems[1] = new CatalogItem(2, "Orange", 1.25);
    catalogItems[2] = new CatalogItem(3, "Mango", 1.75);
    catalogItems[3] = new CatalogItem(4, "Kiwi", 1.50);
    catalogItems[4] = new CatalogItem(5, "Box of Strawberries", 5.00);

    OrderedItem[] orderedItems = new OrderedItem[2];
    orderedItems[0] = new OrderedItem(1, 3);
    orderedItems[1] = new OrderedItem(2, 2);

    double moneyProvided = 10.00;
    double changeExpected = 4.50;

    double changeReceived = Main.GiveChange(catalogItems, orderedItems, moneyProvided);

    assertEquals(changeExpected, changeReceived, 0);
  }

  @Test
  public void BasicTest3() throws IllegalArgumentException, ItemNotInCatalogException, InsufficientFundsException {
    CatalogItem[] catalogItems = new CatalogItem[5];
    catalogItems[0] = new CatalogItem(1, "Apple", 1.00);
    catalogItems[1] = new CatalogItem(2, "Orange", 1.25);
    catalogItems[2] = new CatalogItem(3, "Mango", 1.75);
    catalogItems[3] = new CatalogItem(4, "Kiwi", 1.50);
    catalogItems[4] = new CatalogItem(5, "Box of Strawberries", 5.00);

    OrderedItem[] orderedItems = new OrderedItem[1];
    orderedItems[0] = new OrderedItem(3, 3);

    double moneyProvided = 10.00;
    double changeExpected = 4.75;

    double changeReceived = Main.GiveChange(catalogItems, orderedItems, moneyProvided);

    assertEquals(changeExpected, changeReceived, 0);
  }

  @Test
  public void BasicTest4() throws IllegalArgumentException, ItemNotInCatalogException, InsufficientFundsException {
    CatalogItem[] catalogItems = new CatalogItem[1];
    catalogItems[0] = new CatalogItem(1, "Apple", 1.25);

    OrderedItem[] orderedItems = new OrderedItem[1];
    orderedItems[0] = new OrderedItem(1, 3);

    double moneyProvided = 5.00;
    double changeExpected = 1.25;

    double changeReceived = Main.GiveChange(catalogItems, orderedItems, moneyProvided);

    assertEquals(changeExpected, changeReceived, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void NegativeMoneyProvided() throws IllegalArgumentException, ItemNotInCatalogException, InsufficientFundsException {
    CatalogItem[] catalogItems = new CatalogItem[5];
    catalogItems[0] = new CatalogItem(1, "Apple", 1.00);
    catalogItems[1] = new CatalogItem(2, "Orange", 1.25);
    catalogItems[2] = new CatalogItem(3, "Mango", 1.75);
    catalogItems[3] = new CatalogItem(4, "Kiwi", 1.50);
    catalogItems[4] = new CatalogItem(5, "Box of Strawberries", 5.00);

    OrderedItem[] orderedItems = new OrderedItem[2];
    orderedItems[0] = new OrderedItem(1, 1);
    orderedItems[1] = new OrderedItem(5, 1);

    Main.GiveChange(catalogItems, orderedItems, -1.0);
  }

  @Test(expected = ItemNotInCatalogException.class)
  public void ItemNotInCatalog1() throws IllegalArgumentException, ItemNotInCatalogException, InsufficientFundsException {
    CatalogItem[] catalogItems = new CatalogItem[5];
    catalogItems[0] = new CatalogItem(1, "Apple", 1.00);
    catalogItems[1] = new CatalogItem(2, "Orange", 1.25);
    catalogItems[2] = new CatalogItem(3, "Mango", 1.75);
    catalogItems[3] = new CatalogItem(4, "Kiwi", 1.50);
    catalogItems[4] = new CatalogItem(5, "Box of Strawberries", 5.00);

    OrderedItem[] orderedItems = new OrderedItem[2];
    orderedItems[0] = new OrderedItem(1, 1);
    orderedItems[1] = new OrderedItem(6, 1);

    double moneyProvided = 10.00;

    Main.GiveChange(catalogItems, orderedItems, moneyProvided);
  }

  @Test(expected = InsufficientFundsException.class)
  public void InsufficientFunds() throws IllegalArgumentException, ItemNotInCatalogException, InsufficientFundsException {
    CatalogItem[] catalogItems = new CatalogItem[5];
    catalogItems[0] = new CatalogItem(1, "Apple", 1.00);
    catalogItems[1] = new CatalogItem(2, "Orange", 1.25);
    catalogItems[2] = new CatalogItem(3, "Mango", 1.75);
    catalogItems[3] = new CatalogItem(4, "Kiwi", 1.50);
    catalogItems[4] = new CatalogItem(5, "Box of Strawberries", 5.00);

    OrderedItem[] orderedItems = new OrderedItem[2];
    orderedItems[0] = new OrderedItem(1, 1);
    orderedItems[1] = new OrderedItem(5, 1);

    double moneyProvided = 4.00;

    double changeReceived = Main.GiveChange(catalogItems, orderedItems, moneyProvided);
  }

  @Test
  public void NoCatalogOrOrderRefund1() throws IllegalArgumentException, ItemNotInCatalogException, InsufficientFundsException {
    CatalogItem[] catalogItems = new CatalogItem[0];
    OrderedItem[] orderedItems = new OrderedItem[0];

    double moneyProvided = 5.00;
    double changeExpected = 5.00;

    double changeReceived = Main.GiveChange(catalogItems, orderedItems, moneyProvided);

    assertEquals(changeExpected, changeReceived, 0);
  }

  @Test
  public void NoCatalogOrOrderRefund2() throws IllegalArgumentException, ItemNotInCatalogException, InsufficientFundsException {
    CatalogItem[] catalogItems = new CatalogItem[5];
    OrderedItem[] orderedItems = new OrderedItem[5];

    double moneyProvided = 5.00;
    double changeExpected = 5.00;

    double changeReceived = Main.GiveChange(catalogItems, orderedItems, moneyProvided);

    assertEquals(changeExpected, changeReceived, 0);
  }

  @Test(expected = ItemNotInCatalogException.class)
  public void ItemNotInCatalog2() throws IllegalArgumentException, ItemNotInCatalogException, InsufficientFundsException {
    OrderedItem[] orderedItems = new OrderedItem[2];
    orderedItems[0] = new OrderedItem(1, 1);
    orderedItems[1] = new OrderedItem(6, 1);

    double moneyProvided = 10.00;

    Main.GiveChange(null, orderedItems, moneyProvided);
  }

  @Test
  public void NullOrderRefund() throws IllegalArgumentException, ItemNotInCatalogException, InsufficientFundsException {
    CatalogItem[] catalogItems = new CatalogItem[5];
    catalogItems[0] = new CatalogItem(1, "Apple", 1.00);
    catalogItems[1] = new CatalogItem(2, "Orange", 1.25);
    catalogItems[2] = new CatalogItem(3, "Mango", 1.75);
    catalogItems[3] = new CatalogItem(4, "Kiwi", 1.50);
    catalogItems[4] = new CatalogItem(5, "Box of Strawberries", 5.00);

    double moneyProvided = 10.00;
    double changeExpected = 10.00;

    Main.GiveChange(catalogItems, null, moneyProvided);
  }

  @Test
  public void NullCatalogNullOrderRefund() throws IllegalArgumentException, ItemNotInCatalogException, InsufficientFundsException {
    double moneyProvided = 5.00;
    double changeExpected = 5.00;

    double changeReceived = Main.GiveChange(null, null, moneyProvided);

    assertEquals(changeExpected, changeReceived, 0);
  }
}