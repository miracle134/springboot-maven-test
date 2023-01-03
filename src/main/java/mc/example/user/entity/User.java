/**
 * MiracleCat Project
 * Copyright 2018 https://github.com/miracle134
 */
package mc.example.user.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * packageName    : mc.example.user.entity
 * fileName       : User
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
//@JsonIgnoreProperties(value={"password", "ssn"})
@JsonFilter("UserInfo")
public class User {
    private Integer id;
    @Size(min = 2, message = "Name은 2글자 이상 작성해주세요.")
    private String name;
    @Past
    private Date joinDate;

    private String password;
    private String ssn;
}
