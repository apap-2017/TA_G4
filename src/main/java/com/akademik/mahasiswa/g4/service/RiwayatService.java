package com.akademik.mahasiswa.g4.service;

import com.akademik.mahasiswa.g4.dao.PenilaianDAO;
import com.akademik.mahasiswa.g4.mapper.KelasMapper;
import com.akademik.mahasiswa.g4.mapper.RiwayatMapper;
import com.akademik.mahasiswa.g4.model.db.RiwayatPerkuliahanModel;
import com.akademik.mahasiswa.g4.model.rest.KelasModel;
import com.akademik.mahasiswa.g4.model.rest.NilaiKuliahModel;
import com.akademik.mahasiswa.g4.model.rest.TermModel;
import com.akademik.mahasiswa.g4.model.rest.SemuaNilaiResponseModel;
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
        List<SemuaNilaiResponseModel.NilaiResultModel.NilaiTermModel> nilaiModels = penilaianDAO.getNilaiMahasiswa(npm);
        for(SemuaNilaiResponseModel.NilaiResultModel.NilaiTermModel nilaiModel : nilaiModels){
            TermModel term = nilaiModel.getTerm();
            /**
             * Nilai kuliah merupakan nilai suatu matakuliah
             */
            for(NilaiKuliahModel nilaiKuliah
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
        /**
         * creates holder for nilai kuliah
         */
        Map<String,Integer> nilaiAkhirHolders = new HashMap<>();
        Map<String, String> nilaiHurufHolders = new HashMap<>();
        List<NilaiKuliahModel> nilaiKuliahs = penilaianDAO.getNilaiMahasiswa(npm, tahunAjar, term);
        for(NilaiKuliahModel nilaiKuliah : nilaiKuliahs){
            String key = nilaiKuliah.getKelas().getMatakuliah().getKodeMK();
            nilaiAkhirHolders.put(key, nilaiKuliah.getNilai());
            nilaiHurufHolders.put(key, nilaiKuliah.getNilaiHuruf());
        }

        RiwayatPerkuliahanModel riwayat = riwayatMapper.getRiwayatMahasiswa(npm, tahunAjar, term);
        if(riwayat != null) {
            riwayat.setKelases(kelasService.getKelasByIdRiwayat(riwayat.getId()));
            //set nilai kuliah
            for(KelasModel kelas : riwayat.getKelases()){
                String key = kelas.getKodeMK();
                kelas.setNilaiHuruf(nilaiHurufHolders.get(key));
                kelas.setNilaiAkhir(nilaiAkhirHolders.get(key));
            }
            return riwayat;
        }
        return null;
    }

}
