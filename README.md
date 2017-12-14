# Aplikasi Sekretariat


Base url: `http://localhost:8002`

API List:
* [getAngkatanAktif](#getangkatanaktif)
* [getStudentKurikulum](#getstudentkurikulum)
* [getAllTerm](#getallterm)
* [getTermNow](#gettermnow)
* [getTermByIdTerm](#gettermbyidterm)
* [getTerm](#getterm)
* [getKelas](#getkelas)
* [getListMatkul](#getlistmatkul)
* [getListKelas](#getlistkelas)
* [getKelasList](#getkelaslist)
* [getJadwalListNow](#getjadwallistnow)
* [getJadwalList](#getjadwallist)
* [getMatkulDiajar](#getmatkuldiajar)

## getAngkatanAktif

Mengembalikan daftar angkatan yang aktif beserta kurikulumnya

**URL** : `/api/getAngkatanAktif/{id_univ}/{id_fakultas}/{id_prodi}`

**Method** : `GET`

### Success Response

**Contoh Request**: [/api/getAngkatanAktif/1/1/1](http://localhost:8002/api/getAngkatanAktif/1/1/1)

```json
{
  "status": 200,
  "msg": "success",
  "result": {
    "pengaturan_kurikulum_list": [
      {
        "id_univ": 1,
        "id_fakultas": 1,
        "id_prodi": 1,
        "angkatan": 2017,
        "kode_kurikulum": "U1-F1-P1-1",
        "nama_kurikulum": null
      },
      {
        "id_univ": 1,
        "id_fakultas": 1,
        "id_prodi": 1,
        "angkatan": 2016,
        "kode_kurikulum": "U1-F1-P1-1",
        "nama_kurikulum": null
      },
      {
        "id_univ": 1,
        "id_fakultas": 1,
        "id_prodi": 1,
        "angkatan": 2015,
        "kode_kurikulum": "U1-F1-P1-1",
        "nama_kurikulum": null
      },
      {
        "id_univ": 1,
        "id_fakultas": 1,
        "id_prodi": 1,
        "angkatan": 2010,
        "kode_kurikulum": "U1-F1-P1-2",
        "nama_kurikulum": null
      }
    ]
  }
}
```

### Error Response

**Condition** : Jika id_univ tidak valid.

**Contoh Request**: [api/getAngkatanAktif/100/1/1](http://localhost:8002/api/getAngkatanAktif/100/1/1)

```json
{
  "status": 404,
  "msg": "Universitas tidak ditemukan",
  "result": null
}
```

**Condition** : Jika id_fakultas tidak valid.

**Contoh Request**: [/api/getAngkatanAktif/1/100/1](http://localhost:8002/api/getAngkatanAktif/1/100/1)

```json
{
  "status": 404,
  "msg": "Fakultas tidak ditemukan",
  "result": null
}
```

**Condition** : Jika id_prodi tidak valid.

**Contoh Request**: [api/getAngkatanAktif/1/1/100](http://localhost:8002/api/getAngkatanAktif/1/1/100)

```json
{
  "status": 404,
  "msg": "Prodi tidak ditemukan",
  "result": null
}
```

## getStudentKurikulum

Mendapatkan kurikulum dari suatu angkatan

**URL** : `/api/getStudentKurikulum/{id_univ}/{id_fakultas}/{id_prodi}/{angkatan}`

**Method** : `GET`

### Success Response

**Contoh Request**: [/api/getStudentKurikulum/1/1/1/2017](http://localhost:8002/api/getStudentKurikulum/1/1/1/2017)

```json
{
  "status": 200,
  "msg": "success",
  "result": {
    "pengaturan_kurikulum": {
      "id_univ": 1,
      "id_fakultas": 1,
      "id_prodi": 1,
      "angkatan": 2017,
      "kode_kurikulum": "U1-F1-P1-1",
      "nama_kurikulum": null
    }
  }
}
```

### Error Response

**Condition** : Jika id_univ tidak valid.

**Contoh Request**: [/api/getStudentKurikulum/100/1/1/2015](http://localhost:8002/api/getStudentKurikulum/100/1/1/2015)

```json
{
  "status": 404,
  "msg": "Universitas tidak ditemukan",
  "result": null
}
```

**Condition** : Jika id_fakultas tidak valid.

**Contoh Request**: [/api/getStudentKurikulum/1/100/1/2015](http://localhost:8002/api/getStudentKurikulum/1/100/1/2015)

```json
{
  "status": 404,
  "msg": "Fakultas tidak ditemukan",
  "result": null
}
```

**Condition** : Jika id_prodi tidak valid.

**Contoh Request**: [/api/getStudentKurikulum/1/1/100/2015](http://localhost:8002/api/getStudentKurikulum/1/1/100/2015)

```json
{
  "status": 404,
  "msg": "Prodi tidak ditemukan",
  "result": null
}
```

**Condition** : Jika angkatan tidak valid.

**Contoh Request**: [/api/getStudentKurikulum/1/1/1/9999](http://localhost:8002/api/getStudentKurikulum/1/1/1/999)

```json
{
  "status": 404,
  "msg": "Angkatan tidak ditemukan",
  "result": null
}
```

## getAllTerm

Mengembalikan semua term dan tahun berdasarkan prodi

**URL** : `/api/getAllTerm/{id_univ}/{id_fakultas}/{id_prodi}`

**Method** : `GET`

### Success Response

**Contoh Request**: [/api/getAllTerm/1/1/1](http://localhost:8002/api/getAllTerm/1/1/1)

```json
{
  "status": 200,
  "msg": "success",
  "result": {
    "termList": [
      {
        "id": 1,
        "tahun_ajaran": "2017-18",
        "nomor": 1,
        "waktu_mulai": "2017-08-30",
        "waktu_akhir": "2017-12-20",
        "start_isi": "2017-08-01",
        "akhir_isi": "2017-08-07",
        "is_aktif": 1,
        "id_univ": 1,
        "id_fakultas": 1,
        "id_prodi": 1
      },
      {
        "id": 2,
        "tahun_ajaran": "2017-18",
        "nomor": 2,
        "waktu_mulai": "2018-02-09",
        "waktu_akhir": "2018-06-20",
        "start_isi": "2018-01-10",
        "akhir_isi": "2018-01-20",
        "is_aktif": 0,
        "id_univ": 1,
        "id_fakultas": 1,
        "id_prodi": 1
      },
      {
        "id": 6,
        "tahun_ajaran": "2016-17",
        "nomor": 2,
        "waktu_mulai": "2017-02-09",
        "waktu_akhir": "2017-06-20",
        "start_isi": "2017-01-10",
        "akhir_isi": "2017-01-11",
        "is_aktif": 0,
        "id_univ": 1,
        "id_fakultas": 1,
        "id_prodi": 1
      },
      {
        "id": 7,
        "tahun_ajaran": "2016-17",
        "nomor": 1,
        "waktu_mulai": "2016-08-30",
        "waktu_akhir": "2016-12-20",
        "start_isi": "2016-08-01",
        "akhir_isi": "2016-08-02",
        "is_aktif": 0,
        "id_univ": 1,
        "id_fakultas": 1,
        "id_prodi": 1
      }
    ]
  }
}
```

### Error Response

**Condition** : Jika id_univ tidak valid.

**Contoh Request**: [/api/getAllTerm/100/1/1](http://localhost:8002/api/getAllTerm/100/1/1)

```json
{
  "status": 404,
  "msg": "Universitas tidak ditemukan",
  "result": null
}
```

**Condition** : Jika id_fakultas tidak valid.

**Contoh Request**: [/api/getAllTerm/1/100/1](http://localhost:8002/api/getAllTerm/1/100/1)

```json
{
  "status": 404,
  "msg": "Fakultas tidak ditemukan",
  "result": null
}
```

**Condition** : Jika id_prodi tidak valid.

**Contoh Request**: [/api/getAllTerm/1/1/100](http://localhost:8002/api/getAllTerm/1/1/100)

```json
{
  "status": 404,
  "msg": "Prodi tidak ditemukan",
  "result": null
}
```

## getTermNow

Mengembalikan term dan tahun ajaran yang aktif berdasarkan prodi

**URL** : `/api/getTermNow/{id_univ}/{id_fakultas}/{id_prodi}`

**Method** : `GET`

### Success Response

**Contoh Request**: [/api/getTermNow/1/1/1](http://localhost:8002/api/getTermNow/1/1/1)

```json
{
  "status": 200,
  "msg": "success",
  "result": {
    "term": {
      "id": 1,
      "tahun_ajaran": "2017-18",
      "nomor": 1,
      "waktu_mulai": "2017-08-30",
      "waktu_akhir": "2017-12-20",
      "start_isi": "2017-08-01",
      "akhir_isi": "2017-08-07",
      "is_aktif": 1,
      "id_univ": 1,
      "id_fakultas": 1,
      "id_prodi": 1
    }
  }
}
```

### Error Response

**Condition** : Jika id_univ tidak valid.

**Contoh Request**: [/api/getTermNow/100/1/1](http://localhost:8002/api/getTermNow/100/1/1)

```json
{
  "status": 404,
  "msg": "Universitas tidak ditemukan",
  "result": null
}
```

**Condition** : Jika id_fakultas tidak valid.

**Contoh Request**: [/api/getTermNow/1/100/1](http://localhost:8002/api/getTermNow/1/100/1)

```json
{
  "status": 404,
  "msg": "Fakultas tidak ditemukan",
  "result": null
}
```

**Condition** : Jika id_prodi tidak valid.

**Contoh Request**: [/api/getTermNow/1/1/100](http://localhost:8002/api/getTermNow/1/1/100)

```json
{
  "status": 404,
  "msg": "Prodi tidak ditemukan",
  "result": null
}
```

## getTermByIdTerm

Mengembalikan term dan tahun ajaran berdasarkan id term

**URL** : `/api/getTerm/{id_term}`

**Method** : `GET`

### Success Response

**Contoh Request**: [/api/getTerm/1](http://localhost:8002/api/getTerm/1)

```json
{
  "status": 200,
  "msg": "success",
  "result": {
    "term": {
      "id": 1,
      "tahun_ajaran": "2017-18",
      "nomor": 1,
      "waktu_mulai": "2017-08-30",
      "waktu_akhir": "2017-12-20",
      "start_isi": "2017-08-01",
      "akhir_isi": "2017-08-07",
      "is_aktif": 1,
      "id_univ": 1,
      "id_fakultas": 1,
      "id_prodi": 1
    }
  }
}
```

### Error Response

**Condition** : Jika id_term tidak valid.

**Contoh Request**: [/api/getTerm/100](http://localhost:8002/api/getTerm/100)

```json
{
  "status": 404,
  "msg": "Term tidak ditemukan",
  "result": null
}
```

## getTerm

Mengembalikan term dan tahun ajaran berdasarkan tahun ajaran dan nomor term

**URL** : `/api/getTerm/{id_univ}/{id_fakultas}/{id_prodi}/{tahun_ajaran}/{nomor}`

**Method** : `GET`

### Success Response

**Contoh Request**: [/api/getTerm/1/1/1/2017-18/1](http://localhost:8002/api/getTerm/1/1/1/2017-18/1)

```json
{
  "status": 200,
  "msg": "success",
  "result": {
    "term": {
      "id": 1,
      "tahun_ajaran": "2017-18",
      "nomor": 1,
      "waktu_mulai": "2017-08-30",
      "waktu_akhir": "2017-12-20",
      "start_isi": "2017-08-01",
      "akhir_isi": "2017-08-07",
      "is_aktif": 1,
      "id_univ": 1,
      "id_fakultas": 1,
      "id_prodi": 1
    }
  }
}
```

### Error Response

**Condition** : Jika id_univ tidak valid.

**Contoh Request**: [/api/getTerm/100/1/1/2017-18/1](http://localhost:8002/api/getTerm/100/1/1/2017-18/1)

```json
{
  "status": 404,
  "msg": "Universitas tidak ditemukan",
  "result": null
}
```

**Condition** : Jika id_fakultas tidak valid.

**Contoh Request**: [/api/getTerm/1/100/1/2017-18/1](http://localhost:8002/api/getTerm/1/100/1/2017-18/1)

```json
{
  "status": 404,
  "msg": "Fakultas tidak ditemukan",
  "result": null
}
```

**Condition** : Jika id_prodi tidak valid.

**Contoh Request**: [/api/getTerm/1/1/100/2017-18/1](http://localhost:8002/api/getTerm/1/1/100/2017-18/1)

```json
{
  "status": 404,
  "msg": "Prodi tidak ditemukan",
  "result": null
}
```

**Condition** : Jika tahun_ajaran tidak valid.

**Contoh Request**: [/api/getTerm/1/1/1/9999-00/1](http://localhost:8002/api/getTerm/1/1/1/9999-00/1)

```json
{
  "status": 404,
  "msg": "Tahun ajaran tidak ditemukan",
  "result": null
}
```

**Condition** : Jika nomor tidak valid.

**Contoh Request**: [/api/getTerm/1/1/1/2017-18/100](http://localhost:8002/api/getTerm/1/1/1/2017-18/100)

```json
{
  "status": 404,
  "msg": "Nomor term tidak ditemukan",
  "result": null
}
```

## getKelas

Mengembalikan kelas berdasarkan id kelas

**URL** : `/api/getKelas/{id_kelas}`

**Method** : `GET`

### Success Response

**Contoh Request**: [/api/getKelas/1](http://localhost:8002/api/getKelas/1)

```json
{
  "status": 200,
  "msg": "success",
  "result": {
    "kelas": {
      "id": 1,
      "nama": "Pengantar Akuntansi 1-A",
      "max_kapasitas": 50,
      "id_univ": 1,
      "id_fakultas": 1,
      "id_prodi": 1,
      "kode_mata_kuliah": "ECM103",
      "kode_kurikulum": "U1-F1-P1-1",
      "id_term": 1,
      "term": {
        "id": 1,
        "tahun_ajaran": "2017-18",
        "nomor": 1,
        "waktu_mulai": "2017-08-30",
        "waktu_akhir": "2017-12-20",
        "start_isi": "2017-08-01",
        "akhir_isi": "2017-08-07",
        "is_aktif": 1,
        "id_univ": 1,
        "id_fakultas": 1,
        "id_prodi": 1
      },
      "jadwalList": [
        {
          "id": 3,
          "id_kelas": 1,
          "ruangan": "2303",
          "hari": "Rabu",
          "jam_mulai": "08:00:00",
          "jam_akhir": "08:50:00",
          "dosen": null,
          "dosenPengajar": [
            {
              "id": 31,
              "nama": "Fayina Canizares",
              "nidn": "1013408829",
              "id_univ": 0,
              "id_fakultas": 1,
              "id_prodi": 1
            }
          ]
        }
      ],
      "matkul": null
    }
  }
}
```

### Error Response

**Condition** : Jika id_kelas tidak valid.

**Contoh Request**: [/api/getKelas/100](http://localhost:8002/api/getKelas/100)

```json
{
  "status": 404,
  "msg": "Kelas tidak ditemukan",
  "result": null
}
```

## getListMatkul

Mengembalikan daftar mata kuliah dan jadwal berdasarkan id term

**URL** : `/api/getListMatkul/{id_term}`

**Method** : `GET`

### Success Response

**Contoh Request**: [/api/getListMatkul/1](http://localhost:8002/api/getListMatkul/1)

```json
{
  "status": 200,
  "msg": "success",
  "result": {
    "matkulList": [
      {
        "kode_mata_kuliah": "EL4230",
        "nama": "Analisis & Perancangan IC Digital",
        "jumlah_sks": 3,
        "jumlah_sks_minimal": 0,
        "deskripsi": "Model perancangan sistem digital",
        "kode_kurikulum": "U1-F1-P1-1",
        "kelasList": [
          {
            "id": 5,
            "nama": "Analisis & Perancangan IC Digital-A",
            "max_kapasitas": 50,
            "id_univ": 1,
            "id_fakultas": 1,
            "id_prodi": 1,
            "kode_mata_kuliah": "EL4230",
            "kode_kurikulum": "U1-F1-P1-1",
            "id_term": 1,
            "term": null,
            "jadwalList": [
              {
                "id": 1,
                "id_kelas": 5,
                "ruangan": "Aula",
                "hari": "Senin",
                "jam_mulai": "08:00:00",
                "jam_akhir": "08:50:00",
                "dosen": null,
                "dosenPengajar": [
                  {
                    "id": 18,
                    "nama": "Octavia Tolliday",
                    "nidn": "3657295275",
                    "id_univ": 0,
                    "id_fakultas": 1,
                    "id_prodi": 1
                  }
                ]
              }
            ],
            "matkul": null
          }
        ],
        "wajib": true
      },
      {
        "kode_mata_kuliah": "FI1101",
        "nama": "Fisika Dasar IA",
        "jumlah_sks": 4,
        "jumlah_sks_minimal": 0,
        "deskripsi": "Fisika dasar semester 1",
        "kode_kurikulum": "U1-F1-P1-2",
        "kelasList": [
          {
            "id": 6,
            "nama": "Fisika Dasar IA-A",
            "max_kapasitas": 30,
            "id_univ": 1,
            "id_fakultas": 1,
            "id_prodi": 1,
            "kode_mata_kuliah": "FI1101",
            "kode_kurikulum": "U1-F1-P1-2",
            "id_term": 1,
            "term": null,
            "jadwalList": [],
            "matkul": null
          },
          {
            "id": 7,
            "nama": "Fisika Dasar IA-B",
            "max_kapasitas": 45,
            "id_univ": 1,
            "id_fakultas": 1,
            "id_prodi": 1,
            "kode_mata_kuliah": "FI1101",
            "kode_kurikulum": "U1-F1-P1-2",
            "id_term": 1,
            "term": null,
            "jadwalList": [],
            "matkul": null
          }
        ],
        "wajib": true
      }
    ],
    "term": {
      "id": 1,
      "tahun_ajaran": "2017-18",
      "nomor": 1,
      "waktu_mulai": "2017-08-30",
      "waktu_akhir": "2017-12-20",
      "start_isi": "2017-08-01",
      "akhir_isi": "2017-08-07",
      "is_aktif": 1,
      "id_univ": 1,
      "id_fakultas": 1,
      "id_prodi": 1
    }
  }
}
```

### Error Response

**Condition** : Jika id_term tidak valid.

**Contoh Request**: [/api/getListMatkul/100](http://localhost:8002/api/getListMatkul/100)

```json
{
  "status": 404,
  "msg": "Term tidak ditemukan",
  "result": null
}
```

## getListKelas

Mengembalikan kelas berdasarkan kode matkul dan id term

**URL** : `/api/getListKelas/{id_term}/{kode_matkul}`

**Method** : `GET`

### Success Response

**Contoh Request**: [/api/getListKelas/1/FI1101](http://localhost:8002/api/getListKelas/1/FI1101)

```json
{
  "status": 200,
  "msg": "success",
  "result": {
    "kelasList": [
      {
        "id": 6,
        "nama": "Fisika Dasar IA-A",
        "max_kapasitas": 30,
        "id_univ": 1,
        "id_fakultas": 1,
        "id_prodi": 1,
        "kode_mata_kuliah": "FI1101",
        "kode_kurikulum": "U1-F1-P1-2",
        "id_term": 1,
        "term": null,
        "jadwalList": [],
        "matkul": null
      },
      {
        "id": 7,
        "nama": "Fisika Dasar IA-B",
        "max_kapasitas": 45,
        "id_univ": 1,
        "id_fakultas": 1,
        "id_prodi": 1,
        "kode_mata_kuliah": "FI1101",
        "kode_kurikulum": "U1-F1-P1-2",
        "id_term": 1,
        "term": null,
        "jadwalList": [],
        "matkul": null
      }
    ],
    "term": {
      "id": 1,
      "tahun_ajaran": "2017-18",
      "nomor": 1,
      "waktu_mulai": "2017-08-30",
      "waktu_akhir": "2017-12-20",
      "start_isi": "2017-08-01",
      "akhir_isi": "2017-08-07",
      "is_aktif": 1,
      "id_univ": 1,
      "id_fakultas": 1,
      "id_prodi": 1
    }
  }
}
```

### Error Response

**Condition** : Jika id_term tidak valid.

**Contoh Request**: [/api/getListKelas/100/FI1101](http://localhost:8002/api/getListKelas/100/FI1101)

```json
{
  "status": 404,
  "msg": "Term tidak ditemukan",
  "result": null
}
```

**Condition** : Jika kode_matkul tidak valid.

**Contoh Request**: [/api/getListKelas/1/XXXXX](http://localhost:8002/api/getListKelas/1/XXXXX)

```json
{
  "status": 404,
  "msg": "Mata Kuliah tidak ditemukan",
  "result": null
}
```

## getKelasList

Mengembalikan jadwal dari semua id_kelas yg ada di parameter

**URL** : `/api/getKelasList/{list of kelas id}`

**Method** : `GET`

### Success Response

**Contoh Request**: [/api/getKelasList/\[1,2\]](http://localhost:8002/api/getKelasList/\[1,2\])

```json
{
  "status": 200,
  "msg": "success",
  "result": {
    "kelasList": [
      {
        "id": 1,
        "nama": "Pengantar Akuntansi 1-A",
        "max_kapasitas": 50,
        "id_univ": 1,
        "id_fakultas": 1,
        "id_prodi": 1,
        "kode_mata_kuliah": "ECM103",
        "kode_kurikulum": "U1-F1-P1-1",
        "id_term": 1,
        "term": {
          "id": 1,
          "tahun_ajaran": "2017-18",
          "nomor": 1,
          "waktu_mulai": "2017-08-30",
          "waktu_akhir": "2017-12-20",
          "start_isi": "2017-08-01",
          "akhir_isi": "2017-08-07",
          "is_aktif": 1,
          "id_univ": 1,
          "id_fakultas": 1,
          "id_prodi": 1
        },
        "jadwalList": [
          {
            "id": 3,
            "id_kelas": 1,
            "ruangan": "2303",
            "hari": "Rabu",
            "jam_mulai": "08:00:00",
            "jam_akhir": "08:50:00",
            "dosen": null,
            "dosenPengajar": [
              {
                "id": 31,
                "nama": "Fayina Canizares",
                "nidn": "1013408829",
                "id_univ": 0,
                "id_fakultas": 1,
                "id_prodi": 1
              }
            ]
          }
        ],
        "matkul": {
          "kode_mata_kuliah": "ECM103",
          "nama": "Pengantar Akuntansi 1",
          "jumlah_sks": 4,
          "jumlah_sks_minimal": 0,
          "deskripsi": "dasar akuntansi wajib",
          "kode_kurikulum": null,
          "kelasList": null,
          "wajib": true
        }
      },
      {
        "id": 2,
        "nama": "Pengantar Akuntansi II-A",
        "max_kapasitas": 40,
        "id_univ": 1,
        "id_fakultas": 1,
        "id_prodi": 1,
        "kode_mata_kuliah": "ECM106",
        "kode_kurikulum": "U1-F1-P1-1",
        "id_term": 2,
        "term": {
          "id": 2,
          "tahun_ajaran": "2017-18",
          "nomor": 2,
          "waktu_mulai": "2018-02-09",
          "waktu_akhir": "2018-06-20",
          "start_isi": "2018-01-10",
          "akhir_isi": "2018-01-20",
          "is_aktif": 0,
          "id_univ": 1,
          "id_fakultas": 1,
          "id_prodi": 1
        },
        "jadwalList": [
          {
            "id": 5,
            "id_kelas": 2,
            "ruangan": "2301",
            "hari": "Senin",
            "jam_mulai": "08:00:00",
            "jam_akhir": "08:50:00",
            "dosen": null,
            "dosenPengajar": [
              {
                "id": 19,
                "nama": "Rodger Tournay",
                "nidn": "7942954617",
                "id_univ": 0,
                "id_fakultas": 1,
                "id_prodi": 1
              }
            ]
          },
          {
            "id": 12,
            "id_kelas": 2,
            "ruangan": "3314",
            "hari": "Senin",
            "jam_mulai": "08:00:00",
            "jam_akhir": "08:50:00",
            "dosen": null,
            "dosenPengajar": [
              {
                "id": 19,
                "nama": "Rodger Tournay",
                "nidn": "7942954617",
                "id_univ": 0,
                "id_fakultas": 1,
                "id_prodi": 1
              }
            ]
          }
        ],
        "matkul": {
          "kode_mata_kuliah": "ECM106",
          "nama": "Pengantar Akuntansi II",
          "jumlah_sks": 4,
          "jumlah_sks_minimal": 0,
          "deskripsi": "Lanjutan Pengantar Akuntansi 1",
          "kode_kurikulum": null,
          "kelasList": null,
          "wajib": true
        }
      }
    ]
  }
}
```

### Error Response

**Condition** : Jika tidak ada id_kelas yang ditemukan.

**Contoh Request**: [/api/getKelasList/\[100,101\]](http://localhost:8002/api/getKelasList/\[100,101\])

```json
{
  "status": 404,
  "msg": "Kelas tidak ditemukan",
  "result": null
}
```

## getJadwalListNow

Mengembalikan daftar jadwal untuk halaman jadwal kuliah ataupun isi IRS

**URL** : `/api/getJadwalListNow/{id_univ}/{id_fakultas}/{id_prodi}/{angkatan}`

**Method** : `GET`

### Success Response

**Contoh Request**: [api/getJadwalListNow/1/1/1/2017](http://localhost:8002/api/getJadwalListNow/1/1/1/2017)

```json
{
  "status": 200,
  "msg": "success",
  "result": {
    "matkulList": [
      {
        "kode_mata_kuliah": "EL4230",
        "nama": "Analisis & Perancangan IC Digital",
        "jumlah_sks": 3,
        "jumlah_sks_minimal": 0,
        "deskripsi": "Model perancangan sistem digital",
        "kode_kurikulum": "U1-F1-P1-1",
        "kelasList": [
          {
            "id": 5,
            "nama": "Analisis & Perancangan IC Digital-A",
            "max_kapasitas": 50,
            "id_univ": 1,
            "id_fakultas": 1,
            "id_prodi": 1,
            "kode_mata_kuliah": "EL4230",
            "kode_kurikulum": "U1-F1-P1-1",
            "id_term": 1,
            "term": null,
            "jadwalList": [
              {
                "id": 1,
                "id_kelas": 5,
                "ruangan": "Aula",
                "hari": "Senin",
                "jam_mulai": "08:00:00",
                "jam_akhir": "08:50:00",
                "dosen": null,
                "dosenPengajar": [
                  {
                    "id": 18,
                    "nama": "Octavia Tolliday",
                    "nidn": "3657295275",
                    "id_univ": 0,
                    "id_fakultas": 1,
                    "id_prodi": 1
                  }
                ]
              }
            ],
            "matkul": null
          }
        ],
        "wajib": true
      },
      {
        "kode_mata_kuliah": "MB4045",
        "nama": "Manajemen Investasi",
        "jumlah_sks": 3,
        "jumlah_sks_minimal": 0,
        "deskripsi": "Pengelolaan investasi bisnis",
        "kode_kurikulum": "U1-F1-P1-1",
        "kelasList": [
          {
            "id": 10,
            "nama": "Manajemen Investasi-A",
            "max_kapasitas": 20,
            "id_univ": 1,
            "id_fakultas": 1,
            "id_prodi": 1,
            "kode_mata_kuliah": "MB4045",
            "kode_kurikulum": "U1-F1-P1-1",
            "id_term": 1,
            "term": null,
            "jadwalList": [
              {
                "id": 2,
                "id_kelas": 10,
                "ruangan": "2304",
                "hari": "Selasa",
                "jam_mulai": "08:00:00",
                "jam_akhir": "08:50:00",
                "dosen": null,
                "dosenPengajar": [
                  {
                    "id": 19,
                    "nama": "Rodger Tournay",
                    "nidn": "7942954617",
                    "id_univ": 0,
                    "id_fakultas": 1,
                    "id_prodi": 1
                  }
                ]
              }
            ],
            "matkul": null
          }
        ],
        "wajib": true
      },
      {
        "kode_mata_kuliah": "ECM103",
        "nama": "Pengantar Akuntansi 1",
        "jumlah_sks": 4,
        "jumlah_sks_minimal": 0,
        "deskripsi": "dasar akuntansi wajib",
        "kode_kurikulum": "U1-F1-P1-1",
        "kelasList": [
          {
            "id": 1,
            "nama": "Pengantar Akuntansi 1-A",
            "max_kapasitas": 50,
            "id_univ": 1,
            "id_fakultas": 1,
            "id_prodi": 1,
            "kode_mata_kuliah": "ECM103",
            "kode_kurikulum": "U1-F1-P1-1",
            "id_term": 1,
            "term": null,
            "jadwalList": [
              {
                "id": 3,
                "id_kelas": 1,
                "ruangan": "2303",
                "hari": "Rabu",
                "jam_mulai": "08:00:00",
                "jam_akhir": "08:50:00",
                "dosen": null,
                "dosenPengajar": [
                  {
                    "id": 31,
                    "nama": "Fayina Canizares",
                    "nidn": "1013408829",
                    "id_univ": 0,
                    "id_fakultas": 1,
                    "id_prodi": 1
                  }
                ]
              }
            ],
            "matkul": null
          }
        ],
        "wajib": true
      },
      {
        "kode_mata_kuliah": "ECM106",
        "nama": "Pengantar Akuntansi II",
        "jumlah_sks": 4,
        "jumlah_sks_minimal": 0,
        "deskripsi": "Lanjutan Pengantar Akuntansi 1",
        "kode_kurikulum": "U1-F1-P1-1",
        "kelasList": [
          {
            "id": 17,
            "nama": "Pengantar Akuntansi II-A",
            "max_kapasitas": 30,
            "id_univ": 1,
            "id_fakultas": 1,
            "id_prodi": 1,
            "kode_mata_kuliah": "ECM106",
            "kode_kurikulum": "U1-F1-P1-1",
            "id_term": 1,
            "term": null,
            "jadwalList": [
              {
                "id": 13,
                "id_kelas": 17,
                "ruangan": "Aula",
                "hari": "Jumat",
                "jam_mulai": "08:00:00",
                "jam_akhir": "08:50:00",
                "dosen": null,
                "dosenPengajar": [
                  {
                    "id": 19,
                    "nama": "Rodger Tournay",
                    "nidn": "7942954617",
                    "id_univ": 0,
                    "id_fakultas": 1,
                    "id_prodi": 1
                  }
                ]
              }
            ],
            "matkul": null
          }
        ],
        "wajib": true
      },
      {
        "kode_mata_kuliah": "EL3214",
        "nama": "Sistem Mikroprosesor yey",
        "jumlah_sks": 4,
        "jumlah_sks_minimal": 0,
        "deskripsi": "matkul baru nih",
        "kode_kurikulum": "U1-F1-P1-1",
        "kelasList": [
          {
            "id": 3,
            "nama": "Sistem Mikroprosesor-A",
            "max_kapasitas": 30,
            "id_univ": 1,
            "id_fakultas": 1,
            "id_prodi": 1,
            "kode_mata_kuliah": "EL3214",
            "kode_kurikulum": "U1-F1-P1-1",
            "id_term": 1,
            "term": null,
            "jadwalList": [
              {
                "id": 4,
                "id_kelas": 3,
                "ruangan": "2302",
                "hari": "Kamis",
                "jam_mulai": "08:00:00",
                "jam_akhir": "08:50:00",
                "dosen": null,
                "dosenPengajar": [
                  {
                    "id": 18,
                    "nama": "Octavia Tolliday",
                    "nidn": "3657295275",
                    "id_univ": 0,
                    "id_fakultas": 1,
                    "id_prodi": 1
                  }
                ]
              }
            ],
            "matkul": null
          },
          {
            "id": 4,
            "nama": "Sistem Mikroprosesor-B",
            "max_kapasitas": 40,
            "id_univ": 1,
            "id_fakultas": 1,
            "id_prodi": 1,
            "kode_mata_kuliah": "EL3214",
            "kode_kurikulum": "U1-F1-P1-1",
            "id_term": 1,
            "term": null,
            "jadwalList": [],
            "matkul": null
          }
        ],
        "wajib": false
      }
    ],
    "term": {
      "id": 1,
      "tahun_ajaran": "2017-18",
      "nomor": 1,
      "waktu_mulai": "2017-08-30",
      "waktu_akhir": "2017-12-20",
      "start_isi": "2017-08-01",
      "akhir_isi": "2017-08-07",
      "is_aktif": 1,
      "id_univ": 1,
      "id_fakultas": 1,
      "id_prodi": 1
    }
  }
}
```

## getJadwalList

Mengembalikan jadwal kelas yang diajarkan oleh dosen berdasarkan tahun ajaran dan nomor term

**URL** : `/api/getJadwalList/{id_dosen}/{id_univ}/{id_fakultas}/{id_prodi}/{tahun_ajaran}/{nomor}`

**Method** : `GET`

### Success Response

**Contoh Request**: [/api/getJadwalList/18/1/1/1/2017-18/1](http://localhost:8002/api/getJadwalList/18/1/1/1/2017-18/1)

```json
{
  "status": 200,
  "msg": "success",
  "result": {
    "matkulList": [
      {
        "kode_mata_kuliah": "EL3214",
        "nama": "Sistem Mikroprosesor yey",
        "jumlah_sks": 4,
        "jumlah_sks_minimal": 0,
        "deskripsi": "matkul baru nih",
        "kode_kurikulum": null,
        "kelasList": [
          {
            "id": 3,
            "nama": "Sistem Mikroprosesor-A",
            "max_kapasitas": 30,
            "id_univ": 1,
            "id_fakultas": 1,
            "id_prodi": 1,
            "kode_mata_kuliah": "EL3214",
            "kode_kurikulum": null,
            "id_term": 1,
            "term": null,
            "jadwalList": [
              {
                "id": 4,
                "id_kelas": 3,
                "ruangan": "2302",
                "hari": "Kamis",
                "jam_mulai": "08:00:00",
                "jam_akhir": "08:50:00",
                "dosen": null,
                "dosenPengajar": [
                  {
                    "id": 18,
                    "nama": "Octavia Tolliday",
                    "nidn": "3657295275",
                    "id_univ": 0,
                    "id_fakultas": 1,
                    "id_prodi": 1
                  }
                ]
              }
            ],
            "matkul": null
          }
        ],
        "wajib": false
      },
      {
        "kode_mata_kuliah": "EL4230",
        "nama": "Analisis & Perancangan IC Digital",
        "jumlah_sks": 3,
        "jumlah_sks_minimal": 0,
        "deskripsi": "Model perancangan sistem digital",
        "kode_kurikulum": null,
        "kelasList": [
          {
            "id": 5,
            "nama": "Analisis & Perancangan IC Digital-A",
            "max_kapasitas": 50,
            "id_univ": 1,
            "id_fakultas": 1,
            "id_prodi": 1,
            "kode_mata_kuliah": "EL4230",
            "kode_kurikulum": null,
            "id_term": 1,
            "term": null,
            "jadwalList": [
              {
                "id": 1,
                "id_kelas": 5,
                "ruangan": "Aula",
                "hari": "Senin",
                "jam_mulai": "08:00:00",
                "jam_akhir": "08:50:00",
                "dosen": null,
                "dosenPengajar": [
                  {
                    "id": 18,
                    "nama": "Octavia Tolliday",
                    "nidn": "3657295275",
                    "id_univ": 0,
                    "id_fakultas": 1,
                    "id_prodi": 1
                  }
                ]
              }
            ],
            "matkul": null
          }
        ],
        "wajib": true
      }
    ],
    "term": {
      "id": 1,
      "tahun_ajaran": "2017-18",
      "nomor": 1,
      "waktu_mulai": "2017-08-30",
      "waktu_akhir": "2017-12-20",
      "start_isi": "2017-08-01",
      "akhir_isi": "2017-08-07",
      "is_aktif": 1,
      "id_univ": 1,
      "id_fakultas": 1,
      "id_prodi": 1
    }
  }
}
```

### Error Response

**Condition** : Jika id_dosen tidak valid.

**Contoh Request**: [/api/getJadwalList/100/1/1/1/2017-18/1](http://localhost:8002/api/getJadwalList/100/1/1/1/2017-18/1)

```json
{
  "status": 404,
  "msg": "Dosen tidak ditemukan",
  "result": null
}
```

**Condition** : Jika id_univ tidak valid.

**Contoh Request**: [/api/getJadwalList/1/100/1/1/2017-18/1](http://localhost:8002/api/getJadwalList/1/100/1/1/2017-18/1)

```json
{
  "status": 404,
  "msg": "Universitas tidak ditemukan",
  "result": null
}
```

**Condition** : Jika id_fakultas tidak valid.

**Contoh Request**: [/api/getJadwalList/1/1/100/1/2017-18/1](http://localhost:8002/api/getJadwalList/1/1/100/1/2017-18/1)

```json
{
  "status": 404,
  "msg": "Fakultas tidak ditemukan",
  "result": null
}
```

**Condition** : Jika id_prodi tidak valid.

**Contoh Request**: [/api/getJadwalList/1/1/1/100/2017-18/1](http://localhost:8002/api/getJadwalList/1/1/1/100/2017-18/1)

```json
{
  "status": 404,
  "msg": "Prodi tidak ditemukan",
  "result": null
}
```

**Condition** : Jika tahun_ajaran tidak valid.

**Contoh Request**: [/api/getJadwalList/1/1/1/1/9999-00/1](http://localhost:8002/api/getJadwalList/1/1/1/1/9999-00/1)

```json
{
  "status": 404,
  "msg": "Tahun ajaran tidak ditemukan",
  "result": null
}
```

**Condition** : Jika nomor tidak valid.

**Contoh Request**: [/api/getJadwalList/1/1/1/1/2017-18/100](http://localhost:8002/api/getJadwalList/1/1/1/1/2017-18/100)

```json
{
  "status": 404,
  "msg": "Nomor term tidak ditemukan",
  "result": null
}
```

### Error Response

**Condition** : Jika id_univ tidak valid.

**Contoh Request**: [/api/getJadwalListNow/100/1/1/2015](http://localhost:8002/api/getJadwalListNow/100/1/1/2015)

```json
{
  "status": 404,
  "msg": "Universitas tidak ditemukan",
  "result": null
}
```

**Condition** : Jika id_fakultas tidak valid.

**Contoh Request**: [/api/getJadwalListNow/1/100/1/2015](http://localhost:8002/api/getJadwalListNow/1/100/1/2015)

```json
{
  "status": 404,
  "msg": "Fakultas tidak ditemukan",
  "result": null
}
```

**Condition** : Jika id_prodi tidak valid.

**Contoh Request**: [/api/getJadwalListNow/1/1/100/2015](http://localhost:8002/api/getJadwalListNow/1/1/100/2015)

```json
{
  "status": 404,
  "msg": "Prodi tidak ditemukan",
  "result": null
}
```

**Condition** : Jika angkatan tidak valid.

**Contoh Request**: [/api/getJadwalListNow/1/1/1/9999](http://localhost:8002/api/getJadwalListNow/1/1/1/999)

```json
{
  "status": 404,
  "msg": "Angkatan tidak ditemukan",
  "result": null
}
```

## getMatkulDiajar

Mengembalikan jadwal berdasarkan id dosen dan id term

**URL** : `/api/getMatkulDiajar/{id_dosen}/{id_term}`

**Method** : `GET`

### Success Response

**Contoh Request**: [/api/getMatkulDiajar/18/1](http://localhost:8002/api/getMatkulDiajar/18/1)

```json
{
  "status": 200,
  "msg": "success",
  "result": {
    "matkulList": [
      {
        "kode_mata_kuliah": "EL3214",
        "nama": "Sistem Mikroprosesor yey",
        "jumlah_sks": 4,
        "jumlah_sks_minimal": 0,
        "deskripsi": "matkul baru nih",
        "kode_kurikulum": null,
        "kelasList": [
          {
            "id": 3,
            "nama": "Sistem Mikroprosesor-A",
            "max_kapasitas": 30,
            "id_univ": 1,
            "id_fakultas": 1,
            "id_prodi": 1,
            "kode_mata_kuliah": "EL3214",
            "kode_kurikulum": null,
            "id_term": 1,
            "term": null,
            "jadwalList": [
              {
                "id": 4,
                "id_kelas": 3,
                "ruangan": "2302",
                "hari": "Kamis",
                "jam_mulai": "08:00:00",
                "jam_akhir": "08:50:00",
                "dosen": null,
                "dosenPengajar": [
                  {
                    "id": 18,
                    "nama": "Octavia Tolliday",
                    "nidn": "3657295275",
                    "id_univ": 0,
                    "id_fakultas": 1,
                    "id_prodi": 1
                  }
                ]
              }
            ],
            "matkul": null
          }
        ],
        "wajib": false
      },
      {
        "kode_mata_kuliah": "EL4230",
        "nama": "Analisis & Perancangan IC Digital",
        "jumlah_sks": 3,
        "jumlah_sks_minimal": 0,
        "deskripsi": "Model perancangan sistem digital",
        "kode_kurikulum": null,
        "kelasList": [
          {
            "id": 5,
            "nama": "Analisis & Perancangan IC Digital-A",
            "max_kapasitas": 50,
            "id_univ": 1,
            "id_fakultas": 1,
            "id_prodi": 1,
            "kode_mata_kuliah": "EL4230",
            "kode_kurikulum": null,
            "id_term": 1,
            "term": null,
            "jadwalList": [
              {
                "id": 1,
                "id_kelas": 5,
                "ruangan": "Aula",
                "hari": "Senin",
                "jam_mulai": "08:00:00",
                "jam_akhir": "08:50:00",
                "dosen": null,
                "dosenPengajar": [
                  {
                    "id": 18,
                    "nama": "Octavia Tolliday",
                    "nidn": "3657295275",
                    "id_univ": 0,
                    "id_fakultas": 1,
                    "id_prodi": 1
                  }
                ]
              }
            ],
            "matkul": null
          }
        ],
        "wajib": true
      }
    ],
    "term": {
      "id": 1,
      "tahun_ajaran": "2017-18",
      "nomor": 1,
      "waktu_mulai": "2017-08-30",
      "waktu_akhir": "2017-12-20",
      "start_isi": "2017-08-01",
      "akhir_isi": "2017-08-07",
      "is_aktif": 1,
      "id_univ": 1,
      "id_fakultas": 1,
      "id_prodi": 1
    }
  }
}
```

### Error Response

**Condition** : Jika id_dosen tidak valid.

**Contoh Request**: [/api/getMatkulDiajar/100/1](http://localhost:8002/api/getMatkulDiajar/100/1)

```json
{
  "status": 404,
  "msg": "Dosen tidak ditemukan",
  "result": null
}
```

**Condition** : Jika id_term tidak valid.

**Contoh Request**: [/api/getMatkulDiajar/1/100](http://localhost:8002/api/getMatkulDiajar/1/100)

```json
{
  "status": 404,
  "msg": "Term tidak ditemukan",
  "result": null
}
```
