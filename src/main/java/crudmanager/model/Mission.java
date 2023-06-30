package crudmanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "missions")
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotBlank(message = "O nome da operação não pode estar vazio!")
    private String name;
    
    @NotBlank(message = "A descrição do caso não pode estar vazia!")
    @Column(length = 500)
    private String description;
    
    @NotBlank(message = "O local da operação não pode estar vazio!")
    private String local;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "missions_cops",
            joinColumns = @JoinColumn(name = "mission_id"),
            inverseJoinColumns = @JoinColumn(name = "cop_id")
        )
    private List<Cop> cops = new ArrayList<>();

    public Mission() {}

    public Mission(Integer id) {
        this.id = id;
        setName("");
        setDescription("");
        setLocal("");
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public List<Cop> getCops() {
        return cops;
    }

    public void setCops(List<Cop> cops) {
        this.cops = cops;
    }
}
