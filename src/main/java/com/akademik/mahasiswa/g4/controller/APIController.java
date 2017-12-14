package com.akademik.mahasiswa.g4.controller;

import com.akademik.mahasiswa.g4.dao.MahasiswaDAO;
import com.akademik.mahasiswa.g4.dao.SekretariatDAO;
import com.akademik.mahasiswa.g4.dao.UnivDAO;
import com.akademik.mahasiswa.g4.model.db.MahasiswaDBModel;
import com.akademik.mahasiswa.g4.model.rest.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class APIController {

    @Autowired
    private MahasiswaDAO mahasiswaDAO;
    @Autowired
    private UnivDAO univDAO;
    @Autowired
    private SekretariatDAO sekretariatDAO;

    @RequestMapping(value = {"**"})
    public BaseResponseModel index(){
        return new BaseResponseModel(HttpStatus.NOT_FOUND.value()
                , "API tidak ditemukan", null);
    }

    @RequestMapping(value = {"/peserta-kuliah/{term}/{tahunAjar}/{kodeMK}"
            ,"/peserta-kuliah/**"
            ,"/peserta-kuliah"})
    public BaseResponseModel<KelasModel> getPeserta(@PathVariable("tahunAjar") Optional<String> tahunAjar,
                                        @PathVariable("term") Optional<Integer> term,
                                        @PathVariable("kodeMK") Optional<String> kodeMK){

        if(!tahunAjar.isPresent() || !term.isPresent() || !kodeMK.isPresent()){
            return new BaseResponseModel<>(HttpStatus.NOT_FOUND.value()
                    ,"kurang data tahun ajar, term, atau kode mata kuliah pada url path"
                    ,null);
        }

        return mahasiswaDAO.getAPIPesertaKuliah(tahunAjar.get(), term.get(), kodeMK.get());

    }

    @RequestMapping(value = {"/mahasiswa/{npm}", "/mahasiswa**"})
    public BaseResponseModel<MahasiswaDBModel> get(@PathVariable("npm") Optional<String> npm){

        if(!npm.isPresent()){
            return new BaseResponseModel<>(HttpStatus.NOT_FOUND.value()
                    , "kurang data npm pada url path"
                    , null);
        }

        return mahasiswaDAO.getAPIMahasiswa(npm.get());

    }

    @RequestMapping(value = "/mahasiswa/list")
    public BaseResponseModel<List<MahasiswaDBModel>> getAllMahasiswa(){
        return mahasiswaDAO.getAPIMahasiswaAll();
    }

    @RequestMapping(value = {"/mahasiswa/list/angkatan/{angkatan}", "/mahasiswa/list/angkatan/**"})
    public BaseResponseModel<List<MahasiswaDBModel>> getMahasiswaBerdasarkanAngkatan(@PathVariable("angkatan") Optional<String> angkatan){

        if(!angkatan.isPresent()){
            return new BaseResponseModel<>(HttpStatus.NOT_FOUND.value()
                    , "kurang data angkatan pada url path"
                    , null);
        }

        return mahasiswaDAO.getMahasiswaBerdasarkanAngkatan(angkatan.get());
    }

    @RequestMapping(value = "/mahasiswa/univ/{idUniv}")
    public BaseResponseModel<List<MahasiswaDBModel>> getMahasiswaBerdasarkanUniv(@PathVariable("idUniv") Optional<Integer> idUniv){

        if(!idUniv.isPresent()){
            return new BaseResponseModel<>(HttpStatus.NOT_FOUND.value()
                    , "kurang data ID Univ pada url path"
                    , null);
        }

        return mahasiswaDAO.getMahasiswaBerdasarkanUniv(idUniv.get());
    }

    @RequestMapping(value = "/getListFakultas/{id_univ}")
    public List<FakultasModel> getListFakultas(@PathVariable("id_univ") int idUniv){
        FakultasResponseModel response =  univDAO.getAllFakultasUniv(idUniv);
        if(response.getStatus() == 200){
            return response.getResult().getListFakultas();
        }
        return new ArrayList<>();
    }

    @RequestMapping(value = "/getListProdi/{id_univ}/{id_fakultas}")
    public List<ProdiModel> getListPodi(@PathVariable("id_univ") int idUniv,
                                          @PathVariable("id_fakultas") int idFakultas){
        ProdiResponseModel response =  univDAO.getAllProdiFakultas(idUniv,idFakultas);
        if(response.getStatus() == 200){
            return response.getResult().getListProdi();
        }
        return new ArrayList<>();
    }

    @RequestMapping(value = "/getAngkatan/{id_univ}/{id_fakultas}/{id_prodi}")
    public List<AngkatanModel> getAngkatanAktif(@PathVariable("id_univ") int idUniv,
                                                @PathVariable("id_fakultas") int idFakultas,
                                                @PathVariable("id_prodi") int idProdi){
        return sekretariatDAO.getAngkatanAktif(idUniv,idFakultas,idProdi);
    }


}
