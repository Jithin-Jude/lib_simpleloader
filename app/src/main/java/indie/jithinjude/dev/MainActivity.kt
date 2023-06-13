package indie.jithinjude.dev

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.jithinjude.simpleloader.FullScreenLoader
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fullScreenLoader = FullScreenLoader(this)

        val callback = object : FullScreenLoader.FullScreenLoaderListener {
            override fun onFullScreenLoaderInitialized() {
                fullScreenLoader.setLoaderColor(getColor(R.color.happy_yellow))
                fullScreenLoader.setLoadingMessage("Hey Loading ...")
            }

            override fun onFullScreenLoaderDismissed() {
                Timber.e("onFulScreenLoaderDismissed :=> callback worked")
            }
        }

        fullScreenLoader.setLoaderCancelable(true)
        fullScreenLoader.setFullScreenLoadingDismissListener(callback)

        fullScreenLoader.setLoaderColor(getColor(R.color.happy_yellow))
        fullScreenLoader.setLoadingMessage("Calling API ...")

        fullScreenLoader.show()
    }
}