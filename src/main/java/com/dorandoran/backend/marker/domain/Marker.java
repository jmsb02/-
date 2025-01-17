package com.dorandoran.backend.marker.domain;

import com.dorandoran.backend.common.JpaBaseEntity;
import com.dorandoran.backend.file.domain.File;
import com.dorandoran.backend.member.domain.Member;
import com.dorandoran.backend.post.domain.Post;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Marker extends JpaBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "marker_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    @Embedded
    private MarkerAddress address;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @OneToMany(mappedBy = "marker", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<File> files = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id") // Post와의 관계 설정
    private Post post;

    public void setPost(Post post) {
        this.post = post;
        post.setMarker(this); // 양방향 연관 관계 설정
    }

    public void setFiles(List<File> files) {
        this.files = files;
        for (File file : files) {
            file.setMarker(this);
        }
    }

    @Builder
    public Marker(Long id, Member member, String title, String content, MarkerAddress address, List<File> files) {
        this.id = id;
        this.member = member;
        this.title = title;
        this.content = content;
        this.address = address;
        this.files = files != null ? files : new ArrayList<>(); // null 체크 후 빈 리스트 할당
    }

    public String getMemberName() {
        return member.getName();
    }
}
