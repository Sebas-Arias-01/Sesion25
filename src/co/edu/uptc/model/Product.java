package co.edu.uptc.model;

public class Product {

    private int id;
    private String description;
    private String presentation;
    
    public Product() {
        
    }
    
    public Product(int id, String description, String presentation) {
        this.id = id;
        this.description = description;
        this.presentation = presentation;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPresentation() {
        return presentation;
    }
    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

}
