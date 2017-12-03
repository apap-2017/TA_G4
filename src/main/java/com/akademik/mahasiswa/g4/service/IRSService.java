package com.akademik.mahasiswa.g4.service;

import com.akademik.mahasiswa.g4.dao.JadwalDAO;
import com.akademik.mahasiswa.g4.mapper.KelasMapper;
import com.akademik.mahasiswa.g4.model.rest.JadwalModel;
import com.akademik.mahasiswa.g4.model.rest.KelasModel;
import com.akademik.mahasiswa.g4.model.rest.MatakuliahModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IRSService {

    @Autowired
    private KelasMapper kelasMapper;
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
                int jumlahMhsInKelas = kelasMapper
                        .getJumlahMahasiswa(kelas.getIdKelas(), matakuliah.getKodeMK(),
                                jadwalModel.getTerm().getTahunAjar(),
                                jadwalModel.getTerm().getNomor());
                kelas.setMahasiswaSaatIni(jumlahMhsInKelas);
            }
        }
        return jadwalModel;
    }

    public List<KelasModel> getKelasPadaIRSMahasiswa(String npm){
        String tahunAjar = ""; //TODO change this with Tahun Ajar IRS
        int term = 0; //TODO change this with Term IRS
        List<KelasModel> idKelas = kelasMapper.getKelasYangDiambilMahasiswa(tahunAjar, term, npm);
        return idKelas;
    }

    public void submitIRS(JadwalModel jadwalModel) {
        List<Integer> selectedId = new ArrayList<>();
        for(MatakuliahModel matkul : jadwalModel.getMatkul()){

        }
    }
}
