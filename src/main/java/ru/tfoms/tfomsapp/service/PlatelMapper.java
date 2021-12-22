package ru.tfoms.tfomsapp.service;

import org.springframework.jdbc.core.RowMapper;
import ru.tfoms.tfomsapp.domain.Platel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlatelMapper  implements RowMapper<Platel> {

    public Platel mapRow (ResultSet rs, int rowNum) throws SQLException {
        Platel platel = new Platel();
        platel.setId( rs.getLong("id"));
        platel.setNamef(rs.getString("namef"));
        platel.setNamesc (rs.getString("namesc")); ;
        platel.setOgrn(rs.getString("ogrn"));
        platel.setInn(rs.getString("inn"));
        platel.setKpp(rs.getString("kpp"));
        platel.setVid(rs.getString("vid"));
        platel.setUpr(rs.getString("upr"));
        platel.setRegorg(rs.getString("regorg"));
        platel.setStatus(rs.getString("status"));
        platel.setStch(rs.getString("stch"));
        platel.setAddrss(rs.getLong("addrss"));
        platel.setVidreg(rs.getString("vidreg"));
        platel.setDtstart(rs.getString("dtstart"));
        platel.setDtend(rs.getString("dtend"));
        platel.setRegnpf(rs.getString("regnpf"));
        platel.setPf(rs.getString("pf"));
        platel.setRegnfss(rs.getString("regnfss"));
        platel.setFss(rs.getString("fss"));
        platel.setRegnforms(rs.getString("regnfoms"));
        platel.setFoms(rs.getString("foms"));
        platel.setFilen(rs.getString("filen"));
        platel.setDtpris(rs.getString("dtpris"));
        platel.setPrin(rs.getString("prin"));
        platel.setKuser(rs.getString("kuser"));
        platel.setChis(rs.getString("chis"));
        platel.setPldt(rs.getString("pldt"));
        platel.setVpdt(rs.getString("vpdt"));
        platel.setVpkto(rs.getString("vpkto"));
        return platel;
    }
}
