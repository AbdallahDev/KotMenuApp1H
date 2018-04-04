package com.example.abdallahsarayrah.kotmenuapp1h

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerForContextMenu(textView1)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.item1 -> {
                var i = Intent(this, Main2Activity::class.java)
                i.putExtra("value", "Implicit intent")
                startActivity(i)
            }
            R.id.item2 -> {
                var url = Uri.parse("http://www.google.com")
                var intent = Intent(Intent.ACTION_VIEW, url)
                startActivity(intent)
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)

        menu?.add(100, 100, 100, "Red")
        menu?.add(100, 200, 100, "Blue")
        menu?.add(100, 300, 100, "Green")
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            100 -> main.setBackgroundColor(Color.RED)
            200 -> main.setBackgroundColor(Color.BLUE)
            300 -> main.setBackgroundColor(Color.GREEN)
        }

        return super.onContextItemSelected(item)
    }
}
