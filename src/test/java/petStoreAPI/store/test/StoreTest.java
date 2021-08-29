package petStoreAPI.store.test;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import petStoreAPI.store.model.Store;
import petStoreAPI.store.model.SetDataForStore;
import petStoreAPI.store.methods.Methods;

public class StoreTest {
    @Test
    public void orderPlaceForPet() {
        Store testStore = SetDataForStore.getMyStore();
        Response createStorePlaceResponse = Methods.orderPlaceForPet(testStore);
        Store createdStorePlaceFromResponse = createStorePlaceResponse.getBody().as(Store.class);

        Assert.assertEquals(createStorePlaceResponse.statusCode(), 200);
        Assert.assertEquals(createdStorePlaceFromResponse.id, testStore.id);
        Assert.assertEquals(createdStorePlaceFromResponse.petId, testStore.petId);
        Assert.assertEquals(createdStorePlaceFromResponse.status, testStore.status);
        Assert.assertEquals(createdStorePlaceFromResponse.complete, testStore.complete);
    }

    @Test
    public void findStoreById(){
        Store testStore = SetDataForStore.getMyStore();
        petStoreAPI.store.methods.Methods.orderPlaceForPet(testStore);
        Response existedStore = petStoreAPI.store.methods.Methods.getOrderById(testStore.id);
        Store existedStoreFromResponse = existedStore.getBody().as(Store.class);

        Assert.assertEquals(existedStore.statusCode(), 200);
        Assert.assertEquals(testStore.id, existedStoreFromResponse.id);

        petStoreAPI.store.methods.Methods.deleteStoreById(testStore.id);
    }

    @Test
    public void deleteStoreById(){
        Store testStore = SetDataForStore.getMyStore();
        Response createStoreResponse = petStoreAPI.store.methods.Methods.orderPlaceForPet(testStore);
        Assert.assertEquals(createStoreResponse.statusCode(), 200);
        Response deleteStoreResponse = petStoreAPI.store.methods.Methods.deleteStoreById(testStore.id);
        Assert.assertEquals(deleteStoreResponse.statusCode(), 200);

        Response getDeletedStoreResponse = petStoreAPI.store.methods.Methods.getOrderById(testStore.id);
        Assert.assertEquals(getDeletedStoreResponse.statusCode(), 404);
    }
}