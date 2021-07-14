package hellojpa.prac2;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="CATEGORYS")
public class Category {
    @Id @GeneratedValue
    @Column(name ="CATEGORY_ID")
    private Long id;

    private String name;

    @OneToMany(mappedBy="category")
    private List<Category_Item> categorysItems = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="PARENT_ID")
    private Category parent;

    @OneToMany(mappedBy="parent")
    private List<Category> child = new ArrayList<>();
}
