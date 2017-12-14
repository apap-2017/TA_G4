# Aplikasi Akademik Mahasiswa


Base url: `http://localhost:8004`

API List:
* [getMahasiswa](#getmahasiswa)
* [getPesertaKuliah](#getpesertakuliah)
* [getMahasiswaByAngkatan](#getmahasiswabyangkatan)
* [getMahasiswaByUniv](#getmahasiswabyuniv)
* [getListMahasiswa](#getlistmahasiswa)


## getMahasiswa

Mengembalikan objek mahasiswa dengan npm dari input

**URL** : `/api/getMahasiswa/{npm}

**Method** : `GET`

### Success Response

**Contoh Request**: [/api/getMahasiswa/987654321](http://localhost:8004/api/getMahasiswa/987654321)

```json
{
	"Status":200,
    "Message":"success",
    "Result":{
        "nama":"Badu", 
        "id_univ":"1",
        "id_fakultas":"1",
        "id_prodi":"1",
        "angkatan":"2016"
    }

```

### Error Response

**Condition** : Jika npm tidak valid.

**Contoh Request**: [api/getMahasiswa/1](http://localhost:8004/api/getMahasiswa/1)

```json
{
  "status": 404,
  "msg": "API tidak ditemukan",
  "result": null
}
```

## getPesertaKuliah

Mendapatkan mahasiswa-mahasiswa yang mengambil mata kuliah pada term dan tahun tertentu

**URL** : `/api/getPesertaKuliah/{term}/{tahun}/{kode_matkul}`

**Method** : `GET`

### Success Response

**Contoh Request**: [/api/getPesertaKuliah/1/2015/K123](http://localhost:8004/api/getPesertaKuliah/1/2017/K123)

```json
{
    "Status":200,
    "Message":"success",
    "Result":
    {
        "id" : 1, 
        "nama" : "Kombistek", 
        "kode_mata_kuliah" : "K123", 
        "id_term" : 1, 
        "tahun_ajar" : "2017/2018", 
        "mahasiswa" :{
            "nama":"Badu", 
            "id_univ":"1",
            "id_fakultas":"1",
            "id_prodi":"1",
            "angkatan":"2016"}
        }
}

```

### Error Response

**Condition** : Jika term, tahun atau kode mata kuliah tidak valid.

**Contoh Request**: [/api/getPesertaKuliah/1/2018/CSC12](http://localhost:8004/api/getStudentKurikulum/1/2018/CSC12)

```json
{
  "status": 404,
  "msg": "API tidak ditemukan",
  "result": null
}
```

## getMahasiswaByAngkatan

Mendapatkan list mahasiswa berdasarkan angkatan

**URL** : `/api/mahasiswa/list/angkatan/{angkatan}`

**Method** : `GET`

### Success Response

**Contoh Request**: [/api/mahasiswa/list/angkatan/2016](http://localhost:8004/api/mahasiswa/list/angkatan/2016)

```json
{
	"status":200,
	"msg":"OK",
	"result":[					
		{ 
			"npm":"987654321",
			"nama":"Badu",
			"username":"username1",
			"idUniv":1,
			"idFakultas":1,
			"idProdi":1,
			"angkatan":"2016"
		},
		{
			"npm":"987654322",
			"nama":"Budi",
			"username":"username2",
			"idUniv":1,
			"idFakultas":1,
			"idProdi":1,
			"angkatan":"2016"
		},
		{
			"npm":"987654323",
			"nama":"Ayu",
			"username":"username3",
			"idUniv":1,
			"idFakultas":1,
			"idProdi":1,
			"angkatan":"2016"
		}
	]
}
```

### Error Response

**Condition** : Jika angkatan tidak valid.

**Contoh Request**: [/api/mahasiswa/list/angkatan/2019](http://localhost:8004/api/mahasiswa/list/angkatan/2019)

```json
{
  "status": 404,
  "msg": "API tidak ditemukan",
  "result": null
}
```

## getMahasiswaByUniv

Mendapatkan list mahasiswa berdasarkan ID universitas

**URL** : `/api/mahasiswa/univ/1`

**Method** : `GET`

### Success Response

**Contoh Request**: [/api/mahasiswa/univ/1](http://localhost:8004/api/mahasiswa/univ/1)

```json
{
	"status":200,
	"msg":"OK",
	"result":[	
		{	
			"npm":"987654321",
			"nama":"Badu",
			"username":"username1",			
			"idUniv":1,
			"idFakultas":1,
			"idProdi":1,
			"angkatan":"2016"
		},
		{
			"npm":"987654322",
			"nama":"Budi",
			"username":"username2",
			"idUniv":1,
			"idFakultas":1,
			"idProdi":1,
			"angkatan":"2016"
		},
		{
			"npm":"987654323",
			"nama":"Ayu",
			"username":"username3",
			"idUniv":1,
			"idFakultas":1,
			"idProdi":1,
			"angkatan":"2016"
		}
	]
}
```

### Error Response

**Condition** : Jika idUniv tidak valid.

**Contoh Request**: [/api/mahasiswa/univ/5](http://localhost:8004/api/mahasiswa/univ/5)

```json
{
  "status": 404,
  "msg": "API tidak ditemukan",
  "result": null
}
```

## getListMahasiswa

Mengembalikan list seluruh mahasiswa

**URL** : `/api/mahasiswa/list`

**Method** : `GET`

### Success Response

**Contoh Request**: [/api/mahasiswa/list](http://localhost:8004/api/mahasiswa/list)

```json
{

    "status":200,
    "msg":"OK",
    "result":[
        {
            "npm":"987654321",
            "nama":"Badu",
            "username":"username1",
            "idUniv":1,
            "idFakultas":0,
            "idProdi":0,
            "angkatan":"2016"
        },
        {
            "npm":"987654322",
            "nama":"Budi",
            "username":"username2",
            "idUniv":1,
            "idFakultas":0,
            "idProdi":0,
            "angkatan":"2016"
        },
        {
            "npm":"987654323",
            "nama":"Ayu",
            "username":"username3",
            "idUniv":1,
            "idFakultas":0,
            "idProdi":0,
            "angkatan":"2016"
        }
    ]
}
```
