package librarySystem;

import java.util.ArrayList;
import java.util.List;

/**
 * Library class managing list of items
 */
public class Library {
    private String name;
    private String location;
    private List<Item> catalog;
    
    public Library(String name, String location) {
        this.name = name;
        this.location = location;
        this.catalog = new ArrayList<>();
    }
    
    public void addItem(Item item) {
        catalog.add(item);
    }
    
    public void removeItem(Item item) {
        catalog.remove(item);
    }
    
    public List<Item> getCatalog() {
        return catalog;
    }
    
    public int getCatalogSize() {
        return catalog.size();
    }
    
    public Item findItemByTitle(String title) {
        for (Item item : catalog) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                return item;
            }
        }
        return null;
    }
    
    public String displayCatalog() {
        StringBuilder sb = new StringBuilder();
        sb.append("Library Catalog:\n");
        for (int i = 0; i < catalog.size(); i++) {
            sb.append((i + 1)).append(". ").append(catalog.get(i).getDetails()).append("\n");
        }
        return sb.toString();
    }
    
    // Getters and setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
}
