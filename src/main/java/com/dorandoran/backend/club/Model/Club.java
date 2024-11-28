package com.dorandoran.backend.club.Model;


import com.dorandoran.backend.marker.domain.Marker;
import com.dorandoran.backend.member.domain.Member;
import com.dorandoran.backend.common.JpaBaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Club extends JpaBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "club_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "marker_id")
    private Marker marker;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

}