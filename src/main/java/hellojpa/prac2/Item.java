package hellojpa.prac2;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Entity
@Table(name ="ITEMS")
public class Item {

    @Id @GeneratedValue
    @Column(name="ITEM_ID")
    private Long id;

    @OneToMany(mappedBy="item")
    private List<Category_Item> categorysItems = new ArrayList<>();

    @OneToMany(mappedBy="item")
    private List<OrderItem> orderItems
            = new ArrayList<OrderItem>();

    private String name;
    private Integer price;
    private Integer stockQuantity;
}
