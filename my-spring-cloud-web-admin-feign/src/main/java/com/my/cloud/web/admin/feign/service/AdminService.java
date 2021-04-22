package com.my.cloud.web.admin.feign.service;

import com.my.cloud.web.admin.feign.service.hystrix.AdminServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Feign接口
 * @ClassName: AdminService
 * @Description: TODO
 * @author liuzhq
 * @date 2021年4月21日
 */
@FeignClient(value = "my-spring-cloud-service-admin", fallback = AdminServiceHystrix.class)
public interface AdminService {
    /**
     * 访问服务提供者的方法
     * @param message
     * @return
     */
    @RequestMapping(value = "hi", method = RequestMethod.GET)
    public String sayHi(@RequestParam(value = "message") String message);
}
