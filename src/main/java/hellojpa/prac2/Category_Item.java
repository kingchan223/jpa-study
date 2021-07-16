package hellojpa.prac2;

import javax.persistence.*;

@Entity
public class Category_Item  extends BaseEntity{
    @Id @GeneratedValue
    @Column(name ="CATEGORY_ITEM_ID")
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name ="CATEGORY_ID")
    private Category category;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ITEM_ID")
    private Item item;
}
