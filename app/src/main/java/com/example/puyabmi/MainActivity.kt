package com.example.puyabmi
import android.support.v4.app.RemoteActionCompatParcelizer
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weight: EditText = findViewById(R.id.text_weight)
        val height: EditText = findViewById(R.id.text_height)
        val calculate: Button = findViewById(R.id.calculate)
        val reset: Button = findViewById(R.id.reset)
        val txtview: TextView = findViewById(R.id.text_view)

        calculate.setOnClickListener {
            if(weight.text.isEmpty() or height.text.isEmpty()){
                Toast.makeText(this, "Error: Please Fill weight and height", Toast.LENGTH_LONG).show()

            }
            else{
                val weight: Double = weight.text.toString().toDouble()
                val height: Double = height.text.toString().toDouble() / 100

                val bmi = weight / (height * height)


                when (bmi) {
                    in 0.0..18.5 -> txtview.text = "Status: " + "Under Weight \n" + "BMI = " + bmi.toInt().toShort()
                    in 18.5..25.0 -> txtview.text = "Status: " + "Normal Weight \n" + "BMI = " + bmi.toInt().toShort()
                    in 25.0..30.0 -> txtview.text = "Status: " + "Over Weight \n" + "BMI = " + bmi.toInt().toShort()
                    else -> txtview.text = "Status: " + "Obese \n" + "BMI = " + bmi.toInt().toShort()



                }





            }

        }

        reset.setOnClickListener {
            weight.text.clear()
            height.text.clear()
            txtview.text = ""
            weight.requestFocus()
        }


    }


}