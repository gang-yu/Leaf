package com.sankuai.inf.leaf;

import com.sankuai.inf.leaf.common.Result;

public interface IIdGetter {

    public Result getSegmentId(String key);

    public Result getSnowflakeId(String key);
}