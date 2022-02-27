package ru.tfoms.tfomsapp.repo.pg;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tfoms.tfomsapp.domain.pg.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
