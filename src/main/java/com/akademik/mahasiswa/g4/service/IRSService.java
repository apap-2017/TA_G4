package com.akademik.mahasiswa.g4.service;

import com.akademik.mahasiswa.g4.dao.JadwalDAO;
import com.akademik.mahasiswa.g4.dao.KurikulumDAO;
import com.akademik.mahasiswa.g4.dao.PenilaianDAO;
import com.akademik.mahasiswa.g4.dao.TermDAO;
import com.akademik.mahasiswa.g4.mapper.KelasMapper;
import com.akademik.mahasiswa.g4.mapper.MahasiswaMapper;
import com.akademik.mahasiswa.g4.mapper.RiwayatMapper;
import com.akademik.mahasiswa.g4.model.db.MahasiswaDBModel;
import com.akademik.mahasiswa.g4.model.db.RiwayatPerkuliahanModel;
import com.akademik.mahasiswa.g4.model.rest.*;
import com.akademik.mahasiswa.g4.model.view.IRSModel;
import com.akademik.mahasiswa.g4.utls.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IRSService {

    @Autowired
    private KelasMapper kelasMapper;
    @Autowired
    private JadwalDAO jadwalDAO;
    @Autowired
    private RiwayatMapper riwayatMapper;
    @Autowired
    private MahasiswaMapper mahasiswaMapper;
    @Autowired
    private RiwayatService riwayatService;
    @Autowired
    private TermDAO termDAO;
    @Autowired
    private KurikulumDAO kurikulumDAO;
    @Autowired
    private KelasService kelasService;
    @Autowired
    private PenilaianDAO penilaianDAO;

    /**
     * Mendapatkan jadwal sekarang yang digunakan untuk memilih IRS
     * @return JadwalMode - berisi jadwal sekarang
     */
    public JadwalModel getJadwalSekarang(){

        //TODO delete dummy
        if(true)
            return getJadwalDummy();

        MahasiswaDBModel mahasiswa = mahasiswaMapper.getMahasiswaByUsername(UserUtils.getUsername());
        JadwalModel jadwalModel = jadwalDAO.getJadwalNow(mahasiswa.getIdUniv(),
                mahasiswa.getIdFakultas(),
                mahasiswa.getIdProdi(),
                mahasiswa.getAngkatan());

        if(jadwalModel == null){
            return null;
        }

        List<Integer> kelasYgUdhDipilih = kelasMapper
                .getIdKelasYangDiambilMahasiswa(
                        jadwalModel.getTerm().getTahunAjar(),
                        jadwalModel.getTerm().getNomor(),
                        mahasiswaMapper.getMahasiswaNPM(UserUtils.getUsername()));

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
        String npm = mahasiswaMapper.getMahasiswaNPM(UserUtils.getUsername());
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

    public IRSModel getIRS() {
        //get npm mahasiswa yang login saat init
        return getIRS(
                mahasiswaMapper.getMahasiswaNPM(UserUtils.getUsername())
        );
    }

    public IRSModel getIRS(String npm) {
        //TODO delete dummy
        if(true)
            return getIrsDummy();

        //jika mahasiswa yang mengakses irs orang lain maka tidak boleh
        if(UserUtils.userRoleIs(UserUtils.ROLE_MAHASISWA) &&
                !npm.equalsIgnoreCase(mahasiswaMapper.getMahasiswaNPM(UserUtils.getUsername()))){
            return null;
        }

        IRSModel irs = new IRSModel();

        //get mahasiswa
        MahasiswaDBModel mahasiswa = mahasiswaMapper.getMahasiswa(npm);
        irs.setMahasiswa(mahasiswa);

        //get irs
        TermModel termNow = termDAO.getTermNow();
        RiwayatPerkuliahanModel riwayat = riwayatService.getRiwayatMahasiswa(npm, termNow.getTahunAjar(), termNow.getNomor());
        if(riwayat == null)
            return null;
        irs.setRiwayat(riwayat);

        //get ip terakhir dan sks maksimum
        TermModel prevTerm = TermUtils.getPrevTermOf(termNow);
        List<KelasModel> prevKelases = kelasService.getKelasYgDiambilMahasiswa(prevTerm.getTahunAjar(), prevTerm.getNomor(), npm);
        //kelasMapper.getKelasYangDiambilMahasiswa(prevTerm.getTahunAjar(), prevTerm.getNomor(), npm);

        int angkatanMahasiswa = Integer.parseInt(mahasiswa.getAngkatan());
        boolean isGoBack = true;
        while (isGoBack) {
            if (prevKelases != null && !prevKelases.isEmpty()) {
                irs.setIpTerakhir(IPUtils.getIPT(prevKelases));
                irs.setSksMaksimum(SKSUtils.getMaxSKSByIP(irs.getIpTerakhir()));
                isGoBack = false;
            } else {
                prevTerm = TermUtils.getPrevTermOf(prevTerm);
                if(angkatanMahasiswa > TermUtils.getYear1FromTahunAjar(prevTerm)){
                    //angkatan awal
                    irs.setIpTerakhir(0);
                    irs.setSksMaksimum(20);
                    isGoBack = false;
                }else{
                    prevKelases = kelasService.getKelasYgDiambilMahasiswa(prevTerm.getTahunAjar(), prevTerm.getNomor(), npm);
                }
            }
        }

        irs.setTotalSKS(SKSUtils.getJumlahSKS(irs.getRiwayat().getKelases()));

        //get total sks lulus
        int totalSKSMahasiswa = 0;
        List<SemuaNilaiResponseModel.NilaiResultModel.NilaiTermModel> nilaiKuliahModels = penilaianDAO.getNilaiMahasiswa(npm);
        for(SemuaNilaiResponseModel.NilaiResultModel.NilaiTermModel nilaiTermModel : nilaiKuliahModels){
            for(NilaiKuliahModel nilaiKuliahModel : nilaiTermModel.getNilaiKuliahs()){
                if(NilaiUtils.isLulus(nilaiKuliahModel.getNilaiHuruf())){
                    totalSKSMahasiswa += nilaiKuliahModel.getKelas().getMatakuliah().getSks();
                }
            }
        }

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
                    if(NilaiUtils.isLulus(currentKelas.getNilaiHuruf())){//tidak lulus
                        erorr.add("Anda tidak bisa mengambil " + kelas.getNamaMK() + " sebelum lulus " + prasyaratMatkul.getNama());
                    }
                }
            }
            //syarat minimal sks
            MatakuliahModel matkul = kurikulumDAO.getMataKuliah(kelas.getKodeMK());
            if(totalSKSMahasiswa < matkul.getSksMinimal()){
                erorr.add("Anda kurang " + (matkul.getSksMinimal() - totalSKSMahasiswa) + " sks untuk mengambil mata kuliah " + kelas.getNamaMK());
            }
        }
        irs.setError(erorr);

        return irs;
    }

    //TODO remove this id back end already
    public IRSModel getIrsDummy(){
        IRSModel irs = new IRSModel();

        MahasiswaDBModel mahasiswa = new MahasiswaDBModel();
        mahasiswa.setNama("Badu");
        mahasiswa.setNpm("1507456898");
        irs.setMahasiswa(mahasiswa);

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
        kelas1.setIdKelas(11);
        kelas1.setSks(4);
        kelas1.setNamaMK("APAP");
        kelas1.setKodeMK("SI-32");
        kelas1.setKurikulum("2016.2017.23");
        kelas1.setNamaKelas("APAP-C");
        kelases.add(kelas1);

        KelasModel kelas2 = new KelasModel();
        kelas2.setIdKelas(12);
        kelas2.setSks(3);
        kelas2.setNamaMK("Adbis");
        kelas2.setKodeMK("SI-31");
        kelas2.setKurikulum("2016.2017.23");
        kelas2.setNamaKelas("Adbis-A");
        kelases.add(kelas2);

        KelasModel kelas3 = new KelasModel();
        kelas3.setIdKelas(13);
        kelas3.setSks(2);
        kelas3.setNamaMK("Basdat");
        kelas3.setKodeMK("IK-11");
        kelas3.setKurikulum("2016.2017.23");
        kelas3.setNamaKelas("Basdat-B");
        kelases.add(kelas3);

        KelasModel kelas4 = new KelasModel();
        kelas4.setIdKelas(14);
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
    private JadwalModel getJadwalDummy() {
        JadwalModel model = new JadwalModel();
        TermModel termModel = new TermModel();
        termModel.setTahunAjar("2017-18");
        termModel.setNomor(3);
        model.setTerm(termModel);

        List<MatakuliahModel> matakuliahModels = new ArrayList<>();
        MatakuliahModel matkul1 = new MatakuliahModel();
        matkul1.setNama("Adbis");
        matkul1.setKurikulum("2017.2016.1.1");
        matkul1.setKodeMK("SI-1");
        matkul1.setSks(2);
        List<KelasModel> kelas11 = new ArrayList<>();
        KelasModel kelas111 = new KelasModel();
        kelas111.setKodeMK(matkul1.getKodeMK());
        kelas111.setKurikulum(matkul1.getKurikulum());
        kelas111.setIdKelas(234);
        kelas111.setNamaMK(matkul1.getNama());
        kelas111.setNamaKelas("Adbis-A");
        kelas111.setSks(matkul1.getSks());
        kelas11.add(kelas111);
        kelas111.setKapasitas(54);
        kelas111.setMahasiswaSaatIni(23);

        List<JadwalKelasModel> jadwalKelasModels11 = new ArrayList<>();
        JadwalKelasModel jadwalKelasModel111 = new JadwalKelasModel();
        jadwalKelasModel111.setHari("Sabtu");
        jadwalKelasModel111.setRuangan("Aula");
        jadwalKelasModel111.setJamMulai("17:00");
        jadwalKelasModel111.setJamAkhir("19:00");
        List<DosenPengajarModel> dosenPengajarModels111 = new ArrayList<>();
        dosenPengajarModels111.add(new DosenPengajarModel("Sukiman"));
        dosenPengajarModels111.add(new DosenPengajarModel("Badu"));
        jadwalKelasModel111.setDosenPengajars(dosenPengajarModels111);
        jadwalKelasModels11.add(jadwalKelasModel111);
        JadwalKelasModel jadwalKelasModel112 = new JadwalKelasModel();
        jadwalKelasModel112.setHari("Jumat");
        jadwalKelasModel112.setRuangan("Aula");
        jadwalKelasModel112.setJamMulai("17:00");
        jadwalKelasModel112.setJamAkhir("19:00");
        List<DosenPengajarModel> dosenPengajarModels112 = new ArrayList<>();
        dosenPengajarModels112.add(new DosenPengajarModel("Sukiman"));
        dosenPengajarModels112.add(new DosenPengajarModel("Badu"));
        jadwalKelasModel112.setDosenPengajars(dosenPengajarModels112);
        jadwalKelasModels11.add(jadwalKelasModel112);
        kelas111.setWaktu(jadwalKelasModels11);

        KelasModel kelas112 = new KelasModel();
        kelas112.setKodeMK(matkul1.getKodeMK());
        kelas112.setKurikulum(matkul1.getKurikulum());
        kelas112.setIdKelas(235);
        kelas112.setNamaMK(matkul1.getNama());
        kelas112.setNamaKelas("Adbis-B");
        kelas112.setSks(matkul1.getSks());
        kelas11.add(kelas112);
        kelas112.setKapasitas(78);
        kelas112.setMahasiswaSaatIni(11);

        List<JadwalKelasModel> jadwalKelasModels112 = new ArrayList<>();
        JadwalKelasModel jadwalKelasModel1121 = new JadwalKelasModel();
        jadwalKelasModel1121.setHari("Selasa");
        jadwalKelasModel1121.setRuangan("Aula");
        jadwalKelasModel1121.setJamMulai("17:00");
        jadwalKelasModel1121.setJamAkhir("19:00");
        List<DosenPengajarModel> dosenPengajarModels1121 = new ArrayList<>();
        dosenPengajarModels1121.add(new DosenPengajarModel("Sukiman"));
        dosenPengajarModels1121.add(new DosenPengajarModel("Badu"));
        jadwalKelasModel1121.setDosenPengajars(dosenPengajarModels1121);
        jadwalKelasModels112.add(jadwalKelasModel1121);
        JadwalKelasModel jadwalKelasModel1122 = new JadwalKelasModel();
        jadwalKelasModel1122.setHari("Kamis");
        jadwalKelasModel1122.setRuangan("1204");
        jadwalKelasModel1122.setJamMulai("17:00");
        jadwalKelasModel1122.setJamAkhir("19:00");
        List<DosenPengajarModel> dosenPengajarModels1122 = new ArrayList<>();
        dosenPengajarModels1122.add(new DosenPengajarModel("Sukiman"));
        dosenPengajarModels1122.add(new DosenPengajarModel("Badu"));
        jadwalKelasModel112.setDosenPengajars(dosenPengajarModels1122);
        jadwalKelasModels112.add(jadwalKelasModel1122);
        kelas112.setWaktu(jadwalKelasModels112);

        KelasModel kelas113 = new KelasModel();
        kelas113.setKodeMK(matkul1.getKodeMK());
        kelas113.setKurikulum(matkul1.getKurikulum());
        kelas113.setIdKelas(237);
        kelas113.setNamaMK(matkul1.getNama());
        kelas113.setNamaKelas("Adbis-C");
        kelas113.setSks(matkul1.getSks());
        kelas113.setKapasitas(154);
        kelas113.setMahasiswaSaatIni(1);

        List<JadwalKelasModel> jadwalKelasModels113 = new ArrayList<>();
        JadwalKelasModel jadwalKelasModel1131 = new JadwalKelasModel();
        jadwalKelasModel1131.setHari("Kamis");
        jadwalKelasModel1131.setRuangan("1102");
        jadwalKelasModel1131.setJamMulai("10:00");
        jadwalKelasModel1131.setJamAkhir("11:00");
        List<DosenPengajarModel> dosenPengajarModels1131 = new ArrayList<>();
        dosenPengajarModels1131.add(new DosenPengajarModel("Koko"));
        dosenPengajarModels1131.add(new DosenPengajarModel("Neko"));
        jadwalKelasModel1131.setDosenPengajars(dosenPengajarModels1131);
        jadwalKelasModels113.add(jadwalKelasModel1131);
        JadwalKelasModel jadwalKelasModel1132 = new JadwalKelasModel();
        jadwalKelasModel1132.setHari("Rabu");
        jadwalKelasModel1132.setRuangan("1103");
        jadwalKelasModel1132.setJamMulai("16:00");
        jadwalKelasModel1132.setJamAkhir("11:00");
        List<DosenPengajarModel> dosenPengajarModels1132 = new ArrayList<>();
        dosenPengajarModels1132.add(new DosenPengajarModel("Siou"));
        dosenPengajarModels1132.add(new DosenPengajarModel("Ahur"));
        jadwalKelasModel1132.setDosenPengajars(dosenPengajarModels1132);
        jadwalKelasModels113.add(jadwalKelasModel1132);
        kelas112.setWaktu(jadwalKelasModels113);
        kelas113.setWaktu(jadwalKelasModels113);
        kelas11.add(kelas113);

        matkul1.setKelas(kelas11);
        matakuliahModels.add(matkul1);

        MatakuliahModel matkul2 = new MatakuliahModel();
        matkul2.setNama("APAP");
        matkul2.setKurikulum("2017.2018.2.1");
        matkul2.setKodeMK("SI-3");
        matkul2.setSks(4);
        List<KelasModel> kelas21 = new ArrayList<>();
        KelasModel kelas211 = new KelasModel();
        kelas211.setWaktu(jadwalKelasModels112);
        kelas211.setKodeMK(matkul2.getKodeMK());
        kelas211.setKurikulum(matkul2.getKurikulum());
        kelas211.setIdKelas(238);
        kelas211.setNamaMK(matkul2.getNama());
        kelas211.setNamaKelas("APAP-A");
        kelas211.setSks(matkul2.getSks());
        kelas211.setMahasiswaSaatIni(23);
        kelas211.setKapasitas(100);
        kelas21.add(kelas211);
        KelasModel kelas212 = new KelasModel();
        kelas212.setWaktu(jadwalKelasModels11);
        kelas212.setKodeMK(matkul2.getKodeMK());
        kelas212.setKurikulum(matkul2.getKurikulum());
        kelas212.setIdKelas(239);
        kelas212.setNamaMK(matkul2.getNama());
        kelas212.setNamaKelas("APAP-B");
        kelas212.setSks(matkul2.getSks());
        kelas212.setMahasiswaSaatIni(343);
        kelas212.setKapasitas(1);
        kelas21.add(kelas212);
        matkul2.setKelas(kelas21);
        matakuliahModels.add(matkul2);

        model.setMatkul(matakuliahModels);

        model.setMatkul(matakuliahModels);

        return model;
    }
}
