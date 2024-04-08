package uz.movies.myapplication.view.screens.second

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.movies.myapplication.R
import uz.movies.myapplication.databinding.FragmentFirstBinding
import uz.movies.myapplication.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {
private lateinit var binding: FragmentSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGoBack.setOnClickListener{
            findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
        }
    }
}