package com.madarsoft.storeusers.ui.showUsers

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.utils.Resource
import com.example.rickandmorty.utils.autoCleared
import com.madarsoft.storeusers.R
import com.madarsoft.storeusers.databinding.FragmentMainBinding
import com.madarsoft.storeusers.databinding.FragmentShowUsersBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShowUsersFragment : Fragment() {

    companion object {
        fun newInstance() = ShowUsersFragment()
    }


    private var binding: FragmentShowUsersBinding by autoCleared()

    private  val viewModel: ShowUsersViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShowUsersBinding.inflate(inflater, container, false)

        viewModel.users.observe(viewLifecycleOwner, Observer {

            when (it.status) {
                Resource.Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    if (!it.data.isNullOrEmpty()){
                        binding.usersRv.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
                        binding.usersRv.adapter = UsersAdapter(it.data)
                    }

                }
                Resource.Status.ERROR ->
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING ->
                    binding.progressBar.visibility = View.VISIBLE
            }

        })



        return binding.root
    }
}