package kiit.minor.project.hidepix.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kiit.minor.project.hidepix.R
import kiit.minor.project.hidepix.ui.theme.HidePixTheme

class CoverSourceSelection: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HidePixTheme {
                Surface {
                    ButtonsList(modifier = Modifier)
                }
            }
        }
    }
}

@Composable
fun ButtonsList(
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onPrimary)
    ) {
        Column {
            Text(
                text = stringResource(id = R.string.cover_source_selection_activity_headline),
                textAlign = TextAlign.Center,
                fontStyle = FontStyle.Italic,
                modifier = Modifier
            )
        }
        Column {
            Image(
                painter = painterResource(id = R.drawable.concept),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.cover_source_selection_option)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
        ) {
            ButtonSkeleton(
                onClick = {
                    // open gallery and get from it
                    // The click will open the same activity as the ButtonSkeleton below
                },
                stringResourceId = R.string.choose_cover_source,
                modifier = Modifier
                    .weight(1f)
                    .padding(4.dp)
            )
            ButtonSkeleton(
                onClick = {
                    // open camera and take picture
                    // The click will open the same activity as the ButtonSkeleton below
                },
                stringResourceId = R.string.take_picture,
                modifier = Modifier
                    .padding(4.dp)
            )
        }
    }
}

@Preview(showBackground=true)
@Composable
fun PreviewButtonsList() {
    HidePixTheme {
        Surface {
            ButtonsList()
        }
    }
}

@Composable
fun ButtonSkeleton(
    stringResourceId: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
    ) {
        Text(
            text = stringResource(stringResourceId),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewButtonSkeleton() {
    ButtonSkeleton(
        stringResourceId = R.string.take_picture,
        onClick = { /* TODO */ },
    )
}
