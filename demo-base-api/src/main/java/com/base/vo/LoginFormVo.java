package com.base.vo;

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
public class LoginFormVo {
    @NotBlank(message = "用户名不能为空")
    private String usercode;
    @NotBlank
    @Length(min = 6, message = "密码长度最少是6位数")
    private String password;
}
