package sinatrasites.com


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.android.synthetic.main.fragment_detail.*
import sinatrasites.com.R.id
import sinatrasites.com.view.fragment.config.SettingsFragment
import sinatrasites.com.view.fragment.list.HomeFragment
import android.view.MenuItem

class MainActivity : AppCompatActivity() {
    private var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        setTheme(R.style.Theme_Sinatra)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findNavController(id.navHostFragment).also { navController = it }
        setupActionBarWithNavController(navController!!)
        menu_bottom.setItemSelected(id.home)
        menu_bottom.setOnItemSelectedListener {
            when (it) {
                id.home -> {
                    val homeFragment = HomeFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(id.navHostFragment, homeFragment).commit()
                }
                id.settings -> {
                    val settingsFragment = SettingsFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(id.navHostFragment, settingsFragment).addToBackStack(null).commit()
                }
            }
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            id.action_settings -> {
                val settingsFragment = SettingsFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(id.navHostFragment, settingsFragment).addToBackStack(null).commit()
                //supportActionBar?.setDisplayHomeAsUpEnabled(true)
                menu_bottom.setItemSelected(id.settings)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_activity_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onSupportNavigateUp(): Boolean {
        return !(!navController!!.navigateUp() && !super.onSupportNavigateUp())
    }

}