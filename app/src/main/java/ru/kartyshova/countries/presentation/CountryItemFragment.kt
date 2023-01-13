package ru.kartyshova.countries.presentation

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import ru.kartyshova.countries.data.CountryResponse
import ru.kartyshova.countries.databinding.FragmentCountryItemBinding

class CountryItemFragment: Fragment(){

    private var binding: FragmentCountryItemBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCountryItemBinding.inflate(inflater, container, false)
        return binding?.root!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val country = arguments?.getParcelable<CountryResponse>("arg") ?: return
        binding?.run {
            name.text = country.name
            region.text = country.region
            capital.text = country.capital
            timezones.text = country.timezones.first()

            val currencies = country.currencies.first()
            code.text = currencies.code
            currencyName.text = currencies.name
            symbol.text = currencies.name

            Glide.with(requireContext()).load(country.flags.png)
                .into(flag)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}