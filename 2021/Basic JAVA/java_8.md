# 클래스 실전

## import

import는 java.util.ArrayList로 추가한다.

## ArrayList 생성

```java
ArrayList<Integer> arrayList = new ArrayList<>();
```

타입은 Integer로 선언했다.

## ArrayList 추가

```java
import java.util.ArrayList;
public class ArrayListTest {
    public static void main(String[] args) { ArrayList<String> colors = new ArrayList<>();
    add() method colors.add("Black");
    colors.add("White");
    colors.add(0, "Green");
    colors.add("Red");

    set() method colors.set(0, "Blue");
    System.out.println(colors);
    }
}
```

결과값 : Blue Black White Red

add()는 기본적으로 리스트의 가장 끝에 값을 추가합니다.<br>
set() 메소드를 통해 Index의 값을 변경할 수 있다.

## ArrayList 삭제

```java
colors.remove("White");
System.out.println(colors);

colors.clear();
System.out.println(colors);
```

remove() 메소드를 사용하여 추가했던 값을 삭제한다.<br>
clear()를 호출하여 ArrayList 안의 내용을 전체 삭제한다.

## ArrayList 값 탐색

```java
for (int i = 0; i < colors.size(); ++i) {
    System.out.print(colors.get(i) + " ");
}
```

get() 메소드로 각 인덱스의 값을 순차적으로 탐색한다.

```java
boolean contains = colors.contains("Black"); System.out.println(contains);

int index = colors.indexOf("Blue");
System.out.println(index);
```

값이 존재하는지만 알고 싶은 경우 contains()를 사용한다.<br>
contains()는 값이 있는 경우 true를, 값이 없는 경우 false를 리턴한다.

값이 존재할 때 어느 위치에 존재하는지 알고 싶은 경우 indexOf()를 사용한다.<br>
indexOf()는 값이 존재하는 경우 해당 엘레멘트의 인덱스를 리턴한다.

## 프로그래밍이란

데이터의 효율적인 관리

버그없이 돌아는 가는데, 데이타를 다루는 기술이 부족하여 시스템 속도가 너무 느리다면, 효율적인 시스템이라고 할 수 없다.

우리는 코딩보다 프로그래밍 구조에 대해서 깊이 생각해야 된다.
