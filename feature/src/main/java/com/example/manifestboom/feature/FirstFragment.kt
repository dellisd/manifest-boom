package com.example.manifestboom.feature

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.manifestboom.feature.databinding.FragmentFeatureFirstBinding
import com.example.manifestboom.library.Thing
import com.example.manifestboom.library.ThingContainer
import com.example.manifestboom.library.ThingContainer_Factory

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

  private var _binding: FragmentFeatureFirstBinding? = null

  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  // TODO: This class can be instantiated normally, it exists in the :feature module's generated code
  private val component = DaggerFeatureComponent.create()
    .also { Log.wtf("FeatureFragment", it.toString()) }

  // TODO: This can ALSO be instantiated normally, it exists in the :library module's generated code
  private val provider = ThingContainer_Factory.create()
    .also { Log.wtf("FeatureFragment", it.toString()) }

  // TODO: This class can not, because reasons ???
  private val thing: Thing = Thing("Thingy")
    .also { Log.wtf("FeatureFragment", it.toString()) }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {

    _binding = FragmentFeatureFirstBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.buttonFirst.setOnClickListener {
      findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
    }

    binding.textviewFirst.text = thing.doThing()
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}