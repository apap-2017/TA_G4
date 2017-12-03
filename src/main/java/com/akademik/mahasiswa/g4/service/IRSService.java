package com.akademik.mahasiswa.g4.service;

import com.akademik.mahasiswa.g4.dao.JadwalDAO;
import com.akademik.mahasiswa.g4.mapper.KelasMapper;
import com.akademik.mahasiswa.g4.mapper.RiwayatMapper;
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
    @Autowired
    private RiwayatMapper riwayatMapper;

    /**
     * Mendapatkan jadwal sekarang yang digunakan untuk memilih IRS
     * @return JadwalMode - berisi jadwal sekarang
     */
    public JadwalModel getJadwalSekarang(){
        //TODO change idUniv, idFakultas, idProdi with mahasiswa atribut
        //http://localhost:8002/api/getJadwalListNow/1/1/3/2017
        JadwalModel jadwalModel = jadwalDAO.getJadwalNow(1, 1, 3, "2017").getResult();
        for(MatakuliahModel matakuliah : jadwalModel.getMatkul()){
            for(KelasModel kelas : matakuliah.getKelas()){
                int jumlahMhsInKelas = kelasMapper
                        .getJumlahMahasiswa(kelas.getIdKelas(), matakuliah.getKodeMK(),
                                jadwalModel.getTerm().getTahunAjar(),
                                jadwalModel.getTerm().getNomor());
                kelas.setMahasiswaSaatIni(jumlahMhsInKelas);

                //set for save letter in db
                kelas.setKodeMK(matakuliah.getKodeMK());
                kelas.setKurikulum(matakuliah.getKurikulum());
                kelas.setNamaMK(matakuliah.getNama());
                kelas.setSks(matakuliah.getSks());
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

        String tahunAjar = jadwalModel.getTerm().getTahunAjar();
        int term = jadwalModel.getTerm().getNomor();
        String npm = "123456786";//TODO GET NPM FROM SESION;
        Integer idIRS = riwayatMapper.getIdRiwayatPerkuliahan(npm, tahunAjar, term);

        if(idIRS == null){//buat irs pertama kali
            riwayatMapper.insertRiwayatPerkuliahan(npm, tahunAjar, term);
            idIRS = riwayatMapper.getIdRiwayatPerkuliahan(npm, tahunAjar, term);
        }else{//ubah irs
            //menghapus kelas kelas yang sebelumnya dipilih
            kelasMapper.removeKelas(idIRS);
        }

        //save to DB
        if(jadwalModel.getMatkul() == null){//tidak ada matakuliah yang dipilih
        }else {
            for(MatakuliahModel matkul : jadwalModel.getMatkul()){
                if(matkul.getSelectedKelasIdx() != -1) {
                    KelasModel selectedKelas = matkul.getKelas().get(matkul.getSelectedKelasIdx());
                    selectedKelas.setIdRiwayatPerkuliahan(idIRS);
                    kelasMapper.insertKelas(selectedKelas);
                }
            }
        }

    }
}
