package jp.wasabeef.navplayground.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import jp.wasabeef.navplayground.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel.text.observe(this, Observer {
            text_home.text = it
        })

        btn_to_dashboard.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.toDashboard())
            // or using resId
            // findNavController().navigate(R.id.to_dashboard)
        }
    }
}