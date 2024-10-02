package liber.app.android_music_player

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.VideoView

class PlayerScreenFragment : Fragment() {
    private lateinit var videoView: VideoView
    private lateinit var audioPlaceholder: ImageView
    private lateinit var seekBar: SeekBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_player_screen, container, false)
        videoView = view.findViewById(R.id.videoView)
        audioPlaceholder = view.findViewById(R.id.audioPlaceholder)
        seekBar = view.findViewById(R.id.seekBar)

        // Логика для загрузки и воспроизведения аудио/видео файла

        return view
    }

    private fun setupMediaPlayer(mediaFile: MediaFile) {
        if (mediaFile.isVideo) {
            videoView.visibility = View.VISIBLE
            audioPlaceholder.visibility = View.GONE
            videoView.setVideoURI(mediaFile.uri)
            videoView.start()
        } else {
            videoView.visibility = View.GONE
            audioPlaceholder.visibility = View.VISIBLE
            // Логика для аудиоплеера
        }
    }
}
