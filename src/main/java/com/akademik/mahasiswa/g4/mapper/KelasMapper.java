package com.akademik.mahasiswa.g4.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface KelasMapper {

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


    @Select("select k.id_kelas \n" +
            "from kelas k, riwayat_perkuliahan rp, mahasiswa m \n" +
            "where k.id_riwayat_perkuliahan = rp.id \n" +
            "and rp.npm = m.npm \n" +
            "and rp.tahun_ajar = #tahunAjar \n" +
            "and rp.term = #term \n" +
            "and m.npm = #npm;")
    List<Integer> getIdKelasYangDiambilMahasiswa(@Param("tahunAjar") String tahunAjar,
                                         @Param("term") int term,
                                         @Param("npm") String npm);

}
