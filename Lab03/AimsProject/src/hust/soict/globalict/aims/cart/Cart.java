package hust.soict.globalict.aims.cart;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

import java.util.ArrayList;
import java.util.Collections;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED=20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    private int numberofDVD = 0;
    public int getDVD(){
        return this.numberofDVD;
    }

    public void addMedia(Media disc) {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED && !itemsOrdered.contains(disc)) {
          itemsOrdered.add(disc);
          System.out.println("Media \"" + disc.getTitle() + "\" added to cart.");
          if(disc instanceof DigitalVideoDisc)numberofDVD++;
        } else {
          System.out.println("Cart is full. Could not add \"" + disc.getTitle() + "\".");
        }
    }   
    
    public void removeMedia(Media disc) {
        boolean found = false;
        for (int i = 0; i < itemsOrdered.size(); i++) {
            if (itemsOrdered.get(i)==disc) {
                found = true;
                itemsOrdered.remove(i);
                System.out.println("Media \"" + disc.getTitle() + "\" removed from cart.");
                if(disc instanceof DigitalVideoDisc)numberofDVD--;
                break;
            }
        }
        if (!found) {
          System.out.println("Media \"" + disc.getTitle() + "\" not found in cart.");
        }
    }

    public void print(){
        System.out.println("********************************CART********************************\nOrdered items:");
        for(int i = 0; i < itemsOrdered.size(); i++){
            System.out.printf("%d.%s\n",i+1,itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: "+totalCost()+"$");
        System.out.println("********************************************************************");

    }

    public float totalCost(){
        float sum=0;
        for (int i = 0; i < itemsOrdered.size(); i++){
            sum+= itemsOrdered.get(i).getCost();
        }
        return sum;
    }

    public void SearchByTitle(String title){
        boolean found = false;
        int stt=0;
        System.out.println("Search results for title: " + title);
        for (int i=0; i< itemsOrdered.size(); i++) {
            if (itemsOrdered.get(i).isMatch(title)){
                System.out.println((++stt) +"."+ itemsOrdered.get(i).toString());
                found = true;
            }
        }
        if (!found){
            System.out.println("No matching media found with title: " + title);
        }
    }

    public void SearchByID(int id){
        boolean found = false;
        int stt=0;
        System.out.println("Search results for id: " + id);
        for (int i=0; i< itemsOrdered.size(); i++) {
            if (itemsOrdered.get(i).isMatch(id)){
                System.out.println((++stt) +"."+ itemsOrdered.get(i).toString());
                found = true;
            }
        }
        if (!found){
            System.out.println("No matching media found with ID: " + id);
        }
    }
    public void SortByTitle(){
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);    
        System.out.println("List of medias sorted by title in cart:");
        for(int i=0 ;i<itemsOrdered.size();i++){
            System.out.println((i+1)+itemsOrdered.get(i).toString());
        }
    }
    public void SortByCost(){
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);    
        System.out.println("List of medias sorted by cost in cart:");
        for(int i=0 ;i<itemsOrdered.size();i++){
            System.out.println((i+1)+itemsOrdered.get(i).toString());
        }
    }

    public void clear(){itemsOrdered.clear();}
}
