package pl.adrian.pizzaaplication.remote.rest.api;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.adrian.pizzaaplication.remote.rest.dto.request.AddPizzaDto;
import pl.adrian.pizzaaplication.remote.rest.dto.response.PizzaDto;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(value = "/api/v1/pizzas", produces = APPLICATION_JSON_VALUE)
@RestController
public class PizzaController {

    @PostMapping
    public ResponseEntity<PizzaDto> addPizza(@RequestHeader("Access-token") String token,
                                             @RequestBody AddPizzaDto AddPizzaDto) {
        return ResponseEntity.ok(null);
    }

    @PutMapping("/{pizza-id}")
    public ResponseEntity<PizzaDto> updatePizza(@RequestBody PizzaDto PizzaDto,
                                            @PathVariable("pizza-id") Integer orderId,
                                            @RequestHeader("Access-Token") String token) {
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePizza(@PathVariable("id") Integer id,
                                            @RequestHeader("Access-Token") String token)  {
        return ResponseEntity.ok(null);
    }


}
