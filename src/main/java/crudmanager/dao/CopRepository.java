package crudmanager.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import crudmanager.model.*;
@Repository
public interface CopRepository extends JpaRepository<Cop, Integer>{

}
