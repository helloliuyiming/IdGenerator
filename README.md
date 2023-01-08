# IDGenerator

> IDGenerator是一个支持多种ID生成策略，如UUID、Random、snowflake，并以一种统一的使用方式来实现的，可以让你方便、快速的集成到系统中的工具包。

**支持的策略**
+ UUID
+ 随机ID
+ 分段ID
+ 雪花算法

**策略比较**

// TODO

## 使用指南

IDGenerator使用建造者设计模式来使用和配置各种IDGenerator，一般每种id generator会有三种角色类，builder、config和generator。
builder类是使用id generator的入口类，builder的职责是收集、校验使用generator工作前的配置信息，在命名上一般是`[Type]GeneratorBuilder`，如UUIDIdGeneratorBuilder、RandomIdGeneratorBuilder等。
config类是generator工作过程要用到的配置信息，由builder类创建并传递给generator类，使用者不需要操作config类，在命名上一般是`[Type]Config`，如UUIDConfig、RandomIdConfig。
generator是真正用于生成id的核心类，使用generator的`String next()`方法来生成id，generator类的创建由builder完成，在命名上一般是`[Type]IdGenerator`，如RandomIdGenerator。
除了上面三种角色类之外，可能还会需要一些额外的辅助类来实现id generator，如分段ID有可能会遇到会根据上一个id来计算下一个id的情况，这种时候就需要store类的帮助。

### 随机ID

> 随机ID生成的是一种无序、随机的策略，随机ID不能保证生成id的绝对唯一，具体出现id重复的概率大小取决于参与id生成的元素数量和id的长度

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

### UUID

> UUID是一种无序、随机且长度固定的id生成策略

```java
        UUIDIdGenerator uuidIdGenerator = new UUIDIdGeneratorBuilder()
                .setFastModeEnable(true)
                .build();
        uuidIdGenerator.next();
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

## 参考

### 项目

+ [callicoder/java-snowflake](https://github.com/callicoder/java-snowflake)

### 文章

+ [速看!今天我才知道,UUID还分五个版本 - 掘金](https://juejin.cn/post/6864199183957262350)
+ [全网最全！彻底弄透Java处理GMT/UTC日期时间 - 腾讯云](https://cloud.tencent.com/developer/article/1777707)
+ [基于权重的随机选择算法 - 知乎专栏](https://zhuanlan.zhihu.com/p/146216606)
+ [Generating unique IDs in a distributed environment at high scale.](https://www.callicoder.com/distributed-unique-id-sequence-number-generator)