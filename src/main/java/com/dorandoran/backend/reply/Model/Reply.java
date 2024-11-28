package com.dorandoran.backend.reply.Model;

import com.dorandoran.backend.Comment.Model.Comment;
import com.dorandoran.backend.member.domain.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Reply{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_id")
    private Long id;

    @Column(nullable = false)
    @Lob
    private String content;

    @Column(nullable = false)
    private LocalDateTime created_at;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    //연관관계 편의 메서드 작성
    public void setComment(Comment comment) {
        this.comment = comment;
        if (!comment.getReplies().contains(this)) {
            comment.getReplies().add(this);
        }
    }



}
