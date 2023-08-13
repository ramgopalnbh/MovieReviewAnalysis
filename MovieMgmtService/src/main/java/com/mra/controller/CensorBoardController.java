package com.mra.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/censorboard")
public class CensorBoardController {
    @GetMapping("/")
    public ResponseEntity<List<String>> getStaffs(){
        List<String> data =Arrays.asList("RamGopalNBh","JivaRamNBh","OmKarNBh");
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
