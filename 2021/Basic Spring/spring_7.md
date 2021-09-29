# 회원 관리 예제

- 비지니스 요구사항 정리
- 회원 도메인과 리포지토리 만들기
- 회원 리포지토리 테스트 케이스 작성
- 회원 서비스 개발
- 회원 서비스 테스트

## 회원 서비스 테스트

### 테스트 클래스 만들기

만들고자 하는 클래스에 커서를 두고 **ctrl + shift + T** 단축키를 실행하면 자동으로 해당 클래스의 테스트 클래스가 생성된다.

![14](https://user-images.githubusercontent.com/66400531/134858500-8c7d37ef-b832-49c9-8ce3-f39960b04d15.jpg)

### MemberServiceTest.java

```java
class MemberServiceTest {
    MemberService memberService;
    MemberRepository memberRepository;

    @BeforeEach
    public void beforEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    // 테스트 메소드는 한글로 바꿔도 된다.
    void 회원가입() {
        //given : 주어진 상태
        Member member = new Member();
        member.setName("hello");

        //when : 실행했을 때 (조건)
        Long saveId = memberService.join(member);

        //then : 나와야할 결과
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    // 테스트는 정장 플로우도 중요한데 예외 플로우가 더 중요하다.
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}
```
