package moe.fuqiuluo.shamrock.ui.tools

import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

fun CoroutineScope.toast(ctx: Context, txt: String) {
    launch { Toast.makeText(ctx, txt, Toast.LENGTH_SHORT).show() }
}