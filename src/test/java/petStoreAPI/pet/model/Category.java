package petStoreAPI.pet.model;

public class Category {
    public int id;
    public String name;

    public Category setCategory(int categoryId, String categoryName)
    {
        this.id = categoryId;
        this.name = categoryName;
        return this;
    }
}
