package dev.jithinjude.simpleloader

import android.app.Dialog
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.InsetDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.NonNull
import dev.jithinjude.simpleloader.databinding.FullscreenLoadingBinding

/**
 * Created by JithinJude on 13,June,2023
 */
class FullScreenLoader(context: Context) : Dialog(context) {

    private lateinit var binding: FullscreenLoadingBinding

    private var mListener: FullScreenLoaderListener? = null

    init {
        setCancelable(false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FullscreenLoadingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val back = ColorDrawable(Color.TRANSPARENT)
        val inset = InsetDrawable(back, 10)
        window?.setBackgroundDrawable(inset)

        mListener?.onFullScreenLoaderInitialized()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        mListener?.onFullScreenLoaderDismissed()
    }

    /**
     * Call setLoaderColor either after FullScreenLoader(context) or
     * inside FullScreenLoaderListener.FullScreenLoaderListener.onFullScreenLoaderInitialized() callback.
     */
    fun setLoaderColor(@NonNull @ColorInt color: Int) {
        try {
            binding.progressBar.indeterminateTintList = ColorStateList.valueOf(color)
        } catch (ex: Exception) {
            Log.e(TAG, "setLoaderColor :=> failed: ${ex.message}")
            ex.printStackTrace()
        }
    }


    /**
     * Call setLoadingMessage either after FullScreenLoader(context) or
     * inside FullScreenLoaderListener.FullScreenLoaderListener.onFullScreenLoaderInitialized() callback.
     */
    fun setLoadingMessage(message: String?) {
        try {
            if (message?.isEmpty() == false) {
                binding.tvLoadingMessage.text = message
                binding.tvLoadingMessage.visibility = View.VISIBLE
            } else {
                binding.tvLoadingMessage.visibility = View.GONE
            }
        } catch (ex: Exception) {
            Log.e(TAG, "setLoadingMessage :=> failed: ${ex.message}")
            ex.printStackTrace()
        }
    }

    fun setLoaderCancelable(cancelable: Boolean) {
        setCancelable(cancelable)
    }

    fun setFullScreenLoadingDismissListener(fullScreenLoaderListener: FullScreenLoaderListener) {
        mListener = fullScreenLoaderListener
    }

    interface FullScreenLoaderListener {
        /**
         * Use onFullScreenLoaderInitialized callback to update loader properties.
         */
        fun onFullScreenLoaderInitialized()

        /**
         * Use onFullScreenLoaderDismissed callback to incorporate action
         * after dismissing loader.
         */
        fun onFullScreenLoaderDismissed()
    }

    companion object {
        const val TAG = "SIMPLE_LOADER"
    }
}