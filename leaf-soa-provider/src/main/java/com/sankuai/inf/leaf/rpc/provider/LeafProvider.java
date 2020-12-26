package com.sankuai.inf.leaf.rpc.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.sankuai.inf.leaf.api.ILeafKey;
import com.sankuai.inf.leaf.rpc.service.SegmentService;
import com.sankuai.inf.leaf.rpc.service.SnowflakeService;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class LeafProvider implements ILeafKey {
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
