package back.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import back.domain.enums.Situation;
import back.domain.enums.Type;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Title implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private Integer id;
	private Type type;
	private Situation situation;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dateCreation = LocalDate.now();
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name ="user_id")
	private User user;

	public Title() {
		super();
	}

	public Title(Integer id, Type type, Situation situation, User user) {
		super();
		this.id = id;
		this.type = type;
		this.situation = situation;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Situation getSituation() {
		return situation;
	}

	public void setSituation(Situation situation) {
		this.situation = situation;
	}

	public LocalDate getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(situation, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Title other = (Title) obj;
		return situation == other.situation && type == other.type;
	}
	
	
	
}
