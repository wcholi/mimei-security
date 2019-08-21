package com.mimei.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.mimei.domain.User;
import com.mimei.view.UserDetailView;
import com.mimei.view.UserSimpleView;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wuchongliang
 * @create 2019-08-13 15:38:27
 * @description:
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @GetMapping
    @JsonView(UserSimpleView.class)
    public List<User> query(@PageableDefault(page = 2, size = 17, sort = "username,asc")Pageable pageable) {
        List<User> list = new ArrayList<>();
        list.add(new User());
        list.add(new User());
        list.add(new User());
        return list;
    }

    @GetMapping(value = "/{id:\\d+}")
    @JsonView(UserDetailView.class)
    public User getInfo(@PathVariable Long id) {
        User user = new User();
        user.setUsername("tom");
        return user;
    }

    @PostMapping
    public User createUser(@Valid @RequestBody User user, BindingResult result) {

        if (result.hasErrors()) {
            result.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
        }
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());
        user.setId(1L);
        return user;
    }

    @PutMapping
    public User updateUser(@Valid @RequestBody User user, BindingResult result) {

        if (result.hasErrors()) {
            result.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
        }
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());
        user.setId(1L);
        return user;
    }
}
