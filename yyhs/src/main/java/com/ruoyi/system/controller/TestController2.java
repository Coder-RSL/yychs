package com.ruoyi.system.controller;

import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.core.domain.AjaxResult;
import org.apache.commons.io.FileUtils;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController2 {


    @PostMapping("/pythonToJavaTest")
    public AjaxResult pythonToJavaTest(@RequestBody JSONObject jsonParam) {

        System.out.println("---jsonParam:"+jsonParam.toString());

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("info","Java客户端接收到了消息！");

        AjaxResult ajax = AjaxResult.success();
        ajax.put("success", jsonObject);

        return ajax;
    }


    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        try {
            // 处理上传的文件
            File dest = new File("E:\\test2\\"+file.getOriginalFilename());
            FileUtils.copyInputStreamToFile(file.getInputStream(), dest);
            String name = dest.getName();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file.getName();
    }

}
