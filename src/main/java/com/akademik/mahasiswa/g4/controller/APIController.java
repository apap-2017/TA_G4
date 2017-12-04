package com.akademik.mahasiswa.g4.controller;

import com.akademik.mahasiswa.g4.dao.MahasiswaDAO;
import com.akademik.mahasiswa.g4.model.PesertaKuliahModel;
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

        if(!tahunAjar.isPresent() || !term.isPresent() || !kodeMK.isPresent()){
            PesertaKuliahModel errorModel = new PesertaKuliahModel(0,"",null);
            errorModel.setStatus(404);
            errorModel.setMsg("not found");
            return errorModel;
        }

        return mahasiswaDAO.getPesertaKuliah(tahunAjar.get(), term.get(), kodeMK.get());

    }

}
