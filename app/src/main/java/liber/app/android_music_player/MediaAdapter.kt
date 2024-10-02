package liber.app.android_music_player

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MediaAdapter(
    private val mediaFiles: List<MediaFile>,
    private val onItemClick: (MediaFile) -> Unit
) : RecyclerView.Adapter<MediaAdapter.MediaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MediaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_media_file, parent, false)
        return MediaViewHolder(view)
    }

    override fun onBindViewHolder(holder: MediaViewHolder, position: Int) {
        val mediaFile = mediaFiles[position]
        holder.bind(mediaFile)
        holder.itemView.setOnClickListener {
            onItemClick(mediaFile)
        }
    }

    override fun getItemCount(): Int = mediaFiles.size

    class MediaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.mediaTitle)

        fun bind(mediaFile: MediaFile) {
            titleTextView.text = mediaFile.name
        }
    }
}
