import android.annotation.SuppressLint;

import com.example.crud_api_achmadnurrozikin.databinding.ActivityUpdateAddBinding;

import kotlin.Suppress;

@Suppress("SENSELESS_COMPARISON")
class UpdateAddActivity : AppCompatActivity(), CrudView {
    private lateinit var presenter: Presenter2
    private lateinit var binding :
    ActivityUpdateAddBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {  super.onCreate(savedInstanceState)
        binding = ActivityUpdateAddBinding.inflate(layoutInflater)  setContentView(binding.root)
        presenter = Presenter2(this)
        val itemDataItem = intent.getSerializableExtra("dataItem")
        if (itemDataItem == null){
            binding.btnAction.text = "Tambah"
            binding.btnAction.setOnClickListener() {  presenter.addData(
                    binding.etName.text.toString(),  binding.etPhone.text.toString(),  binding.etAlamat.text.toString())  }
        }else if (itemDataItem != null){
            binding.btnAction.text = "Update"
            val item = itemDataItem as DataItem?
            binding.etName.setText(item?.staffName.toString())  binding.etPhone.setText(item?.staffHp.toString())  binding.etAlamat.setText(item?.staffAlamat.toString())  binding.btnAction.setOnClickListener() {  presenter.updateData(
                    item?.staffId ?: "",
                    binding.etName.text.toString(),  binding.etPhone.text.toString(),  binding.etAlamat.text.toString())  finish()
            }
        }

    }
    override fun successAdd(msg: String) {
        startActivity(Intent(this, MainActivity::class.java))  finish()
    }
    override fun errorAdd(msg: String) {}
    override fun onSuccessUpdate(msg: String) {
        startActivity(Intent(this, MainActivity::class.java))  finish()
    }
    override fun onErrorUpdate(msg: String) {}
    override fun onSuccessGet(data: List<DataItem>?) {}
    override fun onFailedGet(msg: String) {}
    override fun onSuccessDelete(msg: String) {}
    override fun onErrorDelete(msg: String) {}
}
