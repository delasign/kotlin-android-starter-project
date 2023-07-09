package com.delasign.samplestarterproject.ui.components.other

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.delasign.samplestarterproject.coordinators.languageCoordinator.LanguageCoordinator
import com.delasign.samplestarterproject.models.constants.DebuggingIdentifiers
import com.delasign.samplestarterproject.models.constants.kButtonDimension
import com.delasign.samplestarterproject.models.constants.kPadding
import com.delasign.samplestarterproject.models.constants.kShadowSize
import com.delasign.samplestarterproject.ui.styleguide.LabelText
import com.delasign.samplestarterproject.ui.styleguide.theme.Black
import com.delasign.samplestarterproject.ui.styleguide.theme.White
import java.util.concurrent.CancellationException

@Composable
fun DynamicallyAdaptingComposable(modifier: Modifier, onExit: () -> Unit) {
    val currentContent = LanguageCoordinator.shared.currentContent ?: return
    // Mark: Variables
    val identifier = "[PhotoPermissionsAlert]"
    val context = LocalContext.current

    val backgroundColor = MaterialTheme.colorScheme.primary
    val primaryColor = MaterialTheme.colorScheme.background

    // State
    val touchedDown = remember { mutableStateOf(false) }
    val buttonBackgroundColor = if (touchedDown.value) primaryColor else backgroundColor
    val buttonIconColor = if (touchedDown.value) backgroundColor else primaryColor

    // MARK: Visual
    ConstraintLayout(
        modifier = modifier
            .defaultMinSize()
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(kPadding),
            ),
    ) {
        val (prompt, closeButton, caret) = createRefs()
        Box(
            modifier = Modifier
                .constrainAs(caret) {
                    bottom.linkTo(parent.bottom, -kPadding / 2)
                    absoluteLeft.linkTo(parent.absoluteLeft, kPadding)
                    width = Dimension.value(kPadding)
                    height = Dimension.value(kPadding)
                }
                .rotate(45f)
                .background(color = backgroundColor),
        )
        LabelText(
            copy = currentContent.sample.sampleString,
            color = primaryColor,
            modifier = Modifier
                .constrainAs(prompt) {
                    top.linkTo(parent.top, kPadding)
                    absoluteLeft.linkTo(parent.absoluteLeft, kPadding)
                    absoluteRight.linkTo(parent.absoluteRight, kPadding)
                    width = Dimension.fillToConstraints
                }
                .defaultMinSize(),
        )
        Card(
            modifier = Modifier
                .constrainAs(closeButton) {
                    top.linkTo(prompt.bottom, kPadding)
                    absoluteRight.linkTo(parent.absoluteRight, kPadding)
                    bottom.linkTo(parent.bottom, kPadding)
                    width = Dimension.value(kButtonDimension)
                    height = Dimension.value(kButtonDimension)
                }
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
                                onExit()
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
                    ambientColor = if (isSystemInDarkTheme()) Black else White,
                    spotColor = if (isSystemInDarkTheme()) Black else White,
                ),
            shape = RoundedCornerShape(kButtonDimension / 2),
            colors = CardDefaults.cardColors(
                containerColor = buttonBackgroundColor,
            ),
        ) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "A Sample Close Icon",
                modifier = Modifier.fillMaxSize(),
                tint = buttonIconColor,
            )
        }
    }
}
