package pl.adrian.pizzaaplication.domain.mapper;

import org.springframework.stereotype.Component;
import pl.adrian.pizzaaplication.data.entity.size.SizeEntity;
import pl.adrian.pizzaaplication.domain.model.SizeType;
import pl.adrian.pizzaaplication.remote.rest.dto.request.AddSizeDto;
import pl.adrian.pizzaaplication.remote.rest.dto.response.SizeDto;

@Component
public class SizeMapper {

    public SizeEntity mapToSizeEntity(AddSizeDto addSizeDto, Integer pizzaId) {
        SizeEntity sizeEntity = new SizeEntity();
        sizeEntity.setSizeType((addSizeDto.getSize().name()));
        sizeEntity.setPriceBase(addSizeDto.getPrice());
        sizeEntity.setPizzaId(pizzaId);
        return sizeEntity;
    }

    public SizeDto mapToSizeDto(SizeEntity sizeEntity) {

            SizeDto sizeDto = new SizeDto();
            sizeDto.setSize(SizeType.valueOf(sizeEntity.getSizeType()));
            sizeDto.setPrice(sizeEntity.getPriceBase());
            sizeDto.setId(sizeEntity.getId());
            return sizeDto;
    }

}
