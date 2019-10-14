package id.co.gits.workmanagerexample.sendandreceive

import android.content.Context
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters

//class ReceivingWorker(context: Context, workerParameters: WorkerParameters): Worker(context, workerParameters) {
//
//    override fun doWork(): Result {
//        //setting output data
//        val data = Data.Builder()
//            .putString(TASK_DESC, "The conclusion of the task")
//            .build()
//
//        outputData = data
//
//        return Result.SUCCESS
//    }
//
//    companion object {
//        //a public static string that will be used as the key
//        //for sending and receiving data
//        const val TASK_DESC = "task_desk"
//    }
//}