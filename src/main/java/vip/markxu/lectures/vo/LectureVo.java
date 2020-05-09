package vip.markxu.lectures.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NonNull;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Date;


@Data
public class LectureVo implements Serializable {
    @NonNull String name;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @NonNull
    Date start_time;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @NonNull
    Date end_time;

    @NonNull String location;

    String description;

    MultipartFile[] files;

}
