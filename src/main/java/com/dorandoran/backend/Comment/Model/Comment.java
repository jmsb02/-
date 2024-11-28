package com.dorandoran.backend.Comment.Model;

import com.dorandoran.backend.member.domain.Member;
import com.dorandoran.backend.post.domain.Post;
import com.dorandoran.backend.reply.Model.Reply;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Comment{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @Column(nullable = false)
    @Lob
    private String content;

    @Column(nullable = false)
    private LocalDateTime created_at;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @OneToMany(mappedBy = "comment")
    private List<Reply> replies = new ArrayList<>();


    //연관관계 편의 메서드 작성
    public void setPost(Post post) {
        this.post = post;
        if(!post.getComments().contains(this)) {
            post.getComments().add(this);
        }
    }

    public void addReply(Reply reply) {
        replies.add(reply);
        reply.setComment(this);
    }

    public Long getPostId() {
        return post.getId();
    }

}
