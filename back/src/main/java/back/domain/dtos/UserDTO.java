package back.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import back.domain.Title;
import back.domain.User;
import javax.validation.constraints.NotNull;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	@NotNull(message = "NAME required")
	private String name;
	@NotNull(message = "E-MAIL required")
	private String email;
	@NotNull(message = "PASSWORD required")
	private String password;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private	LocalDate dateCreation = LocalDate.now();
	private List<Title> titles = new ArrayList<>(); 
	public UserDTO() {
		super();
	}
	
	public UserDTO(User user) {
		super();
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.setTitles(user.getTitles());
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}

	public List<Title> getTitles() {
		return titles;
	}

	public void setTitles(List<Title> titles) {
		this.titles = titles;
	}
	
}
