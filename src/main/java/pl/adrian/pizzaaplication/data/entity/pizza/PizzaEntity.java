package pl.adrian.pizzaaplication.data.entity.pizza;

import pl.adrian.pizzaaplication.data.entity.size.SizeEntity;

import java.util.Set;

@Entity
@Table(name = "pizzas")
public class PizzaEntity {


    @Id
    @GeneratedValue(stategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;


    @OneToMany(mappedBy = "pizza", orphanRemoval = true)
    private Set<SizeEntity> sizes;


}