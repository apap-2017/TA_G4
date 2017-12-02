package com.akademik.mahasiswa.g4.service;

import com.akademik.mahasiswa.g4.dao.PenilaianDAO;
import com.akademik.mahasiswa.g4.mapper.KelasMapper;
import com.akademik.mahasiswa.g4.mapper.RiwayatMapper;
import com.akademik.mahasiswa.g4.model.db.RiwayatPerkuliahanModel;
import com.akademik.mahasiswa.g4.model.rest.KelasModel;
import com.akademik.mahasiswa.g4.model.rest.TermModel;
import com.akademik.mahasiswa.g4.model.rest.penilaian.NilaiResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RiwayatService {

    @Autowired
    RiwayatMapper riwayatMapper;
    @Autowired
    KelasMapper kelasMapper;
    @Autowired
    PenilaianDAO penilaianDAO;

    public List<RiwayatPerkuliahanModel> getRiwayatMahasiswa(String npm){

        /**
         * holder nilai from api for mapping to model;
         */
        Map<String, Integer> nilaiHolder = new HashMap<>();
        Map<String, String> nilaiHurufHolder = new HashMap<>();

        /**
         * get data from api
         */
        NilaiResponseModel.NilaiResultModel nilaiResult = penilaianDAO.getSeluruhNilaiMahasiswa(npm).getResult();
        for(NilaiResponseModel.NilaiResultModel.NilaiModel nilaiModel : nilaiResult.getNilaiModels()){
            TermModel term = nilaiModel.getTerm();
            for(NilaiResponseModel.NilaiResultModel.NilaiModel.NilaiKuliahModel nilaiKuliah : nilaiModel.getNilaiKuliahs()){
                int nilai = nilaiKuliah.getNilai();
                String nilaiHuruf = nilaiKuliah.getNilaiHuruf();
                String kodeMK = nilaiKuliah.getKelas().getMatakuliah().getKodeMK();
                String key = term.getTahunAjar() + " " + term.getNomor() + " " + kodeMK;
                nilaiHolder.put(key, nilai);
                nilaiHurufHolder.put(key, nilaiHuruf);
            }
        }

        List<RiwayatPerkuliahanModel> riwayatPerkuliahs =
                riwayatMapper.getRiwayatMahasiswa(npm);

        /**
         * build model
         */
        for(RiwayatPerkuliahanModel riwayatPerkuliahan : riwayatPerkuliahs){
            List<KelasModel> kelases = kelasMapper.getKelas(riwayatPerkuliahan.getId());
            for(KelasModel kelas : kelases){
                String key = riwayatPerkuliahan.getTahunAjar()
                        + " " +riwayatPerkuliahan.getTerm()
                        + " " + kelas.getKodeMK();
                kelas.setNilaiAkhir(nilaiHolder.get(key));
                kelas.setNilaiHuruf(nilaiHurufHolder.get(key));
            }
            riwayatPerkuliahan.setKelases(kelases);
        }

        return riwayatPerkuliahs;
    }

}
