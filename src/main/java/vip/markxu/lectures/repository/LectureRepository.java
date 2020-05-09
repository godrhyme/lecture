package vip.markxu.lectures.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vip.markxu.lectures.entity.LectureEntity;


public interface LectureRepository extends JpaRepository<LectureEntity,Long> {

    @Query(value = "select l from LectureEntity l where l.id=?1")
    LectureEntity findLectureEntitiesById(Long id);

}
