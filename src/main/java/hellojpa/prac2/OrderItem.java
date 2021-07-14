package hellojpa.prac2;

import javax.persistence.*;

//@Entity
public class OrderItem {

    @Id @GeneratedValue
    @Column(name ="ORDER_ITEM_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name="ITEM_ID")
    private Item item;

    @ManyToOne
    @JoinColumn(name="ORDER_ID")
    private Order order;

    private Integer orderPrice;
    private Integer count;
}
