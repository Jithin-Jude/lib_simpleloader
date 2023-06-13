package indie.jithinjude.dev

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.jithinjude.simpleloader.FullScreenLoader
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    var fullScreenLoader: FullScreenLoader? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fullScreenLoader = FullScreenLoader(this)

        val callback = object : FullScreenLoader.FullScreenLoaderListener {
            override fun onFullScreenLoaderInitialized() {
                fullScreenLoader?.setLoaderColor(getColor(R.color.happy_yellow))
                fullScreenLoader?.setLoadingMessage("Loading message...")
            }

            override fun onFullScreenLoaderDismissed() {
                Timber.e("onFulScreenLoaderDismissed :=> callback worked")
            }
        }

        fullScreenLoader?.setLoaderCancelable(true)
        fullScreenLoader?.setFullScreenLoadingDismissListener(callback)
        fullScreenLoader?.show()
    }
}