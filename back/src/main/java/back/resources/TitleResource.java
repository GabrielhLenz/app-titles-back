package back.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import back.domain.Title;
import back.domain.dtos.TitleDTO;
import back.services.TitleService;
import javax.validation.Valid;
import back.domain.enums.Situation;;
@RestController
@RequestMapping(value = "/titles")
public class TitleResource {

	@Autowired
	private TitleService titleService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TitleDTO> findById(@PathVariable Integer id) {
		Title obj = titleService.findById(id);
		return ResponseEntity.ok().body(new TitleDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<TitleDTO>> findAll(){
		List<Title> list = titleService.findAll();
		List<TitleDTO> listDTO = list.stream().map(obj -> new TitleDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@GetMapping(value="/user/{userId}")
	public ResponseEntity<List<TitleDTO>> findByUserId(@PathVariable Integer userId){
  	List<Title> list = titleService.findByUserId(userId);
  	List<TitleDTO> listDTO = list.stream().map(obj -> new TitleDTO(obj)).collect(Collectors.toList());
  	return ResponseEntity.ok().body(listDTO);
}
@GetMapping(value="/user/{userId}/situation/{situation}")
public ResponseEntity<List<TitleDTO>> findByUserIdAndSituation(@PathVariable Integer userId, @PathVariable Integer situation){
  Situation situationEnum = Situation.toEnum(situation);
  List<Title> list = titleService.findByUserIdAndSituation(userId, situationEnum);
  List<TitleDTO> listDTO = list.stream().map(obj -> new TitleDTO(obj)).collect(Collectors.toList());
  return ResponseEntity.ok().body(listDTO);
}
	@PostMapping
	public ResponseEntity<TitleDTO> create(@Valid @RequestBody TitleDTO objDTO){
			Title obj = titleService.create(objDTO);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
			return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<TitleDTO> update(@PathVariable Integer id, @Valid @RequestBody TitleDTO objDTO){
		Title newObj = titleService.update(id, objDTO);
		return ResponseEntity.ok().body(new TitleDTO(newObj));
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<TitleDTO> delete(@PathVariable Integer id){
		titleService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
