package com.muhammed.toastoyapp

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.text.Html
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.os.Build
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SeekBar
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.muhammed.toastoy.Toastoy
import com.muhammed.toastoy.ToastoyFont
import com.muhammed.toastoy.ToastoyFontWeight
import com.muhammed.toastoyapp.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    lateinit var binding : FragmentHomeBinding

    private var selectedFont = ToastoyFont.CAIRO
    private var selectedWeight = ToastoyFontWeight.MEDIUM
    private var selectedSize = 14f
    private var lastFun = "showDefaultToast"
    private var lastMsg = "Default Toast"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val codeText = binding.codeId
        getCode(codeText, "showDefaultToast", "Default Toast")

        registerForContextMenu(codeText)

        setupFontSpinner()
        setupWeightSpinner()
        setupSizeSeekBar()

        binding.defaultButton.setOnClickListener {
            Toastoy.showDefaultToast(requireContext() ,"Default Toast", selectedFont, selectedSize, selectedWeight)
            getCode(codeText, "showDefaultToast", "Default Toast")
        }

        binding.successButton.setOnClickListener {
            Toastoy.showSuccessToast(requireContext() ,"Success Toast", selectedFont, selectedSize, selectedWeight)
            getCode(codeText, "showSuccessToast", "Success Toast")
        }

        binding.errorButton.setOnClickListener {
            Toastoy.showErrorToast(requireContext() ,"Error Toast", selectedFont, selectedSize, selectedWeight)
            getCode(codeText, "showErrorToast", "Error Toast")
        }

        binding.warningButton.setOnClickListener {
            Toastoy.showWarningToast(requireContext(),"Warning Toast", selectedFont, selectedSize, selectedWeight)
            getCode(codeText, "showWarningToast", "Warning Toast")
        }

        binding.infoButton.setOnClickListener {
            Toastoy.showInfoToast(requireContext() ,"Info Toast", selectedFont, selectedSize, selectedWeight)
            getCode(codeText, "showInfoToast", "Info Toast")
        }

        binding.implementationBtn.setOnClickListener {
            getCodeForImp(codeText)
        }

    }

    /** Lists every bundled font; each row is rendered in its own typeface. */
    private fun setupFontSpinner() {
        val fonts = ToastoyFont.values()
        val adapter = object : ArrayAdapter<ToastoyFont>(
            requireContext(), android.R.layout.simple_spinner_item, fonts
        ) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View =
                styleRow(super.getView(position, convertView, parent), fonts[position])

            override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View =
                styleRow(super.getDropDownView(position, convertView, parent), fonts[position])

            private fun styleRow(row: View, font: ToastoyFont): View {
                (row as TextView).apply {
                    text = "Font: ${font.name}"
                    setTextColor(resources.getColor(R.color.white, null))
                    typeface = ResourcesCompat.getFont(context, font.fontRes)
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        fontVariationSettings = "'wght' ${ToastoyFontWeight.BOLD.value}"
                    }
                }
                return row
            }
        }
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.fontSpinner.adapter = adapter
        binding.fontSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedFont = fonts[position]
                // weight rows are drawn with the selected font, so refresh them
                (binding.weightSpinner.adapter as? ArrayAdapter<*>)?.notifyDataSetChanged()
                getCode(binding.codeId, lastFun, lastMsg)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    /** Lists every weight; each row is rendered at that weight with the selected font. */
    private fun setupWeightSpinner() {
        val weights = ToastoyFontWeight.values()
        val adapter = object : ArrayAdapter<ToastoyFontWeight>(
            requireContext(), android.R.layout.simple_spinner_item, weights
        ) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View =
                styleRow(super.getView(position, convertView, parent), weights[position])

            override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View =
                styleRow(super.getDropDownView(position, convertView, parent), weights[position])

            private fun styleRow(row: View, weight: ToastoyFontWeight): View {
                (row as TextView).apply {
                    text = "${weight.name} (${weight.value})"
                    setTextColor(resources.getColor(R.color.white, null))
                    typeface = ResourcesCompat.getFont(context, selectedFont.fontRes)
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        fontVariationSettings = "'wght' ${weight.value}"
                    }
                }
                return row
            }
        }
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.weightSpinner.adapter = adapter
        binding.weightSpinner.setSelection(weights.indexOf(selectedWeight))
        binding.weightSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedWeight = weights[position]
                getCode(binding.codeId, lastFun, lastMsg)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    /** 12sp – 32sp; progress 0 maps to 12sp. */
    private fun setupSizeSeekBar() {
        binding.sizeSeekbar.progress = (selectedSize - 12).toInt()
        binding.sizeSeekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                selectedSize = 12f + progress
                binding.sizeLabel.text = "${selectedSize.toInt()}sp"
                getCode(binding.codeId, lastFun, lastMsg)
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }

    private fun getCodeForImp(codeText: TextView) {
        val impText = "implementation"
        codeText.text = Html.fromHtml(impText + " " + "<font color='#4CAF50'>" + "'com.github.muhammedelsami:Toastoy:Tag'\n" + "</font> \n\n\n\n " + "\n<font color='#4CAF50'> repositories {  " +
                " maven { url 'https://jitpack.io' }  " +
                "}</font> ")
    }

    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?) {
        menu.add(0, v.getId(),0, "Copy");
        menu.setHeaderTitle("Select") //setting header title for menu
        val textView = v as TextView
        val manager = requireActivity().getSystemService(Activity.CLIPBOARD_SERVICE) as android.content.ClipboardManager
        val myClip = android.content.ClipData.newPlainText("text", textView.text)
        manager.setPrimaryClip(myClip)
    }

    private fun getColoredSpanned(text: String, color: String): String? {
        return "<font color=$color>$text</font>"
    }

    private fun getCode(view: TextView, funName: String, msg : String) {
        lastFun = funName
        lastMsg = msg
        val codeToastoy = resources.getString(R.string.code_toastoy)
        val codeAct = resources.getString(R.string.code_this)
        var codeMsg = "\"$msg\""
        val codeFont = "ToastoyFont." + selectedFont.name
        val codeSize = "${selectedSize.toInt()}f"
        val codeWeight = "ToastoyFontWeight." + selectedWeight.name
        val next = Html.fromHtml(getColoredSpanned( codeToastoy, "#FFC107") + "." + getColoredSpanned( funName, "#9859F1") + "(" + getColoredSpanned( codeAct, "#FF9800") + " ," + getColoredSpanned( codeMsg, "#4CAF50") + " ," + getColoredSpanned( codeFont, "#03A9F4") + " ," + getColoredSpanned( codeSize, "#E91E63") + " ," + getColoredSpanned( codeWeight, "#00BCD4") + ")")
        view.text = next
    }

}
