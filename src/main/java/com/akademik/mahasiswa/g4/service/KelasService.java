package com.akademik.mahasiswa.g4.service;

import com.akademik.mahasiswa.g4.mapper.KelasMapper;
import com.akademik.mahasiswa.g4.model.rest.KelasModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KelasService {

    @Autowired
    private KelasMapper kelasMapper;

    public List<KelasModel> getKelasByIdRiwayat(int idRiwayat){
        return kelasMapper.getKelas(idRiwayat);
    }
}
