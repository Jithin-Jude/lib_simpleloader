package indie.jithinjude.dev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.jithinjude.simpleloader.FullScreenLoading

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fullScreenLoader = FullScreenLoading(this)

        val callback = object: FullScreenLoading.FullScreenLoadingDismissListener{
            override fun onFulScreenLoaderDismissed() {

            }
        }

        fullScreenLoader.show()
        fullScreenLoader.setLoaderColor(getColor(R.color.happy_yellow))
        fullScreenLoader.setLoaderCancelable(true)
        fullScreenLoader.setFullScreenLoadingDismissListener(callback)
        fullScreenLoader.setLoadingMessage("Hey Loading ...")
    }
}