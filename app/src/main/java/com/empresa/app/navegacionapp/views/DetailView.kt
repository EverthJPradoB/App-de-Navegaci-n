package com.empresa.app.navegacionapp.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.empresa.app.navegacionapp.components.MainButton
import com.empresa.app.navegacionapp.components.MainIconButton
import com.empresa.app.navegacionapp.components.Space
import com.empresa.app.navegacionapp.components.TitleBar
import com.empresa.app.navegacionapp.components.TitleView


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class) // Agrega esta línea
@Composable
fun DetailView(navController: NavController, id:Int, opcional:String?){

    Scaffold(
        topBar = {
            
            TopAppBar(
                title = { TitleBar(name = "Detail vieww")},
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Blue
                ),
                navigationIcon = {

                    MainIconButton(icon = Icons.AutoMirrored.Filled.ArrowBack) {
                        navController.popBackStack();
                    }

                }

            )


        }
        
    ) {
        ContentDetailView(navController,id,opcional)
    }


}


@Composable
fun ContentDetailView(navController: NavController,id:Int, opcional:String?){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        TitleView(name = "Detail View")
        Space()
        TitleView(name = id.toString())
        Space()

        if (opcional == "") {

            Spacer(modifier = Modifier.height(0.dp))
        }else{

//            opcional?.let {
//
//                TitleView(name = it)
//
//            }
            TitleView(name = opcional.orEmpty())
        }

        MainButton(name = "Return home", backColor =Color.Blue
            , colorLetra = Color.White) {
            navController.popBackStack()

        }
    }
}




