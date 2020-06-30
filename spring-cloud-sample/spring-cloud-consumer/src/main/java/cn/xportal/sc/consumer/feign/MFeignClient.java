package cn.xportal.sc.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cn.xportal.sc.consumer.feign.config.MFeignConfig;

import java.util.List;

@FeignClient(name = "provider",path="sc-provider",fallback = MFeignClientFallback.class, configuration = MFeignConfig.class)
public interface MFeignClient {
    // 这是被请求微服务的地址，也就是provider的地址
    @GetMapping(value = "/test/{msg}")
    String sayHelloWorld(@PathVariable("msg") String msg);

    @GetMapping(value = "/test/list")
    List<Integer> list();

    @GetMapping(value = "/test/list")
    Integer[] array();
}
