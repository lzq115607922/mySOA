package com.my.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Title: 配置中心启动类
 * @Description: Http 请求地址和资源文件映射
 *                    1.http://ip:port/{application}/{profile}[/{label}
 *                    2.http://ip:port/{application}-{profile}.yml
 *                    3.http://ip:port/{label}/{application}-{profile}.yml
 *                    4.http://ip:port/{application}-{profile}.properties
 *                    5.http://ip:port/{label}/{application}-{profile}.properties
 * @date 2021年4月22日
 * @author liuzhq
 * @version V1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class, args);
    }
}
