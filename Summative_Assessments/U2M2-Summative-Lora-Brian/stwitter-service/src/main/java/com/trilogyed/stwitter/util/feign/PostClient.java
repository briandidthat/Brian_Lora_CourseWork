package com.trilogyed.stwitter.util.feign;

import org.springframework.cloud.openfeign.FeignClient;

/*Task:
 *
 */
@FeignClient(name = "post-service")
public interface PostClient  {

}
