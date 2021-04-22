package com.my.cloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author liuzhq
 * @Title: 网关启动服务
 * @ClassName: ZuulApplication
 * @Description: Http 请求地址和资源文件映射
 *                  1.http://ip:port/{application}/{profile}[/{label}
 *                  2.http://ip:port/{application}-{profile}.yml
 *                  3.http://ip:port/{label}/{application}-{profile}.yml
 *                  4.http://ip:port/{application}-{profile}.properties
 *                  5.http://ip:port/{label}/{application}-{profile}.properties
 * @date 2020年4月22日
 * @version V1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }
}
