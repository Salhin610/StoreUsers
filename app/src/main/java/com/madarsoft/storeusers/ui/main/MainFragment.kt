package com.madarsoft.storeusers.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.rickandmorty.utils.Resource
import com.example.rickandmorty.utils.autoCleared
import com.madarsoft.storeusers.R
import com.madarsoft.storeusers.data.models.UserModel
import com.madarsoft.storeusers.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainFragment : Fragment() {


    private var binding: FragmentMainBinding by autoCleared()

    private  val viewModel: MainViewModel by viewModels()

    private val gendersList = listOf("Male", "Female")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.genderSpinner.setItems(gendersList)

        setupActions()

        return binding.root
    }

    private fun setupActions() {

        binding.Save.setOnClickListener {

            val userModel = UserModel(
                0,
                binding.UserName.text.toString(),
                binding.Age.text.toString(),
                binding.JobTitle.text.toString(),
                gendersList[binding.genderSpinner.selectedIndex],
            )

            val result =  viewModel.validateEnteredUser(userModel)

            if( result == "Validation Succeeded"){

                viewModel.addUser(userModel)
                viewModel.add.observe(viewLifecycleOwner, Observer {
                    Toast.makeText(context,getString(R.string.user_added), Toast.LENGTH_LONG).show()
                    binding.UserName.setText("")
                    binding.JobTitle.setText("")
                    binding.Age.setText("")
                    binding.genderSpinner.selectedIndex = 0
                })
            }else
                Toast.makeText(context,result, Toast.LENGTH_LONG).show()

        }


        binding.ExsitingUsers.setOnClickListener {
            findNavController().navigate(
                R.id.action_mainFragment_to_showUsersFragment
            )
        }
    }


}