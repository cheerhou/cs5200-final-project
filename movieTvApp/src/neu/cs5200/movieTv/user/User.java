package neu.cs5200.movieTv.user;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@NamedQueries({	
	@NamedQuery(name = "User.findByUsernameAndPassword", 
				query="select u from User u where u.username = :username and u.password = :password"),
	@NamedQuery(name = "User.findByUsername", 
				query="select u from User u where u.username = :username"),
	@NamedQuery(name = "User.findAll", 
				query="select u from User u")
	})

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	@OneToMany(mappedBy="user")
	private List<User2Movie> user2movies;

	public User() {
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;	
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}