package hust.soict.globalict.aims.store;
import java.util.ArrayList;
import java.util.List;

import hust.soict.globalict.aims.media.Media;

public class Store {
    private List<Media> itemsInStore = new ArrayList<Media>();
    public void addMedia(Media disc){
        if (itemsInStore.size() <= 1000 && !itemsInStore.contains(disc)) {
            itemsInStore.add(disc);
            System.out.println("Media \"" + disc.getTitle() + "\" added to store.");
        } 
        else {
            System.out.println("Store is full. Could not add \"" + disc.getTitle() + "\".");
        }
    }

    public void removeMedia(Media disc) {
        boolean found = false;
        for (int i = 0; i < itemsInStore.size(); i++) {
            if (itemsInStore.get(i)==disc) {
                found = true;
                itemsInStore.remove(i);
                System.out.println("Media \"" + disc.getTitle() + "\" removed from store.");
                break;
            }
        }
        if (!found) {
          System.out.println("Media \"" + disc.getTitle() + "\" not found in store.");
        }
    }

    public Media SearchByTitle(String title){
        for(int i = 0; i < itemsInStore.size();i++){
            if(itemsInStore.get(i).getTitle()==title){
                System.out.println("The information of media containing the keyword:\n");
                System.out.println(itemsInStore.get(i).toString());
                return itemsInStore.get(i);
            }
        }
        System.out.println("The information of media containing the keyword:\n");
        return null;
    }
    

}
