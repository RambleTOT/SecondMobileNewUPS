package ramble.sokol.secondnewups.auth.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ramble.sokol.secondnewups.R
import ramble.sokol.secondnewups.ui.theme.ColorBackgroundInput
import ramble.sokol.secondnewups.ui.theme.ColorTextHint

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordInput(
    text: String,
    onValueChange: (String) -> Unit
){

    OutlinedTextField(
        value = text,
        onValueChange = onValueChange,
        shape = RoundedCornerShape(22.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp),
        textStyle = TextStyle(
            fontSize = 14.sp,
            lineHeight = 21.sp,
            fontFamily = FontFamily(Font(R.font.onest_semibold)),
            fontWeight = FontWeight(500),
            color = ColorTextHint,
        ),
        placeholder = {
            Text(
                stringResource(id = R.string.text_input_password),
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 21.sp,
                    fontFamily = FontFamily(Font(R.font.onest_semibold)),
                    fontWeight = FontWeight(500),
                    color = ColorTextHint,
                )
            ) },
        colors = TextFieldDefaults.textFieldColors(
            cursorColor = ColorTextHint,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            containerColor = ColorBackgroundInput,
        ),
        singleLine = true,
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )
}