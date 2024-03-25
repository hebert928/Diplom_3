package stellarBurgersAPI;

public class RegisterResponse {
    private String accessToken;

    public RegisterResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    public RegisterResponse() {
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
