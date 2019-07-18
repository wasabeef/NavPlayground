package jp.wasabeef.navplayground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.plusAssign
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findNavController(R.id.nav_host_fragment).apply {
            navigatorProvider += DefaultNavigator(
                this@MainActivity,
                nav_host_fragment.childFragmentManager,
                R.id.nav_host_fragment
            )
            setGraph(R.navigation.nav_graph)
        }
    }
}