package com.akademik.mahasiswa.g4.controller;

import com.akademik.mahasiswa.g4.dao.MahasiswaDAO;
import com.akademik.mahasiswa.g4.model.PesertaKuliahModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class APIController {

    @Autowired
    private MahasiswaDAO mahasiswaDAO;

    @RequestMapping("/getPesertaKuliah/{term}/{tahunAjar}/{kodeMK}")
    public PesertaKuliahModel getPeserta(@PathVariable("tahunAjar") String tahunAjar,
                                         @PathVariable("term") int term,
                                         @PathVariable("kodeMK") String kodeMK){
        System.out.println(">>>>>>>>>>> tahunAjar : " + tahunAjar);
        System.out.println(">>>>>>>>>>> term : " + term);
        System.out.println(">>>>>>>>>>> kodeMK : " + kodeMK);
        return mahasiswaDAO.getPesertaKuliah(tahunAjar, term, kodeMK);
    }

}
