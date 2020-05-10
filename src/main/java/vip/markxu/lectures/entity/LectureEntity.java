package vip.markxu.lectures.entity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import vip.markxu.lectures.status.LectureStatusEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@Entity
@Table(name = "lecture")
@EntityListeners(AuditingEntityListener.class)
public class LectureEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    Date start_time;

    Date end_time;

    String location;

    String description;

    LectureStatusEnum status;

    @JoinColumn(name = "lecture_id")
    @OneToMany(cascade = CascadeType.ALL)
    List<ImageEntity> imageEntity=new ArrayList<>();

}
