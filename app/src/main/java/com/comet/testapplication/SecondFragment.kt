package com.comet.testapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.comet.testapplication.model.MainViewModel

class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.second_fragment, container, false);
        val secondViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java); //require Activity, by viewModels()이렇게 해도 된다네요
        // viewmodel ktx이거 적용해야 by 사용가능한듯 액티비티에선 by viewModels<> 프래그먼트에선 by activityViewModels<>
        //val secondViewModel : MainViewModel by activityViewModels();
        Toast.makeText(context, secondViewModel.mainString, Toast.LENGTH_LONG).show()
        return view
    }
}