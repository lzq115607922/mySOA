package com.my.cloud.web.admin.feign.service.hystrix;

import com.my.cloud.web.admin.feign.service.AdminService;
import org.springframework.stereotype.Component;

/**
 * @author liuzhq
 * @Title:
 * @ClassName: AdminServiceHystrix
 * @Description:
 * @date
 * @version V1.0
 */
@Component
public class AdminServiceHystrix implements AdminService {

    @Override
    public String sayHi(String message) {
        return String.format("Hi,your message is : %s ,but request bad", message);
    }
}
