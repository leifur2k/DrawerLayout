package com.example.android.drawerlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.example.android.drawerlayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        // При нажатии на Итемы нашей менюшки...
        binding?.apply {
            nv.setNavigationItemSelectedListener {
                when(it.itemId){
                    R.id.item1 -> Toast.makeText(this@MainActivity, "Item 1", Toast.LENGTH_SHORT).show()
                    R.id.item2 -> Toast.makeText(this@MainActivity, "Item 2", Toast.LENGTH_SHORT).show()
                }
                // При нажатии на итем менюшки - дополнительно заезжает обратно Вивигатион вью
                drawer.closeDrawer(GravityCompat.START)
                true
            }
            // При нажатии на кнопку на экране вылезает Навигатион вью
            button.setOnClickListener {
                drawer.openDrawer(GravityCompat.START)
            }
        }
    }

}

