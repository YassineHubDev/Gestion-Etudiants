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
@Table(name = "school_report")
public class SchoolReport implements Serializable {

	private static final long serialVersionUID = 2245985467049517139L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11)
	private Integer id;

	@NotEmpty
	@Column(name = "discipline_average")
	private Double disciplineAverage;

	@NotEmpty
	@Column(name = "gle_average")
	private Double gleAverage;

	@NotEmpty
	@Column(name = "commentary")
	private String commentary;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	// CONSTRUCTEUR SANS PARAMETRES
	public SchoolReport() {
	}

	// CONSTRUCTEUR AVEC PARAMETRES
	public SchoolReport(@NotEmpty Double disciplineAverage, @NotEmpty Double gleAverage, @NotEmpty String commentary,
			User user) {
		this.disciplineAverage = disciplineAverage;
		this.gleAverage = gleAverage;
		this.commentary = commentary;
		this.user = user;
	}

	// GETTERS & SETTERS
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getDisciplineAverage() {
		return disciplineAverage;
	}

	public void setDisciplineAverage(Double disciplineAverage) {
		this.disciplineAverage = disciplineAverage;
	}

	public Double getGleAverage() {
		return gleAverage;
	}

	public void setGleAverage(Double gleAverage) {
		this.gleAverage = gleAverage;
	}

	public String getCommentary() {
		return commentary;
	}

	public void setCommentary(String commentary) {
		this.commentary = commentary;
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
		return "SchoolReport [id=" + id + ", disciplineAverage=" + disciplineAverage + ", gleAverage=" + gleAverage
				+ ", commentary=" + commentary + ", user=" + user + "]";
	}

}
