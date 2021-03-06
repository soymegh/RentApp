package ni.edu.uca.rentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.net.toUri
import androidx.core.view.get
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.*
import com.google.android.material.navigation.NavigationView
import ni.edu.uca.rentapp.EntidadesFrontend.usuarioS
import ni.edu.uca.rentapp.databinding.ActivityArrendadorBinding
import ni.edu.uca.rentapp.databinding.ActivityMarvinBinding
import ni.edu.uca.rentapp.databinding.NavHeaderArrendatarioyarrendadorBinding


class Arrendador : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityArrendadorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArrendadorBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val drawerLayout: DrawerLayout = binding.drawerLayout2
        val navView: NavigationView = binding.navView
        val profileView = binding.navView.getHeaderView(0)
        val headerBinding = NavHeaderArrendatarioyarrendadorBinding.bind(profileView)
        val navController = findNavController(R.id.nav_host_fragment_content_arrendador
        )
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_i,R.id.nav_p
            ), drawerLayout
        )

        headerBinding.ivFotoPerfil.setImageURI(usuarioS.fotoPerfil.toUri())
        headerBinding.tvNombreUsuario.text = usuarioS.nombre
        headerBinding.tvCorreo.text = usuarioS.correo

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
    //Menu 3 puntos
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_arrendador, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_arrendador)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
    //abrir fragment para el menu 3 puntos
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_arrendador)
        when(item.itemId){
            R.id.navi_editar_usuario -> item.onNavDestinationSelected(navController)
        }
        return super.onOptionsItemSelected(item)
    }

}