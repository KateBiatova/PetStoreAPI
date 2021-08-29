package petStoreAPI.pet.model;

public class ApiResponse {

        public int code;
        public String type;
        public String message;

        public petStoreAPI.pet.model.ApiResponse validResponse(int code, String type, String message) {
            this.code = code;
            this.type = type;
            this.message = message;
            return this;
        }
}
