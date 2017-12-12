package com.akademik.mahasiswa.g4.service;

import com.akademik.mahasiswa.g4.dao.PenilaianDAO;
import com.akademik.mahasiswa.g4.mapper.KelasMapper;
import com.akademik.mahasiswa.g4.model.rest.KelasModel;
import com.akademik.mahasiswa.g4.model.rest.NilaiKuliahModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class KelasService {

    @Autowired
    private KelasMapper kelasMapper;
    @Autowired
    private PenilaianDAO penilaianDAO;

    public List<KelasModel> getKelasByIdRiwayat(int idRiwayat){
        return kelasMapper.getKelas(idRiwayat);
    }

    public KelasModel getKelasWithNilai(String npm, String kodeMK) {
        KelasModel kelas = kelasMapper.getKelasByKodeMK(kodeMK);
        //TODO get nilai
//        penilaianDAO.getNilaiMahasiswa(npm, kodeMK);
        return kelas;
    }

    public List<KelasModel> getKelasYgDiambilMahasiswa(String tahunAjar, int term, String npm) {

        List<NilaiKuliahModel> nilaiKuliahs = penilaianDAO.getNilaiMahasiswa(npm, tahunAjar, term);
        Map<String, Integer> nilaikAkhir = new HashMap<>();
        Map<String, String> nilaiHuruf = new HashMap<>();
        for(NilaiKuliahModel nilaiKuliah : nilaiKuliahs){
            String key = nilaiKuliah.getKelas().getMatakuliah().getKodeMK();
            nilaikAkhir.put(key, nilaiKuliah.getNilai());
            nilaiHuruf.put(key, nilaiKuliah.getNilaiHuruf());
        }

        List<KelasModel> kelases = kelasMapper.getKelasYangDiambilMahasiswa(tahunAjar, term, npm);
        for(KelasModel kelas : kelases){
            String key = kelas.getKodeMK();
            kelas.setNilaiAkhir(nilaikAkhir.getOrDefault(key,-1));
            kelas.setNilaiHuruf(nilaiHuruf.getOrDefault(key,"-"));
        }

        return kelases;
    }
}
