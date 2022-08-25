package me.lym.generator.id;

import me.lym.generator.id.random.RandomIdGeneratorBuilder;
import me.lym.generator.id.segment.SegmentIdGeneratorBuilder;
import me.lym.generator.id.snowflake.SnowflakeIdGeneratorBuilder;
import me.lym.generator.id.uuid.UUIDIdGenerator;
import me.lym.generator.id.uuid.UUIDIdGeneratorBuilder;

public class IdGeneratorBuilder {

    public static UUIDIdGenerator buildDefaultUUIDIdGenerator(){
        return new UUIDIdGeneratorBuilder().build();
    }

    public static UUIDIdGeneratorBuilder enterBuildUUIDIdGenerator(){
        return new UUIDIdGeneratorBuilder();
    }

    public static SnowflakeIdGeneratorBuilder enterBuildSnowflakeIdGenerator(){
        return new SnowflakeIdGeneratorBuilder();
    }

    public static SegmentIdGeneratorBuilder enterBuildSegmentIdGenerator(){
        return new SegmentIdGeneratorBuilder();
    }

    public static RandomIdGeneratorBuilder enterBuildRandomIdGenerator(){
        return new RandomIdGeneratorBuilder();
    }
}
