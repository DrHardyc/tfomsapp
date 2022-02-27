package ru.tfoms.tfomsapp.dao.kms;

import org.springframework.jdbc.core.JdbcTemplate;
import ru.tfoms.tfomsapp.domain.kms.Platel;
import ru.tfoms.tfomsapp.service.PlatelMapper;

import javax.sql.DataSource;
import java.util.List;

public class PlatelDAOImpl implements PlatelDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void createPlatel(String namef, String namesc, String ogrn, String inn, String kpp, String vid,
                             String upr, String regorg, String status, String stch, Long address, String vidreg,
                             String dtstart, String dtend, String regnpf, String pf, String regnfss, String fss,
                             String regnforms, String foms, String filen, String dtpris, String prin, String kuser,
                             String chis, String pldt, String vpdt, String vpkto) {

        String SQL = "INSERT INTO PLATEL (namef, namesc, ogrn, inn, kpp, vid, upr, regorg, status, stch, address, " +
                "vidreg, dtstart, dtend, regnpf, pf, regnfss, fss, regnforms, foms, filen, dtpris, prin, kuser, chis," +
                "pldt, vpdt, vpkto) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        jdbcTemplate.update(SQL, namef, namesc, ogrn, inn, kpp, vid, upr, regorg, status, stch, address,
                vidreg, dtstart, dtend, regnpf, pf, regnfss, fss, regnforms, foms, filen, dtpris, prin, kuser, chis,
                pldt, vpdt, vpkto);
    }

    @Override
    public Platel getPlatelById(Long id) {
        String SQL = "SELECT * FROM PLATEL WHERE id = ?";
        Platel platel = jdbcTemplate.queryForObject(SQL, new PlatelMapper());
        return platel;
    }

    @Override
    public List listPlatels() {
        String SQL = "SELECT * FROM PLATEL";
        List platel = jdbcTemplate.query(SQL, new PlatelMapper());
        return platel;
    }

    @Override
    public void removePlatel(Long id) {
        String SQL = "DELETE FROM PLATEL WHERE id = ?";
        jdbcTemplate.update(SQL, id);
    }

    @Override
    public void updatePlatel(Long id, String namef, String namesc, String ogrn, String inn, String kpp, String vid,
                             String upr, String regorg, String status, String stch, Long address, String vidreg,
                             String dtstart, String dtend, String regnpf, String pf, String regnfss, String fss,
                             String regnforms, String foms, String filen, String dtpris, String prin, String kuser,
                             String chis, String pldt, String vpdt, String vpkto) {
        String SQL = "UPDATE PLATEL SET NAMEF = ?, NAMESC = ?, OGRN = ?, INN = ?, KPP = ?, VID = ?, UPR = ?, " +
                " REGORG = ?, STATUS = ?, STCH = ?, ADDRSS = ?, VIDREG = ?, DTSTART = ?, DTEND = ?, REGNPF = ?, " +
                " PF = ?, REGNFSS = ?, FSS = ?, REGNFOMS = ?, FOMS = ?, FILEN = ?, DTPRIS = ?, PRIN = ?, KUSER = ?," +
                " CHIS = ?, PLDT = ?, VPDT = ?, VPKTO = ? WHERE id = ?";
        jdbcTemplate.update(SQL, namef, namesc, ogrn, inn, kpp, vid, upr, regorg, status, stch, address,
                vidreg, dtstart, dtend, regnpf, pf, regnfss, fss, regnforms, foms, filen, dtpris, prin, kuser, chis,
                pldt, vpdt, vpkto, id);
    }
}
