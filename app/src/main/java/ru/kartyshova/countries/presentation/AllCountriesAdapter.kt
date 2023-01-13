package ru.kartyshova.countries.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import ru.kartyshova.countries.data.CountryResponse
import ru.kartyshova.countries.databinding.ListCountryItemBinding

class AllCountriesAdapter(
    private val items: List<CountryResponse>,
    private val onClick: (CountryResponse) -> Unit
) : RecyclerView.Adapter<AllCountriesAdapter.CountryHolder>() {

    class CountryHolder(private val binding: ListCountryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(countryResponse: CountryResponse, onClick: (CountryResponse) -> Unit) =
            with(binding) {
                countryName.text = countryResponse.name
                Glide.with(flag)
                    .load(countryResponse.flags?.png)
                    .transform(CenterCrop())
                    .into(flag)
                root.setOnClickListener { onClick(countryResponse) }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryHolder {
        val binding = ListCountryItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return CountryHolder(binding)
    }

    override fun onBindViewHolder(holder: CountryHolder, position: Int) {
        val item = items[position]
        holder.bind(item, onClick)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

