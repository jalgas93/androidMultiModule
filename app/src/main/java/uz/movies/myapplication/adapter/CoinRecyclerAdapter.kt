package uz.movies.myapplication.adapter

import android.R
import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import uz.movies.domain.domain.common.Constants
import uz.movies.domain.domain.model.Result
import uz.movies.myapplication.databinding.CoinRowBinding


class CoinRecyclerAdapter(
    val moviesList: List<Result>, private val context: Context,
    private val listener: RecyclerViewEvent
) :
    RecyclerView.Adapter<CoinRecyclerAdapter.CoinViewHolder>() {

        var onItemClick : ((Result)->Unit)? = null
    class CoinViewHolder(val binding: CoinRowBinding) : RecyclerView.ViewHolder(binding.root)

    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition

            if (position != RecyclerView.NO_POSITION) {
            listener.onItemClick(position)
            }
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): CoinViewHolder {
        val binding = CoinRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CoinViewHolder(binding)

    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        var requestOptions = RequestOptions()
        requestOptions = requestOptions.transforms(
            FitCenter(), RoundedCorners(16)
        )

        Glide.with(context)
            .load("${Constants.URL_IMAGE_ORIGINAL}${moviesList[position].backdrop_path}")
            .apply(requestOptions).skipMemoryCache(true).into(holder.binding.imageMain)
        holder.binding.textView2.text = moviesList[position].title
        holder.binding.textView3.text = moviesList[position].overview
        holder.binding.textView4.text = moviesList[position].popularity.toString()
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(moviesList[position])
        }

    }


    override fun getItemCount(): Int = moviesList.size

    interface RecyclerViewEvent {
        fun onItemClick(position: Int)
    }

}