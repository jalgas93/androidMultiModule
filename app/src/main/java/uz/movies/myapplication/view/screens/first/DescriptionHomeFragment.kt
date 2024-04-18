package uz.movies.myapplication.view.screens.first

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.movies.myapplication.R
import uz.movies.myapplication.databinding.FragmentHomeDescriptionBinding

class DescriptionHomeFragment : Fragment() {
private  lateinit var binding: FragmentHomeDescriptionBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeDescriptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnGoTo2.setOnClickListener{
            findNavController().navigate(R.id.action_supportFragment_to_secondFragment)
        }
    }
}