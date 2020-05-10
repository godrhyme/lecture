package vip.markxu.lectures.status;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum LectureStatusEnum {
    @JsonValue
    Wait("Wait"),

    @JsonValue
    Processing("Processing"),

    @JsonValue
    Stop("Stop");


    private String status;

    @JsonCreator
    LectureStatusEnum(String status) {
        this.status = status;
    }
}
