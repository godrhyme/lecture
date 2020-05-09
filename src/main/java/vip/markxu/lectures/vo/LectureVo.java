package vip.markxu.lectures.vo;

import lombok.Data;
import lombok.NonNull;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Date;

@Data
public class LectureVo implements Serializable {
    @NonNull String name;

    @NonNull Date start_time;

    @NonNull Date end_time;

    @NonNull String location;

    String description;

    MultipartFile[] files;

}
