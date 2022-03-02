package pl.adrian.pizzaaplication.data.entity.ordersize;

import pl.adrian.pizzaaplication.data.entity.order.OrderEntity;
import pl.adrian.pizzaaplication.data.entity.pizza.PizzaEntity;
import pl.adrian.pizzaaplication.data.entity.size.SizeEntity;

@Entity
@Table(name = "orders_sizes")
public class OrderSizeEntity {

        @Id
        @GeneratedValue(stategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Integer id;

        @Column(name = "size_id")
        private Integer sizeId;

        @Column(name = "order_id")
        private Integer orderId;

        @Column(name = "size_count")
        private Integer sizeCount;

        @ManyToOne
        @JoinColumn(name = "order_id", insertable = false, updatable = false)
        private OrderEntity order;

        @ManyToOne
        @JoinColumn(name = "size_id", insertable = false, updatable = false)
        private SizeEntity size;

}
