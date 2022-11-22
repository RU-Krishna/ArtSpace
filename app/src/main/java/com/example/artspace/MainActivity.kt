package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                ArtSpace()

            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ArtSpace() {

    var imageCounter by remember {
        mutableStateOf(1)
    }
    var imageID by remember { mutableStateOf(R.drawable.indiagate) }

    var title by remember { mutableStateOf("India Gate") }
    var artist by remember { mutableStateOf("Sir Edwin Lutyens") }
    var year by remember { mutableStateOf(1921) }



    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        ArtworkWall(
            modifier = Modifier.weight(0.6f),
            imageID = imageID,
            contentDesc = title
        )


        ArtWorkDescriptor(
            modifier = Modifier.weight(0.25f),
            ArtworkTitle = title,
            ArtworkArtist = artist,
            Year = year
        )


        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.weight(0.15f)
        ) {
            DisplayController(buttonName = "Previous") {
                imageID = when (imageCounter) {
                    1 -> {
                        imageCounter = 4
                        title = "Taj Mahal"
                        artist = "Ustad Ahmad Lahuri"
                        year = 1631
                        R.drawable.taj_mahal
                    }
                    2 -> {
                        imageCounter--
                        title = "India Gate"
                        artist = "Sir Edwin's Lutyens"
                        year = 1921
                        R.drawable.indiagate
                    }
                    3 -> {
                        imageCounter--
                        title = "Red Fort"
                        artist = "Ustad Ahmad Lahuri"
                        year = 1639
                        R.drawable.delhi_fort
                    }
                    else -> {
                        imageCounter--
                        title = "Qutub Minar"
                        artist = "Qutub Ub Din Aibak"
                        year = 1199
                        R.drawable.qutb_minar_2011
                    }
                }
            }
            DisplayController(buttonName = "Next") {
                imageID = when (imageCounter) {
                    1 -> {
                        imageCounter++
                        title = "Red Fort"
                        artist = "Ustad Ahmad Lahuri"
                        year = 1639
                        R.drawable.delhi_fort
                    }
                    2 -> {
                        imageCounter++
                        title = "Qutub Minar"
                        artist = "Qutub Ub Din Aibak"
                        year = 1199
                        R.drawable.qutb_minar_2011
                    }
                    3 -> {
                        imageCounter++
                        title = "Taj Mahal"
                        artist = "Ustad Ahmad Lahuri"
                        year = 1631
                        R.drawable.taj_mahal
                    }
                    else -> {
                        imageCounter = 1
                        title = "India Gate"
                        artist = "Sir Edwin's Lutyens"
                        year = 1921
                        R.drawable.indiagate
                    }
                }

            }
        }

    }


}

@Composable
fun ArtworkWall(
    modifier: Modifier = Modifier,
    imageID: Int,
    contentDesc: String
) {
    Image(
        painter = painterResource(id = imageID),
        contentDescription = contentDesc,
        modifier = modifier
            .fillMaxSize()
            .border(width = 4.dp, color = Color.Gray, shape = RoundedCornerShape(16.dp))
            .clip(RoundedCornerShape(24.dp))
            .padding(16.dp),
        contentScale = ContentScale.FillBounds,


        )

}

@Composable
fun ArtWorkDescriptor(
    modifier: Modifier = Modifier,
    ArtworkTitle: String = "ArtworkTitle",
    ArtworkArtist: String = "ArtworkArtist",
    Year: Int = 2000,
) {

    Surface(
        shape = RoundedCornerShape(16.dp),
        shadowElevation = 8.dp,
        color = Color.LightGray,
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize(align = Alignment.Center)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .wrapContentSize()
                .padding(16.dp)
        ) {
            Text(
                text = ArtworkTitle,
                textAlign = TextAlign.Center,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            Text(
                text = "$ArtworkArtist($Year)",
                textAlign = TextAlign.Center,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Black,
                fontSize = 16.sp,
            )
        }

    }


}

@Composable
fun DisplayController(
    buttonName: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(24.dp),
        colors = ButtonDefaults.outlinedButtonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer),
        border = ButtonDefaults.outlinedButtonBorder.copy(width = 2.dp),
        modifier = Modifier.padding(24.dp)
    ) {
        Text(
            text = buttonName,
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Italic,
            fontFamily = FontFamily.SansSerif,
            fontSize = 16.sp
        )
    }

}

