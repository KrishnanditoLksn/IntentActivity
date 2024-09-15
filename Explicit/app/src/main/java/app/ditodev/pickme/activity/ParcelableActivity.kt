package app.ditodev.pickme.activity

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.ditodev.pickme.R
import app.ditodev.pickme.data.model.Person
import app.ditodev.pickme.data.`object`.Utils

class ParcelableActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_parcelable)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val parcelableObj: TextView = findViewById(R.id.tv_obj_rcv)

        val person = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(Utils.EXTRA_PERSON, Person::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(Utils.EXTRA_PERSON)
        }

        if (person != null) {
            val text = "Name : ${person.name.toString()}\n" +
                    "Email : ${person.email.toString()}\n" +
                    "Age :  ${person.age}\n" +
                    "City: ${person.city.toString()}"
            parcelableObj.text = text
        }
    }
}