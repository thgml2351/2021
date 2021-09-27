# 회원 관리 예제

- 비지니스 요구사항 정리
- 회원 도메인과 리포지토리 만들기
- 회원 리포지토리 테스트 케이스 작성
- 회원 서비스 개발
- 회원 서비스 테스트

### 비지니스 요구사항 정리

- 데이터 : 회원ID, 이름
- 기능 : 회원 등록, 조회
- 아직 데이터 저장소가 선정되지 않음

### 회원 도메인과 리포지토리 만들기

#### 회원 도메인을 작성

domain 폴더를 만들고 Member라는 회원 객체 자바 파일을 생성합니다.

```
package hello.hello_spring.domain;

public class Member {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

회원 객체 도메인은 id와 name을 멤버변수로 갖습니다.

여기서 id는 임의로 부여합니다. name은 회원이 회원가입 시 입력합니다.

#### 회원 리포지토리(저장소)의 인터페이스를 작성

repository폴더를 만들고 MemberRepository라고 인터페이스를 생성합니다.

```
package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
```

Member 객체를 저장하는 save함수

id로 Member 객체를 검색하는 findById함수

name으로 Member 객체를 검색하는 findbyName함수

모든 회원 리스트를 반환하는 findAll함수

> Optional은 id나 name을 기준으로 Member 객체를 찾아 반환할 때 null이 반환되는 것을 처리하기 위한 것입니다.

#### 회원 레포지토리 메모리 구현체를 작성

repository 폴더 안에 MemberRepository 인터페이스를 구현한 MemoryMemberRepository로 자바 파일을 생성합니다.

```
package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private  static long seqence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++seqence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
```

> 저장된 회원들의 id(key)와 Member 객체(value)를 맵으로 저장할 HashMap으로 구현된 store map을 가진다.<br>sequence는 store의 key값을 생성하는 변수이다.

> Member객체를 받아 sequence를 1증가시키고 이를 id를 설정한다.<br>Member의 id와 Member 객체를 store map에 저장한다.<br>저장된 member 객체를 반환한다.

> store에서 id가 key값인 member객체를 Optional로 감싸 반환한다.<br>Optional로 감싸 반환하면 getter로 반환된 값이 null이더라도 처리가 가능하다.

> 저장된 Member객체를 담고 있는 store map의 모든 value를 돌며 member객체의 name이 입력받은 name과 같다면 (filter) 그 Member객체를 반환합니다. 이때 반환되는 Member객체도 Optional로 감싸 반환하면 마찬가지로 null이 반환될 때도 처리가 가능합니다.

> findAll 함수는 store에 저장되어있는 모든 Member객체들을 List형태로 반환합니다.
