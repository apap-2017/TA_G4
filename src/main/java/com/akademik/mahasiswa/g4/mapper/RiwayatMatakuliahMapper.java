package com.akademik.mahasiswa.g4.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RiwayatMatakuliahMapper {

    @Select("select count(*) from mahasiswa m, matakuliah_yg_diambil_mahasiswa mydm, riwayat_perkuliahan rp \n" +
            "where rp.id = mydm.id_riwayat_perkuliahan \n" +
            "and rp.npm = m.npm \n" +
            "and mydm.id_kelas = #idKelas\n" +
            "and mydm.kode_mata_kuliah = #kodeMK \n" +
            "and rp.tahun_ajar = #tahunAjar \n" +
            "and rp.term = #term;")
    int getJumlahMahasiswa(@Param("idKelas") int idKelas,
                           @Param("kodeMK") String kodeMK,
                                  @Param("tahunAjar") String tahunAjar,
                                  @Param("term") int term);


    List<Integer> getIdKelasIRSMahasiswa();

}
