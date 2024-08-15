package com.ITsupport.IT.support.App.controller;

import com.ITsupport.IT.support.App.model.Utilisateur;

import com.ITsupport.IT.support.App.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("api/v1/auth/utilisateurs/")
@CrossOrigin(origins = "*")
public class UtilisateursController {
    @Autowired
    userService utilisateurService;

    @GetMapping("getAll")
    public List<Utilisateur> getAllUtilisateurs(){
        return utilisateurService.getAllUtilisateurs();
    }
}
