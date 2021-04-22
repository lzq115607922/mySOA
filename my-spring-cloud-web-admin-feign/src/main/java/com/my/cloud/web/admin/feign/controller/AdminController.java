package com.my.cloud.web.admin.feign.controller;

import com.my.cloud.web.admin.feign.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: AdminController
 * @Description: TODO
 * @author liuzhq
 * @date 2021年4月21日
 */
@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "hi", method = RequestMethod.GET)
    public String sayHi(String message) {
        return adminService.sayHi(message);
    }
}
