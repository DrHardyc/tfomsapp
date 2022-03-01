package ru.tfoms.tfomsapp.repo.pg;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.tfoms.tfomsapp.domain.pg.Rate;

import java.util.List;

public interface RateRepo extends JpaRepository<Rate, Long> {
//    @Query("SELECT r FROM Rate r WHERE r.age = :age and r.gender = :gender and r.ratename = :ratename")
//    List<Rate> findByAgeAndGenderAndRatename(@Param("age") int age,
//                                             @Param("gender") int gender,
//                                             @Param("ratename") String ratename);

    @Query("SELECT r FROM Rate r WHERE r.age >= 18 and r.gender = :gender and r.ratename = :ratename")
    List<Rate> findByAllOver18(@Param("gender") int gender,
                               @Param("ratename") String ratename);
    @Query("SELECT r FROM Rate r WHERE r.age < 18 and r.gender = :gender and r.ratename = :ratename")
    List<Rate> findByAllUnder18(@Param("gender") int gender,
                                @Param("ratename") String ratename);

}
