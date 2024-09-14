package app.ditodev.pickme

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.ditodev.pickme.activity.DataMoveActivity
import app.ditodev.pickme.activity.FirstActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btn1 = findViewById(R.id.button_id_1)
        btn2 = findViewById(R.id.button_id_2)

        btn2.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.button_id_1 -> {
                val firstIntent = Intent(this@MainActivity, FirstActivity::class.java)
                startActivity(firstIntent)
            }

            R.id.button_id_2 -> {
                val dataMoveAct = Intent(this@MainActivity, DataMoveActivity::class.java)
                dataMoveAct.putExtra(DataMoveActivity.EXTRA_NAME, "Lionel Messi")
                dataMoveAct.putExtra(DataMoveActivity.EXTRA_AGE, "35")
                startActivity(dataMoveAct)
            }
        }
    }
}