package petStoreAPI.store.model;

import java.util.Calendar;
import java.util.Random;

public class SetDataForStore {

    public static final String BASE_URI = "https://petstore.swagger.io/v2/store/order";

    public static Store getMyStore(){
        int id = Math.abs(new Random().nextInt());
        int petId = Math.abs(new Random().nextInt());
        Calendar date = Calendar.getInstance();
        return new Store().createStore(id, petId, 4, date, "placed", true);
    }
}
