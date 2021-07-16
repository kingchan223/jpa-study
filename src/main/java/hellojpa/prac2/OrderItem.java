package hellojpa.prac2;

import javax.persistence.*;

@Entity
public class OrderItem extends BaseEntity{

    @Id @GeneratedValue
    @Column(name ="ORDER_ITEM_ID")
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ITEM_ID")
    private Item item;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ORDER_ID")
    private Order order;

    private Integer orderPrice;
    private Integer count;
}
