package com.ali.penghitungkalorimyhealt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnpindah: Button = findViewById(R.id.pindah)
        val btnhitung: Button = findViewById(R.id.hitung)

        btnhitung.setOnClickListener{
            val tvnama: TextView = findViewById(R.id.nama)
            val tvumur: TextView = findViewById(R.id.umur)
            val tvtinggi: TextView = findViewById(R.id.tinggi)
            val tvberat: TextView = findViewById(R.id.berat)
            val tvgender: TextView = findViewById(R.id.gender)
            val tvkalori: TextView = findViewById(R.id.kalori)


            val nama = intent.getStringExtra("EXTRA_NAMA")
            val umur = intent.getIntExtra("EXTRA_UMUR",0)
            val tinggi = intent.getIntExtra("EXTRA_TINGGI",0)
            val berat = intent.getIntExtra("EXTRA_BERAT",0)
            val gender = intent.getStringExtra("EXTRA_GENDER")

            val kalori = if (gender == "Laki-Laki"){
                66.5 + (13.75 * berat) + (5.003 * tinggi) - (6.75 * umur)
            } else {
                655.1 + (9.563 * berat) + (1.850 * tinggi) - (4.676 * umur)
            }
            val kaloriharian = "kalori harianmu sebanyak : " + kalori + " Cal"

            tvnama.text = nama
            tvumur.text = umur.toString()
            tvtinggi.text = tinggi.toString()
            tvberat.text = berat.toString()
            tvgender.text = gender
            tvkalori.text= kaloriharian.toString()

        }
        btnpindah.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.pindah -> {
                val moveIntent = Intent(this@MainActivity, inputan::class.java)
                startActivity(moveIntent)
            }

        }
    }
}