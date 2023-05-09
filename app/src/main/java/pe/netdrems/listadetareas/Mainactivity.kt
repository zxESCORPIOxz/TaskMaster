package pe.netdrems.listadetareas

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import pe.netdrems.listadetareas.ui.theme.ListaDeTareasTheme
import pe.netdrems.listadetareas.ui.theme.black
import pe.netdrems.listadetareas.ui.theme.colorpry
import pe.netdrems.listadetareas.ui.theme.gray

class Mainactivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListaDeTareasTheme{
                Create()
            }
        }
    }

    private fun navigateToLogin() {
        startActivity(Intent(this, Login::class.java))
        finish()
    }

    @Preview
    @Composable
    fun Create(){
        val colors = listOf(gray, black)
        val progress = remember { mutableStateOf(0.0f) }
        var go = true
        val scale = remember { mutableStateOf(0.0f) }

        LaunchedEffect(key1 = true) {
            while (true) {
                delay(20)
                progress.value += 0.01f
                scale.value += 0.01f
                if (progress.value >= 1.0f && go) {
                    navigateToLogin()
                    finish()
                    go = false
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = colors,
                        start = Offset(0f, 0f),
                        end = Offset.Infinite
                    )
                )
        ) {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(35.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "TaskMaster",
                        fontFamily = FontFamily(Font(R.font.lilitaone)),
                        fontSize = 40.sp,
                        color = colorpry,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                //***************************************************************

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .align(CenterHorizontally),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.logo),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth(scale.value)
                    )
                }

                //***************************************************************



                Canvas(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp)
                        .padding(10.dp)
                ) {
                    val canvasWidth = size.width
                    val canvasHeight = size.height
                    val cornerRadius = 5.dp.toPx()

                    drawRoundRect(
                        color = Color.LightGray,
                        topLeft = Offset(0f, 0f),
                        size = Size(canvasWidth, canvasHeight),
                        cornerRadius = CornerRadius(cornerRadius, cornerRadius)
                    )

                    drawRoundRect(
                        color = colorpry,
                        topLeft = Offset(0f, 0f),
                        size = Size(canvasWidth * progress.value, canvasHeight),
                        cornerRadius = CornerRadius(cornerRadius, cornerRadius)
                    )
                }
                //***************************************************************
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Bienvenido",
                        fontFamily = FontFamily(Font(R.font.lilitaone)),
                        fontSize = 25.sp,
                        color = colorpry,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }
    }
}