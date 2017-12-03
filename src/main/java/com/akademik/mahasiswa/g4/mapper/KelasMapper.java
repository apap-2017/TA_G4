package com.akademik.mahasiswa.g4.mapper;

import com.akademik.mahasiswa.g4.model.rest.KelasModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface KelasMapper {

    @Select("select count(*) from mahasiswa m, kelas k, riwayat_perkuliahan rp " +
            "where rp.id = k.id_riwayat_perkuliahan " +
            "and rp.npm = m.npm " +
            "and k.id_kelas = #{idKelas} " +
            "and k.kode_mata_kuliah = #{kodeMK} " +
            "and rp.tahun_ajar = #{tahunAjar} " +
            "and rp.term = #{term};")
    int getJumlahMahasiswa(@Param("idKelas") int idKelas,
                           @Param("kodeMK") String kodeMK,
                                  @Param("tahunAjar") String tahunAjar,
                                  @Param("term") int term);


    @Select("select k.id_riwayat_perkuliahan as idRiwayatPerkuliahan, " +
            "k.id_kelas as idKelas, " +
            "k.tanggal_pengisian as tanggalPengisian, " +
            "k.kode_mata_kuliah as kodeMK, " +
            "k.kode_kurikulum as kurikulum " +
            "k.nama_mata_kuliah as namaMK" +
            "k.nama_kelas as namaKelas" +
            "k.sks " +
            "from kelas k, riwayat_perkuliahan rp, mahasiswa m " +
            "where k.id_riwayat_perkuliahan = rp.id " +
            "and rp.npm = m.npm " +
            "and rp.tahun_ajar = #tahunAjar " +
            "and rp.term = #term \n" +
            "and m.npm = #{npm};")
    List<KelasModel> getKelasYangDiambilMahasiswa(@Param("tahunAjar") String tahunAjar,
                                                  @Param("term") int term,
                                                  @Param("npm") String npm);

    @Select("select k.id_riwayat_perkuliahan as idRiwayatPerkuliahan, " +
            "k.id_kelas as idKelas, " +
            "k.tanggal_pengisian as tanggalPengisian, " +
            "k.kode_mata_kuliah as kodeMK, " +
            "k.kode_kurikulum as kurikulum " +
            "k.nama_mata_kuliah as namaMK" +
            "k.nama_kelas as namaKelas" +
            "k.sks " +
            "from kelas k, riwayat_perkuliahan rp, mahasiswa m " +
            "where k.id_riwayat_perkuliahan = rp.id " +
            "and rp.npm = m.npm " +
            "and m.npm = #{npm};")
    List<KelasModel> getAllKelasYangDiambilMahasiswa(@Param("npm") String npm);

    @Select("select k.id_riwayat_perkuliahan as idRiwayatPerkuliahan, " +
            "k.id_kelas as idKelas, " +
            "k.tanggal_pengisian as tanggalPengisian, " +
            "k.kode_mata_kuliah as kodeMK, " +
            "k.kode_kurikulum as kurikulum " +
            "k.nama_mata_kuliah as namaMK" +
            "k.nama_kelas as namaKelas" +
            "k.sks " +
            "from kelas k, riwayat_perkuliahan rp, " +
            "where k.id_riwayat_perkuliahan = rp.id " +
            "and rp.id = #{idRiwayatPerkuliahan};")
    List<KelasModel> getKelas(@Param("idRiwayatPerkuliahan") int idRiwayatPerkuliahan);

    @Delete("delete from kelas where id_riwayat_perkuliahan = #{idRiwayatPerkuliahan};")
    void removeKelas(@Param("idRiwayatPerkuliahan") int idRiwayatPerkuliahan);

    @Select("select nama_mata_kuliah as namaMK , kode_mata_kuliah as kodeMK, kode_kurikulum as kurikulum, sks " +
            "from kelas " +
            "where kode_mata_kuliah = #{kodeMK} " +
            "limit 1;")
    KelasModel getKelasByKodeMK(@Param("kodeMK") String kodeMK);

    @Insert("insert into kelas (id_riwayat_perkuliahan, kode_mata_kuliah, kode_kurikulum, id_kelas, nama_mata_kuliah, nama_kelas, sks) " +
            "values (#{kelas.idRiwayatPerkuliahan}, #{kelas.kodeMK}, #{kelas.kurikulum}, #{kelas.idKelas}, #{kelas.namaMK}, #{kelas.namaKelas}, #{kelas.sks}) ;")
    void insertKelas(@Param("kelas") KelasModel selectedIdKelas);
}
