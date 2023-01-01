/**
 * MiracleCat Project
 * Copyright 2018 https://github.com/miracle134
 */
package mc.example.user.service.impl;

import mc.example.user.entity.User;
import mc.example.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * packageName    : mc.example.user.service.impl
 * fileName       : UserServiceImpl
 * author         : MiracleCat
 * date           : 2022-12-31(031)
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-12-31(031)        MiracleCat       최초 생성
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    private static List<User> users = new ArrayList<>();

    private static int usersCount = 3;

    static {
        users.add(new User(1, "JIHO", new Date(), "pass1", "101010-1111111"));
        users.add(new User(2, "IU", new Date(), "pass2", "201010-1111111"));
        users.add(new User(3, "WINTER", new Date(), "pass3", "201010-1111111"));
    }

    @Override
    public List<User> findAll(){
        return users;
    }

    @Override
    public User save(User user){
        if (user.getId() == null) {
            user.setId(++usersCount);
        }

        users.add(user);
        return user;
    }

    @Override
    public User findOne(int id){
        for (User user : users){
            if(user.getId() == id){
                return user;
            }
        }

        return null;
    }

    @Override
    public User deleteById(int id) {
        Iterator<User> iterator = users.iterator();

        while (iterator.hasNext()){
            User user = iterator.next();

            if(user.getId() == id){
                iterator.remove();
                return user;
            }
        }

        return null;
    }

    @Override
    public User patchUser(User user) {
        User u = null;

        for(User use : users){
            if(use.getId() == user.getId()) {
                use.setName(user.getName());
                use.setJoinDate(user.getJoinDate());
                u = use;
                break;
            }
        }

        return u;
    }

}
