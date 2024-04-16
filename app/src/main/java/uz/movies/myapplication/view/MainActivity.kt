package uz.movies.myapplication.view

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import uz.movies.domain.domain.presentation.Navigator
import uz.movies.myapplication.R
import uz.movies.myapplication.adapter.CoinRecyclerAdapter
import uz.movies.myapplication.databinding.ActivityMainBinding
import uz.movies.myapplication.databinding.CoinRowBinding
import uz.movies.myapplication.view.screens.bottom_navigation.DownloadFragment
import uz.movies.myapplication.view.screens.bottom_navigation.HomeFragment
import uz.movies.myapplication.view.screens.bottom_navigation.SupportFragment
import uz.movies.myapplication.view.screens.first.FirstFragment
import uz.movies.myapplication.view.screens.second.SecondFragment
import uz.movies.myapplication.view.screens.third.ThirdFragment
import uz.movies.myapplication.viewmodel.MainViewModel


@AndroidEntryPoint
class MainActivity : AppCompatActivity(),CoinRecyclerAdapter.RecyclerViewEvent {

        private lateinit var binding: ActivityMainBinding
        private lateinit var coinAdapter: CoinRecyclerAdapter
        private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
       // replaceFragment(HomeFragment())
        // setContentView(R.layout.activity_main)

      /*  binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.bottom_home -> replaceFragment(HomeFragment())
                R.id.bottom_support -> replaceFragment(SupportFragment())
                R.id.bottom_downloads -> replaceFragment(DownloadFragment())

                else -> {


                }
            }
            true
        }*/


          viewModel = ViewModelProvider(this)[MainViewModel::class.java]
          viewModel.state.observe(this) {

              if (!it.isLoading) {
                  binding.progressBar.visibility = View.INVISIBLE
                if (it.error.isNotBlank()) {
                    binding.errorText.visibility = View.VISIBLE
                    binding.errorText.text = it.error
                } else {

                    binding.recyclerView.visibility = View.VISIBLE
                    binding.recyclerView.layoutManager = GridLayoutManager(this,1)
                    coinAdapter = CoinRecyclerAdapter(it.movies, context = this@MainActivity,this)
                    binding.recyclerView.adapter = coinAdapter
                    coinAdapter.onItemClick = {

                    }

                }
            }

        }
    }

    override fun onItemClick(position: Int) {

        Toast.makeText(this,"",Toast.LENGTH_SHORT).show()
    }

    /*    private fun replaceFragment(fragment: Fragment) {

            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frameLayout, fragment)
            fragmentTransaction.commit()


        }*/
}