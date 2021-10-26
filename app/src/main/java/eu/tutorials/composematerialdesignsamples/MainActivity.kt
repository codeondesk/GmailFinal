package eu.tutorials.composematerialdesignsamples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import eu.tutorials.composematerialdesignsamples.components.GmailDrawerMenu
import eu.tutorials.composematerialdesignsamples.components.HomeAppBar
import eu.tutorials.composematerialdesignsamples.ui.theme.ComposeMaterialDesignSamplesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeMaterialDesignSamplesTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    GmailApp()
                }
            }
        }
    }
}

@Composable
fun GmailApp() {
    /**Todo 4 create values for Scaffold state and coroutine scope
     * pass the values into HomeAppBar
     * */
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    //Todo 6:add scaffold state to scaffold
    Scaffold(scaffoldState = scaffoldState,
        topBar = {
        HomeAppBar(scaffoldState,coroutineScope)
    },
        //Todo 5: add drawer content with empty lambda
        drawerContent = {
      //Todo 9:pass GmailDrawerMenu as the drawer content
            GmailDrawerMenu()
    }){
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeMaterialDesignSamplesTheme {
        GmailApp()
    }
}