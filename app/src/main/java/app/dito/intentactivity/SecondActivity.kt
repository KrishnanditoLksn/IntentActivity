package app.dito.intentactivity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import app.dito.intentactivity.ui.theme.IntentActivityTheme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntentActivityTheme {
                Text(
                    text = "Hey it's 2nd activity"
                )
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
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
                }
            }
        }
    }
}