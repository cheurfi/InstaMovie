package com.example.pool.instamovie.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.pool.instamovie.R
import com.example.pool.instamovie.models.MovieItem
import kotlinx.android.synthetic.main.fragment_detail.*

class MovieDetailFragment : Fragment() {

    companion object {
        fun newInstance(movieItem: MovieItem): MovieDetailFragment {
            val fragment = MovieDetailFragment()
            val bundle = Bundle()
            bundle.putSerializable("Movie Item", movieItem)
            fragment.arguments = bundle
            return fragment
        }
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let{
            val item = it.get("Movie Item") as MovieItem
            title.text = item.title
            description.text = item.description
            Glide.with(image).load( item.url).into(image)
            item
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }
}