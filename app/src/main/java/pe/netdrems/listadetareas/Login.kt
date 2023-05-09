package pe.netdrems.listadetareas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pe.netdrems.listadetareas.ui.theme.ListaDeTareasTheme
import pe.netdrems.listadetareas.ui.theme.colorpry

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
    Column(
        modifier = Modifier.fillMaxSize(),
        content = {
            Text(
                text = "Inicio de sesión",
                fontFamily = FontFamily(Font(R.font.lilitaone)),
                fontSize = 40.sp,
                color = colorpry
            )
            val emailState = remember { mutableStateOf("") }
            val passwordState = remember { mutableStateOf("") }

            TextField(
                value = emailState.value,
                onValueChange = { emailState.value = it },
                label = { Text("Correo electrónico") },
                modifier = Modifier.padding(16.dp)
            )

            TextField(
                value = passwordState.value,
                onValueChange = { passwordState.value = it },
                label = { Text("Contraseña") },
                modifier = Modifier.padding(16.dp)
            )

            Button(
                onClick = { performLogin(emailState.value, passwordState.value) },
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = "Iniciar sesión")
            }
        }
    )
}
private fun performLogin(email: String, password: String) {
    // Aquí puedes agregar la lógica para verificar las credenciales de inicio de sesión
    // y realizar las acciones correspondientes, como navegar a la siguiente pantalla.
}