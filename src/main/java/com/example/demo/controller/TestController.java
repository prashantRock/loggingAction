package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/getRequest")
    public ResponseEntity<String> getRequest(@RequestParam(required = false) String title) {
        try {

            System.out.println("Get Request");
            Thread.sleep(1000);
            return new ResponseEntity<>("Get Request", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/postRequest")
    public ResponseEntity<String> postRequest() {
        try {
            System.out.println("Post Request");
            Thread.sleep(2000);

            return new ResponseEntity<>("Post Request", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/putRequest/{id}")
    public ResponseEntity<String> putRequest(@PathVariable("id") long id) {

        System.out.println("Put Request " + id);

        return new ResponseEntity<>("Put Request", HttpStatus.OK);
    }

    @DeleteMapping("/deleteRequest/{id}")
    public ResponseEntity<String> deleteRequest(@PathVariable("id") long id) {
        try {
            System.out.println("Delete Request " + id);
            return new ResponseEntity<>("Delete Request", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
