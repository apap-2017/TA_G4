package com.akademik.mahasiswa.g4.service;

import com.akademik.mahasiswa.g4.mapper.KelasMapper;
import com.akademik.mahasiswa.g4.mapper.RiwayatMapper;
import com.akademik.mahasiswa.g4.model.db.RiwayatPerkuliahanModel;
import com.akademik.mahasiswa.g4.model.rest.KelasModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiwayatService {

    @Autowired
    RiwayatMapper riwayatMapper;
    @Autowired
    KelasMapper kelasMapper;

    public List<RiwayatPerkuliahanModel> getRiwayatMahasiswa(String npm){
        List<RiwayatPerkuliahanModel> riwayatPerkuliahs =
                riwayatMapper.getRiwayatMahasiswa(npm);

        //TODO get api penilaian

        for(RiwayatPerkuliahanModel riwayatPerkuliahan : riwayatPerkuliahs){
            List<KelasModel> kelases = kelasMapper.getKelas(riwayatPerkuliahan.getId());
            riwayatPerkuliahan.setKelases(kelases);
        }

        return riwayatPerkuliahs;
    }

}
