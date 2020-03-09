package com.jreis.teste.controller;

import com.jreis.teste.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@CrossOrigin("*")
@RestController
@RequestMapping({"/upload"})
public class UploadFileController {

    @Autowired
    private UploadFileService uploadFileService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestParam("file") MultipartFile file) {

        uploadFileService.save(file);
        return ResponseEntity.status(HttpStatus.OK)
                .build();
    }

}