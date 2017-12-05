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
    @Autowired
    KelasService kelasService;

    public List<RiwayatPerkuliahanModel> getAllRiwayatMahasiswa(String npm){

        /**
         * holder nilai from api for mapping to model;
         */
        Map<String, Integer> nilaiHolder = new HashMap<>();
        Map<String, String> nilaiHurufHolder = new HashMap<>();

        /**
         * get data from api penilaian
         */
        List<NilaiResponseModel.NilaiResultModel.NilaiModel> nilaiModels = penilaianDAO.getSeluruhNilaiMahasiswa(npm);
        for(NilaiResponseModel.NilaiResultModel.NilaiModel nilaiModel : nilaiModels){
            TermModel term = nilaiModel.getTerm();
            /**
             * Nilai kuliah merupakan nilai suatu matakuliah
             */
            for(NilaiResponseModel.NilaiResultModel.NilaiModel.NilaiKuliahModel nilaiKuliah
                    : nilaiModel.getNilaiKuliahs()){
                //get all data
                int nilai = nilaiKuliah.getNilai();
                String nilaiHuruf = nilaiKuliah.getNilaiHuruf();
                String kodeMK = nilaiKuliah.getKelas().getMatakuliah().getKodeMK();
                String key = term.getTahunAjar()
                        + " " + term.getNomor()
                        + " " + kodeMK;
                //save to holder
                nilaiHolder.put(key, nilai);
                nilaiHurufHolder.put(key, nilaiHuruf);
            }
        }

        //get semua riwayat mahasiswa without kelas
        List<RiwayatPerkuliahanModel> riwayatPerkuliahs =
                riwayatMapper.getAllRiwayatMahasiswa(npm);

        /**
         * build model
         */
        for(RiwayatPerkuliahanModel riwayatPerkuliahan : riwayatPerkuliahs){
            //get semua kelas yang diambil pada suatu riwayat per term
            List<KelasModel> kelases = kelasMapper.getKelas(riwayatPerkuliahan.getId());
            for(KelasModel kelas : kelases){
                //populate nilai from holder
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

    public RiwayatPerkuliahanModel getRiwayatMahasiswa(String npm, String tahunAjar, int term){
        //TODO add API Penilaian for getting nilai in some term
        RiwayatPerkuliahanModel riwayat = riwayatMapper.getRiwayatMahasiswa(npm, tahunAjar, term);
        if(riwayat != null) {
            riwayat.setKelases(kelasService.getKelasByIdRiwayat(riwayat.getId()));
            return riwayat;
        }
        return null;
    }

}
