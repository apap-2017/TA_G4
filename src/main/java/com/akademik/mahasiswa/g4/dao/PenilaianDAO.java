package com.akademik.mahasiswa.g4.dao;

import com.akademik.mahasiswa.g4.model.rest.NilaiKuliahModel;
import com.akademik.mahasiswa.g4.model.rest.SebagianNilaiResponseModel;
import com.akademik.mahasiswa.g4.model.rest.SemuaNilaiResponseModel;
import com.akademik.mahasiswa.g4.model.rest.SpesifikNilaiResponseModel;
import com.akademik.mahasiswa.g4.utls.NetworkUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PenilaianDAO {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    /**
     * Mendapatkan nilai mahasiswa pada suatu kelas tertentu
     */
    public NilaiKuliahModel getNilaiMahasiswa(int idKelas, String npm){
        SpesifikNilaiResponseModel response = restTemplateBuilder
                .build().getForObject(NetworkUtils.BASE_URL_PENILAIAN + "/api/getNilaiKuliah/" + idKelas + "/" + npm
                        ,SpesifikNilaiResponseModel.class);
        if(response.getStatus() == 200){
            return response.getResult().getNilai();
        }
        return null;
    }

    public List<SemuaNilaiResponseModel.NilaiResultModel.NilaiTermModel> getNilaiMahasiswa(String npm){
        SemuaNilaiResponseModel response = restTemplateBuilder
                .build().getForObject(NetworkUtils.BASE_URL_PENILAIAN + "/api/getNilaiKuliah/" + npm
                        ,SemuaNilaiResponseModel.class);
        if(response.getStatus() == 200){
            return response.getResult().getNilaiModels();
        }
        return new ArrayList<>();
    }

    public List<NilaiKuliahModel> getNilaiMahasiswa(String npm, String tahunAjar, int term){
        SebagianNilaiResponseModel response = restTemplateBuilder
                .build().getForObject(NetworkUtils.BASE_URL_PENILAIAN + "/api/getNilaiKuliah/" + npm + "/" + tahunAjar + "/" + term
                        ,SebagianNilaiResponseModel.class);
        if(response.getStatus() == 200){
            return response.getResult().getNilaiKuliahs();
        }
        return new ArrayList<>();
    }

}
