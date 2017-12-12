package com.akademik.mahasiswa.g4.dao;

import com.akademik.mahasiswa.g4.mapper.MahasiswaMapper;
import com.akademik.mahasiswa.g4.model.db.MahasiswaDBModel;
import com.akademik.mahasiswa.g4.model.rest.*;
import com.akademik.mahasiswa.g4.utls.NetworkUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KurikulumDAO {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @Autowired
    private SekretariatDAO sekretariatDAO;

    public KurikulumModel getKurikulum(MahasiswaDBModel mahasiswa){

        //get kode kurikulum dulu
        KurikulumModel kurikulum = sekretariatDAO.getKurikulumMahasiswa(mahasiswa.getIdUniv()
                , mahasiswa.getIdFakultas()
                , mahasiswa.getIdProdi()
                , mahasiswa.getAngkatan());

        //return invalid kode kurikulum
        if(kurikulum == null || kurikulum.getKode() == null || kurikulum.getKode().isEmpty()){
            return null;
        }

        KurikulumResponseModel response = restTemplateBuilder
                .build().getForObject(NetworkUtils.BASE_URL_KURIKULUM + "/api/getKurikulum/" + kurikulum.getKode()
                        ,KurikulumResponseModel.class);
        if(response.getStatus() == 200){
            response.getResult().getKurikulum().setKode(kurikulum.getKode());
            kurikulum = response.getResult().getKurikulum();
            return kurikulum;
        }
        return null;
    }

    public List<MatakuliahModel> getPrasyaratMatkul(String kodeMatkul, String kodeKurikulum){

        PrasyaratMatkulResponseModel response = restTemplateBuilder
                .build().getForObject(NetworkUtils.BASE_URL_KURIKULUM + "/api/getPrasyarat/" + kodeMatkul + "/" + kodeKurikulum
                        ,PrasyaratMatkulResponseModel.class);

        if(response.getStatus() == 200){
            return response.getResult().getMatkulPrasyarats();
        }

        return new ArrayList<>();
    }

    public MatakuliahModel getMataKuliah(String npm) {
        SpesifikMatakuliahResponseModel response = restTemplateBuilder
                .build().getForObject(NetworkUtils.BASE_URL_KURIKULUM + "/api/getMataKuliah/" + npm
                ,SpesifikMatakuliahResponseModel.class);
        if(response.getStatus() == 200){
            return response.getResult().getMatakuliahModel();
        }
        return null;
    }
}
