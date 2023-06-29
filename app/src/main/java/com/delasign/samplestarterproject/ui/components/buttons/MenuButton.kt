package com.delasign.samplestarterproject.ui.components.buttons

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.input.pointer.pointerInput
import com.delasign.samplestarterproject.models.constants.DebuggingIdentifiers
import com.delasign.samplestarterproject.models.constants.kButtonDimension
import com.delasign.samplestarterproject.models.constants.kShadowSize
import com.delasign.samplestarterproject.models.states.ExperienceStates
import com.delasign.samplestarterproject.ui.styleguide.theme.Black
import com.delasign.samplestarterproject.ui.styleguide.theme.White
import java.util.concurrent.CancellationException

@Composable
fun MenuButton(
    state: ExperienceStates,
    modifier: Modifier,
    onClick: () -> Unit,
) {
    // Mark: Variables
    val identifier = "[MenuButton UI]"
    var icon = Icons.Default.Menu
    var iconDescription = ""
    when (state) {
        ExperienceStates.LANDING -> {
            icon = Icons.Default.Menu
            iconDescription = "Press this button to access the menu."
        }

        ExperienceStates.MENU -> {
            icon = Icons.Default.Close
            iconDescription = "Press this button to close the menu."
        }
    }

    // MARK: States
    val touchedDown = remember { mutableStateOf(false) }
    // Variables based on state
    var backgroundColor = MaterialTheme.colorScheme.background
    var iconColor = MaterialTheme.colorScheme.primary

    if (touchedDown.value) {
        backgroundColor = MaterialTheme.colorScheme.primary
        iconColor = MaterialTheme.colorScheme.background
    }

    // Mark: Visual
    Box(
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
                ambientColor = if (isSystemInDarkTheme()) White else Black,
                spotColor = if (isSystemInDarkTheme()) White else Black,
            )
            .clip(RoundedCornerShape(kButtonDimension / 2))
            .background(color = backgroundColor),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = iconDescription,
            modifier = Modifier.fillMaxSize(fraction = 2 / 3f),
            tint = iconColor,
        )
    }
}
