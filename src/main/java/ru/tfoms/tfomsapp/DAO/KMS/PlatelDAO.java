package ru.tfoms.tfomsapp.DAO.KMS;

import ru.tfoms.tfomsapp.domain.KMS.Platel;

import javax.sql.DataSource;
import java.util.List;

public interface PlatelDAO {

    public void setDataSource(DataSource dataSource);
    public void createPlatel(String namef, String namesc, String ogrn, String inn, String kpp, String vid,
                             String upr, String regorg, String status, String stch, Long addrss, String vidreg,
                             String dtstart, String dtend, String regnpf, String pf, String regnfss, String fss,
                             String regnforms, String foms, String filen, String dtpris, String prin, String kuser,
                             String chis, String pldt, String vpdt, String vpkto);
    public Platel getPlatelById(Long id);
    public List listPlatels();
    public void removePlatel(Long id);
    public void updatePlatel(Long id, String namef, String namesc, String ogrn, String inn, String kpp, String vid,
                             String upr, String regorg, String status, String stch, Long addrss, String vidreg,
                             String dtstart, String dtend, String regnpf, String pf, String regnfss, String fss,
                             String regnforms, String foms, String filen, String dtpris, String prin, String kuser,
                             String chis, String pldt, String vpdt, String vpkto);
}