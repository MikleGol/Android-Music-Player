package liber.app.android_music_player

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.File

class HomeScreenFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MediaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home_screen, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val mediaFiles = loadMediaFiles()
        adapter = MediaAdapter(mediaFiles) { mediaFile ->
            val bundle = Bundle().apply {
                putString("fileName", mediaFile.name)
                putParcelable("fileUri", mediaFile.uri)
                putBoolean("isVideo", mediaFile.isVideo)
            }
            findNavController().navigate(R.id.action_homeScreenFragment_to_playerScreenFragment, bundle)
        }
        recyclerView.adapter = adapter

        return view
    }

    private fun loadMediaFiles(): List<MediaFile> {
        val mediaFiles = mutableListOf<MediaFile>()
        val directory = File(requireContext().filesDir, "LiberPlayer")

        // Проверяем, существует ли директория, если нет - создаем
        if (!directory.exists()) {
            directory.mkdir()  // Создаем директорию
            Log.d("HomeScreenFragment", "Created directory: ${directory.absolutePath}")
        }

        // Проверяем, является ли это директорией
        if (directory.isDirectory) {
            directory.listFiles()?.forEach { file ->
                Log.d("HomeScreenFragment", "Found file: ${file.name}")
                val uri = Uri.fromFile(file)
                val isVideo = file.extension.equals("mp4", ignoreCase = true)
                mediaFiles.add(MediaFile(file.name, uri, isVideo))
            }
        } else {
            Log.d("HomeScreenFragment", "Not a directory: ${directory.absolutePath}")
        }

        return mediaFiles
    }


}

