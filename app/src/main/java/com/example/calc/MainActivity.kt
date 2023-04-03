package com.example.calc


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder
import net.objecthunter.exp4j.function.Function
import net.objecthunter.exp4j.operator.Operator
import kotlin.math.log10
import kotlin.math.log2


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Calc)
        setContentView(R.layout.activity_main)

        var buttonSettings: Button = findViewById(R.id.button_about)
        buttonSettings.setOnClickListener {
            val intent = Intent(this@MainActivity, AboutActivity::class.java)
            startActivity(intent)}

        lateinit var b0: TextView
        lateinit var b1: TextView
        lateinit var b2: TextView
        lateinit var b3: TextView
        lateinit var b4: TextView
        lateinit var b5: TextView
        lateinit var b6: TextView
        lateinit var b7: TextView
        lateinit var b8: TextView
        lateinit var b9: TextView
        lateinit var bminus: TextView
        lateinit var bplus: TextView
        lateinit var bdel: TextView
        lateinit var bumn: TextView
        lateinit var bscobL: TextView
        lateinit var bscobR: TextView
        lateinit var bAC: TextView
        lateinit var bBack: TextView
        lateinit var bravn: TextView
        lateinit var bdot: TextView


        b0 = findViewById(R.id.btn_0)
        b1 = findViewById(R.id.btn_1)
        b2 = findViewById(R.id.btn_2)
        b3 = findViewById(R.id.btn_3)
        b4 = findViewById(R.id.btn_4)
        b5 = findViewById(R.id.btn_5)
        b6 = findViewById(R.id.btn_6)
        b7 = findViewById(R.id.btn_7)
        b8 = findViewById(R.id.btn_8)
        b9 = findViewById(R.id.btn_9)
        bminus = findViewById(R.id.btn_minus)
        bplus = findViewById(R.id.btn_plus)
        bdel = findViewById(R.id.btn_del)
        bumn = findViewById(R.id.btn_umn)
        bscobL = findViewById(R.id.btn_scobL)
        bscobR = findViewById(R.id.btn_scobR)
        bAC = findViewById(R.id.btn_AC)
        bBack = findViewById(R.id.btn_back)
        bravn = findViewById(R.id.btn_ravn)
        bdot = findViewById(R.id.btn_dot)


        b0.setOnClickListener { setTextFields("0") }
        b1.setOnClickListener { setTextFields("1") }
        b2.setOnClickListener { setTextFields("2") }
        b3.setOnClickListener { setTextFields("3") }
        b4.setOnClickListener { setTextFields("4") }
        b5.setOnClickListener { setTextFields("5") }
        b6.setOnClickListener { setTextFields("6") }
        b7.setOnClickListener { setTextFields("7") }
        b8.setOnClickListener { setTextFields("8") }
        b9.setOnClickListener { setTextFields("9") }
        bminus.setOnClickListener { setTextFields("-") }
        bplus.setOnClickListener { setTextFields("+") }
        bdel.setOnClickListener { setTextFields("/") }
        bumn.setOnClickListener { setTextFields("*") }
        bscobL.setOnClickListener { setTextFields("(") }
        bscobR.setOnClickListener { setTextFields(")") }
        bdot.setOnClickListener{setTextFields(".")}

        bAC.setOnClickListener {
            val pole1:TextView = findViewById(R.id.math_operation)
            val pole2:TextView = findViewById(R.id.result_text)
            pole1.text = ""
            pole2.text = ""

        }
        bBack.setOnClickListener{
            val pole1: TextView = findViewById(R.id.math_operation)
            val pole2:TextView = findViewById(R.id.result_text)
            val pole: String = pole1.text.toString()
            if (pole.isNotEmpty())
                pole1.text = pole.substring(0, pole.length - 1)
            pole2.text = ""
        }
        bravn.setOnClickListener{
            try {
                val pole1: TextView = findViewById(R.id.math_operation)
                val pole2:TextView = findViewById(R.id.result_text)
                val ex = ExpressionBuilder(pole1.text.toString()).build()
                val result = ex.evaluate()
                val longRes = result.toLong()
                if (result == longRes.toDouble())
                    pole2.text = longRes.toString()
                else
                    pole2.text = result.toString()

            } catch (e:java.lang.Exception) {
                Log.d("Ошибка", "Сообщение: ${e.message}")
            }
        }
    }

    fun setTextFields(str: String) {
        val pole1: TextView = findViewById(R.id.math_operation)
        val pole2: TextView = findViewById(R.id.result_text)
        if (pole2.text != "") {
            pole1.text = pole2.text
            pole2.text = ""
        }
        pole1.append(str)
    }
}