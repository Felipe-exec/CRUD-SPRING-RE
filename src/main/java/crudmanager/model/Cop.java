package crudmanager.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="cops")
public class Cop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotBlank(message = "O nome do policial não pode estar vazio!")
    private String name;
    
    @NotBlank(message = "O gênero do policial não pode estar vazio!")
    private String gender;
    
    @NotBlank(message = "O rank/patente do policial não pode estar vazio!")
    private String rank;

    @ManyToMany(mappedBy = "cops", fetch = FetchType.EAGER)
    private List<Mission> missions = new ArrayList<>();
    
    public Cop() {}

    public Cop(Integer id) {
        this.id = id;
        setName("");
        setGender("");
        setRank("");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public List<Mission> getMissions() {
        return missions;
    }

    public void setMissions(List<Mission> missions) {
        this.missions = missions;
    }
}
