package petStoreAPI.store.model;

import java.util.Calendar;

public class Store {
    public int id;
    public int petId;
    public int quantity;
    public Calendar shipDate;
    public String status;
    public boolean complete;

    public Store createStore(int id, int petId, int storeQuantity, Calendar storeShipDate,
                             String storeStatus, boolean complete){
        this.id = id;
        this.petId = petId;
        this.quantity = storeQuantity;
        this.shipDate = storeShipDate;
        this.status = storeStatus;
        this.complete = complete;
        return this;
    }
}
