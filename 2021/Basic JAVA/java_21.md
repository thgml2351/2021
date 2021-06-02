# API

## API란

누군가가 만들어 놓은 기능들

## String의 이해

String은 객체데이터입니다. 하지만 많이 쓰이는 객체라서 new를 사용하지 않고 기초데이터처럼 쓸 수 있습니다.

String string = "HelloWorld";
String string = new String("HelloWorld");

따라서 위와 같이 두 경우 모두 사용할 수 있습니다.

## String의 주요 기능들

concat : 문자열 연결
substring : 문자열 자르기
length : 문자열 길이
toUpperCase : 대문자로 만들기
toLowerCase : 소문자로 만들기
charAt : 특정위치의 글자 찾기
indexOf : 특정문자열의 위치
equals : 문자열 비교
trim : 문자열 공백제거
replace : 특정문자 변경
replaceAll : 특정문자열 변경

```java
String str1 = "abcdefg";
String str2 = "HIJKLMN";

System.out.println(str1.concat(str2));
System.out.println(str1.substring(3));
// 앞에서부터 문자 3개를 자른다.

System.out.println(str1.length());
System.out.println(str1.toUpperCase());
System.out.println(str1.toLowerCase());
System.out.println(str1.charAt(3));
// 0부터 시작

System.out.println(str1.indexOf('c'));
// 0부터 시작

String str3 = "abcdefg";
System.out.println(str1.equals(str3));

String str4 = " abc def ghi ";
System.out.println(str1.trim());
// 문자 사이가 아닌 가장자리 공백만 지워진다.

System.out.println(str1.replace('a', 'Z'));
System.out.println(str1.replaceAll("abcd", "ZZZZZ"));
```

> abcdefgHIJKLMN
> defg
> 7
> ABCDEFG
> abcdefg
> d
> 2
> true
> abcdefg
> Zbcdefg
> ZZZZZefg

## String 문제점

String str = "ABC";
str에 D를 추가할 때 기존 메모리에 추가하는게 아니고 새로운 메모리를 차지한다.

## StringBuffer, StringBuilder

String이 새로운 메모리를 생성하는 문제로 속도가 느려져서
StringBuffer, StringBuilder가 등장했다.

### StringBuffer 주요 기능

append : 문자열 추가
insert : 특정 위치에 문자열 추가
delete : 문자열 삭제
deleteCharAt : 특정 문자 하나 삭제

```java
		StringBuffer stringBuffer = new StringBuffer("abcdefg");

		stringBuffer.append("hijklmn");
		System.out.println(stringBuffer);

        // 0부터 시작해서 3자리에 넣는다.
		stringBuffer.insert(3, "AAA");
		System.out.println(stringBuffer);

        // 3번째 자리부터 5번째 자리 앞까지 지워라
		stringBuffer.delete(3, 5);
		System.out.println(stringBuffer);

		stringBuffer.deleteCharAt(10);
		System.out.println(stringBuffer);
```

> abcdefghijklmn
> abcAAAdefghijklmn
> abcAdefghijklmn
> abcAdefghiklmn

### StringBuffer, StringBuilder의 차이

거의 동일하다. 단, StringBuffer가 먼저 나왔다. 따라서 기능은 같고, 단지 StringBuilder가 속도 면에서 좀 더 빠르다.

## 날짜(Calendar) API

```java
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH)+1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);

		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);

		System.out.println(year + "년 " + month + "월 " + day + "일");
		System.out.println(hour + "시 " + minute + "분 " + second + "초");
```

- 현재 날짜, 시간이 나옴
  > 2021년 6월 2일
  > 15시 36분 50초

## 속도 테스트 용도

System.currentTimeMillis() : 시스템의 현재 시간

```java
        System.out.println(System.currentTimeMillis());

		String str = "A";
		long startNum = System.currentTimeMillis();

		for (int i = 0; i < 50000; i++) {
			str+="A";
		}

		long endNum = System.currentTimeMillis();
		System.out.println("경과 시간"+ (endNum - startNum));



		StringBuilder stringBuilder = new StringBuilder("A");
		long startNum1 = System.currentTimeMillis();

		for (int i = 0; i < 50000; i++) {
			stringBuilder = stringBuilder.append("A");
		}

		long endNum1 = System.currentTimeMillis();
		System.out.println("경과 시간"+ (endNum1 - startNum1));
```

= StringBuilder가 훨씬 빠르다.
