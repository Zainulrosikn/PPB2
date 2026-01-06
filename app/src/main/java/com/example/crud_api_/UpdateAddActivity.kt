package com.example.crud_api_ari_setiawan

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.crud_api_ari_setiawan.databinding.ActivityUpdateAddBinding

@Suppress("SENSELESS_COMPARISON", "DEPRECATION")
class UpdateAddActivity : AppCompatActivity(), CrudView {
    private lateinit var presenter: Presenter2
    private lateinit var binding : ActivityUpdateAddBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateAddBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = Presenter2(this)
        val itemDataItem = intent.getSerializableExtra("dataItem")
        if (itemDataItem == null){
            binding.btnAction.text = "Tambah"
            binding.btnAction.setOnClickListener {
                presenter.addData(
                    binding.etName.text.toString(),
                    binding.etJenisKelamin.text.toString(),
                    binding.etProgramStudi.text.toString(),
                    binding.etPhone.text.toString(),
                    binding.etAlamat.text.toString())
            }
        }else if (itemDataItem != null){
            binding.btnAction.text = "Update"
            val item = itemDataItem as DataItem?
            binding.etName.setText(item?.staffName.toString())
            binding.etJenisKelamin.setText(item?.staffJenisKelamin.toString())
            binding.etProgramStudi.setText(item?.staffProgamStudi.toString())
            binding.etPhone.setText(item?.staffHp.toString())
            binding.etAlamat.setText(item?.staffAlamat.toString())
            binding.btnAction.setOnClickListener {
                presenter.updateData(
                    item?.staffId ?: "",
                    binding.etName.text.toString(),
                    binding.etJenisKelamin.text.toString(),
                    binding.etProgramStudi.text.toString(),
                    binding.etPhone.text.toString(),
                    binding.etAlamat.text.toString())
                finish()
            }
        }
    }

    override fun successAdd(msg: String) {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
    override fun errorAdd(msg: String) {}
    override fun onSuccessUpdate(msg: String) {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
    override fun onErrorUpdate(msg: String) {}
    override fun onSuccessGet(data: List<DataItem>?) {}
    override fun onFailedGet(msg: String) {}
    override fun onSuccessDelete(msg: String) {}
    override fun onErrorDelete(msg: String) {}
}