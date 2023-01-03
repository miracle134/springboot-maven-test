/**
 * MiracleCat Project
 * Copyright 2018 https://github.com/miracle134
 */
package mc.example.user.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * packageName    : mc.example.user.entity
 * fileName       : UserV2
 * author         : MiracleCat
 * date           : 2022-12-31(031)
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-12-31(031)        MiracleCat       최초 생성
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter("UserInfoV2")
public class UserV2 extends User {
    private String grade;
}
