package com.example.tugas10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.tugas10.databinding.ActivityMainBinding
import com.example.tugas10.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        title = "myApp"
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val name = intent.getStringExtra("name")
        val ipk = intent.getStringExtra("ipk")
        val photo = intent.getStringExtra("photo")
        val birth = intent.getStringExtra("birth")
        val location = intent.getStringExtra("location")
        with(binding){
            val resID = root.context.resources.getIdentifier(
                photo,
                "drawable",
                root.context.packageName
            )
            fotoSiswa.setImageResource(resID)
            namaSiswa.text = name
            ipkSiswa.text = ipk
            birthSiswa.text = birth
            lokasiSiswa.text = location
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_options, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_back -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}