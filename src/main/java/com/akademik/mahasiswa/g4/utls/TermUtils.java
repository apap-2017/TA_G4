package com.akademik.mahasiswa.g4.utls;

import com.akademik.mahasiswa.g4.model.rest.TermModel;

import java.util.StringTokenizer;

public class TermUtils {

    public static TermModel getPrevTermOf(TermModel termModel){
        TermModel prevTerm = new TermModel();
        if(termModel.getNomor() > 1){
            prevTerm.setNomor(termModel.getNomor()-1);
            prevTerm.setTahunAjar(termModel.getTahunAjar());
        }else{
            prevTerm.setNomor(3);

            StringTokenizer tokenTahunAjar = new StringTokenizer(termModel.getTahunAjar(),"-");
            int year1 = Integer.parseInt(tokenTahunAjar.nextToken());
            int year2 = Integer.parseInt(tokenTahunAjar.nextToken());
            year1--;
            year2--;
            prevTerm.setTahunAjar(year1 + "-" + year2);
        }
        return prevTerm;
    }

    public static int getYear1FromTahunAjar(TermModel prevTerm) {
        StringTokenizer tahunAjarToken = new StringTokenizer(prevTerm.getTahunAjar(), "-");
        return Integer.parseInt(tahunAjarToken.nextToken());
    }
}
