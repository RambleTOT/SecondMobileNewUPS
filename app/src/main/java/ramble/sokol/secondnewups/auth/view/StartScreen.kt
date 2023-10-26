package ramble.sokol.secondnewups.auth.view

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import ramble.sokol.secondnewups.R
import ramble.sokol.secondnewups.auth.components.ButtonEntry
import ramble.sokol.secondnewups.auth.components.ButtonEntryGoogle
import ramble.sokol.secondnewups.destinations.LoginScreenDestination
import ramble.sokol.secondnewups.ui.theme.ColorMain
import ramble.sokol.secondnewups.ui.theme.ColorTextMain

@Composable
@Destination(start = true)
fun StartScreen(
    navigator: DestinationsNavigator
){

    val context = LocalContext.current
    
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ){
        
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.image_background_start_screen),
            contentDescription = "image_background_start_screen",
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ){

            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(
                        fontSize = 32.sp,
                        fontFamily = FontFamily(Font(R.font.onest_bold)),
                        fontWeight = FontWeight(700),
                        color = Color.White,
                    )) {
                        append("${stringResource(id = R.string.text_welcome_start)} ")
                    }
                    withStyle(style = SpanStyle(
                        fontSize = 32.sp,
                        fontFamily = FontFamily(Font(R.font.onest_bold)),
                        fontWeight = FontWeight(700),
                        color = ColorMain,
                    )) {
                        append(stringResource(id = R.string.text_keepfoód))
                    }
                    }
            )

            Spacer(modifier = Modifier.padding(top = 22.dp))

            Text(
                text = stringResource(id = R.string.text_description_start),
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 21.sp,
                    fontFamily = FontFamily(Font(R.font.onest_regular)),
                    fontWeight = FontWeight(500),
                    color = ColorTextMain,

                    )
            )
            
            Spacer(modifier = Modifier.padding(top = 22.dp))
            
            ButtonEntry(text = stringResource(id = R.string.text_button_entry_email)) {
                navigator.popBackStack()
                navigator.navigate(LoginScreenDestination)
            }
            
            Spacer(modifier = Modifier.padding(top = 15.dp))
            
            ButtonEntryGoogle(text = stringResource(id = R.string.text_next_with)) {
                Toast.makeText(context, R.string.text_stub, Toast.LENGTH_SHORT).show()
            }
            
            Spacer(modifier = Modifier.padding(top = 27.dp))

            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.onest_regular)),
                        fontWeight = FontWeight(500),
                        color = ColorTextMain,
                    )) {
                        append("${stringResource(id = R.string.text_no_account)} ")
                    }
                    withStyle(style = SpanStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.onest_regular)),
                        fontWeight = FontWeight(500),
                        color = ColorMain,
                    )
                    ) {
                        append(stringResource(id = R.string.text_go_to_reg))
                    }
                }
            )
            
            Spacer(modifier = Modifier.padding(top = 22.dp))

        }
        
    }
    
}