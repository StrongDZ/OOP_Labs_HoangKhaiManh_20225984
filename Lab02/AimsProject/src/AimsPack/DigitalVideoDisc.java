package AimsPack;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String directory;
    private int length;
    private float cost;
    public String getTitle() {
        return title;
      }
      
      public String getCategory() {
        return category;
      }
      
      public String getDirectory() {
        return directory;
      }
      
      public int getLength() {
        return length;
      }
      
      public float getCost() {
        return cost;
      }
      public DigitalVideoDisc(String title) {
        this.title = title;
      }
    
      public DigitalVideoDisc(String category, String title, float cost) {
        this.category = category;
        this.title = title;
        this.cost = cost;
      }

      public DigitalVideoDisc(String director, String category, String title, float cost) {
        this.directory = director; 
        this.category = category;
        this.title = title;
        this.cost = cost;
      }

      public DigitalVideoDisc(String director, String category, String title, int length, float cost) {
        this.directory = director;
        this.category = category;
        this.title = title;
        this.length = length;
        this.cost = cost;
      }
}
