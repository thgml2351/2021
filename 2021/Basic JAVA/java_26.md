# JAVA Collections (2)

## Map계열 컬렉션 클래스 살펴보기

Map계열의 자료구조는 물품 보관함을 생각하면 이해하기 쉽습니다. 물품 보관함의 경우 번호가 있지만, 번호가 중요한 것이 아니라, 해당 물품 보관함의 키가 중요합니다. 즉 키만 있으면 키에 해당하는 물품 보관함을 이용할 수 있습니다. Map이 바로 이런 것입니다.

List계열과 달리 인덱스가 없고, 키와 값만 있습니다. 그리고 키는 유니크해야 합니다. 우리가 값을 관리하고자 한다면 키를 이용해서 값을 관리할 수 있습니다.

### HashMap

```java
//     <키, 데이터>
HashMap<Integer, String> hashMap = new HashMap<Integer, String>();

// HashMap은 add 대신 put을 쓴다.
// 키는 순서대로 안해도 된다.
hashMap.put(10, "str1");
hashMap.put(5, "str2");
hashMap.put(7, "str3");
hashMap.put(15, "str4");

System.out.println(hashMap.toString());

// 괄호 안의 숫자는 키 값
String str4 = hashMap.get(7);
System.out.println(str4);

hashMap.remove(15);
System.out.println(hashMap.toString());

hashMap.clear();
System.out.println(hashMap);
```

> {5=str2, 7=str3, 10=str1, 15=str4}
> str3
> {5=str2, 7=str3, 10=str1}
> {}

## Set계열 컬렉션 클래스 살펴보기

Set계열 자료구조에서는 데이터의 순서는 없습니다. 하지만 중복된 데이터는 허락하지 않습니다.

```java
HashSet<String> hashSet = new HashSet<String>();
hashSet.add("str0");
hashSet.add("str1");
hashSet.add("str2");
hashSet.add("str3");
hashSet.add("str2");
System.out.println(hashSet.toString());

hashSet.remove("str0");
System.out.println(hashSet.toString());

int i = hashSet.size();
System.out.println("사이즈 : " + i);
```

> [str3, str1, str2, str0]
> [str3, str1, str2]
> 사이즈 : 3

## Iterator 자료구조 살펴보기

Iterator는 정보를 얻어내는 역할을 한다.<br>
Iterator 메소드는 hasNext(), next(), remove()가 있다.

- hasNext() : 읽어올 요소가 남아있는지 확인하는 메소드이다. 요소가 있으면 true, 없으면 false
- next() : 다음 데이터를 반환한다.
- remove() : next()로 읽어온 요소를 삭제한다.

메소드 호출 순서는 hasNext() -> next() -> remove() 이다.

```java
HashMap<Integer, String> hashMap = new HashMap<Integer, String>();

hashMap.put(0, "str1");
hashMap.put(1, "str2");
hashMap.put(2, "str3");
hashMap.put(3, "str4");
System.out.println(hashMap.toString());

System.out.println("----");

// keySet : 키를 전부 얻어옴
Iterator<Integer> iterator = hashMap.keySet().iterator();
while (iterator.hasNext()) {
    String string = hashMap.get(iterator.next());
    if (string == "str3") {
        iterator.remove();
    }
    System.out.println(string);
}

System.out.println("----");

iterator = hashMap.keySet().iterator();
while (iterator.hasNext()) {
    System.out.println(hashMap.get(iterator.next()));
}
```

> {0=str1, 1=str2, 2=str3, 3=str4}
>
> ---
>
> str1
> str2
> str3
> str4
>
> ---
>
> str1
> str2
> str4
