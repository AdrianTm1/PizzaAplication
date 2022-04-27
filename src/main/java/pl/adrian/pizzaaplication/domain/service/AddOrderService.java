package pl.adrian.pizzaaplication.domain.service;

import org.springframework.stereotype.Service;
import pl.adrian.pizzaaplication.data.entity.order.OrderEntity;
import pl.adrian.pizzaaplication.data.entity.ordersize.OrderSizeEntity;
import pl.adrian.pizzaaplication.data.repository.OrderRepository;
import pl.adrian.pizzaaplication.data.repository.OrderSizeRepository;
import pl.adrian.pizzaaplication.data.repository.SizeRepository;
import pl.adrian.pizzaaplication.domain.exception.ResourceNotFoundException;
import pl.adrian.pizzaaplication.domain.mapper.TokenMapper;
import pl.adrian.pizzaaplication.domain.model.OrderStatusType;
import pl.adrian.pizzaaplication.remote.rest.dto.request.AddOrderDto;
import pl.adrian.pizzaaplication.remote.rest.dto.request.PersonOrderDto;
import pl.adrian.pizzaaplication.remote.rest.dto.request.PizzaOrderDto;
import pl.adrian.pizzaaplication.remote.rest.dto.response.TokenDto;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AddOrderService {

    private final SizeRepository sizeRepository;
    private final OrderRepository orderRepository;
    private final OrderSizeRepository orderSizeRepository;
    private final TokenMapper tokenMapper;



    public AddOrderService(SizeRepository sizeRepository, OrderRepository orderRepository, OrderSizeRepository orderSizeRepository, TokenMapper tokenMapper) {
        this.sizeRepository = sizeRepository;
        this.orderRepository = orderRepository;
        this.orderSizeRepository = orderSizeRepository;

        this.tokenMapper = tokenMapper;
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

        Date now = new Date();
        PersonOrderDto person = addOrderDto.getPerson();
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setClientName(person.getName());
        orderEntity.setClientAddress(person.getAddress());
        orderEntity.setClientPhone(person.getPhone());
        orderEntity.setFloor(person.getFloor());
        orderEntity.setStatus(OrderStatusType.NEW.name());
        orderEntity.setCreatedAt(now);
        orderEntity.setUpdatedAt(now);
        orderEntity.setToken(token);
        orderRepository.save(orderEntity);

        Integer orderId = orderEntity.getId();

        List<PizzaOrderDto> pizzaOrderDtoList = addOrderDto.getPizzas();
        List<OrderSizeEntity> orderSizeEntities = pizzaOrderDtoList
                .stream()
                .map(PizzaOrderDto -> {
                    OrderSizeEntity orderSizeEntity = new OrderSizeEntity();
                    orderSizeEntity.setSizeId(PizzaOrderDto.getSizeId());
                    orderSizeEntity.setOrderId(orderId);
                    orderSizeEntity.setSizeCount(PizzaOrderDto.getCount());
                    return orderSizeEntity;
                }).collect(Collectors.toList());
        orderSizeRepository.saveAll(orderSizeEntities);

        TokenDto tokenDto = new TokenDto();
        tokenDto.setToken(token);

        return tokenMapper.mapToTokenDto(orderEntity);

    }

}
