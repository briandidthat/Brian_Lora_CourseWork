package com.trilogyed.hotelbookingservice.util.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="room-service")
public interface RoomClient {

}
