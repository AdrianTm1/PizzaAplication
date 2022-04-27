package pl.adrian.pizzaaplication.domain.mapper;

import org.springframework.stereotype.Component;
import pl.adrian.pizzaaplication.data.entity.order.OrderEntity;
import pl.adrian.pizzaaplication.remote.rest.dto.response.TokenDto;

@Component
public class TokenMapper {

        public TokenDto mapToTokenDto(OrderEntity orderEntity) {
            TokenDto tokenDto = new TokenDto();
            tokenDto.setToken(orderEntity.getToken());
            return tokenDto;
        }

}
