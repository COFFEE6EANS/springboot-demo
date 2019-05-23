package com.validation.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @Author guojianfeng.
 * @Date Created in  2019/5/13
 * @Description：
 */
@Data
public class UserVo {
    @NotBlank
    private String usernmae;
    @NotNull
    private Date birthday;
    @NotNull
    private Integer age;
    @NotBlank
    private String usercode;
    @NotBlank
    @Length(min = 6, message = "密码长度最少是6位数")
    private String password;
}
