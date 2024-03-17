package app.dito.intentactivity

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import app.dito.intentactivity.activity.SecondActivity
import app.dito.intentactivity.ui.theme.IntentActivityTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntentActivityTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RedirectButton(appComponent = this)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IntentAppPreview() {
    IntentActivityTheme {

    }
}

@Composable
fun RedirectButton(appComponent: ComponentActivity) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        /*
        Redirect to 2nd activity at
        */

        //Implicit Intent Implementation
        Column {
            Button(onClick = {
                Intent(Intent.ACTION_MAIN).also {
                    it.`package` = "com.google.android.youtube"
                    try {
                        appComponent.startActivity(it)
                    } catch (e: ActivityNotFoundException) {
                        e.printStackTrace()
                    }
                }
            }
            ) {
                Text(
                    text = "Go to youtube"
                )
            }
            /*
             //Explicit Intent implementation
            Redirect to 2nd activity at
            2nd Activity
             */
            Button(onClick = {
                Intent(appComponent.applicationContext, SecondActivity::class.java).also {
                    appComponent.startActivity(it)
                }
            }
            ) {
                Text(
                    text = "Go to 2nd activity"
                )
            }

            Button(onClick = {
                Intent(Intent.ACTION_MAIN).also {
                    it.`package` = "com.google.android.apps.maps"
                    try {
                        appComponent.startActivity(it)
                    } catch (e: ActivityNotFoundException) {
                        e.printStackTrace()
                    }
                }
            }
            ) {
                Text(
                    text = "Go to maps"
                )
            }
        }
    }
}