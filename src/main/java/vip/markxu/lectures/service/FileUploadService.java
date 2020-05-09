package vip.markxu.lectures.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import vip.markxu.lectures.entity.ImageEntity;
import vip.markxu.lectures.service.Iservice.IFileUploadService;


import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class FileUploadService implements IFileUploadService {
    @Autowired
    private RestTemplate restTemplate;


    @Override
    public List<ImageEntity> uploadImage(MultipartFile[] files) {
        List<ImageEntity> imageEntities= null;
        if(files!=null){
            try {
                MultiValueMap<String, Object> multiValueMap=new LinkedMultiValueMap<>();
                for(MultipartFile file:files){
                    multiValueMap.add("files",file.getResource());
                }
                String[] str=restTemplate.postForObject("http://localhost:9010/file/upload",multiValueMap,String[].class);
                imageEntities = new ArrayList<>();
                for(String s:str){
                    ImageEntity imageEntity=new ImageEntity();
                    imageEntity.setImage_url(s);
                    imageEntities.add(imageEntity);
                }
            } catch (RestClientException e) {

            }
        }


        return imageEntities;
    }

    @Override
    public ImageEntity uploadImage(MultipartFile file) {
        ImageEntity imageEntity=null;

        if(file.getSize() !=0){
            try {
                MultiValueMap<String, Object> multiValueMap=new LinkedMultiValueMap<>();

                multiValueMap.add("files",file.getResource());

                String[] str=restTemplate.postForObject("http://localhost:9010/file/upload",multiValueMap,String[].class);
                imageEntity = new ImageEntity();
                imageEntity.setImage_url(str[0]);
            } catch (RestClientException e) {

            }
        }

        return imageEntity;
    }
}
