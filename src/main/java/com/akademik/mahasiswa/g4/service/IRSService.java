package com.akademik.mahasiswa.g4.service;

import com.akademik.mahasiswa.g4.dao.JadwalDAO;
import com.akademik.mahasiswa.g4.dao.KurikulumDAO;
import com.akademik.mahasiswa.g4.dao.TermDAO;
import com.akademik.mahasiswa.g4.mapper.KelasMapper;
import com.akademik.mahasiswa.g4.mapper.RiwayatMapper;
import com.akademik.mahasiswa.g4.model.db.MahasiswaDBModel;
import com.akademik.mahasiswa.g4.model.db.RiwayatPerkuliahanModel;
import com.akademik.mahasiswa.g4.model.rest.*;
import com.akademik.mahasiswa.g4.model.view.IRSModel;
import com.akademik.mahasiswa.g4.utls.IPUtils;
import com.akademik.mahasiswa.g4.utls.SKSUtils;
import com.akademik.mahasiswa.g4.utls.TermUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IRSService {

    @Autowired
    private KelasMapper kelasMapper;
    @Autowired
    private JadwalDAO jadwalDAO;
    @Autowired
    private RiwayatMapper riwayatMapper;
    @Autowired
    private MahasiswaService mahasiswaService;
    @Autowired
    private RiwayatService riwayatService;
    @Autowired
    private TermDAO termDAO;
    @Autowired
    private KurikulumDAO kurikulumDAO;
    @Autowired
    private KelasService kelasService;

    /**
     * Mendapatkan jadwal sekarang yang digunakan untuk memilih IRS
     * @return JadwalMode - berisi jadwal sekarang
     */
    public JadwalModel getJadwalSekarang(){
        //TODO change idUniv, idFakultas, idProdi with mahasiswa atribut
        //http://localhost:8002/api/getJadwalListNow/1/1/3/2017
        JadwalModel jadwalModel = jadwalDAO.getJadwalNow(1, 1, 1, "2016");

        if(jadwalModel == null){
            return null;
        }

        //TODO get irs yang dipilih mahasiswa jika ada
        //TODO get NPM dari sesion
        List<Integer> kelasYgUdhDipilih = kelasMapper
                .getIdKelasYangDiambilMahasiswa(
                        jadwalModel.getTerm().getTahunAjar(),
                        jadwalModel.getTerm().getNomor(),
                        "123456786");

        System.out.println(">>>>>>>>>>> " +kelasYgUdhDipilih.toString());

        for(MatakuliahModel matakuliah : jadwalModel.getMatkul()){
            for(int i = 0 ; i < matakuliah.getKelas().size() ; i++){
                KelasModel kelas = matakuliah.getKelas().get(i);
                int jumlahMhsInKelas = kelasMapper
                        .getJumlahMahasiswa(kelas.getIdKelas(), matakuliah.getKodeMK(),
                                jadwalModel.getTerm().getTahunAjar(),
                                jadwalModel.getTerm().getNomor());
                kelas.setMahasiswaSaatIni(jumlahMhsInKelas);

                //set for save letter in db
                kelas.setKodeMK(matakuliah.getKodeMK());
                kelas.setKurikulum(matakuliah.getKurikulum());
                kelas.setNamaMK(matakuliah.getNama());
                kelas.setSks(matakuliah.getSks());

                if(kelasYgUdhDipilih.contains(kelas.getIdKelas()))
                    matakuliah.setSelectedKelasIdx(i);
            }
        }
        return jadwalModel;
    }

    public void submitIRS(JadwalModel jadwalModel) {

        String tahunAjar = jadwalModel.getTerm().getTahunAjar();
        int term = jadwalModel.getTerm().getNomor();
        String npm = "123456786";//TODO GET NPM FROM SESION;
        Integer idIRS = riwayatMapper.getIdRiwayatPerkuliahan(npm, tahunAjar, term);

        if(idIRS == null){//buat irs pertama kali
            riwayatMapper.insertRiwayatPerkuliahan(npm, tahunAjar, term);
            idIRS = riwayatMapper.getIdRiwayatPerkuliahan(npm, tahunAjar, term);
        }else{//ubah irs
            //menghapus kelas kelas yang sebelumnya dipilih
            kelasMapper.removeKelas(idIRS);
        }

        //save to DB
        if(jadwalModel.getMatkul() == null){//tidak ada matakuliah yang dipilih
        }else {
            for(MatakuliahModel matkul : jadwalModel.getMatkul()){

                if(matkul.getSelectedKelasIdx() != -1) {
                    KelasModel kelas = matkul.getKelas().get(matkul.getSelectedKelasIdx());
                    System.out.println(">>>>>>>> " + kelas);
                    kelas.setIdRiwayatPerkuliahan(idIRS);
                    kelasMapper.insertKelas(kelas);
                }

            }
        }

    }

    public IRSModel getIRS(String npm) {

        IRSModel irs = new IRSModel();

        //get mahasiswa
        MahasiswaDBModel mahasiswa = mahasiswaService.getMahasiswa(npm);
        irs.setMahasiswa(mahasiswa);

        //get irs
        TermModel termNow = termDAO.getTermNow();
        RiwayatPerkuliahanModel riwayat = riwayatService.getRiwayatMahasiswa(npm, termNow.getTahunAjar(), termNow.getNomor());
        if(riwayat == null)
            return null;
        irs.setRiwayat(riwayat);

        //get ip terakhir dan sks maksimum
        TermModel prevTerm = TermUtils.getPrevTermOf(termNow);
        List<KelasModel> prevKelases = kelasMapper.getKelasYangDiambilMahasiswa(prevTerm.getTahunAjar(), prevTerm.getNomor(), npm);

        int angkatanMahasiswa = Integer.parseInt(mahasiswa.getAngkatan());
        boolean isGoBack = true;
        while (isGoBack) {
            if (prevKelases != null && !prevKelases.isEmpty()) {
                irs.setIpTerakhir(IPUtils.getIP(prevKelases));
                irs.setSksMaksimum(SKSUtils.getMaxSKSByIP(irs.getIpTerakhir()));
                isGoBack = false;
            } else {
                prevTerm = TermUtils.getPrevTermOf(prevTerm);
                if(angkatanMahasiswa > TermUtils.getYear1FromTahunAjar(prevTerm)){
                    irs.setIpTerakhir(0);
                    irs.setSksMaksimum(20);
                    isGoBack = false;
                }else{
                    prevKelases = kelasMapper.getKelasYangDiambilMahasiswa(prevTerm.getTahunAjar(), prevTerm.getNomor(), npm);
                }
            }
        }

        irs.setTotalSKS(SKSUtils.getJumlahSKS(irs.getRiwayat().getKelases()));

        //set error
        List<String> erorr = new ArrayList<>();
        if(irs.getSksMaksimum() < irs.getTotalSKS())
            erorr.add("SKS melebih batas bung!");
        for(KelasModel kelas : irs.getRiwayat().getKelases()){
            List<MatakuliahModel> prasyaratMatkuls = kurikulumDAO.getPrasyaratMatkul(kelas.getKodeMK(), kelas.getKurikulum());
            for(MatakuliahModel prasyaratMatkul : prasyaratMatkuls ){
                KelasModel currentKelas = kelasService.getKelasWithNilai(npm, prasyaratMatkul.getKodeMK());
                if(currentKelas == null){//belum mengambil
                    erorr.add("Anda tidak bisa mengambil " + kelas.getNamaMK() + " sebelum mengambil " + prasyaratMatkul.getNama());
                }else{//
                    if(55 > currentKelas.getNilaiAkhir()){//tidak lulus
                        erorr.add("Anda tidak bisa mengambil " + kelas.getNamaMK() + " sebelum lulus " + prasyaratMatkul.getNama());
                    }
                }
            }
        }
        irs.setError(erorr);

        return irs;
    }

    public IRSModel getIrsDummy(){
        IRSModel irs = new IRSModel();
        irs.setTotalSKS(22);
        irs.setIpTerakhir(3.89);
        irs.setSksMaksimum(24);
        List<String> error = new ArrayList<>();
        error.add("SKS kekurangan");
        error.add("Kecepetan isi IRS");
        error.add("IRS udah tutup");
        irs.setError(error);
        RiwayatPerkuliahanModel riwayatPerkuliahanModel = new RiwayatPerkuliahanModel();
        riwayatPerkuliahanModel.setNpm("123456798");
        riwayatPerkuliahanModel.setStatusIrs(true);
        riwayatPerkuliahanModel.setTahunAjar("2017-18");
        riwayatPerkuliahanModel.setTerm(1);
        List<KelasModel> kelases = new ArrayList<>();

        KelasModel kelas1 = new KelasModel();
        kelas1.setSks(4);
        kelas1.setNamaMK("APAP");
        kelas1.setKodeMK("SI-32");
        kelas1.setKurikulum("2016.2017.23");
        kelas1.setNamaKelas("APAP-C");
        kelases.add(kelas1);

        KelasModel kelas2 = new KelasModel();
        kelas2.setSks(3);
        kelas2.setNamaMK("Adbis");
        kelas2.setKodeMK("SI-31");
        kelas2.setKurikulum("2016.2017.23");
        kelas2.setNamaKelas("Adbis-A");
        kelases.add(kelas2);

        KelasModel kelas3 = new KelasModel();
        kelas3.setSks(2);
        kelas3.setNamaMK("Basdat");
        kelas3.setKodeMK("IK-11");
        kelas3.setKurikulum("2016.2017.23");
        kelas3.setNamaKelas("Basdat-B");
        kelases.add(kelas3);

        KelasModel kelas4 = new KelasModel();
        kelas4.setSks(6);
        kelas4.setNamaMK("Propensi");
        kelas4.setKodeMK("SI-111");
        kelas4.setKurikulum("2016.2017.23");
        kelas4.setNamaKelas("Propensi-K");
        kelases.add(kelas4);

        riwayatPerkuliahanModel.setKelases(kelases);
        irs.setRiwayat(riwayatPerkuliahanModel);
        return irs;
    }


}
