package com.akademik.mahasiswa.g4.mapper;

import com.akademik.mahasiswa.g4.model.db.MahasiswaDBModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MahasiswaMapper {

    @Select("select m.npm, m.nama, m.username, m.id_universitas as idUniv, m.id_fakultas as idFakultas, m.id_prodi as idProdi, m.angkatan " +
            "from mahasiswa m, riwayat_perkuliahan rp, kelas k " +
            "where m.npm = rp.npm " +
            "and rp.id = k.id_riwayat_perkuliahan " +
            "and rp.tahun_ajar = #{tahunAjar} " +
            "and rp.term = #{term} " +
            "and k.kode_mata_kuliah = #{kodeMK};")
    List<MahasiswaDBModel> getMahasiswaPadaSuatuMatkul(@Param("tahunAjar") String tahunAjar,
                                                       @Param("term") int term,
                                                       @Param("kodeMK") String kodeMK);

}