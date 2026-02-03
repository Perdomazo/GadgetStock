package com.perdomazo.firstproject.Services;

import com.perdomazo.firstproject.Models.GadgetModel;
import com.perdomazo.firstproject.Repositories.GadgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
//administrar las clases

@Service
public class GadgetService {
// I don't use @Override because I didn't split my GadgetService in interface and implementation
    @Autowired
    private GadgetRepository gadgetRepository;

    public List<GadgetModel> getAllGadget(){
        return gadgetRepository.findAll();
    }

    public GadgetModel saveGadget(GadgetModel gadget){
        return gadgetRepository.save(gadget);
    }

    public List<GadgetModel> findByName(String name){
        return gadgetRepository.findByName(name);
    }

}
