public interface Interface {
    public String updateValue(double itemWeight,double itemValue);
    
    public String deleteItem(double itemWeight,double itemValue);
    
    public String searchItem(double itemWeight,double itemValue);

    public void addToMap(double itemWeight,double itemValue);

    public void printItems();
}
