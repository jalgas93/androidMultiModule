package uz.movies.myapplication.view.screens.third

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.movies.myapplication.R
import uz.movies.myapplication.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {
private lateinit var binding: FragmentThirdBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThirdBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnGoBack.setOnClickListener{
            findNavController().navigate(R.id.action_thirdFragment_to_firstFragment)
        }
    }
}