package com.akademik.mahasiswa.g4.mapper;

import com.akademik.mahasiswa.g4.model.db.RiwayatPerkuliahanModel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RiwayatMapper {

    @Select("select id, status_irs as statusIrs, npm, tahun_ajar as tahunAjar, term " +
            "from riwayat_perkuliahan rp" +
            "where rp.npm = #{npm};")
    List<RiwayatPerkuliahanModel> getRiwayatMahasiswa(@Param("npm") String npm);

    @Select("select id from riwayat_perkuliahan " +
            "where npm = #{npm} and tahun_ajar = #{tahunAjar} and term = #{term};")
    Integer getIdRiwayatPerkuliahan(@Param("npm") String npm, @Param("tahunAjar") String tahunAjar, @Param("term") int term);

    @Insert("insert into riwayat_perkuliahan (npm, tahun_ajar, term) " +
            "values(#{npm}, #{tahunAjar}, #{term})")
    void insertRiwayatPerkuliahan(@Param("npm") String npm, @Param("tahunAjar") String tahunAjar, @Param("term") int term);
}
