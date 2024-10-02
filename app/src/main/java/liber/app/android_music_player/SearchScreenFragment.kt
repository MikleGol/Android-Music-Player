package liber.app.android_music_player

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView

class SearchScreenFragment : Fragment() {
    private lateinit var webView: WebView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_search_screen, container, false)
        webView = view.findViewById(R.id.webView)
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("https://www.google.com")

        webView.setDownloadListener { url, userAgent, contentDisposition, mimeType, contentLength ->
            // Логика для загрузки файла в папку приложения
            downloadFile(url)
        }

        return view
    }

    private fun downloadFile(url: String) {
        // Реализация загрузки файла в папку приложения
    }
}
