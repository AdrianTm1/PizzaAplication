package pl.adrian.pizzaaplication.domain.service;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import pl.adrian.pizzaaplication.data.entity.pizza.PizzaEntity;
import pl.adrian.pizzaaplication.data.entity.size.SizeEntity;
import pl.adrian.pizzaaplication.data.repository.PizzaRepository;
import pl.adrian.pizzaaplication.data.repository.SizeRepository;
import pl.adrian.pizzaaplication.domain.exception.ResourceNotFoundException;
import pl.adrian.pizzaaplication.domain.mapper.PizzaMapper;
import pl.adrian.pizzaaplication.domain.mapper.SizeMapper;
import pl.adrian.pizzaaplication.domain.model.SizeType;
import pl.adrian.pizzaaplication.remote.rest.dto.request.AddPizzaDto;
import pl.adrian.pizzaaplication.remote.rest.dto.request.AddSizeDto;
import pl.adrian.pizzaaplication.remote.rest.dto.request.UpdatePizzaDto;
import pl.adrian.pizzaaplication.remote.rest.dto.response.MenuDto;
import pl.adrian.pizzaaplication.remote.rest.dto.response.PizzaDto;
import pl.adrian.pizzaaplication.remote.rest.dto.response.SizeDto;

import java.util.List;
import java.util.stream.Collectors;

import static pl.adrian.pizzaaplication.domain.service.AuthorizationService.checkToken;

@Service
public class PizzaService {

    private final SizeRepository sizeRepository;
    private final PizzaRepository pizzaRepository;
    private final PizzaMapper pizzaMapper;
    private final SizeMapper sizeMapper;


    public PizzaService(SizeRepository sizeRepository, PizzaRepository pizzaRepository, PizzaMapper pizzaMapper, SizeMapper sizeMapper) {
        this.sizeRepository = sizeRepository;
        this.pizzaRepository = pizzaRepository;
        this.pizzaMapper = pizzaMapper;
        this.sizeMapper = sizeMapper;
    }

    public PizzaDto addPizza(AddPizzaDto addPizzaDto, String token) {

        checkToken(token);

//        if (token == null || !token.equals("xzv")) {
//            throw new UnauthorizedException("Bledny token");
//        }

        //wpisujemy name pizzy do bazy danych
        PizzaEntity pizzaEntity = pizzaMapper.mapToPizzaEntity(addPizzaDto);
        pizzaRepository.save(pizzaEntity);


        //wpisujemy liste rozmiar+cena do DB

        List<AddSizeDto> addSizeDtoList = addPizzaDto.getSizes();
        List<SizeEntity> sizeEntities = addSizeDtoList
                .stream()
                .map(addSizeDto -> sizeMapper.mapToSizeEntity(addSizeDto, pizzaEntity.getId()))
                .collect(Collectors.toList());
        sizeRepository.saveAll(sizeEntities);

        //mapowanie z encji do PizzaDto
        List<SizeDto> sizeDtoList = sizeEntities.stream()
                .map(sizeEntity -> sizeMapper.mapToSizeDto(sizeEntity))
                .collect(Collectors.toList());



//        List<SizeDto> sizeDtoList = savedSizeEntities
//                .stream()
//                .map(sizeEntity -> sizeMapper.mapToSizeDto(sizeEntity)).collect(Collectors.toList());
//


//        List<AddSizeDto> addSizeDtoList = addPizzaDto.getAddSizeDtoList();
//        List<SizeEntity> sizeEntities = addSizeDtoList
//        .stream()
//        .map(addSizeDto -> {
//            SizeEntity sizeEntity = new SizeEntity();
//            sizeEntity.setSizeType(sizeDto.getSize().name());
//            sizeEntity.setPriceBase(sizeDto.getPrice());
//            sizeEntity.setId(sizeDto.getId());
//            sizeEntity.setPizzaId(savedPizzaEntity.getId());
//            return sizeEntity;
//        }).collect(Collectors.toList());
//        PizzaEntity savedSizeEntity = sizeRepository.saveAll(sizeEntity);
//
        return pizzaMapper.mapToPizzaDto(pizzaEntity, sizeDtoList);
    }

    public MenuDto getMenu() {
        List<PizzaEntity> pizzaEntities = pizzaRepository.findAll();
        List<PizzaDto> pizzaDtoList = pizzaEntities
                .stream()
                .map(pizzaEntity -> pizzaMapper.mapToPizzaDto(pizzaEntity))
                .collect(Collectors.toList());

            return new MenuDto(pizzaDtoList);
    }

    public void deletePizza(Integer pizzaId, String token) {

        checkToken(token);
        boolean pizzaExist = pizzaRepository.existsById(pizzaId);
        if (!pizzaExist) {
            throw new ResourceNotFoundException("Pizza o podanym id nie istnieje");
        }
        pizzaRepository.deleteById(pizzaId);
    }

    public PizzaDto updatePizza(UpdatePizzaDto updatePizzaDto, String token, Integer pizzaId) {
        checkToken(token);
        boolean pizzaExist = pizzaRepository.existsById(pizzaId);
        if (!pizzaExist) {
            throw new ResourceNotFoundException("Pizza o podanym id nie istnieje");
        }
    PizzaEntity pizzaEntity = pizzaRepository.getById(pizzaId);
        pizzaEntity.setName(updatePizzaDto.getName());
        pizzaRepository.save(pizzaEntity);

        sizeRepository.deleteAllByPizzaId(pizzaId);

        List<AddSizeDto> addSizeDtoList = updatePizzaDto.getSizes();
        List<SizeEntity> sizeEntities = addSizeDtoList
                .stream()
                .map(addSizeDto -> sizeMapper.mapToSizeEntity(addSizeDto, pizzaId))
                .collect(Collectors.toList());
        sizeRepository.saveAll(sizeEntities);

        List<SizeDto> sizeDtoList = sizeEntities.stream()
                .map(sizeMapper::mapToSizeDto)
                .collect(Collectors.toList());

        return pizzaMapper.mapToPizzaDto(pizzaEntity, sizeDtoList);

    }
}















