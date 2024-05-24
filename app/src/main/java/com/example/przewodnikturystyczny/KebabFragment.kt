package com.example.przewodnikturystyczny

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider

class KebabFragment : Fragment() {

    private lateinit var kebabListView: ListView
    private lateinit var model: AppViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = ViewModelProvider(requireActivity()).get(AppViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kebab, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val kebabList = listOf<String>(
            "Kebab 1",
            "Kebab 2",
            "Kebab 3",
            "Kebab 4",
            "Kebab 5",
            "Kebab 6",
            "Kebab 7",
            "Kebab 8",
            "Kebab 9",
            "Kebab 10"
        )

        kebabListView = view.findViewById<ListView>(R.id.kebab_list)

        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
            activity as Context, android.R.layout.simple_list_item_1, kebabList
        )

        kebabListView.adapter = adapter

        kebabListView.setOnItemClickListener { adapterView, view, i, l ->

            model.choosenKebab.value = kebabList[i]

            Toast.makeText(activity, "Wybrano Kebab: " + kebabList[i], Toast.LENGTH_SHORT).show()
        }
    }
}