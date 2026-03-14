package com.example.everydayapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.maplibre.compose.map.MaplibreMap
import org.maplibre.compose.style.BaseStyle
import org.maplibre.compose.camera.CameraPosition
import org.maplibre.compose.camera.rememberCameraState
import org.maplibre.compose.map.MapOptions
import org.maplibre.compose.map.OrnamentOptions
import org.maplibre.spatialk.geojson.Position
import java.nio.file.WatchEvent


public class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppScreen()
        }
    }
}

@Composable
fun AppScreen() {

    Box(modifier = Modifier.fillMaxSize()){

        MapScreen()

        BottomBar(
            onAddSpot = {/* Draggeble marker on map*/},
            onMenuClick = { /* Open settings*/},
            modifier = Modifier.align(Alignment.BottomCenter)

        )
    }

}

@Preview(showBackground = true)
@Composable
fun BottomBarPreview() {
    BottomBar(
        onAddSpot = { },
        onMenuClick = { }
    )
}
@Composable
fun BottomBar(
    onAddSpot: () -> Unit,
    onMenuClick: () -> Unit,
    modifier: Modifier = Modifier,
    ){
    Row(
        modifier = modifier

            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFF1A1A1A))  // dark background
            .padding(horizontal = 60.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        // Add spot button
        IconButton(onClick = onAddSpot) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add Spot",
                tint = Color.White
            )
        }
        // Hamburger menu button
        IconButton(onClick = onMenuClick) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu",
                tint = Color.White
            )
        }
    }
}

@Composable
fun MapScreen() {

    val cameraState = rememberCameraState(  // ← here
        firstPosition = CameraPosition(
            target = Position(
                longitude = 25.7473,
                latitude = 62.2426
            ),
            zoom = 12.0
        )
    )

    MaplibreMap(
        baseStyle = BaseStyle.Uri("https://tiles.openfreemap.org/styles/liberty"),
        cameraState = cameraState,
        options =
            MapOptions(
                ornamentOptions = OrnamentOptions(
                    isLogoEnabled = false,
                    isScaleBarEnabled = false,
                    isAttributionEnabled = true,
                    attributionAlignment = Alignment.TopEnd,
                )
            )
    )
}