/**
 * MiracleCat Project
 * Copyright 2018 https://github.com/miracle134
 */
package mc.example.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * packageName    : mc.example.util
 * fileName       : ExceptionResponse
 * author         : MiracleCat
 * date           : 2023-01-01(001)
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-01-01(001)        MiracleCat       최초 생성
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {
    private Date timestamp;
    private String message;
    private String details;
}
