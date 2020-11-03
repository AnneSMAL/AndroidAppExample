package be.henallux.ig3.android.app.example.ui.module6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import be.henallux.ig3.android.app.example.R

/**
 * A simple [Fragment] subclass.
 */
class KotlinLinksFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.mod6_fragment_kotlin_links, container, false)

        val doneButton = root.findViewById<Button>(R.id.kotlin_links_done_button)
        doneButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_kotlinLinksFragment_to_mod6PresentationFragment)
        }

        return root
    }

}
