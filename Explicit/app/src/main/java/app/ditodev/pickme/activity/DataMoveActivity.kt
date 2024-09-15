package app.ditodev.pickme.activity

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.ditodev.pickme.R
import app.ditodev.pickme.data.`object`.Utils

class DataMoveActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_data_move)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rcvData: TextView = findViewById(R.id.textDataId)
        val name = intent.getStringExtra(Utils.EXTRA_AGE)
        val age = intent.getStringExtra(Utils.EXTRA_AGE)

        val text = "Hallo $name \n" +
                "Umurmu yaitu $age"

        rcvData.text = text
    }
}