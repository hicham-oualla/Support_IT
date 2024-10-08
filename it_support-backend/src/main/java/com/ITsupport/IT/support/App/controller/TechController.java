package com.ITsupport.IT.support.App.controller;

import com.ITsupport.IT.support.App.model.Technicien;
import com.ITsupport.IT.support.App.service.TechService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/v1/auth/tech/")
@CrossOrigin(origins = "*")
public class TechController {


@Autowired
TechService technicienService;

@GetMapping("getAll")
public List<Technicien> getAllTechniciens(){
    return technicienService.getTechnicienList();
}
}
