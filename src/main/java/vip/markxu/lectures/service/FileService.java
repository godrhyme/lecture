package vip.markxu.lectures.service;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vip.markxu.lectures.interfaces.IFileService;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class FileService implements IFileService {

    @Value("${qiniuKey}")
    private String key;

    @Value("${qiniuSecret}")
    private String secret;

    @Value("${qiniuBucket}")
    private String bucket;

    @Value("${oss_URL}")
    private String ossURL;

    private Configuration cfg = new Configuration();
    private UploadManager uploadManager = new UploadManager(cfg);


    @Override
    public List<String> upload(MultipartFile[] files) {
        List<String> imagesList=new ArrayList<>();

        log.info("上传文件");

        Auth auth = Auth.create(key, secret);
        String upToken = auth.uploadToken(bucket);
        //todo 防盗链的设置
        for (MultipartFile f : files) {
            InputStream inputStream = null;
            try {
                inputStream = f.getInputStream();
            } catch (IOException e) {
                //e.printStackTrace();
                log.error("文件输入流解析异常");
            }
            Response response = null;
            try {
                response = uploadManager.put(inputStream, null, upToken, null, null);
            } catch (QiniuException e) {
                //e.printStackTrace();
                log.error("七牛云返回异常");
            }
            DefaultPutRet putRet = null;
            try {
                putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            } catch (QiniuException e) {
                //e.printStackTrace();
                log.error("七牛云json解析异常");
            }

            imagesList.add(ossURL + putRet.key);

        }
        return imagesList;
    }
}
