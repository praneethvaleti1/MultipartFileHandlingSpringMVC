package com.sample.demo.controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MultipartFilter;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Controller
public class FileController {

    @Autowired
    private HttpServletRequest req;




    @PostMapping(path = "/sample")
    private ResponseEntity<String> sample(Model model, @RequestParam(name="file") MultipartFile file) throws IOException {
        Path tempPath = Files.createTempDirectory("temp_");
        File f = new File(tempPath.toString()+"/"+file.getOriginalFilename());
        System.out.println(f.getAbsolutePath());
        f.createNewFile();
        FileOutputStream fos = new FileOutputStream(f);
        fos.write(file.getBytes());
        fos.close();
        return new ResponseEntity<>("Caught  the  file", HttpStatus.OK);
    }


}
