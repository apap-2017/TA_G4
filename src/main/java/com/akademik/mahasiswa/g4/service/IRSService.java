package com.akademik.mahasiswa.g4.service;

import com.akademik.mahasiswa.g4.dao.JadwalDAO;
import com.akademik.mahasiswa.g4.mapper.RiwayatMatakuliahMapper;
import com.akademik.mahasiswa.g4.model.rest.JadwalModel;
import com.akademik.mahasiswa.g4.model.rest.KelasModel;
import com.akademik.mahasiswa.g4.model.rest.MatakuliahModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IRSService {

    @Autowired
    private RiwayatMatakuliahMapper riwayatMatakuliahMapper;
    @Autowired
    private JadwalDAO jadwalDAO;

    /**
     * Mendapatkan jadwal sekarang yang digunakan untuk memilih IRS
     * @return JadwalMode - berisi jadwal sekarang
     */
    public JadwalModel getJadwalSekarang(){
        //TODO change idUniv, idFakultas, idProdi with mahasiswa atribut
        JadwalModel jadwalModel = jadwalDAO.getJadwalNow(1, 2, 3).getResult();
        for(MatakuliahModel matakuliah : jadwalModel.getMatkul()){
            for(KelasModel kelas : matakuliah.getKelas()){
                int jumlahMhsInKelas = riwayatMatakuliahMapper
                        .getJumlahMahasiswa(kelas.getIdKelas(), matakuliah.getKodeMK(),
                                jadwalModel.getTerm().getTahunAjar(),
                                jadwalModel.getTerm().getNomor());
                kelas.setMahasiswaSaatIni(jumlahMhsInKelas);
            }
        }
        return jadwalModel;
    }

}
