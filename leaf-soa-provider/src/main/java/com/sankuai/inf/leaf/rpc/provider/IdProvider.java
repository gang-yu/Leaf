package com.sankuai.inf.leaf.rpc.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.sankuai.inf.leaf.IIdGetter;
import com.sankuai.inf.leaf.common.Result;
import com.sankuai.inf.leaf.rpc.service.SegmentService;
import com.sankuai.inf.leaf.rpc.service.SnowflakeService;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class IdProvider implements IIdGetter {
    @Autowired
    private SegmentService segmentService;
    @Autowired
    private SnowflakeService snowflakeService;


    @Override
    public Result getSegmentId(String key) {
        return segmentService.getId(key);
    }

    @Override
    public Result getSnowflakeId(String key) {
        return snowflakeService.getId(key);
    }
}
