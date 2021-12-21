package sinatrasites.com.view.fragment.details

import android.content.Intent
import android.net.Uri.parse
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail.*
import sinatrasites.com.R

class DetailFragment : Fragment(R.layout.fragment_detail) {
    private val args: DetailFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val character = args.character

        Picasso.get().load(character.image).into(img_character)
        txt_name.text = character.name
        txt_descripcion.text = character.description
        txt_temp.text = "Temperatura: " + character.temp + " °C"
        txt_location.text = character.location

        map_btn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val gmmIntentUri = parse(character.coordinates)
                val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                mapIntent.setPackage("com.google.android.apps.maps")
                try {
                    if (mapIntent.resolveActivity(activity!!.packageManager) != null) {
                        startActivity(mapIntent)
                    }
                } catch (e: NullPointerException) {
                }
            }
        })
    }


}