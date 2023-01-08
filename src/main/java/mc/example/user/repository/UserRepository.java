/**
 * MiracleCat Project
 * Copyright 2016 https://github.com/miracle134
 */
package mc.example.user.repository;

import mc.example.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * packageName    : mc.example.user.repository
 * fileName       : UserRepository
 * author         : MiracleCat
 * date           : 2023-01-05(005)
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-01-05(005)        MiracleCat       최초 생성
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
