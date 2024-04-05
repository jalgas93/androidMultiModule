package uz.movies.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import uz.movies.domain.domain.model.Coin
import uz.movies.myapplication.databinding.CoinRowBinding

class CoinRecyclerAdapter(val coinList:List<Coin>):RecyclerView.Adapter<CoinRecyclerAdapter.CoinViewHolder>() {
    class CoinViewHolder(val binding: CoinRowBinding):RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): CoinRecyclerAdapter.CoinViewHolder {
        val binding = CoinRowBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return CoinViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoinRecyclerAdapter.CoinViewHolder, position: Int) {
       holder.binding.coinName.text = coinList[position].name
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}