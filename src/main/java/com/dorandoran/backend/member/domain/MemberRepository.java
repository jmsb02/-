package com.dorandoran.backend.member.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Boolean existsByName(String name);
    Boolean existsByEmail(String email);
    Optional<Member> findByName(String name);
    Boolean existsByLoginId(String loginId);
    Optional<Member> findByLoginId(String loginId);
}