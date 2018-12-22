package com.edandaniel.jokenpokemon.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.edandaniel.jokenpokemon.R
import com.edandaniel.jokenpokemon.view.model.Points
import java.util.ArrayList

class CustomAdapter(var context: Context, var ranking: ArrayList<Points>): BaseAdapter() {
    private class ViewHolder(row: View?) {
        var txtName: TextView
        var txtValue: TextView
        init{
            this.txtName = row?.findViewById(R.id.txtName) as TextView
            this.txtValue = row?.findViewById(R.id.txtValue) as TextView
        }
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View?
        var viewHolder: ViewHolder
        if (convertView == null){
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.ranking_item_list, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }
        else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        var ranking: Points = getItem(position) as Points
        viewHolder.txtName.text = ranking.name
        viewHolder.txtValue.text = ranking.points
        return view as View

    }

    override fun getItem(position: Int): Any {
        return ranking.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return ranking.count()
    }
}