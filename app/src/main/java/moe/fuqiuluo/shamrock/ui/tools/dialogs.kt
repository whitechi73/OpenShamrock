package moe.fuqiuluo.shamrock.ui.tools

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import moe.fuqiuluo.shamrock.ui.theme.GlobalColor
import moe.fuqiuluo.shamrock.ui.theme.ShamrockTheme

data class InputDialogState(
    val isOpen: MutableState<Boolean>,
    val isError: MutableState<Boolean>,
    var confirm: (() -> Unit)? = null,
    var cancel: (() -> Unit)? = null,
) {
    fun show(
        confirm: (() -> Unit)? = null,
        cancel: (() -> Unit)? = null,
    ) {
        this.confirm = confirm
        this.cancel = cancel
        isOpen.value = true
    }

}

@SuppressLint("ComposableNaming")
@Composable
fun InputDialog(
    openDialog: MutableState<Boolean>,
    title: String,
    desc: String,
    hint: String,
    errorText: String,
    text: MutableState<String> = remember { mutableStateOf("") },
    singleLine: Boolean = true,
    isError: MutableState<Boolean> = remember {
        mutableStateOf(false)
    },
    keyboardType: KeyboardType = KeyboardType.Text,
    checker: ((String) -> Boolean)? = null,
): InputDialogState {
    val state = remember { InputDialogState(openDialog, isError) }
    if (!openDialog.value) return state

    AlertDialog(
        shape = RoundedCornerShape(12.dp),
        onDismissRequest = {
            if(openDialog.value) {
                openDialog.value = false
                state.cancel?.invoke()
            }
        },
        title = {
            Text(
                text = title,
                fontSize = 16.sp,
                color = GlobalColor.NoticeBoxText
            )
        },
        text = {
            Column {
                Text(
                    text = desc
                )
                TextField(
                    modifier = Modifier.padding(top = 12.dp),
                    value = text.value,
                    onValueChange = {
                        if (checker?.invoke(it) != false) {
                            if (isError.value) {
                                isError.value = false
                            }
                            text.value = it
                        } else {
                            isError.value = true
                        }
                    },
                    isError = isError.value,
                    singleLine = singleLine,
                    placeholder = { Text(text = hint) },
                    label = if (isError.value) ({ Text(text = errorText) }) else null,
                    keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
                    colors = TextFieldDefaults.colors(
                        //cursorColor = Color(0xFF673AB7)
                    )
                )
            }
        },
        confirmButton = {
            Button(
                modifier = Modifier,
                onClick = {
                    openDialog.value = false
                    state.confirm?.invoke()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color(0xFF2196F3)
                )
            ) {
                Text("修改")
            }
        },
        dismissButton = {
            Button(
                modifier = Modifier,
                onClick = {
                    openDialog.value = false
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color(0xFF616161)
                )
            ) {
                Text("取消")
            }
        }
    )

    return state
}

@Composable
fun NoticeTextDialog(
    openDialog: MutableState<Boolean>,
    title: String,
    text: String
) {
    if (openDialog.value) {
        AlertDialog(
            shape = RoundedCornerShape(12.dp),
            onDismissRequest = {
                openDialog.value = false
            },
            title = {
                Text(
                    text = title,
                    fontSize = 16.sp,
                    color = GlobalColor.NoticeBoxText
                )
            },
            text = {
                Text(
                    text,
                    fontSize = 14.sp,
                    color = GlobalColor.NoticeBoxText
                )
            },
            confirmButton = {
                Button(
                    modifier = Modifier
                        .fillMaxWidth(),
                    onClick = {
                        openDialog.value = false
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2196F3),
                        contentColor = Color.White
                    )
                ) {
                    Text("我知道了")
                }
            },
        )
    }
}

@Preview
@Composable
private fun NoticeDialogPreView() {
    ShamrockTheme {
        NoticeTextDialog(openDialog = remember {
            mutableStateOf(true)
        }, "Notice", "Text")
    }
}

@Preview
@Composable
private fun InputDialogPreView() {
    ShamrockTheme {
        InputDialog(
            openDialog = remember { mutableStateOf(true) },
            title = "主动HTTP端口",
            desc = "端口范围在0~65565间，请确保可用。",
            hint = "请输入端口号",
            keyboardType = KeyboardType.Number,
            errorText = "输入你的端口"
        )
    }
}

@Preview
@Composable
private fun InputDialogErrorPreView() {
    ShamrockTheme {
        InputDialog(
            openDialog = remember { mutableStateOf(true) },
            title = "主动HTTP端口",
            desc = "端口范围在0~65565，并确保可用。",
            isError = remember {
                mutableStateOf(true)
            },
            text = remember { mutableStateOf("1008611") },
            hint = "请输入端口号",
            keyboardType = KeyboardType.Number,
            errorText = "端口范围应在0~65565"
        )
    }
}