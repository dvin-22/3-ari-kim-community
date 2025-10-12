package kr.adapterz.ari_community.post;

import jakarta.persistence.*;
import kr.adapterz.ari_community.comment.Comment;
import kr.adapterz.ari_community.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue
    private BigInteger post_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    @ColumnDefault("0")
    private Boolean is_modified;

    @Column(nullable = false)
    private LocalDateTime created_at;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String image_url;

    @Column(nullable = false)
    @ColumnDefault("0")
    private Integer like_count;

    @Column(nullable = false)
    @ColumnDefault("0")
    private BigInteger view_count;

    @Column(nullable = false)
    @ColumnDefault("0")
    private Integer comment_count;

    // 단방향 연관관계, comment 테이블에 FK(post_id) 생성
    @OneToMany
    @JoinColumn(name = "post_id")
    private List<Comment> comments = new ArrayList<>();

    public Post(User user, String nickname, String title, String content, String image_url) {
        this.user = user;
        this.nickname = nickname;
        this.title = title;
        this.content = content;
        this.image_url = image_url;
        this.created_at = LocalDateTime.now();
    }

}
