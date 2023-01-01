/**
 * MiracleCat Project
 * Copyright 2018 https://github.com/miracle134
 */
package mc.example.helloworld;

import mc.example.util.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

/**
 * packageName    : mc.example.helloworld
 * fileName       : HelloWorldController
 * author         : MiracleCat
 * date           : 2022-12-31(031)
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-12-31(031)        MiracleCat       최초 생성
 */

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    /**
     * Method : GET
     * /hello-world
     * @return String
     */
    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    /**
     * Method : GET
     * /hello-world-bean
     * @return HelloWorldBean
     */
    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
    }

    /**
     * Method : GET
     * /hello-world-bean/path-variable/{name}
     * @param name name
     * @return HelloWorldBeanName
     */
    @GetMapping(path = "/hello-world-bean/path-variable/{name}")
    public HelloWorldBean HelloWorldBeanName(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }

    @GetMapping(path="/hello-world-internationalized")
    public String helloWorldInternationalized(
            @RequestHeader(name="Accept-Language", required = false) Locale locale) {
        return messageSource.getMessage("greeting.message",null,locale);
    }


}

