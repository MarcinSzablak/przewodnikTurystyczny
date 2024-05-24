package com.example.przewodnikturystyczny

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider

class InformationFragment : Fragment() {

    lateinit var counterButton: Button
    private lateinit var model: AppViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = ViewModelProvider(requireActivity()).get(AppViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_information, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        counterButton = view.findViewById<Button>(R.id.count_button)

        counterButton.setOnClickListener {
            val number = model.countNumber.value?.plus(1)
            model.countNumber.value = number
            Toast.makeText(activity, "Button Clicked!", Toast.LENGTH_SHORT).show()
        }
    }
}
