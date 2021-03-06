package hellojpa.prac2;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="CATEGORYS")
public class Category  extends BaseEntity{
    @Id @GeneratedValue
    @Column(name ="CATEGORY_ID")
    private Long id;

    private String name;

    @OneToMany(mappedBy="category")
    private List<Category_Item> categorysItems = new ArrayList<>();

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PARENT_ID")
    private Category parent;

    @OneToMany(mappedBy="parent")
    private List<Category> child = new ArrayList<>();
}
