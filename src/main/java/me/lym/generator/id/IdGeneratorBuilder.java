package me.lym.generator.id;

import me.lym.generator.id.random.RandomIdGeneratorBuilder;
import me.lym.generator.id.segment.SegmentIdGeneratorBuilder;
import me.lym.generator.id.snowflake.SnowflakeIdGeneratorBuilder;
import me.lym.generator.id.uuid.UUIDIdGenerator;
import me.lym.generator.id.uuid.UUIDIdGeneratorBuilder;

public class IdGeneratorBuilder {

    public static UUIDIdGenerator defaultBuildUUIDIdGenerator(){
        return new UUIDIdGeneratorBuilder().build();
    }

    public static UUIDIdGeneratorBuilder buildUUIDIdGenerator(){
        return new UUIDIdGeneratorBuilder();
    }

    public static SnowflakeIdGeneratorBuilder buildSnowflakeIdGenerator(){
        return new SnowflakeIdGeneratorBuilder();
    }

    public static SegmentIdGeneratorBuilder buildSegmentIdGenerator(){
        return new SegmentIdGeneratorBuilder();
    }

    public static RandomIdGeneratorBuilder buildRandomIdGenerator(){
        return new RandomIdGeneratorBuilder();
    }
}
