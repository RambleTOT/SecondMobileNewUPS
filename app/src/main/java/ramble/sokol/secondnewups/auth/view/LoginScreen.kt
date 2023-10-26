package ramble.sokol.secondnewups.auth.view

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import ramble.sokol.secondnewups.auth.components.EmailInput
import ramble.sokol.secondnewups.auth.components.PasswordInput
import ramble.sokol.secondnewups.destinations.OnboardingScreenDestination
import ramble.sokol.secondnewups.ui.theme.ColorMain
import ramble.sokol.secondnewups.ui.theme.ColorTextBlack
import ramble.sokol.secondnewups.ui.theme.ColorTextMain

private lateinit var textEmail: MutableState<String>
private lateinit var textPassword: MutableState<String>

@Composable
@Destination
fun LoginScreen(
    navigator: DestinationsNavigator
){

    textEmail = remember {
        mutableStateOf("")
    }

    textPassword = remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.TopCenter
    ){

        Image(
            painter = painterResource(id = R.drawable.image_login),
            contentDescription = "image_login"
        )

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter){

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color(0xFFFFFFFF),
                        shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {

                Column (
                    modifier = Modifier.padding(horizontal = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                    Spacer(modifier = Modifier.padding(top = 30.dp))

                    Text(
                        text = stringResource(id = R.string.text_entry),
                        style = TextStyle(
                            fontSize = 32.sp,
                            fontFamily = FontFamily(Font(R.font.onest_bold)),
                            fontWeight = FontWeight(700),
                            color = ColorTextBlack,
                        )
                    )

                    Spacer(modifier = Modifier.padding(top = 30.dp))

                    EmailInput(
                        text = textEmail.value,
                        onValueChange = {
                            textEmail.value = it
                        }
                    )

                    Spacer(modifier = Modifier.padding(top = 15.dp))

                    PasswordInput(
                        text = textPassword.value,
                        onValueChange = {
                            textPassword.value = it
                        }
                    )

                    Spacer(modifier = Modifier.padding(top = 15.dp))

                    ButtonEntry(text = stringResource(id = R.string.text_entry)) {
                        navigator.popBackStack()
                        navigator.navigate(OnboardingScreenDestination)
                    }

                    Spacer(modifier = Modifier.padding(top = 22.dp))

                    Text(
                        buildAnnotatedString {
                            withStyle(style = SpanStyle(
                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font(R.font.onest_regular)),
                                fontWeight = FontWeight(500),
                                color = ColorTextMain,
                            )
                            ) {
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

    }


}