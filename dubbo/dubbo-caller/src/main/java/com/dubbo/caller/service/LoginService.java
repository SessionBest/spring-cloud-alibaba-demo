package com.dubbo.caller.service;


import com.alibaba.dubbo.config.annotation.Reference;
import com.dubbo.api.service.SafeCheckService;
import org.springframework.stereotype.Service;

@Service
public class LoginService {


    @Reference(version = "${dubbo.application.version}", timeout = 5000)
    private SafeCheckService safeCheckService;


    public String login(String userName,String password){

        if(!safeCheckService.isSafe(userName)){
            return "you login in a unusual location,please check it";
        }
        return userName;
    }

}
