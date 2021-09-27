# Controller 이해

## index.html

```
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
Hello
<a href="/hello">hello</a>
</body>
</html>
```

![1](https://user-images.githubusercontent.com/66400531/134464442-a922cae6-5ff0-4992-b9d6-a1531eadc34e.PNG)

## hello.html

```
<!doctype html>
<html xmlns="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<p th:text="'안녕하세요. ' + ${data}">손님</p>
</body>
</html>
```

th:text는 서버에서 data라는 변수가 있을 경우 '손님' 자리를 변수값으로 대체하게 된다.

![2](https://user-images.githubusercontent.com/66400531/134464642-c7e7bffd-0d78-4cdc-ac57-391357a75781.PNG)

## HelloController.java

```
package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data","hello!!");
        return "hello";
    }
}
```

> @GetMapping

HTTP GET 요청을 처리하는 메소드를 맵핑(@RequestMapping) 하는 어노테이션이다. 메서드(url)에 따라 어떤 페이지를 보여줄지 결정하는 역할을 한다.

> Model

JSP에 컨트롤러에서 생성된 데이터를 담아서 전달하는 역할을 하는 존재이다.
addAttribute("키", "값") 메소드를 사용하여 전달할 데이터 세팅한다.

> @model.addAttribute("키", "값")

강제로 전달받은 파라미터를 Model에 담아서 전달하도록 할 때 필요한 어노테이션
