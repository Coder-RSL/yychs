import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import org.junit.Test;

import java.io.*;
import java.net.MalformedURLException;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Collections;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class TT {
    @Test
    public void test1(){
       // 定义要发送的字符
        String text = "D:\\demotest&&&185";

        // 创建HttpHeaders对象，设置Content-Type为text/plain
        HttpHeaders headers = new HttpHeaders();
        // headers.setContentType(MediaType.TEXT_PLAIN);
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAcceptCharset(Collections.singletonList(StandardCharsets.UTF_8));


        // 创建HttpEntity对象，将字符设置为请求体，并将HttpHeaders对象传递给构造函数
        HttpEntity<String> request = new HttpEntity<>(text, headers);

        // 使用RestTemplate发送HTTP POST请求
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:9999/text";
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        // 获取Flask返回的响应
        String flaskResponse = response.getBody();
        System.out.println(flaskResponse);
   }

   @Test
    public void str(){
        String a="14:30-16:30|15:30-16:30|15:30-16:30";
       System.out.println(a.replaceAll("\\|","\n"));

   }
}
