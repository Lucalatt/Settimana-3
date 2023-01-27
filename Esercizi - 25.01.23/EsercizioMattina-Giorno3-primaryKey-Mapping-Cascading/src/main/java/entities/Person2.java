package entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "people_2")
@Getter
@Setter
@ToString
public class Person2 {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstname;
    private String lastname;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
        name = "address_id", referencedColumnName = "id"
    )
    
    private Address address;
    
    @ManyToMany
    @JoinTable(
    	name = "person2_project1",
    	joinColumns = @JoinColumn(name = "person2_id"),
    	inverseJoinColumns = @JoinColumn(name = "project1_id")
    )
    Set<Project1> projects = new HashSet<>();
    

}
