package com.pryabykh.authserver.feign;

import com.pryabykh.authserver.dtos.request.UserCredentialsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "${user-service.name}", url = "${user-service.url}")
public interface UserServiceFeignClient {
    @RequestMapping(method = RequestMethod.POST, value = "/v1/users/check-credentials", consumes = "application/json")
    boolean checkCredentials(@RequestBody UserCredentialsDto userCredentialsDto);

    @RequestMapping(method = RequestMethod.GET, value = "/v1/users/findIdByEmail/{email}")
    long findUserIdByEmail(@PathVariable("email") String email);
}
