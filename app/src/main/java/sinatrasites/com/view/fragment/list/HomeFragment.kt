package sinatrasites.com.view.fragment.list

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import sinatrasites.com.R
import sinatrasites.com.data.Repository
import sinatrasites.com.viewmodel.SharedViewModel
import sinatrasites.com.viewmodel.SharedViewModelFactory


class HomeFragment : Fragment(R.layout.fragment_home) {

    private val viewModel: SharedViewModel by activityViewModels { SharedViewModelFactory(Repository()) }
    var adapter = CharacterAdpater()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.listCharactersInEpisode.observe(viewLifecycleOwner, {
            adapter.setCharacters(it)
        })
        recycclerview.layoutManager =
            StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        recycclerview.adapter = adapter

        refreshLayout.setOnClickListener {
            recycclerview.layoutManager =
                StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
            recycclerview.adapter = adapter
            viewModel.getCharacters()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel.getCharacters()
    }


}