package pl.adrian.pizzaaplication.remote.rest.dto.response;

public class TokenDto {
    private String token;

    public TokenDto() {
    }

    public TokenDto(String token) {
        this.token = token;
    }

    public String getToken(){
        return token;
    }

    public void TokenDto(String token) {
        this.token = token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
