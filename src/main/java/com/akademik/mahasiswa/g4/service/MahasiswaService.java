package com.akademik.mahasiswa.g4.service;

import com.akademik.mahasiswa.g4.mapper.MahasiswaMapper;
import com.akademik.mahasiswa.g4.model.db.MahasiswaDBModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MahasiswaService {

    @Autowired
    MahasiswaMapper mahasiswaMapper;

    public MahasiswaDBModel getMahasiswa(String npm){
        return mahasiswaMapper.getMahasiswa(npm);
    }

    public String deleteMahasiswa(String npm){
        if(mahasiswaMapper.deleteMahasiswa(npm) == -1){
            return "gagal";
        } else {
            return "berhasil";
        }
    }
}
