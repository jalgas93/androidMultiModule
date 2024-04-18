package uz.movies.myapplication.view.screens.bottom_navigation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import uz.movies.myapplication.adapter.CoinRecyclerAdapter
import uz.movies.myapplication.databinding.FragmentHomeBinding
import uz.movies.myapplication.viewmodel.MainViewModel
import javax.inject.Inject

class HomeFragment : Fragment(){

    private lateinit var binding: FragmentHomeBinding
    private lateinit var coinAdapter: CoinRecyclerAdapter
    private lateinit var viewModel: MainViewModel



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        viewModel.state.observe(viewLifecycleOwner, Observer {
            if (!it.isLoading) {
                binding.progressBar.visibility = View.INVISIBLE
                if (it.error.isNotBlank()) {
                    binding.errorText.visibility = View.VISIBLE
                    binding.errorText.text = it.error
                } else {

                    binding.recyclerView.visibility = View.VISIBLE
                    binding.recyclerView.layoutManager = GridLayoutManager(context, 1)
                    coinAdapter = CoinRecyclerAdapter(it.movies, context = context)
                    binding.recyclerView.adapter = coinAdapter
                    coinAdapter.onItemClick = {
                        Log.i("Click","Click")
                            // navigation?.openMovie(12)

                    }
                }
            }
        })
    }
}