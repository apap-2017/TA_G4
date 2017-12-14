package com.akademik.mahasiswa.g4.service;

import com.akademik.mahasiswa.g4.dao.PenilaianDAO;
import com.akademik.mahasiswa.g4.mapper.KelasMapper;
import com.akademik.mahasiswa.g4.mapper.MahasiswaMapper;
import com.akademik.mahasiswa.g4.mapper.RiwayatMapper;
import com.akademik.mahasiswa.g4.model.db.RiwayatPerkuliahanModel;
import com.akademik.mahasiswa.g4.model.rest.KelasModel;
import com.akademik.mahasiswa.g4.model.rest.NilaiKuliahModel;
import com.akademik.mahasiswa.g4.model.rest.TermModel;
import com.akademik.mahasiswa.g4.model.rest.SemuaNilaiResponseModel;
import com.akademik.mahasiswa.g4.utls.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Autowired
    MahasiswaMapper mahasiswaMapper;

    public List<RiwayatPerkuliahanModel> getAllRiwayatMahasiswa(){
        return getAllRiwayatMahasiswa(
                mahasiswaMapper.getMahasiswaNPM(UserUtils.getUsername())
        );
    }

    public List<RiwayatPerkuliahanModel> getAllRiwayatMahasiswa(String npm){

//        //TODO remove this dummy
//        if(true)
//            return getRiwayatDummy();

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
                String key = term.getTahunAjar().trim()
                        + " " + term.getNomor()
                        + " " + kodeMK.trim();
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
                String key = riwayatPerkuliahan.getTahunAjar().trim()
                        + " " +riwayatPerkuliahan.getTerm()
                        + " " + kelas.getKodeMK().trim();
                kelas.setNilaiAkhir(nilaiHolder.getOrDefault(key, -1));
                kelas.setNilaiHuruf(nilaiHurufHolder.getOrDefault(key, "-"));
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
                kelas.setNilaiHuruf(nilaiHurufHolders.getOrDefault(key, "-"));
                kelas.setNilaiAkhir(nilaiAkhirHolders.getOrDefault(key,-1));
            }
            return riwayat;
        }
        return null;
    }

    //TODO remove this if back end already
    private List<RiwayatPerkuliahanModel> getRiwayatDummy(){
        List<RiwayatPerkuliahanModel> riwayats = new ArrayList<>();

        RiwayatPerkuliahanModel riwayat1 = new RiwayatPerkuliahanModel();

        riwayat1.setTerm(1);
        riwayat1.setTahunAjar("2016-17");
        List<KelasModel> kelas11 = new ArrayList<>();

        KelasModel kelas111 = new KelasModel();
        kelas111.setKodeMK("SI1");
        kelas111.setKurikulum("2016.2017.1.1");
        kelas111.setNamaMK("Administrasi Bisnis");
        kelas111.setNamaKelas("Adbis-A");
        kelas111.setSks(3);
        kelas111.setNilaiAkhir(85);
        kelas111.setNilaiHuruf("A");
        kelas11.add(kelas111);

        KelasModel kelas114 = new KelasModel();
        kelas114.setKodeMK("SI3");
        kelas114.setKurikulum("2014.2016.1.2");
        kelas114.setNamaMK("Statistika dan Pobablitas");
        kelas114.setNamaKelas("Statprob-A");
        kelas114.setSks(3);
        kelas114.setNilaiAkhir(83);
        kelas114.setNilaiHuruf("A-");
        kelas11.add(kelas114);

        KelasModel kelas113 = new KelasModel();
        kelas113.setKodeMK("SI2");
        kelas113.setKurikulum("2016.2017.1.1");
        kelas113.setNamaMK("Prinsip - Prinsip Manajemen");
        kelas113.setNamaKelas("PPM-B");
        kelas113.setSks(3);
        kelas113.setNilaiAkhir(79);
        kelas113.setNilaiHuruf("B+");
        kelas11.add(kelas113);

        KelasModel kelas112 = new KelasModel();
        kelas112.setKodeMK("SI4");
        kelas112.setKurikulum("2016.2017.1.1");
        kelas112.setNamaMK("Dasar - Dasar Pemrograman");
        kelas112.setNamaKelas("DDP-A");
        kelas112.setSks(6);
        kelas112.setNilaiAkhir(80);
        kelas112.setNilaiHuruf("A-");
        kelas11.add(kelas112);

        riwayat1.setKelases(kelas11);

        riwayats.add(riwayat1);




        RiwayatPerkuliahanModel riwayat2 = new RiwayatPerkuliahanModel();

        riwayat2.setTerm(2);
        riwayat2.setTahunAjar("2016-17");
        List<KelasModel> kelas21 = new ArrayList<>();

        KelasModel kelas211 = new KelasModel();
        kelas211.setKodeMK("CI1");
        kelas211.setKurikulum("2016.2017.1.1");
        kelas211.setNamaMK("Administrasi Bisnis Lanjut");
        kelas211.setNamaKelas("Adbisjut-K");
        kelas211.setSks(3);
        kelas211.setNilaiAkhir(85);
        kelas211.setNilaiHuruf("A");
        kelas21.add(kelas211);

        KelasModel kelas214 = new KelasModel();
        kelas214.setKodeMK("CI3");
        kelas214.setKurikulum("2014.2016.1.2");
        kelas214.setNamaMK("Arsitektur dan Pemrograman Komputer");
        kelas214.setNamaKelas("APK-A");
        kelas214.setSks(3);
        kelas214.setNilaiAkhir(83);
        kelas214.setNilaiHuruf("A-");
        kelas21.add(kelas214);

        KelasModel kelas213 = new KelasModel();
        kelas213.setKodeMK("CI2");
        kelas213.setKurikulum("2016.2017.1.1");
        kelas213.setNamaMK("Proyek Manajemen");
        kelas213.setNamaKelas("Manpro-B");
        kelas213.setSks(3);
        kelas213.setNilaiAkhir(81);
        kelas213.setNilaiHuruf("A-");
        kelas21.add(kelas213);

        KelasModel kelas212 = new KelasModel();
        kelas212.setKodeMK("CI4");
        kelas212.setKurikulum("2016.2017.1.1");
        kelas212.setNamaMK("Sistem Interaksi");
        kelas212.setNamaKelas("Sister-A");
        kelas212.setSks(3);
        kelas212.setNilaiAkhir(87);
        kelas212.setNilaiHuruf("A");
        kelas21.add(kelas212);

        riwayat2.setKelases(kelas21);

        riwayats.add(riwayat2);


        return riwayats;
    }

}
