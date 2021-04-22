package com.my.cloud.zuul.fallback;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @Title: 路由 my-spring-cloud-web-admin-ribbon 失败时的回调
 * @ClassName: WebAdminRibbonFallbackProvider
 * @Description:
 * @date 2021年4月22日
 * @author liuzhq
 * @version V1.0
 */
public class WebAdminRibbonFallbackProvider implements FallbackProvider {
    @Override
    public String getRoute() {
        // ServiceId, 如果需要所有调用都支持回退，则 return "*" 或 return null
        return "my-spring-cloud-web-admin-ribbon";
    }

    /**
     * 如果请求服务失败，则返回指定的信息给调用者
     * @param route
     * @param cause
     * @return
     */
    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            /**
             * 网关向 api 服务请求失败了，但是消费者客户端向网关发送的请求是成功的，
             * 不应该把 api 的 404，500 等问题抛给客户端，
             * 网关和 api 服务集群对于客户端来说是黑盒
             * @return
             * @throws IOException
             */
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.OK.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.OK.getReasonPhrase();
            }

            @Override
            public void close() {

            }

            /**
             * 响应内容
             * @return
             * @throws IOException
             */
            @Override
            public InputStream getBody() throws IOException {
                ObjectMapper objectMapper = new ObjectMapper();
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("status", 200);
                map.put("message", "无法连接，请检查您的网络");
                return new ByteArrayInputStream(objectMapper.writeValueAsString(map).getBytes(StandardCharsets.UTF_8));
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders httpHeaders = new HttpHeaders();
                //
                httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
                return null;
            }
        };
    }
}
