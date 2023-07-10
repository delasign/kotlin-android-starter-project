package com.delasign.samplestarterproject.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.constraintlayout.compose.ConstraintLayout
import com.delasign.samplestarterproject.coordinators.languageCoordinator.LanguageCoordinator
import com.delasign.samplestarterproject.models.constants.kPadding
import com.delasign.samplestarterproject.ui.styleguide.HeaderText

@Composable
fun MenuScreen() {
    val currentContent = LanguageCoordinator.shared.currentContent?.sample ?: return

    // MARK: Variables
    val identifier = "[Menu]"
    val context = LocalContext.current
    // MARK: States
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
        val (header) = createRefs()
        // 2. Add Elements
        // Add a "HeaderText" from the styleguide as "header." Place it top left of the screen.
        HeaderText(
            copy = currentContent.sampleString,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.constrainAs(header) {
                top.linkTo(parent.top)
                absoluteLeft.linkTo(parent.absoluteLeft)
            },
        )
    }
}
