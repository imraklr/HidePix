package kiit.minor.project.hidepix.views

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.sp
import kiit.minor.project.hidepix.R
import kiit.minor.project.hidepix.ui.theme.HidePixTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navigateToMain: () -> Unit,
    modifier: Modifier = Modifier
) {

    // watch out for the color scheme being used here
    val canvasCircleColor = MaterialTheme.colorScheme.onPrimaryContainer
    // watch out for the color scheme being used here
    val aboveCanvasTextColor = MaterialTheme.colorScheme.onSecondary

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.splashscreen_picture),
            contentDescription = null,
            modifier = Modifier
                .scale(1.2f)
                .weight(20f)
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ) {
            var size by remember { mutableStateOf(IntSize.Zero) }

            var scale by remember { mutableFloatStateOf(1f) }

            val targetScale by animateFloatAsState(
                targetValue = if (scale == 1f) 1.5f else 1f,
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioHighBouncy,
                    stiffness = Spring.StiffnessLow
                ), label = ""
            )

            scale = targetScale

            Canvas(
                modifier = Modifier
                    .align(alignment = Alignment.Center)
                    .graphicsLayer(scaleX = targetScale, scaleY = targetScale)
            ) {
                drawCircle(
                    color = canvasCircleColor,
                    radius = (size.width).toFloat() / 1.5f
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    // "HidePi" text
                    Text(
                        text = stringResource(id = R.string.splash_initial_incomplete_name),
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold,
                        color = aboveCanvasTextColor,
                        modifier = Modifier
                            .onGloballyPositioned { coordinates -> size = coordinates.size }
                    )

                    // "X" text
                    Text(
                        text = stringResource(id = R.string.splash_final_name_letter),
                        style = MaterialTheme.typography.bodyLarge,
                        color = aboveCanvasTextColor,
                        modifier = Modifier
                    )
                }
            }
        }
    }

    // After a delay of 2.5 seconds, move on to the next activity
    LaunchedEffect(null) {
        delay(2500)
        navigateToMain()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSplashScreen() {
    HidePixTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            SplashScreen(
                {},
                modifier = Modifier
                    .fillMaxSize()
            )
        }
    }
}
