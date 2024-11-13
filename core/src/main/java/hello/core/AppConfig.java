package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberSerrviceImpl;
import hello.core.member.MemberService;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberSerrviceImpl(memoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memoryMemberRepository(), fixDiscountPolicy());
    }

    public MemoryMemberRepository memoryMemberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy fixDiscountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
