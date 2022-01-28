package ru.tfoms.tfomsapp.DAO.repoUser;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tfoms.tfomsapp.domain.PG.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
