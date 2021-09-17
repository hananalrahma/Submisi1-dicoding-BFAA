package com.hanan.githubuser3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class MainAdapter (private val context: Context, private val listUser: ArrayList<GitUser>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView = convertView
        if (itemView == null){
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            itemView = inflater.inflate(R.layout.item_row, null, true)
        }

        val viewHolder = ViewHolder(itemView as View)
        val user = getItem(position) as GitUser
        viewHolder.bind(user)
        return itemView
    }

    override fun getItem(position: Int): Any {
        return listUser[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return listUser.size
    }

    private inner class ViewHolder internal constructor(view: View){
        private val imgItem : CircleImageView = view.findViewById(R.id.img_item)
        private val itemName: TextView = view.findViewById(R.id.item_name)
        private val itemLocation: TextView = view.findViewById(R.id.item_location)
        private val itemCompany: TextView = view.findViewById(R.id.item_company)

        internal fun bind (user: GitUser){
            user.image?.let { imgItem.setImageResource(it) }
            itemName.text = user.name
            itemLocation.text = user.location
            itemCompany.text = user.company
        }
    }

}