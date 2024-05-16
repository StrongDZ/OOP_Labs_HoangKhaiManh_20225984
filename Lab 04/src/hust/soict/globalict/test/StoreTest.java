package hust.soict.globalict.test;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.store.*;

public class StoreTest{
    
    public static void testaddMedia_Success() {
        Store store = new Store();
        DigitalVideoDisc disc = new DigitalVideoDisc("The Shawshank Redemption", "drama", "Frank Darabont", 144, 14.99f);
        store.addMedia(disc);
        System.out.println("Test passed: DVD added successfully.");
    }

    public static void testaddMedia_StoreFull() {
        Store store = new Store();

        // Fill the store with 1001 discs (should fail on the last one)
        for (int i = 0; i < 1001; i++) {
            store.addMedia(new DigitalVideoDisc("The Lion King", "animation", "Roger Allers & Rob Minkoff", 89, 19.95f));
        }
        System.out.println("Test passed: Store full message displayed.");
    }

    public static void testremoveMedia_Success() {
        Store store = new Store();
        DigitalVideoDisc disc1 = new DigitalVideoDisc("The Shawshank Redemption", "drama", "Frank Darabont", 144, 14.99f);
        DigitalVideoDisc disc2 = new DigitalVideoDisc("Game of Thrones - Season 1", "fantasy", "", 60 * 10, 29.99f);
        store.addMedia(disc1);
        store.addMedia(disc2);
        store.removeMedia(disc1);
        System.out.println("Test passed: DVD removed successfully.");
    }

    public static void testremoveMedia_NotFound() {
        Store store = new Store();
        DigitalVideoDisc disc = new DigitalVideoDisc("The Shawshank Redemption", "drama", "Frank Darabont", 144, 14.99f);
        store.addMedia(new DigitalVideoDisc("Game of Thrones - Season 1", "fantasy", "", 60 * 10, 29.99f));
        store.removeMedia(disc);
        System.out.println("Test passed: Not found message displayed.");
    }
    public static void main(String[] args){
        testaddMedia_StoreFull();
        testaddMedia_Success();
        testremoveMedia_NotFound();
        testremoveMedia_Success();
    }
}