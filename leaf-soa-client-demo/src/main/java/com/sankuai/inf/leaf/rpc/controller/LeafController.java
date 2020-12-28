package com.sankuai.inf.leaf.rpc.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sankuai.inf.leaf.IIdGetter;
import com.sankuai.inf.leaf.common.Result;
import com.sankuai.inf.leaf.exception.LeafServerException;
import com.sankuai.inf.leaf.exception.NoKeyException;
import com.sankuai.inf.leaf.common.Status;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeafController {
    private Logger logger = LoggerFactory.getLogger(LeafController.class);

    @Reference
    IIdGetter idGetter;

    @RequestMapping(value = "/api/segment/get/{key}")
    public String getSegmentId(@PathVariable("key") String key) {
        return get(key, idGetter.getSegmentId(key));
    }

    @RequestMapping(value = "/api/snowflake/get/{key}")
    public String getSnowflakeId(@PathVariable("key") String key) {
        return get(key, idGetter.getSnowflakeId(key));
    }

    private String get(@PathVariable("key") String key, Result id) {
        Result result;
        if (key == null || key.isEmpty()) {
            throw new NoKeyException();
        }
        result = id;
        if (result.getStatus().equals(Status.EXCEPTION)) {
            throw new LeafServerException(result.toString());
        }
        return String.valueOf(result.getId());
    }
}
