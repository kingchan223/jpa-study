package hellojpa.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;

    //mappedBy있는 쪽은 주인이 아님. 여기서는 읽기만 가능. 아무리 수정해도 DB에 반영안됨 //가짜 매핑
    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();




    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

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
}
