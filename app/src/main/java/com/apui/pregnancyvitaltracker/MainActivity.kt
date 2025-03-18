package com.apui.pregnancyvitaltracker

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.apui.pregnancyvitaltracker.ui.MainScreen
import com.apui.pregnancyvitaltracker.ui.theme.PregnancyVitalTrackerTheme
import com.apui.pregnancyvitaltracker.utils.FABButton
import com.apui.pregnancyvitaltracker.utils.TopBar
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MainActivity : ComponentActivity() {

    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (!isGranted) {
                Toast.makeText(this, "Notification permission denied!", Toast.LENGTH_SHORT).show()
            }
        }

    private val reminderViewModel: ReminderViewModel by viewModel { parametersOf(application) }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        reminderViewModel.observeWorkStatus(this)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requestNotificationPermission()
        }
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            PregnancyVitalTrackerTheme {
                val showDialogBox = remember { mutableStateOf(false) }
                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = { TopBar() },
                    floatingActionButton = {
                        FABButton(
                            onClick = { showDialogBox.value = true }
                        )
                    }
                ) { innerPadding ->
                    MainScreen(showDialogBox, innerPadding)
                }
            }
        }
    }

    private fun requestNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
            ContextCompat.checkSelfPermission(
                this, android.Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissionLauncher.launch(android.Manifest.permission.POST_NOTIFICATIONS)
        }
    }
}
