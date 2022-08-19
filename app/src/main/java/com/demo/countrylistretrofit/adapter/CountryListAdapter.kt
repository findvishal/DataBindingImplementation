package com.demo.countrylistretrofit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.demo.countrylistretrofit.R
import com.demo.countrylistretrofit.data.CountryModel
import com.demo.countrylistretrofit.databinding.CountryListRowBinding

class CountryListAdapter() : RecyclerView.Adapter<CountryListAdapter.MyViewHolder>() {

    private var countryList: List<CountryModel>? = null

    fun setCountryList(countryList: List<CountryModel>?) {
        this.countryList = countryList
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,

    ): CountryListAdapter.MyViewHolder {
        val binding=CountryListRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
      //  val view = LayoutInflater.from(parent.context).inflate(R.layout.country_list_row, parent, false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder:MyViewHolder, position: Int) {
        countryList?.let { it[position] }?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int {
        // if(countryList == null)return 0
        // else return countryList?.size!!
        return countryList?.let {
            it.size
        }?:0
    }

    class MyViewHolder(val binding: CountryListRowBinding): RecyclerView.ViewHolder(binding.root){
       // val flagImage = binding.flagImage
       // val tvName = binding.tvName
       // val tvCapital = binding.tvCapital
      //  val tvRegion = binding.tvRegion

        fun bind(data: CountryModel) {
            binding.countryModel=data
            binding.executePendingBindings()
          //  binding.tvName.text = data.name +"(" + data.alpha2Code+")"
           // binding.tvCapital.text = "Capital: "+data.capital
         //   binding.tvRegion.text = "Region: "+data.region



        }
    }
    companion object{
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(flagImage:ImageView,url:String){
            Glide.with(flagImage)
                .load(url)
                .circleCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .fallback(R.drawable.ic_launcher_foreground)
                .into(flagImage)


        }
    }
   // Glide.with(binding.flagImage)
  //  .load(data.flags.png)
   // .circleCrop()
   // .into(binding.flagImage)
}