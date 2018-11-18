package com.dubbo.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.api.service.SafeCheckService;

import java.util.concurrent.ThreadLocalRandom;

@Service(
        version = "${dubbo.application.version}",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocal.id}",
        registry = "${dubbo.registry.id}"
)
public class SafeCheckServiceImpl implements SafeCheckService {

    @Override
    public boolean isSafe(String userName) {
        int isSafe = ThreadLocalRandom.current().nextInt(1);
        return isSafe == 0 ? true : false;
    }
}
