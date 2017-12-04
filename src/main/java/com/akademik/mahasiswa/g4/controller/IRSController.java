package com.akademik.mahasiswa.g4.controller;

import com.akademik.mahasiswa.g4.model.db.MahasiswaDBModel;
import com.akademik.mahasiswa.g4.model.db.RiwayatPerkuliahanModel;
import com.akademik.mahasiswa.g4.model.rest.*;
import com.akademik.mahasiswa.g4.model.view.IRSModel;
import com.akademik.mahasiswa.g4.service.IRSService;
import com.akademik.mahasiswa.g4.service.KelasService;
import com.akademik.mahasiswa.g4.service.MahasiswaService;
import com.akademik.mahasiswa.g4.service.RiwayatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IRSController {

    @Autowired
    private IRSService irsService;

    @RequestMapping(value = "/irs", method = RequestMethod.GET)
    public String setIRS(Model model){

        JadwalModel jadwalModel = irsService.getJadwalSekarang();
        model.addAttribute("jadwal", jadwalModel);

        return "set-irs";
    }

    @RequestMapping(value = "/irs", method = RequestMethod.POST)
    public String submitIRS(@ModelAttribute("jadwal") JadwalModel jadwalModel){
        irsService.submitIRS(jadwalModel);
        return "lihat-irs";
    }

    @RequestMapping(value = "/irs/{npm}", method = RequestMethod.GET)
    public String lihatIRS(Model model, @PathVariable("npm") String npm){
        IRSModel irs = irsService.getIRS(npm);
        if(irs != null) {
            model.addAttribute("irs", irs);
            return "lihat-irs";
        }else{
            return "not-found-irs";
        }
    }


}
