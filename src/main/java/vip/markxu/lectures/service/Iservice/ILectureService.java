package vip.markxu.lectures.service.Iservice;


import vip.markxu.lectures.entity.LectureEntity;
import vip.markxu.lectures.pojo.LecturePojo;
import vip.markxu.lectures.vo.LectureVo;

public interface ILectureService {

    //展示
    LecturePojo getLecture(Long id);

    //分页展示
    Object getPageLecture(int page, int size);

    //发布讲座信息
    Object post(LectureVo lectureVo);

    //删除讲座信息
    Object delete(Long id);

    //修改讲座信息
    Object change(Long id, LectureVo lectureVo);

}
