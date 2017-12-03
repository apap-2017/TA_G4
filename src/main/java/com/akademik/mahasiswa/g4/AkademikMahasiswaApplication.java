package com.akademik.mahasiswa.g4;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.akademik.mahasiswa.g4.mapper")
public class AkademikMahasiswaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AkademikMahasiswaApplication.class, args);
	}
}
