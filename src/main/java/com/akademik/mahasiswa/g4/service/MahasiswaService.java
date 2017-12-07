package com.akademik.mahasiswa.g4.service;
import com.akademik.mahasiswa.g4.dao.UnivDAO;
import com.akademik.mahasiswa.g4.mapper.MahasiswaMapper;
import com.akademik.mahasiswa.g4.model.db.MahasiswaDBModel;
import com.akademik.mahasiswa.g4.model.rest.UnivModel;
import com.akademik.mahasiswa.g4.model.rest.UnivResponseModel;
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

    @Autowired
    private UnivDAO univDAO;

    public MahasiswaDBModel getMahasiswa(String npm)
    {
        return mahasiswaMapper.getMahasiswa(npm);
    }


    public MahasiswaDBModel getMahasiswaWithUniv(String npm)
    {
        MahasiswaDBModel mahasiswa = mahasiswaMapper.getMahasiswa(npm);
        if(mahasiswa == null) {
            return mahasiswa;
        }

        String idUniv = Integer.toString(mahasiswa.getIdUniv());
        UnivResponseModel univ = univDAO.getUniv(idUniv);
        mahasiswa.setNamaUniv(univ.getResult().getUniversitas().getNamaUniv());
        return mahasiswa;
    }

    public List<MahasiswaDBModel> getAllMahasiswa()
    {
        List<MahasiswaDBModel> mahasiswas = mahasiswaMapper.getAllMahasiswa();

        for(int i = 0; i< mahasiswas.size(); i++) {
            String idUniv = Integer.toString(mahasiswas.get(i).getIdUniv());
            UnivResponseModel univ = univDAO.getUniv(idUniv);
            mahasiswas.get(i).setNamaUniv(univ.getResult().getUniversitas().getNamaUniv());
        }

        return mahasiswas;
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
