package petStoreAPI.pet.methods;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import petStoreAPI.pet.model.Pet;
import petStoreAPI.pet.model.SetDataForPet;

import static io.restassured.RestAssured.given;

public class Methods {

    public static Response createPet(Pet pet){
        Response response = null;
            RestAssured.baseURI = SetDataForPet.BASE_URI;
            response = given().
                    body(pet).contentType(ContentType.JSON).log().all().
                    when().
                    post().
                    then().
                    extract().response();
        return  response;
    }

    public static Response getPetById(int petId){
        Response response = null;
            RestAssured.baseURI = SetDataForPet.BASE_URI;

            response = given().
                    header("api_key", "someNewApiKey123").
                    when().log().all().
                    get("/" + petId).
                    then().
                    extract().response();
        return  response;
    }

    public static Response deletePetById(int petId){
        Response response = null;
            RestAssured.baseURI = SetDataForPet.BASE_URI;

            response = given().
                    header("api_key", "someNewApiKey123").
                    when().
                    delete("/" + petId).
                    then().
                    extract().response();
        return  response;
    }
}
