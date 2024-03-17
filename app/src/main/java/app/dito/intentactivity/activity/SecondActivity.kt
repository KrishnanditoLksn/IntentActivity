package app.dito.intentactivity.activity

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import app.dito.intentactivity.MainActivity
import app.dito.intentactivity.ui.theme.IntentActivityTheme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntentActivityTheme {
                Text(
                    text = "Hey it's 2nd activity"
                )
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = {
                            Intent(
                                applicationContext,
                                MainActivity::class.java
                            ).also {
                                startActivity(it)
                            }
                        }
                    ) {
                        Text(
                            text = "Back to main"
                        )
                    }

                    Button(onClick = {
                        /*
                        take a picture
                         */
                        val imageCapture = 1
                        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                        try {
                            startActivityForResult(takePictureIntent, imageCapture)
                        } catch (e: ActivityNotFoundException) {
                            // display error state to the user
                        }
                    }) {
                        Text(text = "Take a Picture")
                    }
                }
            }
        }
    }
}