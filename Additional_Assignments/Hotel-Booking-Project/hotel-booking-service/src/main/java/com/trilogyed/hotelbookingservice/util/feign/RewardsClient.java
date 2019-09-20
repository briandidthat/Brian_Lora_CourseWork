package com.trilogyed.hotelbookingservice.util.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="rewards-service")
public interface RewardsClient {
    
}
