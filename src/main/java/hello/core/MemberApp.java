package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberSerrviceImpl;
import hello.core.member.MemberService;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberSerrviceImpl();

        // 멤버 생성
        Member member = new Member(1L,"memberA", Grade.VIP);

        // 1. 멤버 가입
        memberService.join(member);

        // 2. 생성된 멤버와 찾은 멤버, 확인하기
        Member findMember = memberService.findMember(1L);
        System.out.println("new member ="+member.getName());
        System.out.println("find member ="+findMember.getName());
    }
}
