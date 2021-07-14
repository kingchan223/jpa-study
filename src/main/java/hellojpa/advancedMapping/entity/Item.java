package hellojpa.advancedMapping.entity;

import javax.persistence.*;

//@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
/*단일 테이블 전략에서는 @DiscriminatorColumn가 없어도 자동으로 생성됩니다. */
//@DiscriminatorColumn
public abstract class Item {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private int price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
