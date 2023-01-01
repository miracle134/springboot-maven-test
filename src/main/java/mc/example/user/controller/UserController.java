/**
 * MiracleCat Project
 * Copyright 2018 https://github.com/miracle134
 */
package mc.example.user.controller;

import mc.example.user.entity.User;
import mc.example.user.service.UserService;
import mc.example.exception.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.net.URI;
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
public class UserController {

    @Resource(name="userService")
    private UserService userService;

    /**
     * 유저 전체 정보
     * @return List<User>
     */
    @GetMapping(path="/users")
    public List<User> retrieveAllUsers() {
        return userService.findAll();
    }

    /**
     * 유저 개인 정보
     * @param id 유저 아이디
     * @return User
     */
    @GetMapping(path="/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        User user = userService.findOne(id);

        if (user == null){
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }

        return user;
    }

    /**
     * 유저 등록
     * @param user 유저
     * @return User
     */
    @PutMapping(path="/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = userService.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    /**
     * 유저 삭제
     * @return id 유저 아이디
     */
    @DeleteMapping(path="/users/{id}")
    public void deleteUser(@PathVariable int id) {
        User user = userService.deleteById(id);

        if(user == null){
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }
    }

    /**
     * 유저 수정
     * @param user 유저
     * @return
     */
    @PatchMapping(path="/users")
    public User patchUser(@RequestBody User user){
        User u = userService.patchUser(user);

        if(u == null){
            throw new UserNotFoundException(String.format("USER[%s] not found", user));
        }

        return u;
    }

}
