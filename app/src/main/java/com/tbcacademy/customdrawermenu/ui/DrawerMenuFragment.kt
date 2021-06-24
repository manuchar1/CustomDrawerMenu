package com.tbcacademy.customdrawermenu.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.tbcacademy.customdrawermenu.R
import com.tbcacademy.customdrawermenu.adapter.DrawerAdapter
import com.tbcacademy.customdrawermenu.databinding.FragmentDrawerMenuBinding
import com.tbcacademy.customdrawermenu.model.ItemModel

class DrawerMenuFragment : Fragment() {

    private lateinit var binding: FragmentDrawerMenuBinding
    private lateinit var adapter: DrawerAdapter

    private var items = arrayListOf(
        ItemModel(R.drawable.ic_home, "Home"),
        ItemModel(R.drawable.ic_music, "Music"),
        ItemModel(R.drawable.ic_movie, "Movies"),
        ItemModel(R.drawable.ic_book, "Books"),
        ItemModel(R.drawable.ic_profile, "Profile"),
        ItemModel(R.drawable.ic_settings, "Settings")
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDrawerMenuBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecycler()
        updateAdapter(0)
        taggle()

    }


    private fun initRecycler() {

        binding.recyclerview.layoutManager = LinearLayoutManager(requireActivity())
        binding.recyclerview.setHasFixedSize(true)

    }



    private fun updateAdapter(highlightItemPos: Int) {
        adapter = DrawerAdapter(items, highlightItemPos)
        binding.recyclerview.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    private fun taggle() {
        val toggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle(
            requireActivity(),
            binding.drawerLayout,
            binding.activityMainToolbar,
            R.string.open,
            R.string.close
        ) {

        }
        binding.drawerLayout.addDrawerListener(toggle)

        toggle.syncState()
    }

}