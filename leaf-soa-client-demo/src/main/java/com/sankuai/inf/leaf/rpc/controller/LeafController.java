package com.sankuai.inf.leaf.rpc.controller;

import com.sankuai.inf.leaf.api.ILeafKeyGen;
import com.sankuai.inf.leaf.api.common.Result;
import com.sankuai.inf.leaf.api.exception.LeafServerException;
import com.sankuai.inf.leaf.api.exception.NoKeyException;
import com.sankuai.inf.leaf.api.common.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeafController {
    private Logger logger = LoggerFactory.getLogger(LeafController.class);

    @Autowired
    ILeafKeyGen leafKey;

    @RequestMapping(value = "/api/segment/get/{key}")
    public String getSegmentId(@PathVariable("key") String key) {
        return get(key, leafKey.getSegmentId(key));
    }

    @RequestMapping(value = "/api/snowflake/get/{key}")
    public String getSnowflakeId(@PathVariable("key") String key) {
        return get(key, leafKey.getSnowflakeId(key));
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
