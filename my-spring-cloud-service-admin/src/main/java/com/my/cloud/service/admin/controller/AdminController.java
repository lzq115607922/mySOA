package com.my.cloud.service.admin.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务类：获取端口
 * @ClassName: AdminController
 * @Description: TODO
 * @author liuzhq
 * @date 2021年4月21日
 */
@RestController
public class AdminController {
    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "hi", method = RequestMethod.GET)
    public String sayHi(@RequestParam(value = "message") String message) {
        // %s 是占位符
        return String.format("Hi, your message is : %s port : %s", message, port);
    }
}
