package back.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import back.domain.Title;
import back.domain.User;
import back.domain.enums.Situation;
import back.domain.enums.Type;
import back.domain.repositories.TitleRepository;
import back.domain.repositories.UserRepository;

@Service
public class DBService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TitleRepository titleRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public void instanciaDB() {
		

		User user1 = new User(null, "Usuario 1", "Usuario1@teste.com", encoder.encode("123"));
		User user2 = new User(null, "Usuario 2", "Usuario2@teste.com", encoder.encode("123"));
		
		Title title1 = new Title(873126, Type.MOVIE, Situation.WATCHED, user1 );
		Title title2 = new Title(76600, Type.MOVIE, Situation.WATCHED, user1 );
		Title title3 = new Title(119051, Type.TV, Situation.WATCHED, user2 );
		
		userRepository.saveAll(Arrays.asList(user1, user2));
		titleRepository.saveAll(Arrays.asList(title1, title2, title3));
	}
}
