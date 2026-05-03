package com.perdomazo.firstproject.Repositories;

import com.perdomazo.firstproject.Models.GadgetModel;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

// maneja persistencia en la base de datos
@Repository
public interface GadgetRepository extends JpaRepository<GadgetModel, Long> {

    // only findByName because its more practical in an inventory full of unique items
    public abstract List<GadgetModel> findByName(String name);

    @Query("SELECT SUM (g.price) FROM GadgetModel g")
    Float getTotalSpent();

    List<GadgetModel> findByIsSoldTrue();
}
