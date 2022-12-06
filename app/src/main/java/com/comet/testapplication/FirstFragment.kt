package com.comet.testapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.comet.testapplication.callback.Callback
import com.comet.testapplication.model.MainViewModel

class FirstFragment : Fragment() {

    private var callback : Callback? = null;

    override fun onAttach(context: Context) {
        callback = context as Callback?
        super.onAttach(context)
    }

    override fun onDetach() {
        callback = null
        super.onDetach()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java);
        val view = inflater.inflate(R.layout.first_fragment, container, false);
        val button = view.findViewById<Button>(R.id.next);
        viewModel.mainString = "첫번째 하이재킹";
        button.setOnClickListener { callback?.changeView() }
        return view //새로 inflate한 뷰 반환해야됨..
    }

    companion object {
        fun newInstance(): FirstFragment {
            return FirstFragment()
        }
    }
}