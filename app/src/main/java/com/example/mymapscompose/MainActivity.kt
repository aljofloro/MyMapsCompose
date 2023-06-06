package com.example.mymapscompose

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mymapscompose.ui.theme.MyMapsComposeTheme
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

class MainActivity : ComponentActivity() {

  val upt = LatLng(-18.0054865,-70.227271)


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MyMapsComposeTheme {
        val cameraPositionState = rememberCameraPositionState{
          position = CameraPosition.fromLatLngZoom(upt,16f)
        }
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState,
            onMapClick ={ mostrarMensaje(it, this ) }
          ){
            Marker(
              state = MarkerState(position = upt),
              title = "Universidad Privada de Tacna",
              snippet = "Marcador en la Universidad"
            )
          }
        }
      }
    }
  }
}

fun mostrarMensaje(position:LatLng,context: Context){
  Toast.makeText(context,position.toString(), Toast.LENGTH_SHORT).show()
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
  Text(
    text = "Hello $name!",
    modifier = modifier
  )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  MyMapsComposeTheme {
    Greeting("Android")
  }
}