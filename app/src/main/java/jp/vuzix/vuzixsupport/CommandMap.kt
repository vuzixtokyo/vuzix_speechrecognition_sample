package jp.vuzix.vuzixsupport

import android.net.Uri

enum class CommandMap(val uri: Uri) {

    support(Uri.parse("https://vuzixtokyo.force.com/support/s/")),
    vuzix(Uri.parse("https://www.vuzix.com")),
    japan(Uri.parse("https://www.vuzix.jp")),
    europe(Uri.parse("https://www.vuzix.eu/")),
    amazon(Uri.parse("https://www.amazon.co.jp/vuzixcorporation"))

}