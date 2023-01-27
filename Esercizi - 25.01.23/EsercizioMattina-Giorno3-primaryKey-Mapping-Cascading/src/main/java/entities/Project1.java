package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "projects_1")
@Getter
@Setter
public class Project1 {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;
    private String description;
    
    // @MainyToMany(mappedBy = "projects")
    // private
    
    @Override
    public String toString() {
    	return this.name + " " + this.description;
    }
    
    
}
