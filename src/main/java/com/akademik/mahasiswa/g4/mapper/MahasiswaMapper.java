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

    @Select("select nama, npm, angkatan, id_universitas as idUniv from mahasiswa where angkatan = #{angkatan}")
    List<MahasiswaDBModel> getMahasiswaBerdasarkanAngkatan(@Param("angkatan") String angkatan);

    @Select("select m.npm, m.nama, m.username, m.id_universitas as idUniv, m.id_fakultas as idFakultas, m.id_prodi as idProdi, m.angkatan " +
            "from mahasiswa m " +
            "where m.npm = #{npm};")
    MahasiswaDBModel getMahasiswa(@Param("npm") String npm);

    @Select("select password from user where username = #{username}")
    String getPassword(@Param("username") String username);

    @Delete("DELETE FROM mahasiswa WHERE npm = #{npm}")
    void deleteMahasiswaDB (@Param("npm") String npm);

    @Delete("DELETE FROM mahasiswa WHERE npm = #{npm}")
    int deleteMahasiswa (@Param("npm") String npm);

    @Delete("DELETE FROM user_role WHERE username = #{username}")
    void deleteUserRole (@Param("username") String username);

    @Delete("DELETE FROM user WHERE username = #{username}")
    void deleteUser (@Param("username") String username);

    @Update("update user set username = #{username}, password = #{password}, enabled = 1 where username = #{username}")
    void updateUser(MahasiswaDBModel newMahasiswa);

    @Update("update user_role set username = #{username}, role = 'ROLE_MAHASISWA' where username = #{username}")
    void updateUserRole(MahasiswaDBModel newMahasiswa);

    @Update("update mahasiswa set nama = #{nama}, npm = #{npm}, username = #{username}, id_universitas = #{idUniv}, " +
            "id_fakultas = #{idFakultas}, id_prodi = #{idProdi}, angkatan = #{angkatan} where username = #{username}")
    void updateMahasiswa(MahasiswaDBModel newMahasiswa);

    @Insert("INSERT INTO user (username, password, enabled) VALUES (#{username}, #{password}, 1)")
    void addUser (MahasiswaDBModel newMahasiswa);

    @Insert("INSERT INTO user_role (username, role) VALUES (#{username}, 'ROLE_MAHASISWA')")
    void addUserRole (MahasiswaDBModel newMahasiswa);

    @Insert("INSERT INTO mahasiswa (nama, npm, username, id_universitas, id_fakultas, id_prodi, angkatan) VALUES" +
            " (#{nama}, #{npm}, #{username}, #{idUniv}, #{idFakultas}, #{idProdi}, #{angkatan})")
    void addMahasiswa (MahasiswaDBModel newMahasiswa);

    @Select("SELECT npm FROM mahasiswa WHERE username = #{username}")
    String getMahasiswaNPM(@Param("username") String username);

    @Select("select m.npm, m.nama, m.username, m.id_universitas as idUniv, m.id_fakultas as idFakultas, m.id_prodi as idProdi, m.angkatan " +
            "from mahasiswa m " +
            "where m.username = #{username};")
    MahasiswaDBModel getMahasiswaByUsername(@Param("username") String username);
}
