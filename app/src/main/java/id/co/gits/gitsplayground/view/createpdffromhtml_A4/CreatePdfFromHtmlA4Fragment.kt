package id.co.gits.gitsplayground.view.createpdffromhtml_A4

import android.app.ProgressDialog
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.webviewtopdf.PdfView
import id.co.gits.gitsplayground.base.BaseFragment
import id.co.gits.gitsplayground.R
import id.co.gits.gitsplayground.util.putArgs
import id.co.gits.gitsplayground.view.main.MainActivity
import kotlinx.android.synthetic.main.create_pdf_from_html_a4_fragment.*
import java.util.*

class CreatePdfFromHtmlA4Fragment : BaseFragment() {

    private var mTimer: Timer? = null

    private lateinit var mTimerTask: TimerTask

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.create_pdf_from_html_a4_fragment, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).setToolbarTitle(arguments?.getString(TAG) ?: "")
        (activity as MainActivity).showHomeBackButton(true)

        webView.loadDataWithBaseURL("", "\n" +
                "<html>\n" +
                "    <header>\n" +
                "        <title>Dokumen</title>\n" +
                "        <style>\n" +
                "            div, textarea {\n" +
                "                padding:5px;\n" +
                "            }\n" +
                "            .horizontalcntr{\n" +
                "                margin: auto !important;\n" +
                "                clear: both !important;\n" +
                "            }\n" +
                "            .title{\n" +
                "                font-size: 18px;\n" +
                "                color: #838383;\n" +
                "                font-family: Arial, Gadget, sans-serif !important;\n" +
                "            }\n" +
                "            .content{\n" +
                "                font-size: 24px;\n" +
                "                font-weight: 200;\n" +
                "                color: #000;\n" +
                "                font-family: Arial, Gadget, sans-serif !important;\n" +
                "            }\n" +
                "            .maintitle{\n" +
                "                font-family: Arial, Gadget, sans-serif !important;\n" +
                "                color: #333333;\n" +
                "                margin-bottom: 5px\n" +
                "            }\n" +
                "        </style>\n" +
                "    </header>\n" +
                "    <body style=\"padding: 0px\">\n" +
                "        <div style=\"padding: 0px\">\n" +
                "            <div style=\"width: 100%; font-family: Arial, Gadget, sans-serif !important; background-color: #c9e9ee !important; margin-bottom: 20px; padding: 0px; padding: 0px\">\n" +
                "                <div style=\"width:50%; float: none; padding-bottom: 20px; padding-top: 20px\" class=\"horizontalcntr width-img\">\n" +
                "                    <img src=\"file:///android_res/drawable/img_jasaraharja.png\" style=\"width: 100%\">\n" +
                "                </div>\n" +
                "            </div>\n" +
                "            <div class=\"title\" style=\"padding-top: 3px; text-align: center\">30 Desember 2018  19:18:00</div>\n" +
                "            <div style=\"width: 100%; margin-top: 12px\">\n" +
                "                <h3 class=\"maintitle\">Informasi Korban</h3>\n" +
                "                <hr style=\"background-color: #0054a3; width: 100%\">\n" +
                "                <div style=\"padding-bottom: 10px\">\n" +
                "                    <div class=\"title\">No. Laporan Polisi</div>\n" +
                "                    <div class=\"content\" style=\"padding-top: 3px\">08689759587</div>\n" +
                "                </div>\n" +
                "                <div style=\"padding-bottom: 10px\">\n" +
                "                    <div class=\"title\">NIK Korban</div>\n" +
                "                    <div class=\"content\" style=\"padding-top: 3px\">08689759587</div>\n" +
                "                </div>\n" +
                "                <div style=\"padding-bottom: 10px\">\n" +
                "                    <div class=\"title\">Nama Korban</div>\n" +
                "                    <div class=\"content\" style=\"padding-top: 3px\">Hadi Tes</div>\n" +
                "                </div>\n" +
                "                <div style=\"padding-bottom: 10px\">\n" +
                "                    <div class=\"title\">Waktu Kejadian</div>\n" +
                "                    <div class=\"content\" style=\"padding-top: 3px\">10/10/2018</div>\n" +
                "                </div>\n" +
                "                <div style=\"padding-bottom: 10px\">\n" +
                "                    <div class=\"title\">Lokasi Kejadian</div>\n" +
                "                    <div class=\"content\" style=\"padding-top: 3px\">Ps Minggu</div>\n" +
                "                </div>\n" +
                "                <div style=\"padding-bottom: 10px;\">\n" +
                "                    <div class=\"title\">Jumlah Santunan</div>\n" +
                "                    <div class=\"content\" style=\"padding-top: 3px\">Rp. 0</div>\n" +
                "                </div>\n" +
                "                \n" +
                "                <h3 class=\"maintitle\">Informasi Pelapor</h3>\n" +
                "                <hr style=\"background-color: #0054a3; width: 100%\">\n" +
                "                <div style=\"padding-bottom: 10px\">\n" +
                "                    <div class=\"title\">Nama Pelapor</div>\n" +
                "                    <div class=\"content\" style=\"padding-top: 3px\">Azkiya Qolbi</div>\n" +
                "                </div>\n" +
                "                <div style=\"padding-bottom: 10px\">\n" +
                "                    <div class=\"title\">Hubungan Pelapor</div>\n" +
                "                    <div class=\"content\" style=\"padding-top: 3px\">Sebatas Teman</div>\n" +
                "                </div>\n" +
                "                <div style=\"padding-bottom: 10px\">\n" +
                "                    <div class=\"title\">No. HP Pelapor</div>\n" +
                "                    <div class=\"content\" style=\"padding-top: 3px\">9765864678</div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </body>\n" +
                "</html>", "text/html", "UTF-8", "")

        btn_createPdf.setOnClickListener {
            val path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS + "/PDFTest/")
            val fileName = "JR-Eks-Santunan.pdf"

            val progressDialog = ProgressDialog(requireContext())
            progressDialog.setMessage("Please wait")
            progressDialog.show()
            PdfView.createWebPrintJob(requireActivity(), webView, path, fileName, object : PdfView.Callback {
                override fun success(path: String) {
                    progressDialog.dismiss()
                    PdfView.openPdfFile(
                            requireActivity(),
                            getString(R.string.app_name),
                            "Do you want to open the pdf file?$fileName",
                            path
                    )
                }

                override fun failure() {
                    progressDialog.dismiss()
                }
            })
        }

        onStartTimer()
    }

    /**
     * Starting the service with job interval time
     */
    private fun onStartTimer() {

        mTimer = Timer()

        onInitTimerTask()

        // Interval 10 detik
        mTimer?.schedule(mTimerTask, 1000, 10000)

    }

    private fun onInitTimerTask() {
        mTimerTask = object : TimerTask() {
            override fun run() {
                Log.d("Anang", "Hey Anang")
            }
        }
    }




    companion object {
        val TAG = CreatePdfFromHtmlA4Fragment::class.java.simpleName

        fun newInstance(title: String) = CreatePdfFromHtmlA4Fragment().putArgs {
            putString(TAG, title)
        }
    }
}
