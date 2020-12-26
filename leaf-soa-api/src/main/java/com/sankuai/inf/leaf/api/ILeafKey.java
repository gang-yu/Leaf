package com.sankuai.inf.leaf.api;

public interface ILeafKey {

    public String getSegmentId(String key);

    public String getSnowflakeId(String key);
}