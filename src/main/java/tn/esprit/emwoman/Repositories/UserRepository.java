package tn.esprit.emwoman.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.emwoman.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
