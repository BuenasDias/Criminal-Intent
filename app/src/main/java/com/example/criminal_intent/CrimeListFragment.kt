package com.example.criminal_intent

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.criminal_intent.databinding.FragmentCrimeListBinding

private const val TAG = "CrimeListFragment"

class CrimeListFragment : Fragment() {

    private val crimeListViewModel: CrimeListViewModel by viewModels()
    private var fragmentCrimeListBinding: FragmentCrimeListBinding? = null
    private lateinit var crimeRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Total crimes: ${crimeListViewModel.crimes.size}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentCrimeListBinding.inflate(inflater, container, false)
        fragmentCrimeListBinding = binding

        binding.crimeRecyclerView.layoutManager = LinearLayoutManager(context)



        return binding.root
    }

    override fun onDestroy() {
        fragmentCrimeListBinding = null
        super.onDestroy()
    }

    private inner class CrimeHolder(view: View) : RecyclerView.ViewHolder(view) {


    }

    companion object {
        fun newInstance(): CrimeListFragment {
            return CrimeListFragment()
        }
    }
}