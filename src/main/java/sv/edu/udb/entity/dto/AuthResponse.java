package sv.edu.udb.entity.dto;

public class AuthResponse {
    private String token;

    public AuthResponse(String token, String refreshToken) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
