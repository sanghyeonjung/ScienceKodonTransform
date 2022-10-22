package com.example.kodontransform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.sciencekodontransform.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.mainTranscriptionButton.setOnClickListener {
            val str : String = binding.mainOriginalEdittext.text.toString()
            if(str.length %3 ==0)
            {
                for(i in 0..(str.length-1)){
                    var c : String = ""
                    if(str[i]=='T')
                    {
                        c = "A"
                    }
                    else if(str[i]=='A')
                    {
                        c = "U"
                    }
                    else if(str[i]=='G')
                    {
                        c = "C"
                    }
                    else if(str[i]=='C')
                    {
                        c = "G"
                    }
                    binding.mainTranscriptionTextview.text = StringBuilder(binding.mainTranscriptionTextview.text.toString()).append(c).toString()
                }
            }
            else
            {
                Toast.makeText(this@MainActivity,"입력문의 길이가 3으로 나눠떨어지지 않습니다.",Toast.LENGTH_SHORT).show()
            }
        }
    }
}