package com.example.pexelsapplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pexelsapplication.R


@Composable
 fun NetworkStubScreen(
    retryAction: () -> Unit,
    modifier: Modifier = Modifier){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        Image(
            painter = painterResource(R.drawable.no_network_icon) ,
            contentDescription = stringResource(R.string.no_network),
            modifier = Modifier
                .width(125.54.dp)
                .height(147.dp)
        )

        Spacer(modifier = Modifier.height(4.dp))

        TextButton(onClick =  retryAction,
            modifier = Modifier
        ) {
            Text(
                text = stringResource(R.string.try_again),
                color = Color(187, 16, 32),
                textAlign = TextAlign.Center,
               // fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        }
    }

}



