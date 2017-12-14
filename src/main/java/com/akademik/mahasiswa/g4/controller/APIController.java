package com.akademik.mahasiswa.g4.controller;

import com.akademik.mahasiswa.g4.dao.MahasiswaDAO;
import com.akademik.mahasiswa.g4.model.db.MahasiswaDBModel;
import com.akademik.mahasiswa.g4.model.rest.BaseResponseModel;
import com.akademik.mahasiswa.g4.model.rest.KelasModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class APIController {

    @Autowired
    private MahasiswaDAO mahasiswaDAO;

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

}
