package back.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import back.domain.Title;
import back.domain.User;
import back.domain.dtos.TitleDTO;
import back.domain.enums.Situation;
import back.domain.enums.Type;
import back.domain.repositories.TitleRepository;
import back.services.exceptions.NotFoundException;
import javax.validation.Valid;

@Service
public class TitleService {
	@Autowired
	private TitleRepository titleRepository;
	@Autowired
	private UserService userService;
	
	public Title findById(Integer id) {
		Optional<Title> obj = titleRepository.findById(id);
		return obj.orElseThrow(() -> new NotFoundException("Not find! ID: " + id));
	}

	public List<Title> findAll() {
		return titleRepository.findAll();
	}

	public Title create(@Valid TitleDTO objDTO) {
		
		return titleRepository.save(newTitle(objDTO));
	}
	
	public Title update(Integer id, @Valid TitleDTO objDTO) {
		objDTO.setId(id);
		Title oldObj = findById(id);
		oldObj = newTitle(objDTO);
		return titleRepository.save(oldObj);
	}
	
	public void delete(Integer id) {
		titleRepository.deleteById(id);
	}
	
	private Title newTitle(TitleDTO obj) {
		User user = userService.findById(obj.getUser());
		
		Title title = new Title();
		 if(obj.getId() != null) {
			 title.setId(obj.getId());
		 }
		 
		 
		 title.setUser(user);
		 title.setSituation(Situation.toEnum(obj.getSituation()));
		 title.setType(Type.toEnum(obj.getType()));
		 return title;
	}

	public List<Title> findByUserId(Integer userId){
		return titleRepository.findByUserId(userId);
	  }

	public List<Title> findByUserIdAndSituation(Integer userId, Situation situation){
  		return titleRepository.findByUserIdAndSituation(userId, situation);
	}
	

}
