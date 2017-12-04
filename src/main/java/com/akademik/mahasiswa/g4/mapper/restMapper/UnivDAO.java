package com.akademik.mahasiswa.g4.mapper.restMapper;


import com.akademik.mahasiswa.g4.model.rest.FakultasModel;
import com.akademik.mahasiswa.g4.model.rest.ProdiModel;
import com.akademik.mahasiswa.g4.model.rest.UnivModel;

import java.util.List;

public interface UnivDAO
{
    List<UnivModel> getAllUniv();
    List<FakultasModel> getAllFakultas();
    List<ProdiModel> getAllProdi();

}
