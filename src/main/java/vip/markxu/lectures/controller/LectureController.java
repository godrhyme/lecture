package vip.markxu.lectures.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import vip.markxu.lectures.service.LectureService;
import vip.markxu.lectures.vo.LectureVo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@RequestMapping("/lectures")
@RestController
public class LectureController {

    @Autowired
    private LectureService lectureService;

    @GetMapping("/post")
    public Object getLectures(int page,int size){
        return lectureService.getPageLecture(page, size);
    }

    @RequestMapping("/post")
    public Object postLectures(LectureVo lectureVo){
        return lectureService.post(lectureVo);
    }

    @RequestMapping("/delete/{postId}")
    public Object deleteLectures(Long postId){
        return lectureService.delete(postId);
    }

    @RequestMapping("/change/{postId}")
    public Object changeLectures(Long postId,LectureVo lectureVo) {
        return lectureService.change(postId, lectureVo);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {

        //转换日期
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器


    }




}
