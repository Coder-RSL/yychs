package com.ruoyi.system.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/test")
@RestController
public class MyTestController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/getFiles")
    public ResponseEntity<Resource> downloadFile(@RequestParam("directory") String directory) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        String pythonUrl = "http://localhost:5000/getFiles?directory=" + directory;
        byte[] fileContent = restTemplate.getForObject(pythonUrl, byte[].class);

        String fileName = "example.txt"; // 你想要保存的文件名
        String fileLocation = "/path/to/your/local/folder/"; // 你想要保存的文件夹路径
        FileOutputStream fos = new FileOutputStream(fileLocation + fileName);
        fos.write(fileContent);
        fos.close();

        File file = new File(fileLocation + fileName);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getName());
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE);
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .body(resource);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
