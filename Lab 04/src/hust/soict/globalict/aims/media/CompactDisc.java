package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private List<Track> tracklist = new ArrayList<>();
    public List<Track> getTracks() {
        return tracklist;
    }
    public void play(){
        String Information= new String("Playing CD - " + getTitle() + " - " + getCategory() +" - " + getArtist() + " - " + getDirector() + " - " + getLength()+ ": ");
        System.out.println(Information);
        System.out.println("List of tracks:");
        for(int i=0; i < tracklist.size(); i++){
            System.out.print(i+".");    
            tracklist.get(i).play();
        }
    }

    public CompactDisc(int id, String title, String category, String artist, String director, List<Track> tracklist, float cost) {
        super(id, title, category, director, 0, cost);
        super.setLength(getLength());
        this.artist = artist;
        this.tracklist = tracklist;
    }

    public String getTracklist() {
        String out = new String("\nList of tracks:\n");
        for(int i=0;i<tracklist.size();i++){
            out += (i+1) +". "+ tracklist.get(i).toString()+"\n";
        }
        return out;
    }

    public String getArtist() {
        return artist;
    }

    public int getLength() {
        int totalLength = 0;
        for (Track track : tracklist) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    public String toString() {
        return "CD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getArtist() + " - " + getLength()+ " - " + getCost() +" $" + getTracklist();
    }

    public void addTrack(Track track) {
        if (!tracklist.contains(track)) {
          tracklist.add(track);
          System.out.println("Track '" + track + "' added successfully!");
        } else {
          System.out.println("track '" + track + "' already exists in the list.");
        }
      }
    
    public void removeTrack(Track track) {
    if (tracklist.contains(track)) {
        tracklist.remove(track);
        System.out.println("track '" + track + "' removed successfully!");
    } else {
        System.out.println("track '" + track + "' not found in the list.");
    }
    }

}
