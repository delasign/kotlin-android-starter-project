package com.delasign.samplestarterproject.ui.components.buttons

import android.util.Log
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.input.pointer.pointerInput
import com.delasign.samplestarterproject.models.constants.DebuggingIdentifiers
import com.delasign.samplestarterproject.models.constants.kButtonDimension
import com.delasign.samplestarterproject.models.constants.kShadowSize
import com.delasign.samplestarterproject.ui.styleguide.LabelText
import java.util.concurrent.CancellationException

@Composable
fun SampleButton(
    title: String,
    modifier: Modifier,
    onClick: () -> Unit,
) {
    val identifier = "[SampleButton]"
    val touchedDown = remember { mutableStateOf(false) }

    var backgroundColor = MaterialTheme.colorScheme.background
    var textColor = MaterialTheme.colorScheme.primary

    if (touchedDown.value) {
        backgroundColor = MaterialTheme.colorScheme.primary
        textColor = MaterialTheme.colorScheme.background
    }

    Card(
        modifier = modifier
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        Log.i(
                            "$identifier",
                            "${DebuggingIdentifiers.actionOrEventSucceded} On Touch Down.",
                        )
                        touchedDown.value = true
                        // start
                        val released = try {
                            tryAwaitRelease()
                        } catch (c: CancellationException) {
                            false
                        }
                        if (released) {
                            // ACTION_UP
                            Log.i(
                                "$identifier",
                                "${DebuggingIdentifiers.actionOrEventSucceded} On Touch Release.",
                            )
                            touchedDown.value = false
                            onClick()
                        } else {
                            // CANCELED
                            Log.i(
                                "$identifier",
                                "${DebuggingIdentifiers.actionOrEventSucceded} On Touch Cancelled.",
                            )
                            touchedDown.value = false
                        }
                    },
                )
            }
            .shadow(
                elevation = kShadowSize,
                shape = RoundedCornerShape(kButtonDimension),
                clip = true,
                ambientColor = MaterialTheme.colorScheme.primary,
                spotColor = MaterialTheme.colorScheme.primary,
            ),
        shape = RoundedCornerShape(kButtonDimension / 2),
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor,
        ),
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            LabelText(
                copy = title,
                color = textColor,
                modifier = Modifier.defaultMinSize(),
            )
        }
    }
}
