package ru.tfoms.tfomsapp.repo.PG;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tfoms.tfomsapp.domain.PG.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}