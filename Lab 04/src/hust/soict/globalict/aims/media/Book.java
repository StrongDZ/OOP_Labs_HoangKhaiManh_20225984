package hust.soict.globalict.aims.media;
import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<>();

    public Book(int id, String title, String category, float cost, List<String> authors) {
        super(id, title, category, cost);
        this.authors = authors;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
          authors.add(authorName);
          System.out.println("Author '" + authorName + "' added successfully!");
        } else {
          System.out.println("Author '" + authorName + "' already exists in the list.");
        }
      }
    
      public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
          authors.remove(authorName);
          System.out.println("Author '" + authorName + "' removed successfully!");
        } else {
          System.out.println("Author '" + authorName + "' not found in the list.");
        }
      }
    public String toString() {
      return "Book - " + getTitle() + " - " + getCategory() + " - "+ getAuthors()+ " - "+getCost() +" $" ;
    }
}
