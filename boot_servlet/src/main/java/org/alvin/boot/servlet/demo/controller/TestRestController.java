package org.alvin.boot.servlet.demo.controller;

import org.alvin.boot.servlet.demo.bean.UserBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tangzhichao on 2017/3/29.
 */
@RestController
public class TestRestController {

    @RequestMapping("/test")
    public String test() {
        return "this is a test";
    }

    @RequestMapping("/test1")
    public UserBean test1() {
        return new UserBean();
    }
}
