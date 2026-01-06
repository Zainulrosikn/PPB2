package com.example.crud_api_ari_setiawan

import retrofit2.Call
import retrofit2.Response

class Presenter2 (val crudView: UpdateAddActivity) {
    //Add data
    fun addData(name : String, jenis_kelamin : String, program_studi : String, hp : String, alamat : String){
        NetworkConfig.getService()
            ?.addStaff(name, jenis_kelamin, program_studi, hp, alamat)
            ?.enqueue(object : retrofit2.Callback<ResultStatus>{
                override fun onFailure(call: Call<ResultStatus>, t: Throwable) {
                    t.localizedMessage?.let { crudView.errorAdd(it) }
                }

                override fun onResponse(call: Call<ResultStatus>, response:
                Response<ResultStatus>) {
                    if (response.isSuccessful && response.body()?.status == 200) {
                        crudView.successAdd(response.body()?.pesan ?: "")
                    }else {
                        crudView.errorAdd(response.body()?.pesan ?: "")
                    }
                }
            }

            )
    }
    //Update Data
    fun updateData(id: String, name: String, jenis_kelamin: String, program_studi: String, hp: String, alamat: String){
        NetworkConfig.getService()
            ?.updateStaff(id, name, jenis_kelamin, program_studi, hp, alamat)
            ?.enqueue(object : retrofit2.Callback<ResultStatus>{
                override fun onFailure(call: Call<ResultStatus>, t: Throwable) {
                    t.localizedMessage?.let { crudView.onErrorUpdate(it) }
                }

                override fun onResponse(call: Call<ResultStatus>, response:
                Response<ResultStatus>) {
                    if (response.isSuccessful && response.body()?.status == 200){
                        crudView.onSuccessUpdate(response.body()?.pesan ?: "")
                    }else{
                        crudView.onErrorUpdate(response.body()?.pesan ?: "")
                    }
                }
            })
    }
}