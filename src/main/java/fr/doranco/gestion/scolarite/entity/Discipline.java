package fr.doranco.gestion.scolarite.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "discipline")
public class Discipline implements Serializable {

	private static final long serialVersionUID = 2245985467049517139L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11)
	private Integer id;

	@NotEmpty
	@Column(name = "name_discipline", length = 45, nullable = false)
	private String nameDiscipline;

	// Relation MANY TO ONE
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	// CONSTRUCTEUR VIDE
	public Discipline() {
	}

	// CONSTRUCTEUR AVEC PARAMETRES
	public Discipline(@NotEmpty String nameDiscipline, User user) {
		this.nameDiscipline = nameDiscipline;
		this.user = user;
	}

	// GETTERS & SETTERS
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameDiscipline() {
		return nameDiscipline;
	}

	public void setNameDiscipline(String nameDiscipline) {
		this.nameDiscipline = nameDiscipline;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	// toString
	@Override
	public String toString() {
		return "Discipline [id=" + id + ", nameDiscipline=" + nameDiscipline + ", user=" + user + "]";
	}

	
}
