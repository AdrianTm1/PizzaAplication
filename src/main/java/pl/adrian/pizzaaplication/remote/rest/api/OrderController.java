package pl.adrian.pizzaaplication.remote.rest.api;


import org.hibernate.sql.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.adrian.pizzaaplication.domain.model.OrderStatusType;
import pl.adrian.pizzaaplication.remote.rest.dto.request.AddOrderDto;
import pl.adrian.pizzaaplication.remote.rest.dto.request.UpdateOrderDto;
import pl.adrian.pizzaaplication.remote.rest.dto.response.OrderCollectionDto;
import pl.adrian.pizzaaplication.remote.rest.dto.response.OrderDto;
import pl.adrian.pizzaaplication.remote.rest.dto.response.OrderStatusDto;
import pl.adrian.pizzaaplication.remote.rest.dto.response.TokenDto;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(value = "/api/v1/order", produces = APPLICATION_JSON_VALUE)
@RestController
public class OrderController {

    @PostMapping
    public ResponseEntity<TokenDto> addOrder(@RequestBody AddOrderDto addOrderDto) {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/status/{token}")
    public ResponseEntity<OrderStatusDto> getStatus(@PathVariable("token")String token) {
        return ResponseEntity.ok(null);
    }


    @GetMapping
    public ResponseEntity<OrderCollectionDto> getOrders(@RequestParam("status") OrderStatusType orderStatus,
                                                        @RequestHeader("Access-Token") String token)  {
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{order-id}")
    public ResponseEntity<Void>deleteOrder(@PathVariable("order-id") Integer orderId,
                                                        @RequestHeader("Access-Token") String token)  {
        return ResponseEntity.ok(null);

    }

    @PutMapping("/{order-id}")
    public ResponseEntity<OrderDto>updateOrder(@RequestBody UpdateOrderDto updateOrderDto,
                                               @PathVariable("order-id") Integer orderId,
                                               @RequestHeader("Access-Token") String token) {
        return ResponseEntity.ok(null);
    }
}

