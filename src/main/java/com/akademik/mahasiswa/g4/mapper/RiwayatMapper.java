package com.akademik.mahasiswa.g4.mapper;

import com.akademik.mahasiswa.g4.model.db.RiwayatPerkuliahanModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RiwayatMapper {

    @Select("select id, status_irs as statusIrs, npm, tahun_ajar as tahunAjar, term " +
            "from riwayat_perkuliahan rp" +
            "where rp.npm = #npm;")
    List<RiwayatPerkuliahanModel> getRiwayatMahasiswa(@Param("npm") String npm);

}
