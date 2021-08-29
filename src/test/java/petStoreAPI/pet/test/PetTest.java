package petStoreAPI.pet.test;

import io.restassured.response.Response;
import org.junit.Test;
import petStoreAPI.pet.methods.Methods;
import petStoreAPI.pet.model.Pet;
import petStoreAPI.pet.model.SetDataForPet;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

    public class PetTest {

        @Test
        public void CreatePet() {
            Pet testPet = SetDataForPet.getMyPet();
            Response createPetResponse = Methods.createPet(testPet);
            Pet createdPetFromResponse = createPetResponse.getBody().as(Pet.class);

            assertEquals(createPetResponse.statusCode(), 200);
            assertEquals(createdPetFromResponse.id, testPet.id);
            assertEquals(createdPetFromResponse.name, testPet.name);

            Methods.deletePetById(testPet.id);
        }

        @Test
        public void FindPetById() throws InterruptedException {
            TimeUnit time = TimeUnit.SECONDS;
            long timeToSleep = 2;

            Pet testPet = SetDataForPet.getMyPet();
            Methods.createPet(testPet);
            time.sleep(timeToSleep);
            Response existedPet = Methods.getPetById(testPet.id);
            Pet existedPetFromResponse = existedPet.getBody().as(Pet.class);

            assertEquals(existedPet.statusCode(), 200);
            assertEquals(testPet.id, existedPetFromResponse.id);

            Methods.deletePetById(testPet.id);

            Response getDeletedPetResponse = Methods.getPetById(testPet.id);
            assertEquals(getDeletedPetResponse.statusCode(), 404);
        }

        @Test
        public void deletePetById() throws InterruptedException {
            TimeUnit time = TimeUnit.SECONDS;
            long timeToSleep = 3;

            Pet testPet = SetDataForPet.getMyPet();
            Response createPetResponse = Methods.createPet(testPet);
            assertEquals(createPetResponse.statusCode(), 200);
            time.sleep(timeToSleep);
            Response deletePetResponse = Methods.deletePetById(testPet.id);
            assertEquals(deletePetResponse.statusCode(), 200);
            time.sleep(timeToSleep);

            Response getDeletedPetResponse = Methods.getPetById(testPet.id);
            assertEquals(getDeletedPetResponse.statusCode(), 404);
        }
    }
