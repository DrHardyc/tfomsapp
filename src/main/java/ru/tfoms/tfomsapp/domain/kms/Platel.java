package ru.tfoms.tfomsapp.domain.kms;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Platel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String namef;
    private String namesc;
    private String ogrn;
    private String inn;
    private String kpp;
    private String vid;
    private String upr;
    private String regorg;
    private String status;
    private String stch;
    private Long addrss;
    private String vidreg;
    private String dtstart;
    private String dtend;
    private String regnpf;
    private String pf;
    private String regnfss;
    private String fss;
    private String regnfoms;
    private String foms;
    private String filen;
    private String dtpris;
    private String prin;
    private String kuser;
    private String chis;
    private String pldt;
    private String vpdt;
    private String vpkto;
}
