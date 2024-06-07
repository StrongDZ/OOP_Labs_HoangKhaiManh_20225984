package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {

    public void play() throws PlayerException {
        if(this.getLength()>0){
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        }
        else{
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }

    }

    public DigitalVideoDisc(String title) {
      super.setTitle(title);
    }
    
    public DigitalVideoDisc(String title, String category, float cost) {
      super.setTitle(title);
      super.setCategory(category);
      super.setCost(cost);
    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
      super.setTitle(title);
      super.setCategory(category);
      super.setCost(cost);
      super.setDirector(director); 
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
      super.setTitle(title);
      super.setCategory(category);
      super.setCost(cost);
      super.setDirector(director);
      super.setLength(length);
    }
    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
      super.setId(id);
      super.setTitle(title);
      super.setCategory(category);
      super.setCost(cost);
      super.setDirector(director);
      super.setLength(length);
    }

    public String toString() {
      return "DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + ": " + getCost()+" $";
    }
  
}
