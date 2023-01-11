package back.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import back.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByEmail(String email);
}
