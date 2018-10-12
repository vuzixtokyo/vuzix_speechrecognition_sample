package jp.vuzix.vuzixsupport

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.vuzix.sdk.speechrecognitionservice.VuzixSpeechClient


class VoiceCommandReceiver : BroadcastReceiver() {

    companion object {
        val TAG = VoiceCommandReceiver::class.java.simpleName
    }

    override fun onReceive(context: Context?, intent: Intent) {
        if (intent.action.equals(VuzixSpeechClient.ACTION_VOICE_COMMAND)) {
            intent.getStringExtra(VuzixSpeechClient.PHRASE_STRING_EXTRA)?.let {
                Log.d(TAG, "phrase: %s".format(it))

                val intent = Intent(Intent.ACTION_VIEW).also { intent ->
                    intent.data = CommandMap.valueOf(it).uri
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
                context?.startActivity(intent)
            }
        }

    }
}