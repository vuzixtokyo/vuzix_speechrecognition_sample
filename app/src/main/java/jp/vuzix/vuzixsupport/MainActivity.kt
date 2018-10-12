package jp.vuzix.vuzixsupport

import android.app.Activity
import android.os.Bundle
import com.vuzix.sdk.speechrecognitionservice.VuzixSpeechClient
import android.content.IntentFilter
import android.util.Log


class MainActivity : Activity() {

    companion object {
        val TAG = MainActivity::class.java.simpleName
    }

    val voiceCommandReceiver = VoiceCommandReceiver()
    val intentFilter = IntentFilter(VuzixSpeechClient.ACTION_VOICE_COMMAND)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerReceiver(voiceCommandReceiver, intentFilter);

        VuzixSpeechClient(this).also {
            it.deletePhrase("*")

            CommandMap.values().forEach { map ->
                it.insertPhrase(map.name, map.name)
            }
        }

        VuzixSpeechClient.EnableRecognizer(this, true);
    }

    override fun onDestroy() {
        super.onDestroy()

        unregisterReceiver(voiceCommandReceiver)
    }


}
