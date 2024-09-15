package app.ditodev.pickme.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.ditodev.pickme.R
import app.ditodev.pickme.data.`object`.Utils
import app.ditodev.pickme.data.`object`.Utils.RESULT_CODE

class MoveResultActivity : AppCompatActivity() , View.OnClickListener {
    private lateinit var rgNumber : RadioGroup
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_move_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnChoose :Button = findViewById(R.id.btn_choose)
        btnChoose.setOnClickListener(this)
        rgNumber = findViewById(R.id.rb_50)
    }

    override fun onClick(p0: View?) {
        if (p0?.id == R.id.btn_choose){
            if (rgNumber.checkedRadioButtonId > 0){
                var value = ""
                when(rgNumber.checkedRadioButtonId){
                    R.id.rb_150 -> {
                        value = "Lionel Messi"
                    }

                    R.id.rb_151 -> {
                        value = "Cristiano Ronaldo"
                    }

                    R.id.rb_152 -> {
                        value = "Neymar Jr"
                    }

                    R.id.rb_153 ->{
                        value = "Kylian Mbappe"
                    }
                }
                val resIntent = Intent()
                resIntent.putExtra(Utils.EXTRA_SELECTED_VALUE , value)
                setResult(RESULT_CODE , resIntent)
                finish()
            }
        }
    }
}