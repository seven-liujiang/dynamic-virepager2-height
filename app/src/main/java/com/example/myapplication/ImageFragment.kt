package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ItemMainBinding

/**
 * @describe:
 * @author：liumingxin
 * @time：2024/5/28
 **/
class ImageFragment : Fragment() {
    private var binding: ItemMainBinding? = null

    private var imageId = 0
    private var title = ""
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.item_main, container, false)

        if (imageId != 0) {
            binding?.ivPic?.let {
                Glide.with(this)
                    .load(imageId)
                    .into(it)
            }
        }
        binding?.tvTitle?.text = title
        return binding?.root
    }

    fun setData(imageId: Int, title: String) {
        this.imageId = imageId
        this.title = title
    }
}