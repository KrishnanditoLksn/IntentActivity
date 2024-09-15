package app.ditodev.pickme

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.ditodev.pickme.activity.DataMoveActivity
import app.ditodev.pickme.activity.FirstActivity
import app.ditodev.pickme.activity.MoveResultActivity
import app.ditodev.pickme.activity.ParcelableActivity
import app.ditodev.pickme.data.model.Person
import app.ditodev.pickme.data.`object`.Utils

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var groupResult: TextView

    @SuppressLint("SetTextI18n")
    private val registerResultActivits =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        { result ->
            if (result.resultCode == Utils.RESULT_CODE && result.data != null) {
                val selectedVal = result.data?.getStringExtra(Utils.EXTRA_SELECTED_VALUE)
                groupResult.text = "Your Favorite Player : $selectedVal"
            }
        }

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
        btn1.setOnClickListener(this)

        btn2 = findViewById(R.id.button_id_2)
        btn2.setOnClickListener(this)

        val btnMoveObj: Button = findViewById(R.id.btn_move_activity_object)
        btnMoveObj.setOnClickListener(this)

        val btnImplicitIntent: Button = findViewById(R.id.btn_camera)
        btnImplicitIntent.setOnClickListener(this)


        val btnMoveRes: Button = findViewById(R.id.btn_move_for_result)
        btnMoveRes.setOnClickListener(this)
        groupResult = findViewById(R.id.intent_result_text)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.button_id_1 -> {
                val firstIntent = Intent(this@MainActivity, FirstActivity::class.java)
                startActivity(firstIntent)
            }

            R.id.button_id_2 -> {
                val dataMoveAct = Intent(this@MainActivity, DataMoveActivity::class.java)
                dataMoveAct.putExtra(Utils.EXTRA_NAME, "Lionel Messi")
                dataMoveAct.putExtra(Utils.EXTRA_AGE, "35")
                startActivity(dataMoveAct)
            }

            R.id.btn_move_activity_object -> {
                val person = Person(
                    "Lionel Messi",
                    35,
                    "lioneloke@gmail.com",
                    "Barcelona"
                )

                val moveObj = Intent(this@MainActivity, ParcelableActivity::class.java)
                moveObj.putExtra(Utils.EXTRA_PERSON, person)
                startActivity(moveObj)
            }

            R.id.btn_camera -> {
                val camera = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                try {
                    startActivity(camera)
                } catch (e: ActivityNotFoundException) {
                    error("Activity Not Found")
                }
            }

            R.id.btn_move_for_result -> {
                val moveRes = Intent(this@MainActivity, MoveResultActivity::class.java)
                registerResultActivits.launch(moveRes)
            }
        }
    }
}