package com.miguelluque.apifirst.web;

import com.miguelluque.apifirst.api.ProductosApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test2")
public class TestController implements ProductosApi {


    @GetMapping
    public ResponseEntity<Void> createProducto() {

        return ResponseEntity.ok(null);
    }
}