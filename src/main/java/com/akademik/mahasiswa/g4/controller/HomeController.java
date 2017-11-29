package com.akademik.mahasiswa.g4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/login")
    public String login()
    {
        return "login";
    }

    @RequestMapping("/mahasiswa")
    public String dashboardMahasiswa()
    {
        return "dashboard-mahasiswa";
    }


}
