package me.lym.generator.id.snowflake;

import me.lym.generator.id.IdGeneratorConfig;

public class SnowflakeIdConfig extends IdGeneratorConfig {

    private long nodeId = 0L;

    public long getNodeId() {
        return nodeId;
    }

    public void setNodeId(long nodeId) {
        this.nodeId = nodeId;
    }
}
