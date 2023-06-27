package umbjm.ft.inf.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Call
import retrofit2.Callback
import android.widget.Toast
import retrofit2.Response
import umbjm.ft.inf.retrofit.data.ResultUsers
import umbjm.ft.inf.retrofit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding // Replace 'ActivityMainBinding' with your actual binding class name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // Inflate the binding object
        setContentView(binding.root) // Set the root view of the activity to the binding root

        NetworkConfig().getService()
            .getUsers()
            .enqueue(object : Callback<List<ResultUsers>> {
                override fun onFailure(call: Call<List<ResultUsers>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: Call<List<ResultUsers>>,
                    response: Response<List<ResultUsers>>
                ) {
                    binding.rvUser.adapter = UsersAdapter(response.body()) // Use 'binding.recyclerView' instead of 'binding.adapter'
                }
            })
    }
}
