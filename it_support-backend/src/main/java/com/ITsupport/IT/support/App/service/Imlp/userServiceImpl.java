package com.ITsupport.IT.support.App.service.Imlp;

import com.ITsupport.IT.support.App.model.Utilisateur;
import com.ITsupport.IT.support.App.repository.UtilisateurRepository;
import com.ITsupport.IT.support.App.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userServiceImpl implements userService {

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Override
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }
}
