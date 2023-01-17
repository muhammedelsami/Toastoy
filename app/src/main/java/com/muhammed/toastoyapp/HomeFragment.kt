package com.muhammed.toastoyapp

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.text.Html
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.muhammed.toastoy.Toastoy
import com.muhammed.toastoyapp.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    lateinit var binding : FragmentHomeBinding

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

        binding.defaultButton.setOnClickListener {
            Toastoy.showDefaultToast(requireContext() ,"Default Toast")
            getCode(codeText, "showDefaultToast", "Default Toast")
        }

        binding.successButton.setOnClickListener {
            Toastoy.showSuccessToast(requireContext() ,"Success Toast")
            getCode(codeText, "showSuccessToast", "Success Toast")
        }

        binding.errorButton.setOnClickListener {
            Toastoy.showErrorToast(requireContext() ,"Error Toast")
            getCode(codeText, "showErrorToast", "Error Toast")
        }

        binding.warningButton.setOnClickListener {
            Toastoy.showWarningToast(requireContext(),"Warning Toast")
            getCode(codeText, "showWarningToast", "Warning Toast")
        }

        binding.infoButton.setOnClickListener {
            Toastoy.showInfoToast(requireContext() ,"Info Toast")
            getCode(codeText, "showInfoToast", "Info Toast")
        }

        binding.implementationBtn.setOnClickListener {
            getCodeForImp(codeText)
        }

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
        val codeToastoy = resources.getString(R.string.code_toastoy)
        val codeAct = resources.getString(R.string.code_this)
        var codeMsg = "\"$msg\""
        val next = Html.fromHtml(getColoredSpanned( codeToastoy, "#FFC107") + "." + getColoredSpanned( funName, "#9859F1") + "(" + getColoredSpanned( codeAct, "#FF9800") + " ," + getColoredSpanned( codeMsg, "#4CAF50") + ")")
        view.text = next
    }

}