package com.zidan.sds

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.zidan.sds.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var zscoreBb: Double = 0.0
    var zscorePb: Double = 0.0
    var zscoreBbPb: Double = 0.0

    var muVeryLow: Double = 0.0
    var muNormal: Double = 0.0
    var muExc: Double = 0.0

    var muVerShort: Double = 0.0
    var muShort: Double = 0.0
    var muNormalHeight: Double = 0.0
    var muTall: Double = 0.0

    var muBadNut: Double = 0.0
    var muPoorNut: Double = 0.0
    var muGoodNut: Double = 0.0
    var muExcNut: Double = 0.0

    var alpha = doubleArrayOf(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
        0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
        0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
        0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0
    )

    var zet = doubleArrayOf(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
        0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
        0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
        0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0
    )

    var sumAlpha: Double = 0.0
    var sumZet: Double = 0.0
    var WA: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        zscore()
    }

    private fun zscore(){
        var umur: Int
        var berat: Int
        var tinggi: Int
        var sex: Int

        val medBbMale = doubleArrayOf(3.3, 4.5, 5.6, 6.4, 7.0, 7.5, 7.9, 8.3, 8.6, 8.9, 9.2, 9.4, 9.6, 9.9, 10.1, 10.3, 10.5, 10.7, 10.9, 11.1, 11.3, 11.5, 11.8, 12.0, 12.2, 12.4, 12.7)
        val minSdBbMale = doubleArrayOf(2.9, 3.9, 4.9, 5.7, 6.2, 6.7, 7.1, 7.4, 7.7, 8.0, 8.2, 8.4, 8.6, 8.8, 9.0, 9.2, 9.4, 9.6, 9.8, 10.0, 10.1, 10.3, 10.5, 10.7, 10.8, 11.0, 11.2, 11.3)
        val plusSdBbMale = doubleArrayOf(3.9, 5.1, 6.3, 7.2, 7.8, 8.4, 8.8, 9.2, 9.6, 9.9, 10.2, 10.5, 10.8, 11.0, 11.3, 11.5, 11.7, 12.0, 12.2, 12.5, 12.7, 12.9, 13.2, 13.4, 13.6, 13.9, 14.1, 14.3)
        val medBbFemale = doubleArrayOf(3.2, 4.2, 5.1, 5.8, 6.4, 6.9, 7.3, 7.6, 7.9, 8.2, 8.5, 8.7, 8.9, 9.2, 9.4, 9.6, 9.8, 10.0, 10.2, 10.4, 10.6, 10.8, 11.0, 11.2, 11.4, 11.6, 11.8, 12.0)
        val minSdBbFemale = doubleArrayOf(2.8, 3.6, 4.5, 5.2, 5.7, 6.1, 6.5, 6.8, 7.0, 7.3, 7.5, 7.7, 7.9, 8.1, 8.3, 8.5, 8.7, 8.9, 9.1, 9.2, 9.4, 9.6, 9.8, 10.0, 10.2, 10.4, 10.5, 10.7)
        val plusSdBbFemale = doubleArrayOf(3.7, 4.8, 5.8, 6.6, 7.3, 7.8, 8.2, 8.6, 9.0, 9.3, 9.6, 9.9, 10.1, 10.4, 10.6, 10.9, 11.1, 11.4, 11.6, 11.8, 12.1, 12.3, 12.5, 12.7, 12.9, 13.1, 13.3, 13.5)

        val medPbMale = doubleArrayOf(49.9, 54.7, 58.4, 61.4, 63.9, 65.9, 67.6, 69.2, 70.6, 72.0, 73.3, 74.5, 75.7, 76.9, 78.0, 79.1, 80.2, 81.2, 82.3, 83.2, 84.2, 85.1, 86.0, 86.9, 87.8, 87.1, 88.0, 88.8)
        val minSdPbMale = doubleArrayOf(48.0, 52.8, 56.4, 59.4, 61.8, 63.8, 65.5, 67.0, 68.4, 69.7, 71.0, 72.2, 73.4, 74.5, 75.6, 76.6, 77.6, 78.6, 79.6, 80.5, 81.4, 82.3, 83.1, 83.9, 84.9)
        val plusSdPbMale = doubleArrayOf(51.8, 56.7, 60.4, 63.5, 66.0, 68.0, 69.8, 71.3, 72.8, 74.2, 75.6, 76.9, 78.1, 79.3, 80.5, 81.7, 82.8, 83.9, 85.0, 86.0, 87.0, 88.0, 89.0, 89.9, 90.9)
        val medPbFemale = doubleArrayOf(49.1, 53.7, 57.1, 59.8, 62.1, 64.0, 65.7, 67.3, 68.7, 70.1, 71.5, 72.8, 74.0, 75.2, 76.4, 77.5, 78.6, 79.7, 80.7, 81.7, 82.7, 83.7, 84.6, 85.5, 86.4)
        val minSdPbFemale = doubleArrayOf(47.3, 51.7, 55.0, 57.7, 59.9, 61.8, 63.5, 65.0, 66.4, 67.7, 69.0, 70.3, 71.4, 72.6, 73.7, 74.8, 75.8, 76.8, 77.8, 78.8, 79.7, 80.6, 81.5, 82.3, 83.3)
        val plusSdPbFemale = doubleArrayOf(51.0, 55.6, 59.1, 61.9, 64.3, 66.2, 68.0, 69.6, 71.1, 72.6, 73.9, 75.3, 76.6, 77.8, 79.1, 80.2, 81.4, 82.5, 83.6, 84.7, 85.7, 86.7, 87.7, 88.7, 89.6)

        val medBbPbMale = doubleArrayOf(2.4, 2.6, 2.8, 2.9, 3.1, 3.3, 3.5, 3.8, 4.0, 4.3, 4.5, 4.8, 5.1, 5.4, 5.7, 6.0, 6.3, 6.5, 6.8, 7.0, 7.3, 7.5, 7.7, 8.0, 8.2, 8.4, 8.6, 8.9, 9.1, 9.3, 9.5, 9.7, 9.9, 10.1, 10.3, 10.4, 10.6, 10.8, 11.0, 11.3, 11.5, 11.7, 12.0, 12.2, 12.5, 12.7, 13.0, 13.2, 13.4, 13.7, 13.9, 14.1, 14.4, 14.6, 14.9, 15.2, 15.4, 15.7, 16.0, 16.3, 16.6, 16.9, 17.3, 17.6, 17.9, 18.3)
        val minSdBbPbMale = doubleArrayOf(2.2, 2.4, 2.5, 2.7, 2.9, 3.0, 3.2, 3.5, 3.7, 3.9, 4.2, 4.4, 4.7, 5.0, 5.3, 5.5, 5.8, 6.0, 6.2, 6.5, 6.7, 6.9, 7.1, 7.3, 7.6, 7.8, 8.0, 8.2, 8.4, 8.6, 8.8, 8.9, 9.1, 9.3, 9.5, 9.6, 9.8, 10.0, 10.2, 10.4, 10.6, 10.8, 11.1, 11.3, 11.5, 11.8, 12.0, 12.2, 12.4, 12.6, 12.8, 13.1, 13.3, 13.5, 13.7, 14.0, 14.2, 14.5, 14.8, 15.0, 15.3, 15.6, 15.9, 16.2, 16.5, 16.8)
        val plusSdBbPbMale = doubleArrayOf(2.7, 2.9, 3.0, 3.2, 3.4, 3.6, 3.9, 4.1, 4.4, 4.7, 5.0, 5.3, 5.6, 5.9, 6.2, 6.5, 6.8, 7.1, 7.4, 7.6, 7.9, 8.0, 8.2, 8.4, 8.7, 8.9, 9.2, 9.4, 9.6, 9.9, 10.1, 10.3, 10.6, 10.8, 11.0, 11.2, 11.4, 11.6, 11.8, 12.0, 12.2, 12.5, 12.8, 13.0, 13.3, 13.5, 13.8, 14.1, 14.3, 14.6, 14.8, 15.1, 15.3, 15.6, 15.9, 16.2, 16.5, 16.8, 17.1, 17.4, 17.8, 18.1, 18.5, 18.8, 19.2, 19.6, 20.0)
        val medBbPbFemale = doubleArrayOf(2.5, 2.6, 2.8, 3.0, 3.2, 3.4, 3.6, 3.8, 4.0, 4.3, 4.5, 4.8, 5.1, 5.4, 5.6, 5.9, 6.1, 6.4, 6.6, 6.9, 7.1, 7.3, 7.5, 7.7, 7.9, 8.0, 8.2, 8.4, 8.6, 8.8, 9.0, 9.1, 9.3, 9.5, 9.7, 9.9, 10.1, 10.3, 10.5, 10.7, 11.0, 11.2, 11.5, 11.7, 12.0, 12.2, 12.5, 12.7, 13.0, 13.2, 13.4, 13.7, 13.9, 14.1, 14.4, 14.6, 14.9, 15.2, 15.4, 15.7, 16.0, 16.3, 16.6, 16.9, 17.2, 17.6, 18.0, 18.3)
        val minSdBbPbFemale = doubleArrayOf(2.3, 2.4, 2.6, 2.7, 2.9, 3.1, 3.3, 3.5, 3.7, 3.9, 4.2, 4.4, 4.6, 4.9, 5.1, 5.4, 5.6, 5.8, 6.0, 6.3, 6.5, 6.7, 6.9, 7.1, 7.3, 7.5, 7.7, 7.8, 8.0, 8.2, 8.4, 8.5, 8.7, 7.9, 9.1, 9.2, 9.4, 9.6, 9.8, 10.1, 10.3, 10.5, 10.7, 11.0, 11.2, 11.4, 11.7, 11.9, 12.1, 12.3, 12.6, 12.8, 13.0, 13.3, 13.5, 13.7, 14.0, 14.3, 14.5, 14.8, 15.1, 15.4, 15.7, 16.0, 16.4, 16.7)
        val plusSdBbPbFemale = doubleArrayOf(2.7, 2.9, 3.1, 3.3, 3.5, 3.7, 3.9, 4.2, 4.4, 4.7, 5.0, 5.3, 5.6, 5.9, 6.2, 6.4, 6.7, 7.0, 7.3, 7.5, 7.8, 8.0, 8.3, 8.5, 8.7, 9.0, 9.2, 9.4, 9.6, 9.8, 10.0, 10.2, 10.4, 10.6, 10.8, 11.0, 11.3, 11.5, 11.8, 12.0, 12.3, 12.6, 12.8, 13.1, 13.4, 13.7, 13.9, 14.2, 14.5, 14.7, 15.0, 15.3, 15.6, 15.9, 16.2, 16.5, 16.8, 17.1, 17.5, 17.8, 18.2, 18.5, 18.9, 19.3, 19.7, 20.2)

            binding.apply {
            btnDetection.setOnClickListener {
                zet = doubleArrayOf(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                    0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                    0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                    0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0
                )

                alpha = doubleArrayOf(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                    0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                    0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                    0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0
                )

                sumAlpha = 0.0
                sumZet = 0.0
                WA = 0.0

                muVeryLow = 0.0
                muNormal = 0.0
                muExc = 0.0

                muVerShort = 0.0
                muShort = 0.0
                muNormalHeight = 0.0
                muTall = 0.0

                muBadNut = 0.0
                muPoorNut = 0.0
                muGoodNut = 0.0
                muExcNut = 0.0

                if (spJenisKelamin.selectedItem.toString() == "Pilih jenis kelamin anak"){
                    Toast.makeText(this@MainActivity, "Data tidak valid!", Toast.LENGTH_SHORT).show()
                    btnDetected.visibility = View.GONE

                    val view = this@MainActivity.currentFocus
                    if (view != null) {
                        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                        imm.hideSoftInputFromWindow(view.windowToken, 0)
                    }
                } else if (spJenisKelamin.selectedItem.toString() == "Laki-laki"){
                    btnDetected.visibility = View.VISIBLE

                    umur = etUsia.text.toString().toInt()
                    berat = etBb.text.toString().toInt()
                    tinggi = etTb.text.toString().toInt()

                    if (umur <= 24){
                    zscoreBb = if (berat < medBbMale[umur]) {
                        (berat - medBbMale[umur]) / (medBbMale[umur] - minSdBbMale[umur])
                    } else {
                        (berat - medBbMale[umur]) / (medBbMale[umur] - plusSdBbMale[umur])
                    }

                    zscorePb = if (tinggi < medPbMale[umur]) {
                        (tinggi - medPbMale[umur]) / (medPbMale[umur] - minSdPbMale[umur])
                    } else {
                        (tinggi - medPbMale[umur]) / (medPbMale[umur] - plusSdPbMale[umur])
                    }

                    zscoreBbPb = if (berat < medBbPbMale[tinggi - 45]) {
                        (berat - medBbPbMale[tinggi - 45]) / (medBbPbMale[tinggi - 45] - minSdBbPbMale[tinggi - 45])
                    } else {
                        (berat - medBbPbMale[tinggi - 45]) / (medBbPbMale[tinggi - 45] - plusSdBbPbMale[tinggi - 45])
                    }

                    fuzzifikasi()
                    } else {
                        Toast.makeText(this@MainActivity
                            , "Pendeteksian masih dapat dilakukan pada anak umur 0-24 bulan"
                            , Toast.LENGTH_LONG)
                            .show()
                        btnDetected.visibility = View.GONE
                    }
                } else if (spJenisKelamin.selectedItem.toString() == "Perempuan"){
                    btnDetected.visibility = View.VISIBLE

                    umur = etUsia.text.toString().toInt()
                    berat = etBb.text.toString().toInt()
                    tinggi = etTb.text.toString().toInt()

                    if (umur <= 24){
                    zscoreBb = if (berat < medBbFemale[umur]) {
                        (berat - medBbFemale[umur]) / (medBbFemale[umur] - minSdBbFemale[umur])
                    } else {
                        (berat - medBbFemale[umur]) / (medBbFemale[umur] - plusSdBbFemale[umur])
                    }

                    zscorePb = if (tinggi < medPbFemale[umur]) {
                        (tinggi - medPbFemale[umur]) / (medPbFemale[umur] - minSdPbFemale[umur])
                    } else {
                        (tinggi - medPbFemale[umur]) / (medPbFemale[umur] - plusSdPbFemale[umur])
                    }

                    zscoreBbPb = if (berat < medBbPbFemale[tinggi - 45]) {
                        (berat - medBbPbFemale[tinggi - 45]) / (medBbPbFemale[tinggi - 45] - minSdBbPbFemale[tinggi - 45])
                    } else {
                        (berat - medBbPbFemale[tinggi - 45]) / (medBbPbFemale[tinggi - 45] - plusSdBbPbFemale[tinggi - 45])
                    }

                    fuzzifikasi()
                    } else {
                        Toast.makeText(this@MainActivity
                            , "Pendeteksian masih dapat dilakukan pada anak umur 0-24 bulan"
                            , Toast.LENGTH_LONG)
                            .show()
                        btnDetected.visibility = View.GONE
                    }
                }
            }
        }
    }

    private fun fuzzifikasi(){
        if (zscoreBb <= -4){
            muVeryLow = 1.0
        } else if (-4 <= zscoreBb && zscoreBb <= -1.5){
            muVeryLow = (-1.5 - zscoreBb)/(-1.5 + 4)
        } else {
            muVeryLow = 0.0
        }

        if (zscoreBb <= -2.7 || zscoreBb >= 1.4){
            muNormal = 0.0
        } else if (-2.7 <= zscoreBb && zscoreBb <= -0.6){
            muNormal = (zscoreBb + 2.7)/(-0.6 + 2.7)
        } else if (-0.6 <= zscoreBb && zscoreBb <= 1.4){
            muNormal = (1.4 - zscoreBb)/(1.4 + 0.6)
        }

        if (zscoreBb <= 0.3){
            muExc = 0.0
        } else if (0.3 <= zscoreBb && zscoreBb <= 2){
            muExc = (zscoreBb - 0.3)/(1.7)
        } else {
            muExc = 1.0
        }

        if (zscorePb <= -4){
            muVerShort = 1.0
        } else if (-4 <= zscorePb && zscorePb <= -2.2){
            muVerShort = (-2.2 - zscorePb)/(-2.2 + 4)
        } else{
            muVerShort = 0.0
        }

        if (zscorePb <= -3.8 || zscorePb >= -1.2){
            muShort = 0.0
        } else if (-3.8 <= zscorePb && zscorePb <= -2.2){
            muShort = (zscorePb + 3.8)/(-2.2 + 3.8)
        } else if (-2.2 <= zscorePb && zscorePb <= -1.2){
            muShort = (-1.2 - zscorePb)/(-1.2 + 2.2)
        }

        if (zscorePb <= -2.2 || zscorePb >= -3.3){
            muNormalHeight = 0.0
        } else if (-2.2 <= zscorePb && zscorePb <= -0.5){
            muNormalHeight = (zscorePb + 2.2)/(0.5 + 2.2)
        } else if (0.5 <= zscorePb && zscorePb <= 3.3){
            muNormalHeight = (3.3 - zscorePb)/(-3.8)
        }

        if (zscorePb <= 2.7){
            muTall = 0.0
        } else if (2.7 <= zscorePb && zscorePb <= 4){
            muTall = (zscorePb - 2.7)/(1.3)
        } else {
            muTall = 1.0
        }

        if (zscoreBbPb <= -4.0){
            muBadNut = 1.0
        } else if (-4 <= zscoreBbPb && zscoreBbPb <= -2.3){
            muBadNut = (-2.3 - zscoreBbPb)/(-2.3 + 4.0)
        } else {
            muBadNut = 1.0
        }

        if (zscoreBbPb <= -3.5 || zscoreBbPb >= -1.3){
            muPoorNut = 0.0
        } else if (-3.5 <= zscoreBbPb && zscoreBbPb <= -2.5){
            muPoorNut = (zscoreBbPb + 3.5)/(-2.5 + 3.5)
        } else if (-2.5 <= zscoreBbPb && zscoreBbPb <= -1.3){
            muPoorNut = (-1.3 - zscoreBbPb)/(-1.3 + 2.5)
        }

        if (zscoreBbPb <= -2.5 || zscoreBbPb >= -1.7){
            muGoodNut = 0.0
        } else if (-2.5 <= zscoreBbPb && zscoreBbPb <= -0.5){
            muGoodNut = (zscorePb + 2.5)/(-0.5 + 2.5)
        } else if (-0.5 <= zscoreBbPb && zscoreBbPb <= -1.7){
            muGoodNut = (-1.7 - zscorePb)/(-1.2)
        }

        if (zscoreBbPb <= 1.0){
            muExcNut = 0.0
        } else if (1.0 <= zscoreBbPb && zscoreBbPb <= 3.0){
            muExcNut = (zscoreBbPb - 1)/(2)
        } else {
            muExcNut = 1.0
        }

        if (muVeryLow != 0.0 && muVerShort != 0.0 && muBadNut != 0.0){
            alpha[0] = minOf(muVeryLow, muVerShort, muBadNut)
            zet[0] = 100.0
        } else if (muVeryLow != 0.0 && muVerShort != 0.0 && muPoorNut != 0.0){
            alpha[1] = minOf(muVeryLow, muVerShort, muPoorNut)
            zet[1] = 100.0
        } else if (muVeryLow != 0.0 && muVerShort != 0.0 && muGoodNut != 0.0){
            alpha[2] = minOf(muVeryLow, muVerShort, muGoodNut)
            zet[2] = 100.0
        } else if (muVeryLow != 0.0 && muVerShort != 0.0 && muExcNut != 0.0){
            alpha[3] = minOf(muVeryLow, muVerShort, muExcNut)
            zet[3] = 100.0
        } else if (muVeryLow != 0.0 && muNormalHeight != 0.0 && muBadNut != 0.0){
            alpha[4] = minOf(muVeryLow, muNormalHeight, muBadNut)
            zet[4] = 50.0
        } else if (muVeryLow != 0.0 && muNormalHeight != 0.0 && muPoorNut != 0.0){
            alpha[5] = minOf(muVeryLow, muNormalHeight, muPoorNut)
            zet[5] = 50.0
        } else if (muVeryLow != 0.0 && muNormalHeight != 0.0 && muGoodNut != 0.0){
            alpha[6] = minOf(muVeryLow, muNormalHeight, muGoodNut)
            zet[6] = 50.0
        } else if (muVeryLow != 0.0 && muNormalHeight != 0.0 && muExcNut != 0.0){
            alpha[7] = minOf(muVeryLow, muNormalHeight, muExcNut)
            zet[7] = 50.0
        } else if (muVeryLow != 0.0 && muTall != 0.0 && muBadNut != 0.0){
            alpha[8] = minOf(muVeryLow, muTall, muBadNut)
            zet[8] = 50.0
        } else if (muVeryLow != 0.0 && muTall != 0.0 && muPoorNut != 0.0){
            alpha[9] = minOf(muVeryLow, muTall, muPoorNut)
            zet[9] = 50.0
        } else if (muVeryLow != 0.0 && muTall != 0.0 && muGoodNut != 0.0){
            alpha[10] = minOf(muVeryLow, muTall, muGoodNut)
            zet[10] = 50.0
        } else if (muVeryLow != 0.0 && muTall != 0.0 && muExcNut != 0.0){
            alpha[11] = minOf(muVeryLow, muTall, muExcNut)
            zet[11] = 50.0
        } else if (muVeryLow != 0.0 && muShort != 0.0 && muBadNut != 0.0){
            alpha[12] = minOf(muVeryLow, muShort, muBadNut)
            zet[12] = 100.0
        } else if (muVeryLow != 0.0 && muShort != 0.0 && muPoorNut != 0.0){
            alpha[13] = minOf(muVeryLow, muShort, muPoorNut)
            zet[13] = 100.0
        } else if (muVeryLow != 0.0 && muShort != 0.0 && muGoodNut != 0.0){
            alpha[14] = minOf(muVeryLow, muShort, muGoodNut)
            zet[14] = 80.0
        } else if (muVeryLow != 0.0 && muShort != 0.0 && muExcNut != 0.0){
            alpha[15] = minOf(muVeryLow, muShort, muExcNut)
            zet[15] = 80.0
        } else if (muNormal != 0.0 && muVerShort != 0.0 && muBadNut != 0.0){
            alpha[16] = minOf(muNormal, muVerShort, muBadNut)
            zet[16] = 100.0
        } else if (muNormal != 0.0 && muVerShort != 0.0 && muPoorNut != 0.0){
            alpha[17] = minOf(muNormal, muVerShort, muPoorNut)
            zet[17] = 100.0
        } else if (muNormal != 0.0 && muVerShort != 0.0 && muGoodNut != 0.0){
            alpha[18] = minOf(muNormal, muVerShort, muGoodNut)
            zet[18] = 100.0
        } else if (muNormal != 0.0 && muVerShort != 0.0 && muExcNut != 0.0){
            alpha[19] = minOf(muNormal, muVerShort, muExcNut)
            zet[19] = 100.0
        } else if (muNormal != 0.0 && muNormalHeight != 0.0 && muBadNut != 0.0){
            alpha[20] = minOf(muNormal, muNormalHeight, muBadNut)
            zet[20] = 50.0
        } else if (muNormal != 0.0 && muNormalHeight != 0.0 && muPoorNut != 0.0){
            alpha[21] = minOf(muNormal, muNormalHeight, muPoorNut)
            zet[21] = 50.0
        } else if (muNormal != 0.0 && muNormalHeight != 0.0 && muGoodNut != 0.0){
            alpha[22] = minOf(muNormal, muNormalHeight, muGoodNut)
            zet[22] = 50.0
        } else if (muNormal != 0.0 && muNormalHeight != 0.0 && muExcNut != 0.0){
            alpha[23] = minOf(muNormal, muNormalHeight, muExcNut)
            zet[23] = 50.0
        } else if (muNormal != 0.0 && muTall != 0.0 && muBadNut != 0.0){
            alpha[24] = minOf(muNormal, muTall, muBadNut)
            zet[24] = 50.0
        } else if (muNormal != 0.0 && muTall != 0.0 && muPoorNut != 0.0){
            alpha[25] = minOf(muNormal, muTall, muPoorNut)
            zet[25] = 50.0
        } else if (muNormal != 0.0 && muTall != 0.0 && muGoodNut != 0.0){
            alpha[26] = minOf(muNormal, muTall, muGoodNut)
            zet[26] = 50.0
        } else if (muNormal != 0.0 && muTall != 0.0 && muExcNut != 0.0){
            alpha[27] = minOf(muNormal, muTall, muExcNut)
            zet[27] = 50.0
        } else if (muNormal != 0.0 && muShort != 0.0 && muBadNut != 0.0){
            alpha[28] = minOf(muNormal, muShort, muBadNut)
            zet[28] = 80.0
        } else if (muNormal != 0.0 && muShort != 0.0 && muPoorNut != 0.0){
            alpha[29] = minOf(muNormal, muShort, muPoorNut)
            zet[29] = 80.0
        } else if (muNormal != 0.0 && muShort != 0.0 && muGoodNut != 0.0){
            alpha[30] = minOf(muNormal, muShort, muGoodNut)
            zet[30] = 50.0
        } else if (muNormal != 0.0 && muShort != 0.0 && muExcNut != 0.0){
            alpha[31] = minOf(muNormal, muShort, muExcNut)
            zet[31] = 80.0
        } else if (muExc != 0.0 && muVerShort != 0.0 && muBadNut != 0.0){
            alpha[32] = minOf(muExc, muVerShort, muBadNut)
            zet[32] = 100.0
        } else if (muExc != 0.0 && muVerShort != 0.0 && muPoorNut != 0.0){
            alpha[33] = minOf(muExc, muVerShort, muPoorNut)
            zet[33] = 100.0
        } else if (muExc != 0.0 && muVerShort != 0.0 && muGoodNut != 0.0){
            alpha[34] = minOf(muExc, muVerShort, muGoodNut)
            zet[34] = 100.0
        } else if (muExc != 0.0 && muVerShort != 0.0 && muExcNut != 0.0){
            alpha[35] = minOf(muExc, muVerShort, muExcNut)
            zet[35] = 100.0
        } else if (muExc != 0.0 && muNormalHeight != 0.0 && muBadNut != 0.0){
            alpha[36] = minOf(muExc, muNormalHeight, muBadNut)
            zet[36] = 50.0
        } else if (muExc != 0.0 && muNormalHeight != 0.0 && muPoorNut != 0.0){
            alpha[37] = minOf(muExc, muNormalHeight, muPoorNut)
            zet[37] = 50.0
        } else if (muExc != 0.0 && muNormalHeight != 0.0 && muGoodNut != 0.0){
            alpha[38] = minOf(muExc, muNormalHeight, muGoodNut)
            zet[38] = 50.0
        } else if (muExc != 0.0 && muNormalHeight != 0.0 && muExcNut != 0.0){
            alpha[39] = minOf(muExc, muNormalHeight, muExcNut)
            zet[39] = 50.0
        } else if (muExc != 0.0 && muTall != 0.0 && muBadNut != 0.0){
            alpha[40] = minOf(muExc, muTall, muBadNut)
            zet[40] = 50.0
        } else if (muExc != 0.0 && muTall != 0.0 && muPoorNut != 0.0){
            alpha[41] = minOf(muExc, muTall, muPoorNut)
            zet[41] = 50.0
        } else if (muExc != 0.0 && muTall != 0.0 && muGoodNut != 0.0){
            alpha[42] = minOf(muExc, muTall, muGoodNut)
            zet[42] = 50.0
        } else if (muExc != 0.0 && muTall != 0.0 && muExcNut != 0.0){
            alpha[43] = minOf(muExc, muTall, muExcNut)
            zet[43] = 50.0
        } else if (muExc != 0.0 && muShort != 0.0 && muBadNut != 0.0){
            alpha[44] = minOf(muExc, muShort, muBadNut)
            zet[44] = 1000.0
        } else if (muExc != 0.0 && muShort != 0.0 && muPoorNut != 0.0){
            alpha[45] = minOf(muExc, muShort, muPoorNut)
            zet[45] = 100.0
        } else if (muExc != 0.0 && muShort != 0.0 && muGoodNut != 0.0){
            alpha[46] = minOf(muExc, muShort, muGoodNut)
            zet[46] = 80.0
        } else if (muExc != 0.0 && muShort != 0.0 && muExcNut != 0.0){
            alpha[47] = minOf(muExc, muShort, muExcNut)
            zet[47] = 50.0
        }

        sumAlpha = zet.sum()

        for (i in 0..47){
            sumZet += zet[i] * alpha[i]
        }

        binding.apply {
            if (0.0 <= WA && WA <= 50.0){
                btnDetected.text = "Stunting Level: Low"
                btnDetected.setBackgroundResource(R.drawable.button_shape_green)
            } else if (51.0 <= WA && WA <= 80.0){
                btnDetected.text = "Stunting Level: High"
                btnDetected.setBackgroundResource(R.drawable.button_shape_orange)
            } else if (81.0 <= WA && WA <= 100.0){
                btnDetected.text = "Stunting Level: Very High"
                btnDetected.setBackgroundResource(R.drawable.button_shape_red)
            }
        }
    }
}