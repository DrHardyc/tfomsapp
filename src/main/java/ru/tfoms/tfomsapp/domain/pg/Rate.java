package ru.tfoms.tfomsapp.domain.pg;

import lombok.Data;

import javax.persistence.*;
import java.util.Currency;

@Entity
@Data
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int age;
    private int gender;
    private String ratename;
    private String price;
}
