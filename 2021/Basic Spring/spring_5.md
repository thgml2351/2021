# 회원 관리 예제

- 비지니스 요구사항 정리
- 회원 도메인과 리포지토리 만들기
- 회원 리포지토리 테스트 케이스 작성
- 회원 서비스 개발
- 회원 서비스 테스트

## 회원 리포지토리 테스트 케이스 작성

- 테스트 메소드는 서로 의존관계 없이 설계되어야 한다.
- 테스트가 하나 끝날때마다 공용 데이터를 클리어해줘야 한다.
- given-when-then 문법 : 테스트할 때 직관적으로 볼 수 있어 유용하다.

### MemoryMemberRepositoryTest.java

```java
package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

// 클래스 단위에서 작동시키면 모든 테스트 모듈이 무작위 순서로 동작한다.
public class MemoryMemberRepositoryTest{
    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 각 메소드가 끝날 때마다 호출된다. 공용 데이터를 클리어해주는 용도로 사용한다.
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    // 테스트 메서드에 붙여주는 어노테이션. 테스트 단위에서 작동시키면 해당 테스트 모듈만 동작한다.
    @Test
    public void save() {
        // 1. given
        Member member = new Member();
        member.setName("spring");

        // 2. when
        repository.save(member);

        // 3. then
        // Optional은 get()을 통해 값을 꺼낼 수 있다.
        // 좋은 방법은 아니지만 테스트 코드에서 사용하긴 좋다.
        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        // 1. given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        // 2. when
        Member result = repository.findByName("spring1").get();

        // 3. then
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        // 1. given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        // 2. when
        List<Member> result = repository.findAll();

        // 3. then
        assertThat(result.size()).isEqualTo(2);
    }

}
```

### MemoryMemberRepository.java

```java
    public void clearStore() {
        store.clear();
    }
```
