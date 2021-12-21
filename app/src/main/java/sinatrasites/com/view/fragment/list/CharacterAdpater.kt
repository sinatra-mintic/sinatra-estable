package sinatrasites.com.view.fragment.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import sinatrasites.com.R
import sinatrasites.com.model.Character
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list.view.*

class CharacterAdpater : RecyclerView.Adapter<CharacterAdpater.CharacterViewHolder>() {

    private var listCharacters = emptyList<Character>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(listCharacters[position])
        holder.itemView.setOnClickListener { view ->
            val action =
                HomeFragmentDirections.actionHomeFragmentToDetailFragment(listCharacters[position])
            view.findNavController().navigate(action)
        }
    }


    override fun getItemCount(): Int {
        return listCharacters.size
    }

    fun setCharacters(characters: List<Character>){
        listCharacters = characters
        notifyDataSetChanged()
    }

    //Cargo los valores para cada item del listado
    class CharacterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var image_character = itemView.character_img
        var name_character = itemView.txt_name_character
        var rating_character = itemView.txt_stars
        fun bind(character: Character){
            Picasso.get().load(character.image).into(image_character)
            name_character.text = character.name
            rating_character.rating = character.ratingBar
        }
    }

}