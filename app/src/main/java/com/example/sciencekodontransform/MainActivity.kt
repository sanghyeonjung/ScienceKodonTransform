package com.example.sciencekodontransform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.sciencekodontransform.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val kodon_hashMap = HashMap<String, String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        putInfo()

        binding.mainTranscriptionButton.setOnClickListener {
            val str: String = binding.mainOriginalEdittext.text.toString()
            if (str.isBlank()) {
                Toast.makeText(this, "빈칸을 채워주세요", Toast.LENGTH_SHORT).show()
            }
            if (binding.mainTranscriptionTextview.text.isNotBlank()) {
                binding.mainTranslateTextview.text = ""
                binding.mainTranscriptionTextview.text = ""
            }

            if (str.length % 3 == 0) {
                for (i in 0..(str.length - 1)) {
                    var c: String = ""
                    if (str[i] == 'T') {
                        c = "A"
                    } else if (str[i] == 'A') {
                        c = "U"
                    } else if (str[i] == 'G') {
                        c = "C"
                    } else if (str[i] == 'C') {
                        c = "G"
                    }
                    binding.mainTranscriptionTextview.text =
                        StringBuilder(binding.mainTranscriptionTextview.text.toString()).append(c)
                            .toString()
                }
            } else {
                Toast.makeText(this@MainActivity, "입력문의 길이가 3으로 나눠떨어지지 않습니다.", Toast.LENGTH_SHORT)
                    .show()
            }
        }
        binding.mainTranslateButton.setOnClickListener {
            val str: String = binding.mainTranscriptionTextview.text.toString();
            var resultstr: String = ""
            if (str.isBlank()) {
                Toast.makeText(this, "전사를 먼저 해주세요", Toast.LENGTH_SHORT).show()
            } else {
                val aminoacidLength: Int = str.length / 3;
                Log.e("len", aminoacidLength.toString())
                for (i in 0 until aminoacidLength) {
                    var kodon: String = "";
                    for (j in i * 3 until i * 3 + 3) {
                        kodon += str[j]
                    }
                    Log.e("kodon ", kodon)
                    Log.e("aminoacid ", kodon_hashMap[kodon].toString())
                    resultstr += kodon + " : " + kodon_hashMap[kodon].toString() + "\n"
                }
                binding.mainTranslateTextview.text = resultstr
            }
        }

        binding.mainInitButton.setOnClickListener {
            binding.mainOriginalEdittext.setText("")
            binding.mainTranslateTextview.text = ""
            binding.mainTranscriptionTextview.text = ""
        }
    }

    fun putInfo() {
        kodon_hashMap["UUU"] = "페닐알라닌"
        kodon_hashMap["UUC"] = "페닐알라닌"

        kodon_hashMap["UUA"] = "류신"
        kodon_hashMap["UUG"] = "류신"

        kodon_hashMap["CUU"] = "류신"
        kodon_hashMap["CUC"] = "류신"
        kodon_hashMap["CUA"] = "류신"
        kodon_hashMap["CUG"] = "류신"

        kodon_hashMap["AUU"] = "아이소류신"
        kodon_hashMap["AUC"] = "아이소류신"
        kodon_hashMap["AUA"] = "아이소류신"
        kodon_hashMap["AUG"] = "메싸이오닌(개시 코돈)"

        kodon_hashMap["GUU"] = "발린"
        kodon_hashMap["GUC"] = "발린"
        kodon_hashMap["GUA"] = "발린"
        kodon_hashMap["GUG"] = "발린"

        kodon_hashMap["UCU"] = "세린"
        kodon_hashMap["UCC"] = "세린"
        kodon_hashMap["UCA"] = "세린"
        kodon_hashMap["UCG"] = "세린"

        kodon_hashMap["CCU"] = "프롤린"
        kodon_hashMap["CCC"] = "프롤린"
        kodon_hashMap["CCA"] = "프롤린"
        kodon_hashMap["CCG"] = "프롤린"

        kodon_hashMap["ACU"] = "트레오닌"
        kodon_hashMap["ACC"] = "트레오닌"
        kodon_hashMap["ACA"] = "트레오닌"
        kodon_hashMap["ACG"] = "트레오닌"

        kodon_hashMap["GCU"] = "알라닌"
        kodon_hashMap["GCC"] = "알라닌"
        kodon_hashMap["GCA"] = "알라닌"
        kodon_hashMap["GCG"] = "알라닌"

        kodon_hashMap["UAU"] = "타이로신"
        kodon_hashMap["UAC"] = "타이로신"

        kodon_hashMap["UAA"] = "종결코돈"
        kodon_hashMap["UAG"] = "종결코돈"

        kodon_hashMap["CAU"] = "히스티딘"
        kodon_hashMap["CAC"] = "히스티딘"

        kodon_hashMap["CAA"] = "글루타민"
        kodon_hashMap["CAG"] = "글루타민"

        kodon_hashMap["AAU"] = "아스파라진"
        kodon_hashMap["AAC"] = "아스파라진"

        kodon_hashMap["AAA"] = "라이신"
        kodon_hashMap["AAG"] = "라이신"

        kodon_hashMap["GAU"] = "아스파트산"
        kodon_hashMap["GAC"] = "아스파트산"

        kodon_hashMap["GAA"] = "글루탐산"
        kodon_hashMap["GAG"] = "글루탐산"

        kodon_hashMap["UGU"] = "시스테인"
        kodon_hashMap["UGC"] = "시스테인"

        kodon_hashMap["UGA"] = "종결 코돈"

        kodon_hashMap["UGG"] = "트립토판"

        kodon_hashMap["CGU"] = "아르지닌"
        kodon_hashMap["CGC"] = "아르지닌"
        kodon_hashMap["CGA"] = "아르지닌"
        kodon_hashMap["CGG"] = "아르지닌"

        kodon_hashMap["AGU"] = "세린"
        kodon_hashMap["AGC"] = "세린"

        kodon_hashMap["AGA"] = "아르지닌"
        kodon_hashMap["AGG"] = "아르지닌"

        kodon_hashMap["GGU"] = "글라이신"
        kodon_hashMap["GGC"] = "글라이신"
        kodon_hashMap["GGA"] = "글라이신"
        kodon_hashMap["GGG"] = "글라이신"
    }
}