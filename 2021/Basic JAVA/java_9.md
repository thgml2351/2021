# 패키지 및 접근 제한

## 패키지

관련있는 클래스들을 해당 패키지로 그룹을 만들어 관리한다.

패키지는 클래스를 모아 놓은 폴더이다.

## 패키지 설계 방식

패키지 이름은 유일한 이름일수록 좋다.

ex) 회사 도메인이 www.javalec.com이라면 com.javalec라고 하고 뒤에 기능별 또는 개발팀에서 정한 규칙에 의해 패키지명을 만든다.

#### 패키지명 수정 방법

![9-1](https://user-images.githubusercontent.com/66400531/118092264-d7e75e80-b406-11eb-9779-80461b82d78a.PNG)
![9-2](https://user-images.githubusercontent.com/66400531/118092515-2a287f80-b407-11eb-94dd-70d8421f05dd.PNG)

#### 패키지 이동 (폴더 이동)

드래그로 이동한다.

![9-3](https://user-images.githubusercontent.com/66400531/118092695-65c34980-b407-11eb-9615-0351450f00a8.PNG)

## import

다른 패키지에 있는 클래스를 가져올때 사용한다.

![9-4](https://user-images.githubusercontent.com/66400531/118093511-80e28900-b408-11eb-88de-c37a3acfe816.PNG)

import com.javalec.cal.PlusClass;
PlusClass plusClass = new PlusClass();

![9-5](https://user-images.githubusercontent.com/66400531/118093729-d5860400-b408-11eb-8cad-44941a759bc9.PNG)

패키지 한개의 여러 클래스를 import할땐 \*를 사용한다.

## 접근 제한

클래스의 데이터 또는 메소드에 대해서 다른 클래스로부터의 접근을 제한한다.

ex) 에러가 나는 이유는 private이기 때문이다.
![9-6](https://user-images.githubusercontent.com/66400531/118094690-0450aa00-b40a-11eb-9b51-2839a3385274.PNG)

#### 접근 제한 종류

- public : 접근 제한이 없다. 모든 클래스에서 사용 가능하다.
- private : 자신의 클래스에서만 사용 가능하다. 외부에서 사용 못한다.
- protected : 해당 클래스와 동일한 패키지에 있거나 상속받은 클래스일 경우에만 사용 가능하다.
- default : 해당 클래스와 동일한 패키지에서만 사용 가능하다.
