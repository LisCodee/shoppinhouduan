package com.leyou.item.web;


import com.leyou.item.pojo.SpecGroup;
import com.leyou.item.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("spec")
public class SpecificationController {

    @Autowired
    private SpecificationService service;

    @GetMapping("groups/{cid}")
    public ResponseEntity<List<SpecGroup>> queryGroupById(@PathVariable("cid") Long cid){
        return ResponseEntity.ok(service.queryGroupById(cid));
    }
}