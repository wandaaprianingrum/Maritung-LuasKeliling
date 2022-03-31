package org.d3if1027.maritung

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.RadioButton
import org.d3if1027.maritung.databinding.ActivityMainBinding
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            hitungKelilingLuas()
        }

        binding.button3.setOnClickListener {
            resetHitung()
        }
    }

    private fun hitungKelilingLuas() {
        val panjang = binding.panjangInp.text.toString().toDouble()
        if (TextUtils.isEmpty(panjang.toString())) {
            Toast.makeText(this, R.string.panjang_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val lebar = binding.lebarInp.text.toString().toDouble()
        if (TextUtils.isEmpty(lebar.toString())) {
            Toast.makeText(this, R.string.lebar_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val selectedId = binding.radioGroup.checkedRadioButtonId
        if (selectedId == -1) {
            Toast.makeText(this, R.string.hitung_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val keliling = 2 * (panjang + lebar)
        val luas = panjang * lebar

        val isKeliling = selectedId == R.id.kelilingRadioButton
        if (isKeliling) {
            binding.kelilingTextView.text = getString(R.string.keliling_x, keliling)
        } else {
            binding.kelilingTextView.text = getString(R.string.luas_x, luas)
        }
    }

    private fun resetHitung() {
        binding.panjangInp.setText("")
        binding.lebarInp.setText("")
        binding.radioGroup.clearCheck()
        binding.kelilingTextView.setText("Keliling: ")
        binding.luasTextView.setText("Luas: ")
    }
}