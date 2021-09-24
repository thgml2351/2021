# 스프링 웹 개발 기초

### 정적 컨텐츠

서버에서 하는거 없이 html 파일을 그대로 넘겨줘서 보여주는 것

![7](https://user-images.githubusercontent.com/66400531/134606450-bb6faf80-55bf-4534-9f55-b670181c3c24.PNG)

웹 브라우저에서 내장 톰캣 서버로 URL을 전달하면 서버에서 hello-static 관련 컨트롤러가 있는지 찾고, 없으면 정적 컨텐츠를 찾는다.

![8](https://user-images.githubusercontent.com/66400531/134606645-0aa46fbc-a91d-46e0-91f0-f216e59bc2a1.jpg)

### MVC와 템플릿 엔진

> MVC : Model, View, Controller

![9](https://user-images.githubusercontent.com/66400531/134609430-e0a8d100-eb4c-45fa-978e-c894b1d30a83.PNG)

주소창에 **name**은 **String!!!!** 이라고 치면 컨트롤러에서 **name**은 **String!!!!** 이라고 바뀌고 모델에 담긴다. 그리고 **hello-template**으로 넘어가면 **${name}** 은 모델에서 값을 꺼내간다.

![10](https://user-images.githubusercontent.com/66400531/134619930-fa5b3bef-994f-4c89-b55a-dae9bdc19cbb.jpg)

### API

##### @ResponseBody 문자 반환

![11](https://user-images.githubusercontent.com/66400531/134624619-bd958da8-2d33-4a21-a30f-90017272c2ca.PNG)

**@ResponseBody**를 사용하면 **viewResolver**를 사용하지 않는다. 대신 **Http**의 **Body**에 문자 내용을 직접 반환한다.

> @ResponseBody란 데이터를 직접 넣어주는 역할을 한다.

> viewResolver란 리턴값의 prefix, suffix를 붙혀 src의 경로를 찾아가게 해준다.

> 예) /WEB-INF/viewjsp/hello.jsp

- /WEB-INF/viewjs = prefix
- hello = 뷰 이름
- .jsp = suffix

##### @ResponseBody 객체 반환

![12](https://user-images.githubusercontent.com/66400531/134625853-21bf4272-89a0-4c98-936b-4f143b454a0f.PNG)

객체를 반환하게 되면, json형태로 반환한다.

> json 데이터는 이름과 값의 쌍으로 구성된다.

##### @ResponseBody 사용 원리

![13](https://user-images.githubusercontent.com/66400531/134626028-c33e5a60-2c64-4715-b6ea-62e9da787170.jpg)

문자 = StringConverter 실행
객체 = JsonConverter 실행
