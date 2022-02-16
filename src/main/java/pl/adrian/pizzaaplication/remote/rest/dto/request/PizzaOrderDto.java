package pl.adrian.pizzaaplication.remote.rest.dto.request;

public class PizzaOrderDto {

    private Integer id;
    private Integer sizeId;
    private Integer count;

    public PizzaOrderDto() {
    }

    public PizzaOrderDto(Integer id, Integer sizeId, Integer count) {
        this.id = id;
        this.sizeId = sizeId;
        this.count = count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSizeId(Integer sizeId) {
        this.sizeId = sizeId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getSizeId() {
        return sizeId;
    }
}


