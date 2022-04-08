package com.example.permission

import android.Manifest.*
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var editText = findViewById<EditText>(R.id.editText)
        var btn1 = findViewById<Button>(R.id.btn1)

        btn1.setOnClickListener {
            if (ContextCompat.checkSelfPermission( this,permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this, arrayOf(permission.CALL_PHONE),1)
            } else {
                //Toast.makeText( this, "PERMISSÃO CONCEDIDA", Toast.LENGTH_LONG).show()
                var telefone = editText.text.toString()
                var intent = Intent(Intent.ACTION_CALL, Uri.parse("tel: " + telefone) )
                startActivity(intent)
            }


        }


    }
}