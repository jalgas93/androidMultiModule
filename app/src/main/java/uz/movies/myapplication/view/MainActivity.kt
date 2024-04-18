package uz.movies.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import uz.movies.myapplication.R
import uz.movies.myapplication.databinding.ActivityMainBinding
//import uz.movies.myapplication.navigation.Navigator
import uz.movies.myapplication.view.screens.bottom_navigation.DownloadFragment
import uz.movies.myapplication.view.screens.bottom_navigation.HomeFragment
import uz.movies.myapplication.view.screens.bottom_navigation.SupportFragment
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //replaceFragment(HomeFragment())


        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.bottom_home -> replaceFragment(HomeFragment())
                R.id.bottom_support -> replaceFragment(SupportFragment())
                R.id.bottom_downloads -> replaceFragment(DownloadFragment())
                else -> {}


            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.nav_host_fragment, fragment)
        fragmentTransaction.commit()
    }
}