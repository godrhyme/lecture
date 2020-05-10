package vip.markxu.lectures.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vip.markxu.lectures.entity.ImageEntity;
import vip.markxu.lectures.entity.LectureEntity;
import vip.markxu.lectures.interfaces.IFileService;
import vip.markxu.lectures.pojo.LecturePojo;
import vip.markxu.lectures.pojo.PagePojos;
import vip.markxu.lectures.repository.LectureRepository;
import vip.markxu.lectures.interfaces.ILectureService;
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
    private FileService fileService;


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

        List<String> images=fileService.upload(lectureVo.getFiles());
        images.forEach(item->{{
            ImageEntity imageEntity=new ImageEntity();
            imageEntity.setImage_url(item);
            lectureEntity.getImageEntity().add(imageEntity);
        }});

        lectureRepository.save(lectureEntity);

        return ResponseBody.Success(new LecturePojo(lectureEntity));
    }


    @Transactional
    @Override
    public Object delete(Long id) {
        lectureRepository.deleteById(id);
        return ResponseBody.Success();
    }

    @Override
    @Transactional
    public Object change(Long id,LectureVo lectureVo) {
        LectureEntity lectureEntity=lectureRepository.findById(id).get();
        lectureEntity.setName(lectureVo.getName());
        lectureEntity.setStart_time(lectureVo.getStart_time());
        lectureEntity.setEnd_time(lectureVo.getEnd_time());
        lectureEntity.setLocation(lectureVo.getLocation());
        lectureEntity.setDescription(lectureVo.getDescription());

        lectureRepository.save(lectureEntity);
        return ResponseBody.Success(new LecturePojo(lectureEntity));
    }

}
