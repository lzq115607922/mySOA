package com.my.cloud.web.admin.feign.config;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuzhq
 * @Description: 熔断器仪表盘配置类，配置一个Servlet
 * @date 2021年4月22日
 * @version V1.0
 */
@Configuration
public class HystrixDashboardConfiguration {
    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);    // 启动顺序
        registrationBean.addUrlMappings("/hystrix.stream");    // Servlet访问路径
        registrationBean.setName("HystrixMetricsStreamServlet");     // Servlet的name
        System.out.println(streamServlet);
        return registrationBean;
    }
}
