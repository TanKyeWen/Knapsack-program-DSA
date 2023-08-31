public interface Interface {

    public String deleteItem(String itemName,double itemWeight,double itemValue);
    
    public String searchItem(String itemName,double itemWeight,double itemValue);

    public void addToMap(String itemName,double itemWeight,double itemValue);

    public void printItems();

    public int mapSize();
}
