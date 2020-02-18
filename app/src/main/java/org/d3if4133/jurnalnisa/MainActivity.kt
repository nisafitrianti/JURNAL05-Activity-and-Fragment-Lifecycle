package org.d3if4133.jurnalnisa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*
import org.d3if4133.jurnalnisa.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private var nilaiA = 0
    private var nilaiB = 0
    private val KEY_NILAI_A = "nilai_A"
    private val KEY_NILAI_B = "nilai_B"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btnPlus3A.setOnClickListener {
            this.nilaiA = plus3(nilaiA)
            binding.tvScoreA.setText(nilaiA.toString())
        }

        binding.btnPlus2A.setOnClickListener {
            this.nilaiA = plus2(nilaiA)
            binding.tvScoreA.setText(nilaiA.toString())
        }

        binding.btnFreethrowA.setOnClickListener {
            this.nilaiA = freeThrow(nilaiA)
            binding.tvScoreA.setText(nilaiA.toString())
        }



        binding.btnPlus3B.setOnClickListener {
            this.nilaiB = plus3(nilaiB)
            binding.tvScoreB.setText(nilaiB.toString())
        }

        binding.btnPlus2B.setOnClickListener {
            this.nilaiB = plus2(nilaiB)
            binding.tvScoreB.setText(nilaiB.toString())
        }

        binding.btnFreethrowB.setOnClickListener {
            this.nilaiB = freeThrow(nilaiB)
            binding.tvScoreB.setText(nilaiB.toString())
        }


        binding.btnReset.setOnClickListener {
            this.nilaiA = 0
            this.nilaiB = 0
            binding.tvScoreA.setText(nilaiA.toString())
            binding.tvScoreB.setText(nilaiB.toString())

        }

        if(savedInstanceState != null){
            nilaiA = savedInstanceState.getInt(KEY_NILAI_A, nilaiA)
            nilaiB = savedInstanceState.getInt(KEY_NILAI_B, nilaiB)
        }

        binding.tvScoreA.setText(nilaiA.toString())
        binding.tvScoreB.setText(nilaiB.toString())

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_NILAI_A,nilaiA)
        outState.putInt(KEY_NILAI_B,nilaiB)
    }

    fun plus3(nilai: Int):Int{
        return nilai+3
    }

    fun plus2(nilai : Int):Int{
        return nilai+2
    }

    fun freeThrow(nilai: Int):Int{
        return nilai+1
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.overflow_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,
            view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }

}
