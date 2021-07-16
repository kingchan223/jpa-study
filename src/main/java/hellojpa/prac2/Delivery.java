package hellojpa.prac2;

import javax.persistence.*;

@Entity
public class Delivery  extends BaseEntity{

    @Id @GeneratedValue
    @Column(name="DELIVERY_ID")
    private Long id;

    private String city;

    private String street;

    private String zipcode;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    @OneToOne(mappedBy="delivery", fetch=FetchType.LAZY)//양방향 관계를 위해 만듦. 없어도 된다.
    private Order order;
}



