/**
 * MiracleCat Project
 * Copyright 2018 https://github.com/miracle134
 */
package mc.example.user.service;

import mc.example.user.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * packageName    : mc.example.user.service
 * fileName       : UserService
 * author         : MiracleCat
 * date           : 2022-12-31(031)
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-12-31(031)        MiracleCat       최초 생성
 */
public interface UserService {

    /**
     * 유저 리스트
     * @return List<User>
     */
    List<User> findAll();

    /**
     * 유저 저장
     * @param user 유저
     * @return User
     * @throws Exception
     */
    User save(User user);

    /**
     * 유저 검색
     * @param id 유저 아이디
     * @return User
     * @throws Exception
     */
    User findOne(int id);

    /**
     * 유저 삭제
     * @param id 유저 아이디
     * @return User
     */
    User deleteById(int id);

    /**
     * 유저 삭제
     * @param user 유저
     * @return User
     */
    User patchUser(User user);
}
