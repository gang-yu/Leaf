package com.sankuai.inf.leaf.api;

public interface ILeafKeyGen {

    public String getSegmentId(String key);

    public String getSnowflakeId(String key);
}