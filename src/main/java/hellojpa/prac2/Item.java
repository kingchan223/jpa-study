package hellojpa.prac2;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Table(name ="ITEMS")
public class Item extends BaseEntity{

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Category_Item> getCategorysItems() {
        return categorysItems;
    }

    public void setCategorysItems(List<Category_Item> categorysItems) {
        this.categorysItems = categorysItems;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
