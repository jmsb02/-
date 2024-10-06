package com.dorandoran.backend.Member.Controller;

import com.dorandoran.backend.Member.domain.Member;
import com.dorandoran.backend.Member.domain.MemberService;
import com.dorandoran.backend.Member.dto.req.LoginRequest;
import com.dorandoran.backend.Member.dto.req.MemberUpdateRequestDTO;
import com.dorandoran.backend.Member.dto.req.SignUpDTO;
import com.dorandoran.backend.Member.dto.res.MemberResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
@Slf4j
public class MemberRestController {

    private final MemberService memberService;

    // 회원가입
    @PostMapping("/signup")
    public ResponseEntity<Long> signUp(@RequestBody SignUpDTO signUpDTO) {
        Long memberId = memberService.signUp(signUpDTO);
        return new ResponseEntity<>(memberId, HttpStatus.CREATED);
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<Member> login(@RequestBody LoginRequest loginRequest, HttpServletRequest request) {
        Member findMember = memberService.login(loginRequest, request);
        return ResponseEntity.ok(findMember);
    }

    // 회원 정보 조회
    @GetMapping("/{memberId}")
    public ResponseEntity<MemberResponseDTO> getMemberInfo(@PathVariable Long memberId) {
        MemberResponseDTO memberInfo = memberService.getMemberInfo(memberId);
        return ResponseEntity.ok(memberInfo);
    }

    // 회원 정보 업데이트
    @PatchMapping("/{memberId}")
    public ResponseEntity<MemberResponseDTO> updateMemberInfo(@PathVariable Long memberId, @RequestBody MemberUpdateRequestDTO updateRequestDTO) {
        MemberResponseDTO updatedMember = memberService.updateMemberInfo(memberId, updateRequestDTO);
        return ResponseEntity.ok(updatedMember);
    }

    // 회원 삭제
    @DeleteMapping("/{memberId}")
    public ResponseEntity<String> deleteMember(@PathVariable Long memberId) {
        memberService.deleteMember(memberId);
        return ResponseEntity.ok("Member deleted successfully");
    }
}
