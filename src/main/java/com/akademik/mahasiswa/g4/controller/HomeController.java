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

    @RequestMapping("/admin")
    public String home()
    {
        return "home-admin";
    }

    @RequestMapping("/mahasiswa")
    public String ringkasanMahasiswa()
    {
        return "ringkasan-mahasiswa";
    }

    @RequestMapping("/mahasiswa/riwayat")
    public String riwayatMahasiswa()
    {
        return "riwayat-mahasiswa";
    }

    @RequestMapping("/mahasiswa/irs")
    public String irsMahasiswa()
    {
        return "lihat-irs-mahasiswa";
    }

    @RequestMapping("/admin/viewallmahasiswa")
    public String viewallMahasiswa()
    {
        return "viewall-mahasiswa";
    }

    @RequestMapping("/irs")
    public String isiIrs()
    {
        return "isi-irs-mahasiswa";
    }

}
