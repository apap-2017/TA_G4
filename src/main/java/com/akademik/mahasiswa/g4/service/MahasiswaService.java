package com.akademik.mahasiswa.g4.service;
import com.akademik.mahasiswa.g4.mapper.MahasiswaMapper;
import com.akademik.mahasiswa.g4.model.db.MahasiswaDBModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@Primary
public class MahasiswaService {

    @Autowired
    private MahasiswaMapper mahasiswaMapper;

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

    public void addUserMahasiswaToDB(MahasiswaDBModel newMahasiswa)
    {
        mahasiswaMapper.addUser(newMahasiswa);
        mahasiswaMapper.addUserRole(newMahasiswa);
        mahasiswaMapper.addMahasiswa(newMahasiswa);
    }



}
