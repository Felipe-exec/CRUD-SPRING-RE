package br.edu.ifsuldeminas.mch.webii.crudmanager.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.*;
@Repository
public interface MissionRepository extends JpaRepository<Mission, Integer>{

}
