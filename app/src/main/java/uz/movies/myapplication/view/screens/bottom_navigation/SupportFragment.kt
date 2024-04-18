package uz.movies.myapplication.view.screens.bottom_navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.movies.myapplication.R
import uz.movies.myapplication.databinding.FragmentSupportBinding
class SupportFragment : Fragment() {

private lateinit var  binding:FragmentSupportBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSupportBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGoTo2.setOnClickListener {
            findNavController().navigate(R.id.action_supportFragment_to_secondFragment)
        }
    }

}