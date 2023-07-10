package com.delasign.samplestarterproject.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.delasign.samplestarterproject.coordinators.languageCoordinator.LanguageCoordinator
import com.delasign.samplestarterproject.models.constants.kButtonDimension
import com.delasign.samplestarterproject.models.constants.kPadding
import com.delasign.samplestarterproject.ui.styleguide.LabelText
import com.delasign.samplestarterproject.ui.styleguide.theme.Blue

@Composable
fun LandingScreen() {
    val currentContent = LanguageCoordinator.shared.currentContent?.sample ?: return

    // MARK: Variables
    val identifier = "[Landing]"
    val context = LocalContext.current
    // MARK: States
//    var sampleBooleanState: MutableState<Boolean> = remember { mutableStateOf(false) }
    // MARK: Visual
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(kPadding)
            .background(color = MaterialTheme.colorScheme.background),
    ) {
        // Add the elements within your constrained layout
        // 1. Add References
        // Each of the elements requires a reference.
        val (elementOne, elementTwo) = createRefs()
        // 2. Add Elements
        // First add a box as "elementOne" and make it centered, with a width and height matching our kButtonDimension
        Box(
            modifier = Modifier
                .constrainAs(elementOne) {
                    // Please note that parent is the ConstraintLayout in line 26
                    centerTo(parent)
                    width = Dimension.value(kButtonDimension)
                    height = Dimension.value(kButtonDimension)
                },
        ) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "A Sample Check Icon",
                modifier = Modifier.fillMaxSize(),
                tint = Blue,
            )
        }
        // Then add a "LabelText" from the styleguide as "elementTwo." Place it centered horizontally to the element and kPadding below the bottom.
        LabelText(
            copy = currentContent.sampleString,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.constrainAs(elementTwo) {
                centerHorizontallyTo(elementOne)
                top.linkTo(elementOne.bottom)
            },
        )
    }
}
