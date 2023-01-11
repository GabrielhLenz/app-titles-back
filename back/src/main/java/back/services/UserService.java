package back.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import back.domain.User;
import back.domain.dtos.UserDTO;
import back.domain.repositories.UserRepository;
import back.services.exceptions.DataIntegrityViolationException;
import back.services.exceptions.NotFoundException;
import javax.validation.Valid;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;
		
	public User findById(Integer id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(()-> new NotFoundException("Objeto não encontrado! Id: " + id));
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User create(UserDTO userDTO) {
		userDTO.setId(null);
		userDTO.setPassword(encoder.encode(userDTO.getPassword()));
		emailValidate(userDTO);
		User obj = new User(userDTO);
		return userRepository.save(obj);
	}

	public User update(Integer id, @Valid UserDTO objDTO) {
		objDTO.setId(id);
		objDTO.setPassword(encoder.encode(objDTO.getPassword()));
		User oldObj = findById(id);
		emailValidate(objDTO);
		oldObj = new User(objDTO);
		return userRepository.save(oldObj);
	}

	public void delete(Integer id) {
		//User obj = findById(id);
		userRepository.deleteById(id);
	}

	private void emailValidate(UserDTO userDTO) {
		Optional <User> obj = userRepository.findByEmail(userDTO.getEmail());
		if(obj.isPresent() && obj.get().getId() != userDTO.getId()) {
			throw new DataIntegrityViolationException("E-mail já cadastrado no sistema");
		}
	}

} /*

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public User findById(Integer id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(()-> new NotFoundException("Objeto não encontrado! Id: " + id));
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User create(UserDTO userDTO) {
		userDTO.setId(null);
		userDTO.setPassword(encoder.encode(userDTO.getPassword()));
		emailValidate(userDTO);
		User obj = new User(userDTO);
		return userRepository.save(obj);
	}

	public User update(Integer id, @Valid UserDTO objDTO) {
		objDTO.setId(id);
		objDTO.setPassword(encoder.encode(objDTO.getPassword()));
		User oldObj = findById(id);
		emailValidate(objDTO);
		oldObj = new User(objDTO);
		return userRepository.save(oldObj);
	}

	public void delete(Integer id) {
		//User obj = findById(id);
		userRepository.deleteById(id);
	}

	private void emailValidate(UserDTO userDTO) {
		Optional <User> obj = userRepository.findByEmail(userDTO.getEmail());
		if(obj.isPresent() && obj.get().getId() != userDTO.getId()) {
			throw new DataIntegrityViolationException("E-mail já cadastrado no sistema");
		}
	}

}
*/