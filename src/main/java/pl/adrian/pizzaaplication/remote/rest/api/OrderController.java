package pl.adrian.pizzaaplication.remote.rest.api;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.adrian.pizzaaplication.domain.model.OrderStatusType;
import pl.adrian.pizzaaplication.domain.service.AddOrderService;
import pl.adrian.pizzaaplication.domain.service.DeleteOrderService;
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
    private final DeleteOrderService deleteOrderService;
    private final AddOrderService addOrderService;

    public OrderController(DeleteOrderService deleteOrderService, AddOrderService addOrderService) {
        this.deleteOrderService = deleteOrderService;
        this.addOrderService = addOrderService;
    }

    @PostMapping
    public ResponseEntity<TokenDto> addOrder(@RequestBody AddOrderDto addOrderDto) {
        TokenDto tokenDto = addOrderService.addOrder(addOrderDto);
        return ResponseEntity.ok(tokenDto);
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
        deleteOrderService.deleteOrder(orderId, token);
        return ResponseEntity.ok().build();

    }

    @PutMapping("/{order-id}")
    public ResponseEntity<OrderDto>updateOrder(@RequestBody UpdateOrderDto updateOrderDto,
                                               @PathVariable("order-id") Integer orderId,
                                               @RequestHeader("Access-Token") String token) {
        return ResponseEntity.ok(null);
    }
}

