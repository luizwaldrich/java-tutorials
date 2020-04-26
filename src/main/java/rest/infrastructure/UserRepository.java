package rest.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    @Transactional(readOnly = true)
    Optional<UserEntity> findByEmail(String email);
}