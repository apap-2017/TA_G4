package com.akademik.mahasiswa.g4.service;
import com.akademik.mahasiswa.g4.dao.UnivDAO;
import com.akademik.mahasiswa.g4.mapper.MahasiswaMapper;
import com.akademik.mahasiswa.g4.model.db.MahasiswaDBModel;
import com.akademik.mahasiswa.g4.model.rest.FakultasModel;
import com.akademik.mahasiswa.g4.model.rest.ProdiModel;
import com.akademik.mahasiswa.g4.model.rest.UnivModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@Primary
public class UnivService {

    @Autowired
    private UnivDAO univDAO;

    public List<UnivModel> getAllUniv()
    {
        List<UnivModel> univs = univDAO.getAllUniv().getResult().getListUniv();
        return univs;
    }

    public String checkUniv(String univ)
    {
        List<UnivModel> univs = univDAO.getAllUniv().getResult().getListUniv();
        int i = 0;
        while(i < univs.size()) {
            if(univ.equalsIgnoreCase(univs.get(i).getNamaUniv())) {
                return "valid-univ";
            }else {
                i++;
            }
        }
        return "invalid-univ";
    }


    public String convertUniv(String univ)
    {
        List<UnivModel> univs = univDAO.getAllUniv().getResult().getListUniv();

        int i = 0;
        while(i < univs.size()) {
            if(univ.equalsIgnoreCase(univs.get(i).getNamaUniv())) {
                return univs.get(i).getIdUniv();
            }else {
                i++;
            }
        }
        return "cant convert";
    }

    public String checkFakultas(String idUniv, String fakultas)
    {
        List<FakultasModel> fakults = univDAO.getAllFakultasUniv(idUniv).getResult().getListFakultas();

        int i = 0;
        while(i < fakults.size()) {
            if(fakultas.equalsIgnoreCase(fakults.get(i).getNamaFakultas())) {
                return "valid-fakultas";
            }else {
                i++;
            }
        }
        return "invalid-fakultas";
    }

    public String convertFakultas(String idUniv, String fakultas)
    {
        List<FakultasModel> fakults = univDAO.getAllFakultasUniv(idUniv).getResult().getListFakultas();

        int i = 0;
        while(i < fakults.size()) {
            if(fakultas.equalsIgnoreCase(fakults.get(i).getNamaFakultas())) {
                return fakults.get(i).getIdFakultas();
            }else {
                i++;
            }
        }
        return "cant convert";
    }

    public String checkProdi(String idUniv, String idFakultas, String prodi)
    {
        List<ProdiModel> prodis = univDAO.getAllProdiFakultas(idUniv, idFakultas).getResult().getListProdi();

        int i = 0;
        while(i < prodis.size()) {
            if(prodi.equalsIgnoreCase(prodis.get(i).getNamaProdi())) {
                return "valid-prodi";
            }else {
                i++;
            }
        }
        return "invalid-prodi";
    }

    public String convertProdi(String idUniv, String idFakultas, String prodi)
    {
        List<ProdiModel> prodis = univDAO.getAllProdiFakultas(idUniv, idFakultas).getResult().getListProdi();

        int i = 0;
        while(i < prodis.size()) {
            if(prodi.equalsIgnoreCase(prodis.get(i).getNamaProdi())) {
                return prodis.get(i).getIdProdi();
            }else {
                i++;
            }
        }
        return "cant convert";
    }
}
