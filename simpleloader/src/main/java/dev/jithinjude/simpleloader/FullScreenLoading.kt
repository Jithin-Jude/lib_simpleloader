package dev.jithinjude.simpleloader

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.InsetDrawable
import android.os.Bundle
import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.NonNull
import dev.jithinjude.simpleloader.databinding.FullscreenLoadingBinding

/**
 * Created by JithinJude on 13,June,2023
 */
class FullScreenLoading (context: Context) : Dialog(context) {

    private lateinit var binding: FullscreenLoadingBinding

    private var mListener: FullScreenLoadingDismissListener? = null

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
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        mListener?.onFulScreenLoaderDismissed()
    }

    fun setLoaderColor(@NonNull @ColorInt color: Int){
        binding.progressBar.indeterminateTintList = ColorStateList.valueOf(color)
    }

    fun setLoadingMessage(message: String?){

        if(message?.isEmpty() == false){
            binding.tvLoadingMessage.text = message
            binding.tvLoadingMessage.visibility = View.VISIBLE
        } else {
            binding.tvLoadingMessage.visibility = View.GONE
        }
    }

    fun setLoaderCancelable(cancelable: Boolean){
        setCancelable(cancelable)
    }

    fun setFullScreenLoadingDismissListener(fullScreenLoadingDismissListener: FullScreenLoadingDismissListener){
        mListener = fullScreenLoadingDismissListener
    }

    interface FullScreenLoadingDismissListener{
        fun onFulScreenLoaderDismissed()
    }
}