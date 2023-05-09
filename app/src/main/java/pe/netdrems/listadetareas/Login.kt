package pe.netdrems.listadetareas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pe.netdrems.listadetareas.ui.theme.ListaDeTareasTheme
import pe.netdrems.listadetareas.ui.theme.black
import pe.netdrems.listadetareas.ui.theme.colorpry
import pe.netdrems.listadetareas.ui.theme.colorsec
import pe.netdrems.listadetareas.ui.theme.gray
import pe.netdrems.listadetareas.ui.theme.white

class Login : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListaDeTareasTheme {
                LoginScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun LoginScreen() {
    val colors = listOf(gray, black)
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
            modifier = Modifier.fillMaxSize().padding(30.dp),
            content = {
                Text(
                    text = "Inicio de sesión",
                    fontFamily = FontFamily(Font(R.font.lilitaone)),
                    fontSize = 40.sp,
                    color = colorpry,
                    modifier = Modifier
                        .padding(top = 20.dp, bottom = 50.dp)
                        .align(CenterHorizontally)
                )
                val emailState = remember { mutableStateOf("") }
                val passwordState = remember { mutableStateOf("") }

                TextField(
                    value = emailState.value,
                    onValueChange = { emailState.value = it },
                    label = { Text("Correo electrónico") },
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .background(white, RoundedTextFieldShape)
                )

                TextField(
                    value = passwordState.value,
                    onValueChange = { passwordState.value = it },
                    label = { Text("Contraseña") },
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .background(white, RoundedTextFieldShape)
                )

                val gradientColors = listOf(colorpry, colorsec)
                val roundCornerShape = RoundedCornerShape(topEnd = 30.dp, bottomStart = 30.dp)
                Box(
                    modifier = Modifier.padding(20.dp)
                        .align(CenterHorizontally)
                ) {
                    Box(
                        modifier = Modifier
                            .background(
                                brush = Brush.horizontalGradient(colors = gradientColors),
                                shape = roundCornerShape
                            )
                            .fillMaxWidth()
                            .clip(roundCornerShape)
                            .clickable {
                                performLogin(emailState.value, passwordState.value)
                            }
                            .padding(PaddingValues(horizontal = 30.dp, vertical = 10.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Iniciar sesión",
                            fontSize = 26.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        )
    }
}

private val RoundedTextFieldShape = RoundedCornerShape(10.dp)

private fun performLogin(email: String, password: String) {
    // Aquí puedes agregar la lógica para verificar las credenciales de inicio de sesión
    // y realizar las acciones correspondientes, como navegar a la siguiente pantalla.
}