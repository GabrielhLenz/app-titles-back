package back.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import back.domain.Title;
import javax.validation.constraints.NotNull;

public class TitleDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	@NotNull(message = "Campo requerido")
	private Integer id;
	@NotNull(message = "Campo requerido")
	private Integer type;
	@NotNull(message = "Campo requerido")
	private Integer situation;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dateCreation = LocalDate.now();
	private Integer user;
	private String userName;
	
	public TitleDTO() {
		
	}
	
	public TitleDTO(Title obj) {
		this.id = obj.getId();
		this.type = obj.getType().getCode();	
		this.situation = obj.getSituation().getCode();
		this.dateCreation = obj.getDateCreation();
		this.user = obj.getUser().getId();
		this.userName = obj.getUser().getName();
	}
	
	  public Integer getId() {
		    return id;
		  }
		  
		  public Integer getType() {
		    return type;
		  }
		  
		  public Integer getSituation() {
		    return situation;
		  }
		  
		  public LocalDate getDateCreation() {
		    return dateCreation;
		  }
		  
		  public Integer getUser() {
		    return user;
		  }
		  
		  public String getUserName() {
		    return userName;
		  }
		  

		  public void setId(Integer id) {
		    this.id = id;
		  }
		  
		  public void setType(Integer type) {
		    this.type = type;
		  }
		  
		  public void setSituation(Integer situation) {
		    this.situation = situation;
		  }
		  
		  public void setDateCreation(LocalDate dateCreation) {
		    this.dateCreation = dateCreation;
		  }
		  
		  public void setUser(Integer user) {
		    this.user = user;
		  }
		  
		  public void setUserName(String userName) {
		    this.userName = userName;
		  }
		
}
