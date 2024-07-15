package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _dataBinding: ActivityMainBinding? = null
    private val dataBinding: ActivityMainBinding get() = _dataBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        _dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val viewPager2ViewHeightAnimator = ViewPager2ViewHeightAnimator()
        viewPager2ViewHeightAnimator.viewPager2 = dataBinding.viewPager2
        val imagePagerAdapter = ImagePagerAdapter(this)
        dataBinding.viewPager2.adapter = imagePagerAdapter
        val items = listOf(
            R.mipmap.pic01 to "Image 1",
            R.mipmap.pic02 to "Image 2",
            R.mipmap.pic03 to "Image 3"
        )
        imagePagerAdapter.setItems(items)
    }
}