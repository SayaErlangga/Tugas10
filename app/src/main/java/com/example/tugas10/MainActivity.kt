package com.example.pertemuan10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugas10.SecondActivity
import com.example.tugas10.Siswa
import com.example.tugas10.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        title ="myApp"
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val adapterSiswa = SiswaAdapter(generateSiswa()) {
            siswa ->
            Toast.makeText(this@MainActivity, "Detail Lengkap ${siswa.name}", Toast.LENGTH_SHORT).show()
            val intentToSecondActivity = Intent(this@MainActivity, SecondActivity::class.java)
            intentToSecondActivity.putExtra("name", siswa.name)
            intentToSecondActivity.putExtra("ipk", siswa.ipk)
            intentToSecondActivity.putExtra("photo", siswa.photo)
            intentToSecondActivity.putExtra("birth", siswa.birth)
            intentToSecondActivity.putExtra("location", siswa.location)
            startActivity(intentToSecondActivity)
        }
        setContentView(binding.root)
        with(binding){
            rvSiswa.apply {
                adapter = adapterSiswa
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }

    fun generateSiswa() : List<Siswa>{
        return listOf(
            Siswa(name ="Akmal", ipk ="4.0", photo="boy", birth = "22 September 2002", location = "Yogyakarta" ),
            Siswa(name ="Zaenal", ipk ="3.6", photo="boy2", birth = "01 Maret 2004", location = "Bantul"),
            Siswa(name ="Safitri", ipk ="3.4", photo="girl", birth = "17 Agustus 2001", location = "Ketandan")
        )
    }
}