package com.example.jogocobra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.jogocobra.databinding.ActivityConfigsBinding
import com.example.jogocobra.databinding.NovojogoBinding

class NovoJogo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var binding: NovojogoBinding
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.novojogo)

        for (i in 0..2499){
            val inflater = LayoutInflater.from(this)
            val tv = inflater.inflate(R.layout.fundocampo,binding.gridL, false) as ImageView
        binding.gridL.addView(tv)

    }

}
}