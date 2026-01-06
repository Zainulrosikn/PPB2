package com.example.crud_api_ari_setiawan

import com.google.gson.annotations.SerializedName
import java.io.Serializable
class DataItem : Serializable{
    @field:SerializedName("staff_name")
    val staffName: String? = null
    @field:SerializedName("staff_jenis_kelamin")
    val staffJenisKelamin: String? = null
    @field:SerializedName("staff_program_studi")
    val staffProgamStudi: String? = null
    @field:SerializedName("staff_id")
    val staffId: String? = null
    @field:SerializedName("staff_hp")
    val staffHp: String? = null
    @field:SerializedName("staff_alamat")
    val staffAlamat: String? = null
}