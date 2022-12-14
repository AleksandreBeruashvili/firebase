package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val resemail = email.text.toString()
            val respas = Pas.text.toString()

            if (resemail.isEmpty() || respas.isEmpty()) {
                Toast.makeText(this, "გრაფა ცარიელია", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(resemail,respas)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "წარმატებით შეიქმნა !", Toast.LENGTH_SHORT).show()
                    }else {
                        Toast.makeText(this, "სამწუხაროდ,ვერ შეიქმნა ", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}
