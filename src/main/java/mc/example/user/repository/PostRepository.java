/**
 * MiracleCat Project
 * Copyright 2016 https://github.com/miracle134
 */
package mc.example.user.repository;

import mc.example.user.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * packageName    : mc.example.user.repository
 * fileName       : PostRepository
 * author         : MiracleCat
 * date           : 2023-01-08(008)
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-01-08(008)        MiracleCat       최초 생성
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
}
