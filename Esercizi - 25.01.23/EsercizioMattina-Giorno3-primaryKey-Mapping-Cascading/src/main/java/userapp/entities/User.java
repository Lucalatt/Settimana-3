package userapp.entities;

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
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {

	@Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	private String nickname;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn (
            name = "course_id", referencedColumnName = "id"
    )
    private Course course;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
		name = "users_tasks",
		joinColumns = @JoinColumn( name = "user_id" ),
		inverseJoinColumns = @JoinColumn( name = "task_id" )
	)
	Set<Task> tasks = new HashSet<>();
	
	@Override
	public String toString() {
		return nickname;
	}
	
	public User(String nickname, Course course) {
		this.nickname = nickname;
		this.course = course;
	}
	
}
