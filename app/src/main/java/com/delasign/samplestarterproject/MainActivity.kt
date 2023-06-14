package com.delasign.samplestarterproject

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.delasign.samplestarterproject.coordinators.languageCoordinator.LanguageCoordinator
import com.delasign.samplestarterproject.coordinators.languageCoordinator.updateCurrentContent
import com.delasign.samplestarterproject.models.constants.DebuggingIdentifiers
import com.delasign.samplestarterproject.models.languageContent.UIContent
import com.delasign.samplestarterproject.ui.styleguide.HeaderText
import com.delasign.samplestarterproject.ui.styleguide.theme.AppTheme

class MainActivity : ComponentActivity() {
    // MARK: Variables
    val identifier = "[MainActivity]"

    // MARK: Lifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupCoordinators()
        val currentContent: UIContent = LanguageCoordinator.shared.currentContent ?: return
        setContent {
            AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Greeting(currentContent.sample.sampleString)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        LanguageCoordinator.shared.updateCurrentContent()
    }

    // MARK: Setup Functionality
    private fun setupCoordinators() {
        Log.i(
            identifier,
            "${DebuggingIdentifiers.actionOrEventInProgress} Setting Up Coordinators.",
        )
        LanguageCoordinator.shared.initialize(context = baseContext)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    HeaderText(
        copy = "Hello $name!",
        modifier = modifier,
        color = MaterialTheme.colorScheme.primary,
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppTheme {
        Greeting("Android")
    }
}
