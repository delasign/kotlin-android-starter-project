package com.delasign.samplestarterproject.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.delasign.samplestarterproject.coordinators.languageCoordinator.LanguageCoordinator
import com.delasign.samplestarterproject.coordinators.notificationCoordinator.NotificationCoordinator
import com.delasign.samplestarterproject.coordinators.notificationCoordinator.sendOnUpdateExperienceIntent
import com.delasign.samplestarterproject.models.constants.kButtonDimension
import com.delasign.samplestarterproject.models.constants.kPadding
import com.delasign.samplestarterproject.models.states.ExperienceStates
import com.delasign.samplestarterproject.ui.components.buttons.MenuButton

@Composable
fun HUD(state: ExperienceStates) {
    val currentContent = LanguageCoordinator.shared.currentContent?.sample ?: return

    // MARK: Variables
    val identifier = "[HUD]"
    val context = LocalContext.current
    // MARK: States
    // Updating the experience state this way has to be done otherwise it won't update after pressing.
    val experienceState = remember { mutableStateOf(state) }
    experienceState.value = state
    // MARK: Visual
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(kPadding),
    ) {
        // Add the elements within your constrained layout
        // 1. Add References
        // Each of the elements requires a reference.
        val (menuButton) = createRefs()
        // 2. Add Elements
        // Add a menu button on the bottom right of the screen.
        MenuButton(
            state = state,
            Modifier
                .constrainAs(menuButton) {
                    bottom.linkTo(parent.bottom)
                    absoluteRight.linkTo(parent.absoluteRight)
                    width = Dimension.value(kButtonDimension)
                    height = Dimension.value(kButtonDimension)
                },
            onClick = {
                // As mentioned above, for the state to update within the closure, we have to create a mutable state within the composable - else, if we use the "state" parameter, it will always think its the same state (i.e. Landing) that it was initialized with.
                val newState = when (experienceState.value) {
                    ExperienceStates.LANDING -> ExperienceStates.MENU
                    ExperienceStates.MENU -> ExperienceStates.LANDING
                }
                NotificationCoordinator.shared.sendOnUpdateExperienceIntent(state = newState)
            },
        )
    }
}
