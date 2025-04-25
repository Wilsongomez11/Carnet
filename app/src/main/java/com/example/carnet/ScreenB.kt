package com.example.carnet
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton

@Composable
fun ScreenB(viewModel: PetViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE4F9F5))
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            " Carnet de Mascota",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF008891),
            modifier = Modifier.padding(bottom = 24.dp),
            textAlign = TextAlign.Center
        )


        viewModel.petsList.value.forEach { pet ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RoundedCornerShape(16.dp),
                elevation = 4.dp
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = rememberImagePainter(pet.photoUrl),
                        contentDescription = "Foto de la mascota",
                        modifier = Modifier.size(120.dp)
                    )
                    Text("Nombre: ${pet.name}", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
                    Text("Raza: ${pet.breed}", fontSize = 18.sp)
                    Text("Tamaño: ${pet.size}", fontSize = 18.sp)
                    Text("Edad: ${pet.age}", fontSize = 18.sp)

                    IconButton(onClick = { viewModel.removePet(pet) }) {
                        Icon(Icons.Filled.Delete, contentDescription = "Eliminar mascota")
                    }
                }

            }
        }
    }
}
