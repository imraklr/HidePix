package kiit.minor.project.hidepix

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import kiit.minor.project.hidepix.ui.theme.HidePixTheme
import kiit.minor.project.hidepix.views.CoverSourceSelection
import kiit.minor.project.hidepix.views.SplashScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HidePixTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val context = LocalContext.current
                    SplashScreen(
                        {
                        // call the activity CoverSourceSelection
                        context.startActivity(Intent(context, CoverSourceSelection::class.java))
                        },
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}
