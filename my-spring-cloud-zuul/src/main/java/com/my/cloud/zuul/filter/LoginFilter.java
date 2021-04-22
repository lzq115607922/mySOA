package com.my.cloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Title: 登录过滤器
 * @ClassName:
 * @Description:
 * @date 2021年4月22日
 * @author liuzhq
 * @version V1.0
 */
@Component
public class LoginFilter extends ZuulFilter {
    /**
     * 配置过滤类型：返回一个字符串代表过滤器的类型
     * 在zuul中定义了四种不同生命周期的过滤器类型：
     *      1.pre：路由之前
     *      2.routing：路由之时
     *      3.post：路由之后
     *      4.error：发送错误调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 配置过滤的顺序：数值越小，执行越早
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 配置是否需要过滤：false/不需要，true/需要
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体业务代码
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();

        String token = request.getParameter("token");
        if (token == null) {
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            try {
                // 设置编码
                HttpServletResponse response = currentContext.getResponse();
                response.setContentType("text/html;charset=utf-8");
                // 页面写入内容
                response.getWriter().write("token is empty");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {

        }
        return null;
    }
}
