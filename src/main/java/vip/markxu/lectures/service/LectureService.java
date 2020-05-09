package vip.markxu.lectures.service;

import org.springframework.beans.factory.annotation.Autowired;
import vip.markxu.lectures.entity.LectureEntity;
import vip.markxu.lectures.pojo.LecturePojo;
import vip.markxu.lectures.repository.LectureRepository;
import vip.markxu.lectures.service.Iservice.ILectureService;
import vip.markxu.lectures.vo.LectureVo;


public class LectureService implements ILectureService {

    @Autowired
    private LectureEntity lectureEntity;

    @Autowired
    private LectureRepository lectureRepository;


    @Override
    public LecturePojo getLecture(Long id) {
        return null;
    }

    @Override
    public Object getPageLecture(int page, int size) {
        return null;
    }

    @Override
    public Object post(LectureVo lectureVo) {
        return null;
    }


    @Override
    public Object delete(Long id) {
        return null;
    }

    @Override
    public Object change(Long id, LectureVo lectureVo) {
        return null;
    }

}
