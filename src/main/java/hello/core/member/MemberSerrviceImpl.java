package hello.core.member;

// 관례: 인터페이스에 관한 구현체가 하나만 있을 경우
// 클래스 이름을 +Impl로 적어준다
public class MemberSerrviceImpl implements MemberService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
