package jp.wasabeef.navplayground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = findNavController(R.id.nav_host_fragment)
        // タイトルなどの制御
        setupActionBarWithNavController(
            navController, AppBarConfiguration(
                setOf(
                    R.id.fragment_home,
                    R.id.fragment_dashboard
                )
            )
        )
        // BottomNavigation の遷移を制御
        nav_view.setupWithNavController(navController)
    }
}
