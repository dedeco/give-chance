# Merit America - Mock Technical Interview
## Coding Challenge - Give Change

*-- PLEASE READ THESE INSTRUCTIONS BEFORE PROCEEDING --*

**If you have not already forked this Replit, please fork it now into your own account so that you can edit the Main.java file to provide your solution**

You are tasked with developing an algorithm to calculate the amount of change owed to a customer for a purchase transaction.

Your function GiveChange() takes the following parameters:
* *catalogItems* - an array of CatalogItems which provide the items that can be purchased along with their price
* *orderedItems* - an array of OrderedItems which provide the items that are actually part of this order along with the quantity of each ordered item
* *moneyProvided* - a double representing the amount of money that the customer provided you

Your function should return/throw the following:
* *double* - the difference between the moneyProvided and the total amount due (you will have to compute this)
* *IllegalArgumentException* - in the event that the moneyProvided is a negative amount
* *ItemNotInCatalogException* - in the event that an item in the OrderedItems array does not exist in the CatalogItems array
* *InsufficientFundsException* - in the event that the moneyProvided is less than the total amount due

Review the provided Java files and note that there is an implicit relationship between OrderedItem.id and CatalogItem.id that you will need to leverage as part of your algorithm.

You should only write your code in the Main.java file inside the GiveChange() function.

To run the test cases, click on the green Run button at the top of this screen.

If you pass all of the test cases, the output should simply be: true

Otherwise, you have an error in your code and the failing test cases will be displayed. You may review the TestJunit.java file to see the various test cases you are failing.

**Hint**: do not assume the arguments supplied to the GiveChange() function will be valid.

**Note**: while this Replit IDE does offer syntax auto-completion, do not rely on it as it may not auto-complete everything.

Here is a simple example of how your function GiveChange() will be called and what it should be expected to return:
```java
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

// changeReceived should have the value 4.0 after GiveChange() returns
double changeReceived = Main.GiveChange(catalogItems, orderedItems, moneyProvided);