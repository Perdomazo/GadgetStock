package com.perdomazo.firstproject.Controllers;

import com.perdomazo.firstproject.Models.GadgetModel;
import com.perdomazo.firstproject.Services.GadgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import java.util.List;

// It's who connects with the frontend, http petitions

@RestController
@RequestMapping("/gadget")

public class GadgetController {

    @Autowired
    GadgetService gadgetService;

    @GetMapping()
    @Transactional(readOnly = true)
    public List<GadgetModel> getAllGadget(){
        return gadgetService.getAllGadget();
    }

    @PostMapping()
    @Transactional()
    public GadgetModel saveGadget(@RequestBody GadgetModel gadget){
        return gadgetService.saveGadget(gadget);
    }

    @PutMapping()
    public GadgetModel updateGadget(@RequestBody GadgetModel gadget){
        return gadgetService.saveGadget(gadget);
    }

    @GetMapping(path = "/find") // http://localhost:8081/gadget/find?name=
    public List<GadgetModel> findByName(@RequestParam("name")String name){
        return gadgetService.findByName(name);
    }



}
