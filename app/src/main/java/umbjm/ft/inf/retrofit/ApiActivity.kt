package umbjm.ft.inf.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Call
import retrofit2.Callback
import android.widget.Toast
import retrofit2.Response
import umbjm.ft.inf.retrofit.data.ApiPublic
import umbjm.ft.inf.retrofit.databinding.ActivityMainBinding

class ApiActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        NetworkConfig().getService3()
            .getApi()
            .enqueue(object : Callback<List<ApiPublic>> {
                override fun onFailure(call: Call<List<ApiPublic>>, t: Throwable) {
                    Toast.makeText(this@ApiActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: Call<List<ApiPublic>>,
                    response: Response<List<ApiPublic>>
                ) {
                    binding.rvApi.adapter = ApiAdapter(response.body())
                }
            })
    }
}
