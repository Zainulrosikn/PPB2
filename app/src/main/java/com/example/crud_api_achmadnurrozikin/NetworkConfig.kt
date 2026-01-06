import android.telecom.Call
import com.example.crud_api_achmadnurrozikin.ResultStaff
import com.example.crud_api_achmadnurrozikin.ResultStatus
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

object NetworkConfig {
    fun getInterceptor() : OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        return okHttpClient
    }
    //Retrofit
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http:/192.168.149.150:8080/")
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())  .build()
    }
    fun getService() = getRetrofit().create(StaffService::class.java) }
interface StaffService{
    //Fungsi Create Data
    @FormUrlEncoded
    @POST("add-staff")
    fun addStaff(@Field("name") name : String,
                 @Field("hp") hp : String,
                 @Field("alamat") alamat : String) : Call<ResultStatus>
    //Fungsi Get Data
    @GET("get-staff")
    fun getData() : Call<ResultStaff>
    //Fungsi Delete Data
    @FormUrlEncoded
    @POST("delete-staff")
    fun deleteStaff(@Field("id") id: String?) : Call<ResultStatus>
    //Fungsi Update Data
    @FormUrlEncoded
    @POST("update-staff")
    fun updateStaff(@Field("id") id: String,
                    @Field("name") name: String,
                    @Field("hp") hp : String,
                    @Field("alamat") alamat : String) : Call<ResultStatus> }