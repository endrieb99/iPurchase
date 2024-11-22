package com.scally_p.ipurchase.ui.details

import android.app.Dialog
import android.content.Context
import android.text.*
import android.view.*
import androidx.constraintlayout.widget.ConstraintLayout
import com.scally_p.ipurchase.R
import com.scally_p.ipurchase.databinding.DialogProductSearchKeywordsBinding
import com.scally_p.ipurchase.utils.Constants

class KeyphraseDialog {
    private val tag = KeyphraseDialog::class.java.simpleName

    private var listener: DialogButtonClickListener? = null

    interface DialogButtonClickListener {
        fun onDialogNegativeButtonClick(dialog: Dialog)
        fun onDialogPositiveButtonClick(dialog: Dialog, keyphrase: String)
    }

    inner class Builder(private val context: Context) {

        private var cancelable = false
        private var keyphrase = Constants.General.KEYPHRASE_DEFAULT
        private var limit = 14

        fun cancelable(cancelable: Boolean): Builder {
            this.cancelable = cancelable
            return this
        }

        fun keyphrase(keyphrase: String): Builder {
            this.keyphrase = keyphrase
            return this
        }

        fun limit(limit: Int): Builder {
            this.limit = limit
            return this
        }

        fun setDialogButtonClickListener(listener: DialogButtonClickListener): Builder {
            this@KeyphraseDialog.listener = listener
            return this
        }

        fun build() {
            val binding = DialogProductSearchKeywordsBinding.inflate(LayoutInflater.from(context))

            binding.keyphrase.setText(keyphrase)
            binding.keyphrase.filters = arrayOf(InputFilter.LengthFilter(limit))

            binding.limitCount.text = context.resources.getString(
                R.string.limit_remaining,
                limit.toString(),
                (limit - binding.keyphrase.text.length).toString()
            )

            binding.keyphrase.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    charSequence: CharSequence?,
                    p1: Int,
                    p2: Int,
                    p3: Int
                ) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    binding.limitCount.text = context.resources.getString(
                        R.string.limit_remaining,
                        limit.toString(),
                        (limit - binding.keyphrase.text.length).toString()
                    )
                }

                override fun afterTextChanged(editable: Editable?) {}
            })

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

            binding.negativeBtn.setOnClickListener { listener!!.onDialogNegativeButtonClick(dialog) }
            binding.positiveBtn.setOnClickListener {
                val keyphrase = binding.keyphrase.text.trim().toString()
                if (keyphrase.isNotEmpty()) listener!!.onDialogPositiveButtonClick(
                    dialog,
                    keyphrase
                )
            }
        }
    }
}