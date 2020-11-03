package be.henallux.ig3.android.app.example.ui.module6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import be.henallux.ig3.android.app.example.R
import be.henallux.ig3.android.app.example.databinding.Mod6FragmentKotlinExampleBinding
import be.henallux.ig3.android.app.example.models.NetworkError

/**
 * Default visibility for classes, variables or functions is "public". If you would like another
 * visibility, you should write it in front of your element. Other possible visibilities are "private",
 * "internal" and "protected".
 */
class KotlinExampleFragment : Fragment() {

    private lateinit var binding: Mod6FragmentKotlinExampleBinding
    private lateinit var viewModel: KotlinExampleViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        viewModel = ViewModelProvider(this).get(KotlinExampleViewModel::class.java)
        binding = Mod6FragmentKotlinExampleBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        // Observing LiveData
        viewModel.pizza.observe(viewLifecycleOwner, Observer {
            binding.pizzaProgressBar.visibility = View.GONE
            binding.pizzaErrorLayout.visibility = View.GONE
            binding.pizzaInfoLayout.visibility = View.VISIBLE
            binding.kotlinExampleRefreshButton.visibility = View.VISIBLE
        })
        viewModel.error.observe(viewLifecycleOwner, Observer {
            displayErrorScreen(it)
        })

        // On Click Listeners
        binding.kotlinExampleRefreshButton.setOnClickListener { sendRequest() }
        binding.kotlinExampleNextButton.setOnClickListener {
            Navigation.findNavController(it)
                    .navigate(R.id.action_kotlinExampleFragment_to_kotlinLinksFragment)
        }

        // Initializing Screen (Launch HTTP Request)
        sendRequest()
        return binding.root
    }

    private fun sendRequest() {
        viewModel.getPizzaFromWeb()
        binding.pizzaInfoLayout.visibility = View.GONE
        binding.pizzaErrorLayout.visibility = View.GONE
        binding.kotlinExampleRefreshButton.visibility = View.GONE
        binding.pizzaProgressBar.visibility = View.VISIBLE
    }

    private fun displayErrorScreen(error: NetworkError?) {
        binding.pizzaProgressBar.visibility = View.GONE
        binding.kotlinExampleRefreshButton.visibility = View.VISIBLE
        if (error == null) {
            binding.pizzaInfoLayout.visibility = View.VISIBLE
            binding.pizzaErrorLayout.visibility = View.GONE
        } else {
            binding.pizzaErrorLayout.visibility = View.VISIBLE
            binding.pizzaInfoLayout.visibility = View.GONE
            binding.pizzaErrorImage.setImageDrawable(resources.getDrawable(error.errorDrawable,
                    requireActivity().theme))
            binding.pizzaErrorText.setText(error.errorMessage)
        }
    }

}
