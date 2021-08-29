package petStoreAPI.store.methods;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import petStoreAPI.store.model.SetDataForStore;
import petStoreAPI.store.model.Store;

import static io.restassured.RestAssured.given;

public class Methods {
    public static Response orderPlaceForPet(Store store){
        Response response = null;
        RestAssured.baseURI = SetDataForStore.BASE_URI;
        response = given().
                body(store).contentType(ContentType.JSON).log().all().
                when().
                post().
                then().
                extract().response();
        return  response;
    }

    public static Response getOrderById(int orderId){
        Response response = null;
        RestAssured.baseURI = SetDataForStore.BASE_URI;

        response = given().
                when().log().all().
                get("/" + orderId).
                then().
                extract().response();
        return  response;
    }

    public static Response deleteStoreById(int storeId){
        Response response = null;
        RestAssured.baseURI = SetDataForStore.BASE_URI;

        response = given().
                when().
                delete("/" + storeId).
                then().
                extract().response();
        return  response;
    }
}
