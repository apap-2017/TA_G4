package com.akademik.mahasiswa.g4.controller;

import com.akademik.mahasiswa.g4.dao.MahasiswaDAO;
import com.akademik.mahasiswa.g4.model.PesertaKuliahModel;
import com.akademik.mahasiswa.g4.model.rest.MahasiswaAPIModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class APIController {

    @Autowired
    private MahasiswaDAO mahasiswaDAO;

    @RequestMapping("/getPesertaKuliah/{term}/{tahunAjar}/{kodeMK}")
    public PesertaKuliahModel getPeserta(@PathVariable("tahunAjar") Optional<String> tahunAjar,
                                         @PathVariable("term") Optional<Integer> term,
                                         @PathVariable("kodeMK") Optional<String> kodeMK){

        return mahasiswaDAO.getPesertaKuliah(tahunAjar.get(), term.get(), kodeMK.get());

    }

    @RequestMapping("/getMahasiswa/{npm}")
    public MahasiswaAPIModel get(@PathVariable("npm") String npm){
        MahasiswaAPIModel result = mahasiswaDAO.getMahasiswa(npm);

        if(npm.isEmpty()){
            MahasiswaAPIModel errorModel = new MahasiswaAPIModel(0,"",null);
            errorModel.setStatus(404);
            errorModel.setMsg("not found");
            return errorModel;
        }

        return result;
    }
}
