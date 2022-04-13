package pl.adrian.pizzaaplication.domain.service;

import org.springframework.stereotype.Service;
import pl.adrian.pizzaaplication.data.repository.SizeRepository;
import pl.adrian.pizzaaplication.domain.exception.ResourceNotFoundException;
import pl.adrian.pizzaaplication.remote.rest.dto.request.AddOrderDto;
import pl.adrian.pizzaaplication.remote.rest.dto.response.TokenDto;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AddOrderService {

    private final SizeRepository sizeRepository;

    public AddOrderService(SizeRepository sizeRepository) {
        this.sizeRepository = sizeRepository;
    }

    public TokenDto addOrder(AddOrderDto addOrderDto) {

        Set<Integer> sizeIds = addOrderDto.getPizzas()
                .stream()
                .map(pizzaOrderDto -> pizzaOrderDto.getSizeId())
                .collect(Collectors.toSet());
        Boolean existSizes = sizeRepository.existsAllByIdIn(sizeIds);
        if(!existSizes) {
            throw new ResourceNotFoundException("Pizze o padanym rozmiarze nie istnieja w bazie danych");
        }

        String token = UUID.randomUUID().toString();

    }

}
