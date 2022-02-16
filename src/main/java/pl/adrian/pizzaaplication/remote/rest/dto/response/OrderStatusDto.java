package pl.adrian.pizzaaplication.remote.rest.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import pl.adrian.pizzaaplication.domain.model.OrderStatusType;

import java.util.Date;

public class OrderStatusDto {
    private OrderStatusType status;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createdAt;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateAt;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date expectedAt;


    public OrderStatusDto(){
    }

    public OrderStatusDto(OrderStatusType status, Date createdAt, Date updateAt, Date expectedAt) {
        this.status = status;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        this.expectedAt = expectedAt;
    }
}
