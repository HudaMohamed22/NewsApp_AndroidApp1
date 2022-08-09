import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.ui.JasonData

class CustomAdapter( var mList: Array<JasonData>?, val listener: CustomAdapter.OnItemClickListener) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    // create new views
    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image_view2)
        val textView: TextView = itemView.findViewById(R.id.txt_view)
        val cardView: CardView =itemView.findViewById(R.id.Card)
    }
//    override fun onClick(v: View?) {
//        val position = adapterPosition
//        if (position != RecyclerView.NO_POSITION) {
//            listener.onItemClick(position)
//        }
//    }

    interface OnItemClickListener {
        fun onItemClick(myArtical:JasonData)
       // fun onImageClick()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var JasonData = mList?.get(position)

        // sets the image to the imageview from our itemHolder class
      //  holder.imageView.setImageResource(ItemsViewModel.image)

       // if(JasonData.urlToImage != null){

            Glide.with(holder.imageView)
                .load(JasonData?.urlToImage)
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.imageView)


       // }
        holder.imageView.setOnClickListener(){
            if (JasonData != null) {
                listener.onItemClick(JasonData)
            }
        }
        // sets the text to the textview from our itemHolder class
        holder.textView.text = JasonData?.title


    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList?.size?:0
    }


}
