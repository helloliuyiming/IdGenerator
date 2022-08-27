package me.lym.generator.id.snowflake;

public class SnowflakeIdGeneratorBuilder {

    private SnowflakeIdConfig snowflakeIdConfig;

    public SnowflakeIdGeneratorBuilder(){
        snowflakeIdConfig = new SnowflakeIdConfig();
    }

    public SnowflakeIdGeneratorBuilder setNodeId(long nodeId) {
        this.snowflakeIdConfig.setNodeId(nodeId);
        return this;
    }

    public SnowflakeIdGenerator build(){
        return new SnowflakeIdGenerator(snowflakeIdConfig);
    }
}
