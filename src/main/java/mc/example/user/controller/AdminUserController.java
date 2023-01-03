/**
 * MiracleCat Project
 * Copyright 2018 https://github.com/miracle134
 */
package mc.example.user.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import mc.example.exception.UserNotFoundException;
import mc.example.user.entity.User;
import mc.example.user.entity.UserV2;
import mc.example.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * packageName    : mc.example.user.controller
 * fileName       : UserController
 * author         : MiracleCat
 * date           : 2022-12-31(031)
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-12-31(031)        MiracleCat       최초 생성
 */
@RestController
@RequestMapping("/admin")
public class AdminUserController {

    @Resource(name = "userService")
    private UserService userService;

    /**
     * 유저 전체 정보
     *
     * @return List<User>
     */
    @GetMapping("/users")
    public MappingJacksonValue retrieveAllUsers() {
        List<User> all = userService.findAll();

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("id", "name", "joinDate");

        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(all);
        mapping.setFilters(filters);

        return mapping;
    }

    /**
     * 유저 개인 정보
     *
     * @param id 유저 아이디
     * @return User
     */
//    @GetMapping("/v1/user/{id}")
//    @GetMapping(value = "/user/{id}/", params = "version=1")
//    @GetMapping(value = "/user/{id}", headers = "X-API-VERSION=1")
    @GetMapping(value = "/user/{id}", produces = "application/mc.example.v1+json")
    public MappingJacksonValue retrieveUserV1(@PathVariable int id) {
        User user = userService.findOne(id);

        if (user == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("id", "name", "joinDate", "ssn");

        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(user);
        mapping.setFilters(filters);

        return mapping;
    }

    /**
     * 유저 개인 정보
     *
     * @param id 유저 아이디
     * @return User
     */
//    @GetMapping("/v2/user/{id}")
//    @GetMapping(value = "/user/{id}/", params = "version=2")
//    @GetMapping(value = "/user/{id}", headers = "X-API-VERSION=2")
    @GetMapping(value = "/user/{id}", produces = "application/mc.example.v2+json")
    public MappingJacksonValue retrieveUserV2(@PathVariable int id) {
        User user = userService.findOne(id);

        if (user == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }

        UserV2 userV2 = new UserV2();
        BeanUtils.copyProperties(user, userV2);
        userV2.setGrade("VIP");

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("id", "name", "joinDate", "grade");

        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfoV2", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(userV2);
        mapping.setFilters(filters);

        return mapping;
    }

}
