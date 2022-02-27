package ru.tfoms.tfomsapp.repo.kms;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tfoms.tfomsapp.domain.kms.Platel;


public interface PlatelRepo extends JpaRepository<Platel, Long> {
}
