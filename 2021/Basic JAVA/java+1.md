# Call by value & Call by reference

## Call by value (값에 의한 호출)

원본 값을 그대로 복사하여 매개변수로 전달하는 것

- 특징 : 원본에 영향을 미치지 않는다.
- 장점 : 복사하여 처리하기 때문에 안전하다. 원래의 값이 보존이 된다.
- 단점 : 복사를 하기 때문에 메모리가 사용량이 늘어난다.

```java
public class Value {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println("swap() 호출 전 : a = " + a + " b = " + b);
        swap(a, b);
        System.out.println("swap() 호출 후 : a = " + a + " b = " + b);
    }

    public static void swap(int x, int y) {
        int temp = x;
        x = y;
        y = temp;
    }
}
```

![+1-1](https://user-images.githubusercontent.com/66400531/118060791-8cb15980-b3ce-11eb-9d57-d7d8222484c6.PNG)

swap() 메소드 호출 시 사용한 a, b와 swap() 메소드 내의 x, y는 서로 다르다.

## Call by reference (참조에 의한 호출)

원본의 주소값을 복사하여 전달하는 것

- 장점 : 복사하지 않고 직접 참조를 하기에 빠르다.
- 단점 : 직접 참조를 하기에 원래 값이 영향을 받는다.
