package me.lym.generator.id.segment;

import me.lym.generator.id.IdGenerator;

import java.util.List;

public class SegmentIdGenerator implements IdGenerator {

    private final SegmentConfig segmentConfig;

    public SegmentIdGenerator(SegmentConfig segmentConfig) {
        this.segmentConfig = segmentConfig;
    }

    @Override
    public String next() {
        List<Segment> segments = segmentConfig.getSegments();
        if (segments == null || segments.isEmpty()) {
            throw new IllegalStateException("length of segment must not be empty");
        }
        StringBuilder stringBuilder = new StringBuilder();
        String separator = segmentConfig.getSeparator();
        segments.forEach(segment -> {
            stringBuilder.append(segment.generate());
            if (separator != null) {
                stringBuilder.append(separator);
            }
        });
        if (separator != null && stringBuilder.length() != 0) {
            stringBuilder.delete(stringBuilder.length() - separator.length(), stringBuilder.length());
        }
        return stringBuilder.toString();
    }
}
