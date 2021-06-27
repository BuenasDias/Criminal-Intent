package com.example.criminal_intent

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.criminal_intent.databinding.FragmentCrimeBinding

class CrimeFragment : Fragment() {

    private lateinit var crime: Crime
    private var fragmentCrimeBinding: FragmentCrimeBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crime = Crime()
    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentCrimeBinding.inflate(inflater, container, false)
        fragmentCrimeBinding = binding

        binding.crimeDate.apply {
            text = crime.date.toString()
            isEnabled = false
        }

        return binding.root
    }

    override fun onStart() {
        super.onStart()

        val titleWatcher = object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                crime.title = p0.toString()
            }

            override fun afterTextChanged(p0: Editable?) {
                TODO("Not yet implemented")
            }
        }

        fragmentCrimeBinding?.crimeTitle?.addTextChangedListener(titleWatcher)

        fragmentCrimeBinding?.crimeSolved?.apply {
            setOnCheckedChangeListener { _, isChecked ->
                crime.isSolved = isChecked }
        }
    }

    override fun onDestroyView() {
        fragmentCrimeBinding = null
        super.onDestroyView()
    }
}