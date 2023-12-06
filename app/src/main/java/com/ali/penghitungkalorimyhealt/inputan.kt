package com.ali.penghitungkalorimyhealt

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get



class inputan : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inputan)

        val btn_submit= findViewById<Button>(R.id.btn_sumbit)





        btn_submit.setOnClickListener{
            submitit()
        }
    }

    private fun submitit() {
        val ednamauser= findViewById<EditText>(R.id.nama)
        val edumuruser= findViewById<EditText>(R.id.umur)
        val edtinggiuser=findViewById<EditText>(R.id.tinggi)
        val edberatuser=findViewById<EditText>(R.id.berat)




        val spngender = findViewById<Spinner>(R.id.kelamin)



        val namauser = ednamauser.text.toString()
        val umuruser = edumuruser.text.toString().toInt()
        val tinggiuser = edtinggiuser.text.toString().toInt()
        val beratuse =  edberatuser.text.toString().toInt()
        val genderuser = spngender.selectedItem.toString()

        val intent= Intent(this, MainActivity::class.java).also {
            it.putExtra("EXTRA_NAMA", namauser)
            it.putExtra("EXTRA_UMUR", umuruser)
            it.putExtra("EXTRA_TINGGI", tinggiuser)
            it.putExtra("EXTRA_BERAT", beratuse)
            it.putExtra("EXTRA_GENDER", genderuser)

            startActivity(it)
        }
     fun onNothingSelected(parentView: AdapterView<*>?) {
            // Di sini Anda dapat menangani kasus ketika tidak ada yang dipilih
        }
    }
}
