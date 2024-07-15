package com.example.myapplication

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * @describe:
 * @author：liumingxin
 * @time：2024/5/28
 **/
class ImagePagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    private val items = mutableListOf<Pair<Int, String>>()

    fun setItems(items: List<Pair<Int, String>>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun createFragment(position: Int): Fragment {
        val (imageUrl, text) = items[position]
        return ImageFragment().apply { setData(imageUrl, text) }
    }
}