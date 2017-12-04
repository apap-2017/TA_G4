package com.akademik.mahasiswa.g4.controller;

import com.akademik.mahasiswa.g4.model.db.MahasiswaDBModel;
import com.akademik.mahasiswa.g4.model.rest.UnivModel;
import com.akademik.mahasiswa.g4.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private MahasiswaService mahasiswaDAO;

    @RequestMapping("/admin/addmahasiswa")
    public String goToAddmahasiswa(Model model)
    {
        model.addAttribute("univs", mahasiswaDAO.getAllUniv());
        model.addAttribute("fakults", mahasiswaDAO.getAllFakultas());
        model.addAttribute("prodis", mahasiswaDAO.getAllProdi());

        model.addAttribute("page_title", "Add Mahasiswa");
        return "add-mahasiswa-form";
    }

    @RequestMapping("/admin/addmahasiswa/submit")
    public String addMahasiswa()
    {
        return "add-mahasiswa-sukses";
    }

}
