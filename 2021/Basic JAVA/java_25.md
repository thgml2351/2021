# JAVA Collections

## 컬렉션이란?

컬렉션이란 여러 원소들을 담을 수 있는 자료구조를 뜻한다. 배열이 가장 기본적인 자료구조이다.

## JAVA도 결국 효과적인 데이터를 처리하기 위한 수단

JAVA언어는 무수히 많은 데이터를 어떤 형식으로 잘 정리하느냐에 따라 추후 데이터를 찾아서 사용 할 때 업무의 효율성이 높아 질 수 있습니다. 그래서 JAVA에서는 다양한 자료구조형을 제공하고 있습니다. 다양한 자료구조형이 제공되는 이유는 데이터의 성질에 따라서 데이터를 관리(정리)해야 하는 방식이 다르기 때문입니다.

자료구조형 안에는 객체의 레퍼런스만을 관리합니다.

## List계열 컬렉션 클래스

배열은 처음에 정한 크기를 고정하지만, List는 처음 만들 때 크기를 고정하지 않아도 된다.

### ArrayList

```java
ArrayList<String> arrayList = new ArrayList<String>();

arrayList.add("str1");
arrayList.add("str2");
arrayList.add("str3");
arrayList.add("str4");

System.out.println(arrayList.toString());

String index3 = arrayList.get(3);
System.out.println(index3);

arrayList.set(2, "str22");
System.out.println(arrayList.toString());

int size = arrayList.size();
System.out.println(size);

arrayList.remove(2);
System.out.println(arrayList.toString());

// 주소값을 가리키고 있지만 값이 없다.
arrayList.clear();
System.out.println(arrayList.toString());

// null은 arrayList가 가리키는 주소값을 끊는다.
arrayList = null;
System.out.println(arrayList);
System.out.println(arrayList.size());
```

> [str1, str2, str3, str4]
> str4
> [str1, str2, str22, str4]
> 4
> [str1, str2, str4]
> []
> null
> Exception in thread "main" java.lang.NullPointerException
> at asd.main(asd.java:31)

### LinkedList

```java
LinkedList<String> linkedList = new LinkedList<String>();

linkedList.add("str1");
linkedList.add("str2");
linkedList.add("str3");
linkedList.add("str4");
System.out.println(linkedList.toString());

linkedList.add("str5");
System.out.println(linkedList.toString());

// 2자리에 STR2가 들어가고, 2자리에 있던 값은 뒤로 밀려남. ArrayList와 다른점!
linkedList.add(2, "STR2");
System.out.println(linkedList.toString());

// 값을 변경
linkedList.set(2, "STR3");
System.out.println(linkedList.toString());

int size = linkedList.size();
System.out.println(size);

linkedList.remove(2);
System.out.println(linkedList.toString());

linkedList.clear();
System.out.println(linkedList.toString());

linkedList = null;
System.out.println(linkedList);
```

> [str1, str2, str3, str4] > [str1, str2, str3, str4, str5] > [str1, str2, STR2, str3, str4, str5] > [str1, str2, STR3, str3, str4, str5]
> 6
> [str1, str2, str3, str4, str5]
> []
> null
