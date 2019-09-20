package com.trilogyed.tasker.util.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name = "ad-service")
public interface AdClient {
    @RequestMapping(value = "/ad", method = RequestMethod.GET)
    String getAd();
}
