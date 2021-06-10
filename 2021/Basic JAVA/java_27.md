# JAVA 입출력(I/O) 알아보기

## 입출력(I/O) 이란?

I/O란? 입력(Input)과 출력(Output)을 뜻합니다. 컴퓨터한테 입력하는 것은 Input이며, 컴퓨터가 어떤 것을 출력하는 것을 Output이라고 합니다.

앞으로는 어떤 데이터를 '읽는다' 라고 하면 입력(Input)이고, 데이터를 '쓴다' 라고 하면 출력(Output)이라고 생각하면 됩니다.

## JAVA 입출력 API(Input~, Output~)

### InputStream 사용법

1. InputStream (추상)클래스를 이용해서 객체를 만든다. 또는 다른 클래스의 메소드에서 반환되는 타입 객체를 얻는다.
2. read()메소드를 이용해서 데이터를 읽으면 됩니다.
3. read(), read(byte[]) 두개의 메소드를 이용할 수 있습니다.

InputStream 객체

- read() : 1byte씩 읽는다. 속도가 느리다.
- read(byte[]) : byte[] 만큼씩 읽는다. 속도가 빠르다.

```java
try {
	InputStream is = new FileInputStream("C:\\Users\\user\\Desktop\\Stream.txt");
	while (true) {
		int i = is.read();
		System.out.println("데이터 : "+i);
		if(i == -1) break;
    }
} catch(Exception e) {
	System.out.println(e.getMessage());
}
```

### OutputStream 사용법

1. OutputStream 크래스를 이용해서 객체를 만든다. 또는 다른 클래스의 메소드에서 반환되는 타입 객체를 얻는다.
2. write()메소드를 이용해서 데이터를 읽으면 됩니다.
3. write(), write(byte[]), write(byte[], int, int) 세 개의 메소드를 이용할 수 있습니다.
4. write(byte[], int, int)는 데이터를 원하는 위치에서 원하는 숫자만큼 쓸 수 있습니다.

```java
try {
	OutputStream os = new FileOutputStream("C:\\Users\\user\\Desktop\\Stream.txt");
	String str = " 오늘 날씨는 매우 덥습니다.";
	byte[] bs = str.getBytes();
	os.write(bs);
} catch (Exception e) {}
```

![27-1](https://user-images.githubusercontent.com/66400531/121479761-52ef6500-ca05-11eb-8443-3a07a904f94e.PNG)

### 예외 처리와 무조건 close() 실행

1. I/O를 하면서 반드시 해야 하는 예외처리가 있습니다. IOException 입니다.
2. I/O작업 마지막은 close()로 외부연결을 끝내야 합니다.

```java
OutputStream os = null;

try {
	os = new FileOutputStream("C:\\Users\\user\\Desktop\\Stream.txt");
	String str = " 오늘 날씨는 매우 덥습니다.";
	byte[] bs = str.getBytes();
	os.write(bs);
} catch (Exception e) {

} finally {
	try {
		if(os != null) os.close();
	} catch (Exception e2) {

	}
}
```

## 텍스트 읽고 쓰기

읽고, 쓰기를 동시에 - 파일 복사

1. 파일을 읽고, 다른 파일에 쓰고, 결국은 파일 복사 입니다.
2. 작업순서 : InputStream, OutputStream 준비 > is로 읽어들인 데이터를 os으로 씀 > 외부연결 close()함.

```java
InputStream is = null;
		OutputStream os = null;

		try {
			is = new FileInputStream("C:\\Users\\user\\Desktop\\Stream.txt");
			os = new FileOutputStream("C:\\Users\\user\\Desktop\\Stream_copy.txt");

			byte[] bs = new byte[5];

			while(true) {
				int count = is.read(bs);
				if(count == -1) {
					break;
				}

				os.write(bs, 0, count);
			}
		} catch (Exception e) {
				System.out.println(e.getMessage());
		} finally {
			if(is != null) {
				try {
					is.close();
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}
			}
			if(os != null) {
				try {
					os.close();
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}
			}
		}
```

실행 전

![27-2](https://user-images.githubusercontent.com/66400531/121483063-baf37a80-ca08-11eb-9b37-00d7ae512819.PNG)

실행 후

![27-3](https://user-images.githubusercontent.com/66400531/121483070-bc24a780-ca08-11eb-9b13-1e56e4c2ce3c.PNG)
