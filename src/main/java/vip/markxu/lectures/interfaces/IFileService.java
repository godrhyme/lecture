package vip.markxu.lectures.interfaces;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IFileService {
    public List<String> upload(MultipartFile[] files) ;
}
