package vip.markxu.lectures.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vip.markxu.lectures.entity.ImageEntity;
import vip.markxu.lectures.entity.LectureEntity;
import vip.markxu.lectures.pojo.LecturePojo;
import vip.markxu.lectures.pojo.PagePojos;
import vip.markxu.lectures.repository.LectureRepository;
import vip.markxu.lectures.service.Iservice.ILectureService;
import vip.markxu.lectures.status.ResponseBody;
import vip.markxu.lectures.vo.LectureVo;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
public class LectureService implements ILectureService {

    @Autowired
    private LectureRepository lectureRepository;

    @Autowired
    private FileUploadService fileUploadService;


    @Override
    public LecturePojo getLecture(Long id) {
        return null;
    }

    @Override
    public Object getPageLecture(int page, int size) {
        Pageable pageable= PageRequest.of(page-1,size, Sort.Direction.DESC,"id");
        Page<LectureEntity> lectureEntityPage=lectureRepository.findAll(pageable);
        List<LecturePojo> list=new ArrayList<>();
        lectureEntityPage.getContent().forEach(item->{{list.add(new LecturePojo(item));}});
        return ResponseBody.Success(new PagePojos<>(lectureEntityPage,list));
    }

    @Override
    public Object post(LectureVo lectureVo) {
        LectureEntity lectureEntity = new LectureEntity();
        lectureEntity.setName(lectureVo.getName());
        lectureEntity.setStart_time(lectureVo.getStart_time());
        lectureEntity.setEnd_time(lectureVo.getEnd_time());
        lectureEntity.setDescription(lectureVo.getDescription());
        lectureEntity.setLocation(lectureVo.getLocation());

        List<ImageEntity> images=fileUploadService.uploadImage(lectureVo.getFiles());
        lectureEntity.setImageEntity(images);
        lectureRepository.save(lectureEntity);

        return ResponseBody.Success(new LecturePojo(lectureEntity));
    }


    @Transactional
    @Override
    public Object delete(Long id) {
        @NonNull LectureEntity lectureEntity = lectureRepository.findLectureEntitiesById(id);
        lectureRepository.delete(lectureEntity);
        return ResponseBody.Success();
    }

    @Override
    public Object change(Long id, LectureVo lectureVo) {
        return null;
    }

}
