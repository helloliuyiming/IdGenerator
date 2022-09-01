# IDGenerator

> IDGenerator是一个统一的id生成器，整合了UUID、Random、分段、雪花及类雪花id生成算法，旨在以一种统一的操作方式根据业务需求生成不同的id。

## 使用指南

IDGenerator使用建造者设计模式来配置各种IDGenerator的配置信息，如UUIDIdGeneratorBuilder、RandomIdGeneratorBuilder等；使用xxxBuilder会生成相应的xxxGenerator，如UUIDIdGenerator、RandomIdGenerator，这些才是真正生成id的对象。

### 随机ID

> 随机ID算法生成的是一种无序、随机不保证绝对唯一的ID

```java 
    RandomIdGenerator randomIdGenerator = new RandomIdGeneratorBuilder()
                .addCharacterElement(new NumericRandomSeedElement(10))
                .addCharacterElement(new LowerCaseRandomSeedElement(26))
                .addCharacterElement(new FinalCharacterAsteriskRandomSeedElement(1))
                .addCharacterElement(new FinalCharacterAmpersandRandomSeedElement(1))
                .setMinLength(10)
                .setMaxLength(12)
                .build();
    randomIdGenerator.next()
```

### 分段

> 分段算法由不同的块组成，每个块有不同的生成策略，自由度很高

```java 
    SequenceSegment sequenceSegment = new SequenceSegmentBuilder()
                .addSeqElement(new NumericSeqElement("numericSeqElement", 2, 4, '0'))
                .addSeqElement(new LowerCaseSeqElement("lowerCaseSeqElement", 4, 4, '#'))
                .enterConfigOriginValue()
                .addValue("numericSeqElement", "1")
                .addValue("lowerCaseSeqElement", "")
                .originValueConfigCompleted()
                .build();

    SegmentIdGenerator segmentIdGenerator = new SegmentIdGeneratorBuilder()
            .addSegment(new YearSegment())
            .addSegment(new MonthSegment())
            .addSegment(new DayOfMonthSegment())
            .addSegment(sequenceSegment)
            .build();
            
    segmentIdGenerator.next()
```

### Snowflake

> 使用twitter的雪花算法来实现

```java 
    SnowflakeIdGenerator snowflakeIdGenerator = new SnowflakeIdGeneratorBuilder()
            .build();
    snowflakeIdGenerator.next()
```

### UUID

> 使用UUID来生成ID

```java 
    UUIDIdGenerator uuidIdGenerator = new UUIDIdGeneratorBuilder()
            .setFastModeEnable(true)
            .build();
    uuidIdGenerator.next()
```
## 参考

### 项目

+ [callicoder/java-snowflake](https://github.com/callicoder/java-snowflake)

### 文章

+ [速看!今天我才知道,UUID还分五个版本 - 掘金](https://juejin.cn/post/6864199183957262350)
+ [全网最全！彻底弄透Java处理GMT/UTC日期时间 - 腾讯云](https://cloud.tencent.com/developer/article/1777707)
+ [基于权重的随机选择算法 - 知乎专栏](https://zhuanlan.zhihu.com/p/146216606)
+ [Generating unique IDs in a distributed environment at high scale.](https://www.callicoder.com/distributed-unique-id-sequence-number-generator)