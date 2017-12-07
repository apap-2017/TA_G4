package com.akademik.mahasiswa.g4.mapper;

import com.akademik.mahasiswa.g4.model.db.MahasiswaDBModel;
import com.akademik.mahasiswa.g4.model.rest.FakultasModel;
import com.akademik.mahasiswa.g4.model.rest.ProdiModel;
import com.akademik.mahasiswa.g4.model.rest.UnivModel;
import org.apache.ibatis.annotations.*;

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

    @Select("select nama, npm, angkatan, id_universitas as idUniv from mahasiswa")
    List<MahasiswaDBModel> getAllMahasiswa();

    @Select("select m.npm, m.nama, m.username, m.id_universitas as idUniv, m.id_fakultas as idFakultas, m.id_prodi as idProdi, m.angkatan " +
            "from mahasiswa m " +
            "where m.npm = #{npm};")
    MahasiswaDBModel getMahasiswa(@Param("npm") String npm);

    @Delete("DELETE FROM mahasiswa WHERE npm = #{npm}")
    int deleteMahasiswa (@Param("npm") String npm);


    @Insert("INSERT INTO user (username, password, enabled) VALUES (#{username}, #{password}, 1)")
    void addUser (MahasiswaDBModel newMahasiswa);

    @Insert("INSERT INTO user_role (username, role) VALUES (#{username}, 'ROLE_MAHASISWA')")
    void addUserRole (MahasiswaDBModel newMahasiswa);

    @Insert("INSERT INTO mahasiswa (nama, npm, username, id_universitas, id_fakultas, id_prodi, angkatan) VALUES" +
            " (#{nama}, #{npm}, #{username}, #{idUniv}, #{idFakultas}, #{idProdi}, #{angkatan})")
    void addMahasiswa (MahasiswaDBModel newMahasiswa);
}
