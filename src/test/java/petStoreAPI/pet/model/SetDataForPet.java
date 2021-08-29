package petStoreAPI.pet.model;

import java.util.Random;

public class SetDataForPet {
    private static final String[] PHOTO_URLS = new String[] {"some photo"};
    public static final String BASE_URI = "https://petstore.swagger.io/v2/pet";

    public static Pet getMyPet(){
        int petId = Math.abs(new Random().nextInt());
        return new Pet().createPet(petId, getMyPetCategory(), "shepherd Lu", PHOTO_URLS, getMyPetTags(), "available");
    }

    private static Tag[] getMyPetTags(){
        Tag tag = new Tag().setTag(1, "guard");
        return new Tag[] {tag};
    }

    private static Category getMyPetCategory(){
        return new Category().setCategory(1, "adult");
    }
}
