# 스프링 빈과 의존관계

## 스프링 빈 (Bean)

- 스프링 컨테이너가 관리하는 자바 객체를 빈이라 한다.
- new를 통해 생성하는 객체를 의미하는 것이 아니다.
- 컨테이너에서 스스로 생성하고 관리하는 객체를 의미한다.
- 컨테이너에서의 관리를 통해 객체를 여러번 생성할 필요가 없고, 공용으로 사용할 수 있다.

## 스프링 빈을 사용하는 이유

자주 사용하는 객체를 싱글톤(패턴)으로 만들어 놓고 어디서든 불러쓸 수 있기 때문이다.

## 스프링 빈 등록하기

스프링 빈을 컨테이너에 등록하는 방법으로는 두 가지 방법이 있다.

1. 컴포넌트 스캔과 자동 의존관계 설정
2. 자바 코드로 직접 스프링 빈 등록하기

### 컴포넌트 스캔과 자동 의존관계 설정

**MemberController에 의존관계 추가**

```java
package hello.hello_spring.controller;

import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
```

생성자에 @Autowired가 있으면 스프링이 연관된 객체(여기서는 MemberService)를 찾아서 알아서 연결해준다. 이런 식으로 외부에서 의존관계를 주입해주는 것을 DI라고 한다.

**서비스와 레포지토리 객체 스프링 빈 등록하기**

```java
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository =  memberRepository;
    }
    ...
}
```

```java
@Repository
public class MemoryMemberRepository implements MemberRepository {...}
```

@Service : 서비스 스프링 빈으로 등록
@Repository : 레포지토리 스프링 빈으로 등록

### 자바 코드로 직접 스프링 빈 등록하기

MemberService와 MemoryMemberRepository의 @Autowired, @Service, @Repositoryfmf 삭제하고 나서 진행한다.

hello_spring 패키지 밑에 바로 springConfig 클래스를 작성한다.

```java
@Configurable
public class springConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
```

springConfig가 직접 스프링 등록하기 위한 클래스임을 설정하는 @Configurable 어노테이션을 달아준다.

이후, 각각의 memberService, memberRepository에 대해서 @Bean 어노테이션을 달아주고 리턴 값으로 자기자신의 메모리 구현체를 넘긴다.

> 추가적으로 XML을 통해 등록하는 방법도 있지만 최근에는 잘 사용하지 않는다고 한다.
