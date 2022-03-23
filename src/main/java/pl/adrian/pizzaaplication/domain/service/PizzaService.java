package pl.adrian.pizzaaplication.domain.service;

import org.springframework.stereotype.Service;
import pl.adrian.pizzaaplication.data.entity.pizza.PizzaEntity;
import pl.adrian.pizzaaplication.data.repository.PizzaRepository;
import pl.adrian.pizzaaplication.domain.exception.UnauthorizedException;
import pl.adrian.pizzaaplication.domain.mapper.PizzaMapper;
import pl.adrian.pizzaaplication.remote.rest.dto.request.AddPizzaDto;
import pl.adrian.pizzaaplication.remote.rest.dto.response.PizzaDto;

import static pl.adrian.pizzaaplication.domain.service.AuthorizationService.checkToken;

@Service
public class PizzaService {

    private final PizzaRepository pizzaRepository;
    private final PizzaMapper pizzaMapper;

    public PizzaService(PizzaRepository pizzaRepository, PizzaMapper pizzaMapper) {
        this.pizzaRepository = pizzaRepository;
        this.pizzaMapper = pizzaMapper;
    }

    public PizzaDto addPizza(AddPizzaDto addPizzaDto, String token) {

        checkToken(token);

        if (token == null || !token.equals("xzv")) {
            throw new UnauthorizedException("Bledny token");
        }

        //wpisujemy name pizzy do bazy danych
        pizzaRepository.save(pizzaMapper.mapToPizzaEntity(addPizzaDto));




    }

}
