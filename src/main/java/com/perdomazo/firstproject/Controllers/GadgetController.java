package com.perdomazo.firstproject.Controllers;

import com.perdomazo.firstproject.Models.GadgetModel;
import com.perdomazo.firstproject.Services.GadgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import java.util.List;
//import java.util.Optional;

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

    //@PutMapping()
    //public GadgetModel updateGadget(@RequestBody GadgetModel gadget){
    //   return gadgetService.saveGadget(gadget);
    //}

    @GetMapping(path = "/find") // http://localhost:8081/gadget/find?name=
    public List<GadgetModel> findByName(@RequestParam("name")String name){
        return gadgetService.findByName(name);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody GadgetModel gadget){

        GadgetModel gad = this.gadgetService.findById(id);

        gad.setName(gadget.getName());
        gad.setModel(gadget.getModel());
        gad.setPrice(gadget.getPrice());
        gad.setComments(gadget.getComments());
        gad.setRepair(gadget.getRepair());

        // Because it didn't break till here we can return ResponseEntity

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(gadgetService.update(id, gad));
    }

    @GetMapping("/total-spent")
    @Transactional
    public Float totalSpent(){
        return gadgetService.calculateMoneySpent();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        gadgetService.deleteById(id);
    }

    @DeleteMapping("/delete/name/{name}")
    public void deleteByName(@PathVariable String name){
        gadgetService.deleteByName(name);
    }


}
