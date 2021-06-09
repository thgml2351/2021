# API (3)

## Timer 클래스

Timer 클래스는 특정한 시간 또는 일정 시간을 주기로 반복적으로 특정 작업을 실행할 수 있도록 해 준다.

Timer 클래스는 세 가지 메소드를 제공한다.

- schedule
- scheduleAtFixedRate
- cancel

### schedule() 메소드

특정한 시간에 원하는 작업을 수행하고자 할 때 사용한다.<br>

| void | schedule(TimerTask task, Date time) |
| ---- | ----------------------------------- |

지정한 시간에 지정한 작업(task)을 수행한다.

| void | schedule(TimerTask task, Date firstTime, long period) |
| ---- | ----------------------------------------------------- |

지정한 시간(firstTime)부터 일정 간격(period)으로 지정한 작업(task)을 수행한다.

| void | schedule(TimerTask task, long delay) |
| ---- | ------------------------------------ |

일정 시간(delay)이 지난 후에 지정한 작업(task)을 수행한다.

| void | schedule(TimerTask task, long delay, long period) |
| ---- | ------------------------------------------------- |

일정 시간(delay)이 지난 후에 일정 간격(period)으로 지정한 작업(task)을 수행한다.

### scheduleAtFixedRate() 메소드

정확하게 일정 시간 간격으로 작업을 실행하기 위해 사용한다.<br>

| void | scheduleAtFixedRate(TimerTask task, Date firstTime, long period) |
| ---- | ---------------------------------------------------------------- |

지정한 시간(firstTime)부터 일정 간격(period)으로 지정한 작업(task)을 수행한다.

| void | scheduleAtFixedRate(TimerTask task, long delay, long period) |
| ---- | ------------------------------------------------------------ |

일정 시간(delay)이 지난 후에 일정 간격(period)으로 지정한 작업(task)을 수행한다.

cancel() 메소드는 Timer를 중지시키며, 실행될 예정인 모든 작업을 취소한다.

### TimerTask 클래스

TimerTask 클래스는 Timer클래스가 수행할 작업을 나타낸다.<br>

| boolean | cancel() |
| ------- | -------- |

이 TimerTask 작업을 취소한다.

| abstract void | run() |
| ------------- | ----- |

이 TimerTask가 실행할 작업

| long | scheduledExecutionTime() |
| ---- | ------------------------ |

가장 최근에 이 작업이 실행된 시간을 리턴한다.

### Timer 예제

```java
public class MainClass {
	public static void main(String[] args) throws InterruptedException{
		TimerEx ex = new TimerEx();
	}
}
```

```java
import java.util.Timer;
import java.util.TimerTask;

public class TimerEx{
	public TimerEx() throws InterruptedException{
		System.out.println("**");
        // true는 프로그램 로직이 끝나면 종료하라는 뜻
		Timer timer = new Timer(true);
		TimerTask t1 = new ExTimerTask1();
		TimerTask t2 = new ExTimerTask2();

		timer.schedule(t1, 2000); // 2초 후 수행
		timer.schedule(t2, 10000); //10초 후 수행

        // 지정된 시간 동안 일시 중단합니다.
		Thread.sleep(11000);
		System.out.println("**");
	}
}
```

```java
import java.util.TimerTask;

public class ExTimerTask1 extends TimerTask {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("ExTimerTask1");
	}
}
```

```java
import java.util.TimerTask;

public class ExTimerTask2 extends TimerTask{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("ExTimerTask2");
	}
}
```

> **
> ExTimerTask1
> ExTimerTask2
> **

## StringTokenizer 클래스

```java
import java.util.StringTokenizer;

public class MainClass {
	public static void main(String[] args) {
		String str1 = "오늘 날씨는 덥습니다. 반팔을 입으세요";
		String str2 = "2021/06/09";

		// 매개변수만 주면 띄어쓰기를 기준으로 글자를 나눈다.
		StringTokenizer tokenizer1 = new StringTokenizer(str1);
		// /를 기준으로 글자를 나눈다.
		StringTokenizer tokenizer2 = new StringTokenizer(str2, "/");

		// 몇개로 나누었는지 출력한다.
		System.out.println(tokenizer1.countTokens());
		System.out.println(tokenizer2.countTokens());

		// 다음 토큰이 있으면 실행해라
		while (tokenizer1.hasMoreTokens()) {
			// 다음 문자 출력해라
			System.out.println(tokenizer1.nextToken());
		}

		while (tokenizer2.hasMoreTokens()) {
			System.out.println(tokenizer2.nextToken());
		}
	}
}
```

> 5
> 3
> 오늘
> 날씨는
> 덥습니다.
> 반팔을
> 입으세요
> 2021
> 06
> 09
