package com.sankuai.inf.leaf.rpc.client;

import com.alibaba.dubbo.config.annotation.Service;
import com.sankuai.inf.leaf.api.ILeafKeyGen;
import com.sankuai.inf.leaf.rpc.service.SegmentService;
import com.sankuai.inf.leaf.rpc.service.SnowflakeService;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class LeafProvider implements ILeafKeyGen {
    @Autowired
    private SegmentService segmentService;
    @Autowired
    private SnowflakeService snowflakeService;


    @Override
    public String getSegmentId(String key) {
        return null;
    }

    @Override
    public String getSnowflakeId(String key) {
        return null;
    }
}
