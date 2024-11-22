package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberSerrviceImpl;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {

        // 스프링 컨테이너 사용 전
//        AppConfig appConfig = new AppConfig();
////        MemberService memberService = new MemberSerrviceImpl();
//        MemberService memberService = appConfig.memberService();


            // 스프링 컨테이너 사용 후
        ApplicationContext ap = new AnnotationConfigApplicationContext(AppConfig.class);
        // getBean(AppConfig내의 스프링 빈 이름, 반환형)
        MemberService memberService = ap.getBean("memberService", MemberService.class);


        // 멤버 생성
        Member member = new Member(1L,"memberA", Grade.VIP);

        // 1. 멤버 가입
        memberService.join(member);

        // 2. 생성된 멤버와 찾은 멤버, 확인하기
        Member findMember = memberService.findMember(1L);
        System.out.println("new member = "+member.getName());
        System.out.println("find member = "+findMember.getName());
    }
}
