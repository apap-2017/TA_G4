package com.akademik.mahasiswa.g4.dao;

import com.akademik.mahasiswa.g4.mapper.KelasMapper;
import com.akademik.mahasiswa.g4.mapper.MahasiswaMapper;
import com.akademik.mahasiswa.g4.model.db.MahasiswaDBModel;
import com.akademik.mahasiswa.g4.model.rest.BaseResponseModel;
import com.akademik.mahasiswa.g4.model.rest.KelasModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MahasiswaDAO {

    @Autowired
    private KelasMapper kelasMapper;
    @Autowired
    private MahasiswaMapper mahasiswaMapper;


    public BaseResponseModel<KelasModel> getAPIPesertaKuliah(String tahunAjaran, int term, String kodeMK){

        BaseResponseModel<KelasModel> responseModel = new BaseResponseModel<>();
        KelasModel kelasModel = kelasMapper.getKelasByKodeMK(kodeMK);
        if(kelasModel != null) {
            kelasModel.setMahasiswa(mahasiswaMapper.getMahasiswaPadaSuatuMatkul(tahunAjaran, term, kodeMK));
            responseModel.setStatus(HttpStatus.OK.value());
            responseModel.setMsg(HttpStatus.OK.getReasonPhrase());
            responseModel.setResult(kelasModel);
        }else{
            responseModel.setStatus(HttpStatus.NOT_FOUND.value());
            responseModel.setMsg("mata kuliah dengan kode " + kodeMK + " tidak ditemukan");
        }
        return responseModel;
    }

    public BaseResponseModel<MahasiswaDBModel> getAPIMahasiswa(String npm){
        BaseResponseModel<MahasiswaDBModel> responseModel = new BaseResponseModel<>();
        MahasiswaDBModel mahasiswa = mahasiswaMapper.getMahasiswa(npm);
        if(mahasiswa != null) {
            responseModel.setStatus(HttpStatus.OK.value());
            responseModel.setMsg(HttpStatus.OK.getReasonPhrase());
            responseModel.setResult(mahasiswa);
        } else {
            responseModel.setStatus(HttpStatus.NOT_FOUND.value());
            responseModel.setMsg("mahasiswa dengan npm " + npm + " tidak ditemukan");
        }
        return responseModel;
    }

    public BaseResponseModel<List<MahasiswaDBModel>> getAPIMahasiswaAll(){
        BaseResponseModel<List<MahasiswaDBModel>> responseModel = new BaseResponseModel<>();
        List<MahasiswaDBModel> allMahasiswa = mahasiswaMapper.getAllMahasiswa();
        if(allMahasiswa != null) {
            responseModel.setStatus(HttpStatus.OK.value());
            responseModel.setMsg(HttpStatus.OK.getReasonPhrase());
            responseModel.setResult(allMahasiswa);
        } else {
            responseModel.setStatus(HttpStatus.NOT_FOUND.value());
            responseModel.setMsg("tidak ada mahasiswa yang terdaftar");
        }
        return responseModel;
    }
}
