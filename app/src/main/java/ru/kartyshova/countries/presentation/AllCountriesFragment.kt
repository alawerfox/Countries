package ru.kartyshova.countries.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import ru.kartyshova.countries.data.CountryResponse
import ru.kartyshova.countries.databinding.FragmentAllCountriesBinding

class AllCountriesFragment : Fragment() {

    private val viewModel: CountryViewModel by viewModel()
    private val navController: NavController by lazy { findNavController() }

    private val onClick: (CountryResponse) -> Unit = {
        navController.navigate(AllCountriesFragmentDirections.actionAllCountriesFragmentToCountryItemFragment(it))
    }

    var binding: FragmentAllCountriesBinding? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel.loadCountry()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAllCountriesBinding.inflate(inflater)
        return binding?.root!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.countryList.observe(viewLifecycleOwner) {
            binding?.listCountries?.adapter = AllCountriesAdapter(it, onClick)
        }

        binding?.btnUpdate?.setOnClickListener {
            viewModel.loadCountry()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}

