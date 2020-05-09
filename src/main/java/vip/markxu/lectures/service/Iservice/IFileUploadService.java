package vip.markxu.lectures.service.Iservice;

import org.springframework.web.multipart.MultipartFile;
import vip.markxu.lectures.entity.ImageEntity;

import java.util.List;

public interface IFileUploadService {
    List<ImageEntity> uploadImage(MultipartFile[] files);
    ImageEntity uploadImage(MultipartFile file);
}
