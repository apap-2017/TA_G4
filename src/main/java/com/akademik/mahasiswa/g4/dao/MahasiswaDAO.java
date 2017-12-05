package com.akademik.mahasiswa.g4.dao;

import com.akademik.mahasiswa.g4.mapper.KelasMapper;
import com.akademik.mahasiswa.g4.mapper.MahasiswaMapper;
import com.akademik.mahasiswa.g4.model.PesertaKuliahModel;
import com.akademik.mahasiswa.g4.model.rest.KelasModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MahasiswaDAO {

    @Autowired
    private KelasMapper kelasMapper;
    @Autowired
    private MahasiswaMapper mahasiswaMapper;


    public PesertaKuliahModel getPesertaKuliah(String tahunAjaran, int term, String kodeMK){

        PesertaKuliahModel pesertaKuliahModel = new PesertaKuliahModel(0,"",null);
        KelasModel kelasModel = kelasMapper.getKelasByKodeMK(kodeMK);
        if(kelasModel != null) {
            kelasModel.setMahasiswa(mahasiswaMapper.getMahasiswaPadaSuatuMatkul(tahunAjaran, term, kodeMK));
            pesertaKuliahModel.setStatus(200);
            pesertaKuliahModel.setMsg("success");
            pesertaKuliahModel.setResult(kelasModel);
        }else{
            pesertaKuliahModel.setStatus(404);
            pesertaKuliahModel.setMsg("kelas not found");
        }
        return pesertaKuliahModel;
    }

}
