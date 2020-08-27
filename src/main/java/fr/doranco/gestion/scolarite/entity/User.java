package fr.doranco.gestion.scolarite.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User implements Serializable {
	
	private static final long serialVersionUID = 2245985467049517139L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11)
	private Integer id;
	
	@NotEmpty
	@Size(min = 2, max = 45, message = "La longueur du nom doit être comprise entre 2 et 45 caractères !")
	@Column(name = "username", length = 45, nullable = false)
	private String username;
	
	@NotEmpty
	@Column(name = "password", length = 45, nullable = false)
	private String password;
	
	@NotEmpty
	@Column(name = "lastname", length = 45, nullable = false)
	private String lastname;
	
	@NotEmpty
	@Column(name = "firstname", length = 45, nullable = false)
	private String firstname;
	
	@NotEmpty
	@Column(name = "email", length = 45, nullable = false)
	private String email;
	
	@NotEmpty
	@Column(name = "sex", length = 45, nullable = false)
	private String sex;
	
	@NotEmpty
	@Column(name = "date_birth", nullable = false)
	private Date dateBirth;
	
	@NotEmpty
	@Column(name = "profile", nullable = true)
	private String profile;

	
	
	// CONSTRUCTEUR VIDE
	public User() {
	}

	// CONSTRUCTEUR AVEC PARAMATRES
	public User(
			@NotEmpty @Size(min = 2, max = 45, message = "La longueur du nom doit être comprise entre 2 et 45 caractères !") String username,
			@NotEmpty String password, @NotEmpty String lastname, @NotEmpty String firstname, @NotEmpty String email,
			@NotEmpty String sex, @NotEmpty Date dateBirth, @NotEmpty String profile) {
		this.username = username;
		this.password = password;
		this.lastname = lastname;
		this.firstname = firstname;
		this.email = email;
		this.sex = sex;
		this.dateBirth = dateBirth;
		this.profile = profile;
	}
	

	//GETTERS & SETTERS
	public Integer getId() {
		return id;
	}

	

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}
		
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	//toString
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", lastname=" + lastname
				+ ", firstname=" + firstname + ", email=" + email + ", sex=" + sex + ", dateBirth=" + dateBirth
				+ ", profile=" + profile + "]";
	}
	


}
