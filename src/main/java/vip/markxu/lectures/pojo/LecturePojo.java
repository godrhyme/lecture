package vip.markxu.lectures.pojo;

import lombok.Data;
import vip.markxu.lectures.entity.LectureEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class LecturePojo {
    Long id;

    String name;

    Date start_time;

    Date end_time;

    String location;

    String description;

    List<String> images=new ArrayList<>();

    public LecturePojo(LectureEntity lectureEntity){
        this.id = lectureEntity.getId();
        this.setName(lectureEntity.getName());
        this.setStart_time(lectureEntity.getStart_time());
        this.setEnd_time(lectureEntity.getEnd_time());
        this.setDescription(lectureEntity.getDescription());
        this.setLocation(lectureEntity.getLocation());
        lectureEntity.getImageEntity().forEach(item->{{this.images.add(item.getImage_url());}});
    }
}
