package hust.soict.globalict.aims.media;

import java.util.Comparator;
import java.util.Objects;

public abstract class Media implements Comparable<Media> {
    private int id;
    private String title;
    private String category;
    private float cost;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public Media() {
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public boolean isMatch(String title) {
        return this.getTitle().toLowerCase().contains(title.toLowerCase());
    }

    public boolean isMatch(int id) {
        return this.id == id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Media media = (Media) obj;
        return Float.compare(media.getCost(), getCost()) == 0 &&
                Objects.equals(getTitle(), media.getTitle());
    }

    @Override
    public int compareTo(Media other) {
        if (other == null) {
            throw new NullPointerException("The compared media object is null");
        }
        int result = this.getTitle().compareTo(other.getTitle());
        if (result == 0) {
            result = Float.compare(this.getCost(), other.getCost());
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getCost());
    }

    public static class MediaComparatorByCostTitle implements Comparator<Media> {
        @Override
        public int compare(Media media1, Media media2) {
            int result = Float.compare(media2.getCost(), media1.getCost());
            if (result == 0) {
                result = media1.getTitle().compareTo(media2.getTitle());
            }
            return result;
        }
    }

    public static class MediaComparatorByTitleCost implements Comparator<Media> {
        @Override
        public int compare(Media media1, Media media2) {
            int result = media1.getTitle().compareTo(media2.getTitle());
            if (result == 0) {
                result = Float.compare(media2.getCost(), media1.getCost());
            }
            return result;
        }
    }
}
