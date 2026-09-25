package grocery;

public class GroceryItem {
    private final int id;
    private final String name;
    private final int quality;

    public GroceryItem(int id, String name, int quality) {
        this.id = id;
        this.name = name;
        this.quality = quality;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuality() {
        return quality;
    }
}
