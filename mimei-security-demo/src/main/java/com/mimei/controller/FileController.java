package com.mimei.controller;

import com.mimei.domain.FileInfo;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

/**
 * @author wuchongliang
 * @create 2019-08-24 11:16:37
 * @description:
 */
@RestController
@RequestMapping(value = "/file")
public class FileController {

    @PostMapping
    public FileInfo uploadFile(MultipartFile file) throws Exception{
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());

        File localFile = new File("d:/", new Date().getTime() + ".txt");
        file.transferTo(localFile);
        return new FileInfo(localFile.getAbsolutePath());
    }

    @GetMapping("/{id}")
    public void downloadFile(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response) throws Exception{

        FileInputStream inputStream = new FileInputStream(new File("d:/", id + ".txt"));
        ServletOutputStream outputStream = response.getOutputStream();
        response.setContentType("application/x-download");
        response.addHeader("Content-Disposition", "attachment;filename=test.txt");
        IOUtils.copy(inputStream, outputStream);
        outputStream.flush();
    }

}
