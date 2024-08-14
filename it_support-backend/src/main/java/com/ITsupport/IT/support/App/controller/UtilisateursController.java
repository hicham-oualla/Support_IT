package com.ITsupport.IT.support.App.controller;

import com.ITsupport.IT.support.App.model.Utilisateur;

import com.ITsupport.IT.support.App.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/utilisateurs/getALLutilisateurs/")
public class UtilisateursController {
    @Autowired
    userService utilisateurService;

    @GetMapping("utilisateurs")
    public List<Utilisateur> getAllUtilisateurs(){
        return utilisateurService.getAllUtilisateurs();
    }
}
