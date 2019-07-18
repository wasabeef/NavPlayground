package jp.wasabeef.navplayground

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavDestination
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.fragment.FragmentNavigator

@Navigator.Name("fragment_with_anim")
class DefaultNavigator(
    context: Context,
    manager: FragmentManager,
    containerId: Int
) : FragmentNavigator(context, manager, containerId) {

    override fun navigate(
        destination: Destination,
        args: Bundle?,
        navOptions: NavOptions?,
        navigatorExtras: Navigator.Extras?
    ): NavDestination? {
        val exOp = navOptions?.let { op ->
            androidx.navigation.navOptions {
                launchSingleTop = op.shouldLaunchSingleTop()
                popUpTo(op.popUpTo) {
                    inclusive = op.isPopUpToInclusive
                }
                anim {
                    enter = op.enterAnim.takeIf { it != -1 } ?: R.anim.nav_default_enter_anim
                    exit = op.exitAnim.takeIf { it != -1 } ?: R.anim.nav_default_exit_anim
                    popEnter = op.popEnterAnim.takeIf { it != -1 } ?: R.anim.nav_default_pop_enter_anim
                    popExit = op.popExitAnim.takeIf { it != -1 } ?: R.anim.nav_default_pop_exit_anim
                }
            }
        }
        return super.navigate(destination, args, exOp, navigatorExtras)
    }
}