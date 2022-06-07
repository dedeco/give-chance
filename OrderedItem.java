public class OrderedItem {
  int id;
  int quantity;

  public OrderedItem(int id, int quantity) {
    this.id = id;
    this.quantity = quantity;
  }

  public int getId() {
    return this.id;
  }

  public int getQuantity() {
    return this.quantity;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    result = prime * result + quantity;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    OrderedItem other = (OrderedItem) obj;
    if (id != other.id)
      return false;
    if (quantity != other.quantity)
      return false;
    return true;
  }
}