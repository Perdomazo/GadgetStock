package com.perdomazo.firstproject.Services;

import com.perdomazo.firstproject.Models.GadgetModel;
import com.perdomazo.firstproject.Repositories.GadgetRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
//import java.util.Optional;
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

    public GadgetModel findById(Long id){
        return gadgetRepository.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("No Gadget found with id"+id)
                );
    }

    public GadgetModel update(Long id, GadgetModel gadget) {


        GadgetModel gad = gadgetRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("No Gadget found with id"+id)
                );

        gad.setName(gadget.getName());
        gad.setModel(gadget.getModel());
        gad.setPrice(gadget.getPrice());
        gad.setComments(gadget.getComments());
        gad.setRepair(gadget.getRepair());

        return gadgetRepository.save(gad);



        /*Optional<GadgetModel> gadOptional = gadgetRepository.findById(id);

        if (gadOptional.isPresent()) {
            GadgetModel gad = gadOptional.get();



            return this.gadgetRepository.save(gad);
        } else {
            throw new EntityNotFoundException(
                    "No Gadget found with id" + id
            );

        }*/


    }

    public Float calculateMoneySpent(){
        return gadgetRepository.getTotalSpent();
    }

    public void deleteById(Long id){
        gadgetRepository.deleteById(id);
    }

    public void deleteByName(String name){
        List<GadgetModel> gadgets = gadgetRepository.findByName(name);
        if(!gadgets.isEmpty()){

            GadgetModel gad = gadgets.getFirst();
            Long gadId = gad.getId();
            gadgetRepository.deleteById(gadId);

        }

    }

}
