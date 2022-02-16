package pl.adrian.pizzaaplication.remote.rest.dto.request;

import pl.adrian.pizzaaplication.domain.model.OrderStatusType;
import pl.adrian.pizzaaplication.remote.rest.dto.response.OrderStatusDto;

import java.util.List;

public class UpdateOrderDto {

    private OrderStatusType status;
    private List<PizzaOrderDto> pizzas;
    private PersonOrderDto person;

    public UpdateOrderDto() {
    }


    public UpdateOrderDto(OrderStatusType status, List<PizzaOrderDto> pizzas, PersonOrderDto person) {
        this.status = status;
        this.pizzas = pizzas;
        this.person = person;
    }

    public OrderStatusType getStatus() {
        return status;
    }

    public void setStatus(OrderStatusType status) {
        this.status = status;
    }

    public List<PizzaOrderDto> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<PizzaOrderDto> pizzas) {
        this.pizzas = pizzas;
    }

    public PersonOrderDto getPerson() {
        return person;
    }

    public void setPerson(PersonOrderDto person) {
        this.person = person;
    }



}