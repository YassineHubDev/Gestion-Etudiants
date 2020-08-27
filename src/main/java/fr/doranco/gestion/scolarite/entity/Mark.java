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
@Table(name = "mark")
public class Mark implements Serializable {

	private static final long serialVersionUID = 2245985467049517139L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11)
	private Integer id;

	@NotEmpty
	@Column(name = "discipline_mark", nullable = false)
	private Double disciplineMark;

	@NotEmpty
	@Column(name = "commentary", length = 45, nullable = false)
	private String commentary;

	// Relation MANY TO ONE
	@ManyToOne
	@JoinColumn(name = "discipline_id")
	private Discipline discipline;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	// CONSTRUCTEUR SANS PARAMATRES
	public Mark() {
	}

	// CONSTRUCTEUR AVEC PARAMATRES
	public Mark(@NotEmpty Double disciplineMark, @NotEmpty String commentary, Discipline discipline, User user) {
		this.disciplineMark = disciplineMark;
		this.commentary = commentary;
		this.discipline = discipline;
		this.user = user;
	}

	// GETTERS & SETTERS
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getDisciplineMark() {
		return disciplineMark;
	}

	public void setDisciplineMark(Double disciplineMark) {
		this.disciplineMark = disciplineMark;
	}

	public String getCommentary() {
		return commentary;
	}

	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}

	public Discipline getDiscipline() {
		return discipline;
	}

	public void setDiscipline(Discipline discipline) {
		this.discipline = discipline;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	//toString
	@Override
	public String toString() {
		return "Mark [id=" + id + ", disciplineMark=" + disciplineMark + ", commentary=" + commentary + ", discipline="
				+ discipline + ", user=" + user + "]";
	}

}
