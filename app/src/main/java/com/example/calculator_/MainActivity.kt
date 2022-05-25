package com.example.calculator_

import android.content.ContentValues
import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.calculator_.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var lastDot: Boolean=false
    var lastNumeric: Boolean=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn0.setOnClickListener {
            binding.input.append("0")
        }

        binding.btn1.setOnClickListener {
            binding.input.append("1")
        }

        binding.btn2.setOnClickListener {
            binding.input.append("2")
        }

        binding.btn3.setOnClickListener {
            binding.input.append("3")
        }

        binding.btn4.setOnClickListener {
            binding.input.append("4")
        }

        binding.btn5.setOnClickListener {
            binding.input.append("5")
        }

        binding.btn6.setOnClickListener {
            binding.input.append("6")
        }

        binding.btn7.setOnClickListener {
            binding.input.append("7")
        }

        binding.btn8.setOnClickListener {
            binding.input.append("8")
        }

        binding.btn9.setOnClickListener {
            binding.input.append("9")
        }


        binding.btnAdd.setOnClickListener {
            binding.input.append("+")
        }
        binding.btnSub.setOnClickListener {
            binding.input.append("-")
        }
        binding.btnMul.setOnClickListener {
            binding.input.append("*")
        }
        binding.btnDiv.setOnClickListener {
            binding.input.append("/")
        }

        binding.btnDot.setOnClickListener {
            if (binding.input.text != null) {
                if (binding.input.text.toString().contains(".")) {
                    Log.d(ContentValues.TAG, "From Dot1")
                } else {
                    binding.input.append(".")
                }
            }
        }

        binding.btnSB.setOnClickListener {
            binding.input.append("(")
        }
        binding.btnEB.setOnClickListener {
            binding.input.append(")")
        }


        binding.btnEqal.setOnClickListener {

            try {
                var experation=ExpressionBuilder(binding.input.text.toString()).build()
                var result=experation.evaluate()
                val longresult=result.toLong()

                if (result == longresult.toDouble()) {
                    binding.output.text=longresult.toString()
                } else {
                    binding.output.text=result.toString()
                }
            } catch (e: Exception) {
                Log.d("Exception", " message : " + e.message)
            }

        }

        binding.btnAc.setOnClickListener {
            binding.input.text=""
            binding.output.text=""
        }

        binding.btnBack.setOnClickListener {
            /*val str=binding.input.text.toString()
            if (str.isNotEmpty()) {
                binding.input.text=str.substring(0, str.length - 1)
            }*/
            binding.input.text = binding.input.text.dropLast(1)
            binding.output.text=""
        }


    }

}