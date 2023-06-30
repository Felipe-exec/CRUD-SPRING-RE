package crudmanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import crudmanager.model.*;
@Repository
public interface MissionRepository extends JpaRepository<Mission, Integer>{

}
