package com.scally_p.ipurchase.ui.report

import android.app.Dialog
import android.content.Context
import android.view.*
import androidx.constraintlayout.widget.ConstraintLayout
import com.scally_p.ipurchase.R
import com.scally_p.ipurchase.databinding.DialogProductReportLoadingCompleteBinding

class ReportLoadingCompleteDialog {
    private val tag = ReportLoadingCompleteDialog::class.java.simpleName

    private var listener: DialogButtonClickListener? = null

    interface DialogButtonClickListener {
        fun onDialogViewButtonClick(dialog: Dialog)
        fun onDialogCloseButtonClick(dialog: Dialog)
    }

    inner class Builder(private val context: Context) {

        private var cancelable = false
        private var messageText = ""

        fun cancelable(cancelable: Boolean): Builder {
            this.cancelable = cancelable
            return this
        }

        fun messageText(messageText: String): Builder {
            this.messageText = messageText
            return this
        }

        fun setDialogButtonClickListener(listener: DialogButtonClickListener): Builder {
            this@ReportLoadingCompleteDialog.listener = listener
            return this
        }

        fun build() {
            val binding =
                DialogProductReportLoadingCompleteBinding.inflate(LayoutInflater.from(context))

            binding.message.text = messageText

            val dialog = Dialog(context, R.style.CustomDialog)
            dialog.setContentView(binding.root)
            dialog.setCancelable(cancelable)
            dialog.setCanceledOnTouchOutside(cancelable)
            dialog.window!!.setWindowAnimations(R.style.CustomDialog)
            dialog.window!!.setLayout(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.MATCH_PARENT
            )
            dialog.window!!.setGravity(Gravity.NO_GRAVITY)
            dialog.show()

            binding.viewButton.setOnClickListener {
                listener!!.onDialogViewButtonClick(dialog)
            }
            binding.closeButton.setOnClickListener {
                listener!!.onDialogCloseButtonClick(dialog)
            }
        }
    }
}