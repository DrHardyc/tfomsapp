package ru.tfoms.tfomsapp.dao.repoUser;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tfoms.tfomsapp.domain.pg.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
