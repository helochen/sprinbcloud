package com.example.eurekazuulclient;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * class MyFallBackProvider
 * function:
 *
 * @Author chens
 * @Date 2018/8/12 15:50
 */
@Component
public class MyFallBackProvider implements FallbackProvider {


    /**
     * The route this fallback will be used for.
     *
     * @return The route the fallback will be used for.
     */
    @Override
    public String getRoute() {
        return "eureka-client";
    }

    /**
     * Provides a fallback response based on the cause of the failed execution.
     *
     * @param route The route the fallback is for
     * @param cause cause of the main method failure, may be <code>null</code>
     * @return the fallback response
     */
    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return 200;
            }

            @Override
            public String getStatusText() throws IOException {
                return "OK";
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("ooops! some error happened!".getBytes("UTF-8"));
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
                return httpHeaders;
            }
        };
    }
}
