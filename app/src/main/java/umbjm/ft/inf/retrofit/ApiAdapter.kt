package umbjm.ft.inf.retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import umbjm.ft.inf.retrofit.data.ApiPublic


class ApiAdapter(val data: List<ApiPublic>?) : RecyclerView.Adapter<ApiAdapter.MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_api, parent, false)
        return MyHolder(v)

    }
    override fun getItemCount(): Int = data?.size ?: 0

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(data?.get(position))
    }


    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(get: ApiPublic?) {
            itemView.findViewById<TextView>(R.id.count).text = get?.count.toString()

            val entries =
                "${get?.entries?.aPI},${get?.entries?.description},${get?.entries?.auth},${get?.entries?.cors},${get?.entries?.hTTPS},${get?.entries?.link}"
            itemView.findViewById<TextView>(R.id.entries).text = entries

        }

    }
}