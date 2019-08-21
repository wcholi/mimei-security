package com.mimei.domain;

import com.fasterxml.jackson.annotation.JsonView;
import com.mimei.validator.MyConstraint;
import com.mimei.view.UserDetailView;
import com.mimei.view.UserSimpleView;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @author wuchongliang
 * @create 2019-08-13 15:53:28
 * @description:
 */
@Data
public class User {

    private Long id;

    @JsonView(UserSimpleView.class)
    @MyConstraint(message = "这是一个测试")
    private String username;

    @JsonView(UserDetailView.class)
    @NotBlank(message = "密码不能为空")
    private String password;

    @Past(message = "生日必须是过去的时间")
    private Date birthday;
}
