package pl.adrian.pizzaaplication.domain.service;

import org.springframework.stereotype.Service;
import pl.adrian.pizzaaplication.domain.exception.UnauthorizedException;
import pl.adrian.pizzaaplication.remote.rest.dto.request.AddPizzaDto;
import pl.adrian.pizzaaplication.remote.rest.dto.response.PizzaDto;

@Service
public class AuthorizationService {

    public static void checkToken(String token) {
        if (token == null || !token.equals("xzv")) {
            throw new UnauthorizedException("Bledny token");
        }
    }

}
