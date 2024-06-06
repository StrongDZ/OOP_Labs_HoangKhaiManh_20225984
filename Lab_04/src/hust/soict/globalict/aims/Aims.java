package hust.soict.globalict.aims;

import java.util.InputMismatchException;
import java.util.Scanner;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.store.Store;

public class Aims {
    static Store store = new Store();
    static Cart cart = new Cart();

    public static void main(String[] args) {
        while (true) {
            showMenu();
            Scanner input = new Scanner(System.in);
            System.out.print("Your choice:");
            try {
                int n = input.nextInt();
                input.nextLine(); // consume the newline character
                switch (n) {
                    case 0:
                        System.out.println("Thanks for using our service! Hope to see you again");
                        input.close();
                        return;
                    case 1:
                        Storefunc();
                        break;
                    case 2:
                        UpdateStore();
                        System.out.print("Your choice:");
                        try {
                            int kk = input.nextInt();
                            input.nextLine(); // consume the newline character
                            System.out.println("Enter the title: ");
                            String searchTitle = input.nextLine();
                            Media media = store.SearchByTitle(searchTitle);
                            if (media == null) break;
                            if (kk == 1)
                                store.addMedia(media);
                            else
                                store.removeMedia(media);
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid number.");
                            input.nextLine(); // consume the newline character
                        }
                        break;
                    case 3:
                        cart.print();
                        cartFunc();
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid number.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            } catch (Exception e) {
                // Handle other exceptions if any
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void UpdateStore() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add a media to store");
        System.out.println("2. Remove a media to store");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void Storefunc() {
        Scanner input = new Scanner(System.in);
        boolean out = true;
        while (out) {
            storeMenu();
            System.out.print("Your choice:");
            try {
                int po = input.nextInt();
                input.nextLine(); // consume the newline character
                if (po == 0) {
                    input.close();
                    return;
                }
                System.out.println("Enter the title: ");
                String searchTitle = input.nextLine();
                Media media = store.SearchByTitle(searchTitle);
                if (media == null) {
                    System.out.println("Media not found.");
                    break;
                }
                switch (po) {
                    case 1:
                        media.toString();
                        mediaFunc();
                        break;
                    case 2:
                        cart.addMedia(media);
                        break;
                    case 3:
                        if (media instanceof DigitalVideoDisc || media instanceof CompactDisc)
                            media.play();
                        break;
                    case 4:
                        cart.print();
                        cartMenu();
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid number.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                input.nextLine(); // consume the newline character
            }
        }
        input.close();
    }

    public static void mediaFunc() {
        Scanner input = new Scanner(System.in);
        while (true) {
            mediaDetailsMenu();
            System.out.print("Your choice:");
            try {
                int po = input.nextInt();
                input.nextLine(); // consume the newline character
                if (po == 0) {
                    input.close();
                    return;
                }
                System.out.println("Enter the title: ");
                String searchTitle = input.nextLine();
                Media media = store.SearchByTitle(searchTitle);
                if (media == null) {
                    System.out.println("Media not found.");
                    break;
                }
                switch (po) {
                    case 1:
                        cart.addMedia(media);
                        if (media instanceof DigitalVideoDisc) {
                            System.out.println("The number of DVDs in cart: " + cart.getDVD());
                        }
                        break;
                    case 2:
                        if (media instanceof DigitalVideoDisc || media instanceof CompactDisc)
                            media.play();
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid number.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                input.nextLine(); // consume the newline character
            }
        }
    }

    public static void cartFunc() {
        Scanner input = new Scanner(System.in);
        while (true) {
            cartMenu();
            System.out.print("Your choice:");
            try {
                int po = input.nextInt();
                input.nextLine(); // consume the newline character
                if (po == 0) {
                    input.close();
                    return;
                }
                switch (po) {
                    case 1:
                        System.out.println("1. By id \n 2. By title");
                        System.out.print("Your choice:");
                        int kk = input.nextInt();
                        input.nextLine(); // consume the newline character
                        if (kk == 1) {
                            System.out.println("Enter the id: ");
                            int id = input.nextInt();
                            cart.SearchByID(id);
                        } else {
                            System.out.println("Enter the title: ");
                            String searchTitle = input.nextLine();
                            cart.SearchByTitle(searchTitle);
                        }
                        break;
                    case 2:
                        System.out.println("1. By title \n 2. By cost");
                        System.out.print("Your choice:");
                        int m = input.nextInt();
                        if (m == 1) {
                            cart.SortByTitle();
                        } else {
                            cart.SortByCost();
                        }
                        break;
                    case 3:
                        System.out.println("Enter the title: ");
                        String searchTitle = input.nextLine();
                        Media media = store.SearchByTitle(searchTitle);
                        if (media == null)
                            break;
                        cart.removeMedia(media);
                        break;
                    case 4:
                        System.out.println("Enter the title: ");
                        String searchTitle1 = input.nextLine();
                        Media media1 = store.SearchByTitle(searchTitle1);
                        if (media1 == null)
                            break;
                        if (media1 instanceof DigitalVideoDisc || media1 instanceof CompactDisc)
                            media1.play();
                        break;
                    case 5:
                        System.out.println("Order placed. Thank you for shopping!");
                        cart.clear();
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid number.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                input.nextLine(); // consume the newline character
            }
        }
    }
}
