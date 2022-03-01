package ru.tfoms.tfomsapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.tfoms.tfomsapp.domain.pg.Rate;
import ru.tfoms.tfomsapp.repo.pg.RateRepo;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Random;

@SpringBootTest
public class RateTest {
    @Autowired
    RateRepo rateRepo;

    @Test
    void test() {
        Random random = new Random();
        double money = 15522.45;
        String strMoney = "15522,45654654";

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String moneyString = formatter.format(money);
        Rate rate = new Rate();
        rate.setGender(random.nextInt(2) + 1);
        rate.setAge(random.nextInt(150) + 1);
        rate.setRatename("DF");
        rate.setPrice(String.format("%.2f", money));

        rateRepo.save(rate);
        List<Rate> rates = new ArrayList<>();
        rates.add(rate);
        System.out.println(rates);

    }

}
