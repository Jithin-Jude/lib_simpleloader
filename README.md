# Simple Fullscreen loader
For the past few years, I was using Lottie for showing both loading & other custom animations. Even tho Lottie is providing cooler animations, one major issue I was facing was that the Lottie files are not doing well in terms of performance.

So here is a simple, lightweight, easy-to-use library for showing a simple native loader when the app is doing heavy background tasks & network calls.

<img src="https://github.com/Jithin-Jude/lib_simpleloader/blob/feb5ea9ac1323fac14093e8287c88e7a6dda7615/images/loader_with_message_screenshot.jpg" width=25% height=25%>

[![Buy Me a Coffee](https://img.shields.io/static/v1?label=Buy%20Me%20a%20Coffee&message=Donate&color=FF813F&logo=buy-me-a-coffee&logoColor=white&labelColor=FF813F)](https://www.buymeacoffee.com/jithinjude1997)

## Usage

### Sample project
See `sample` directory. Sample project is under construction.

### Loader initialization
```
import dev.jithinjude.simpleloader.FullScreenLoader

var fullScreenLoader: FullScreenLoader? = null
fullScreenLoader = FullScreenLoader(context)
fullScreenLoader?.show()
```

### Loader listener
```
val callback = object : FullScreenLoader.FullScreenLoaderListener {
            override fun onFullScreenLoaderInitialized() {
                fullScreenLoader?.setLoaderColor(getColor(R.color.happy_yellow))
                fullScreenLoader?.setLoadingMessage("Loading message...")
            }

            override fun onFullScreenLoaderDismissed() {
                Timber.e("onFulScreenLoaderDismissed :=> callback worked")
            }
        }
fullScreenLoader?.setFullScreenLoadingDismissListener(callback)
```

### Making loader dismissible
```
fullScreenLoader?.setLoaderCancelable(true)
```

### Set Loader Color
```
fullScreenLoader?.setLoaderColor(getColor(R.color.yellow))
```

### Set Loading message
```
fullScreenLoader?.setLoadingMessage("Your loading message...")
```
