package liber.app.android_music_player

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class HotButtonScreenFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_hot_button_screen, container, false)

        view.findViewById<Button>(R.id.button1).setOnClickListener {
            showTimePickerDialog { time ->
                // Настраиваем Button 1 на указанное время
            }
        }
        // Аналогично для остальных кнопок

        return view
    }

    private fun showTimePickerDialog(onTimeSelected: (Int) -> Unit) {
        // Открываем диалог для выбора времени
    }
}
