package pl.adrian.pizzaaplication.remote.rest.dto.request;

import pl.adrian.pizzaaplication.remote.rest.dto.request.PersonOrderDto;
import pl.adrian.pizzaaplication.remote.rest.dto.request.PizzaOrderDto;

import java.util.List;

public class AddOrderDto {


    private List<PizzaOrderDto> pizzas;
    private PersonOrderDto person;


    public AddOrderDto() {

    }

    public AddOrderDto(List<PizzaOrderDto> pizzas, PersonOrderDto person) {
        this.pizzas = pizzas;
        this.person = person;
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
