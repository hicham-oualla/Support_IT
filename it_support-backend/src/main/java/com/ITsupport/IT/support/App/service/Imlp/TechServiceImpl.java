package com.ITsupport.IT.support.App.service.Imlp;

import com.ITsupport.IT.support.App.model.Technicien;
import com.ITsupport.IT.support.App.repository.TechicienRpository;
import com.ITsupport.IT.support.App.service.TechService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TechServiceImpl implements TechService {

    @Autowired
    TechicienRpository technicienRepository;

    @Override
    public List<Technicien> getTechnicienList() {
        return technicienRepository.findAll();
    }
}
