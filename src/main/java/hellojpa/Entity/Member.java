package hellojpa.Entity;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.Date;

//(name="Member")//jpa가 괸리해야 하는 객체. DB테이블과 매핑
@Table//(name="Member")//매핑할 테이블 이름. 안붙이면 클래스 이름이 디폴트
@AllArgsConstructor
@Entity
public class Member{

    @Id @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    @Column(name ="USERNAME", nullable = false)//객체는 username, DB에는 name
    private String username;

    @ManyToOne//멤버 입장에서는 자기가 many, 팀이 one
    @JoinColumn(name="TEAM_ID")//Team테이블의 TEAM_ID와 조인
    private Team team;

//    @Column(name="TEAM_ID")
//    private Long teamId;


    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    public Long getTeamId() {
//        return teamId;
//    }
//
//    public void setTeamId(Long teamId) {
//        this.teamId = teamId;
//    }


//    private Integer age;
//
//    @Enumerated(EnumType.STRING)//EnumType.STRING: enum의 이름을 DB에 저장. USER, ADMIN(ORDINAL 쓰지말자.)
//    private RoleType roleType;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createDate;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;
//
//    @Lob//큰 컨텐츠. 여기서는 String이라서 clob으로 생성된다.
//    private String description;
//
//    @Transient//DB와 매핑 X
//    private Boolean MembershipStatus;

    public Member() {

    }
}
