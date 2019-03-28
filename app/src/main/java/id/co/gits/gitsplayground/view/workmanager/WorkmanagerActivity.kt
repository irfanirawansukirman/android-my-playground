package id.co.gits.gitsplayground.view.workmanager

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.work.*
import id.co.gits.gitsplayground.R
import id.co.gits.workmanagerexample.sendandreceive.ReceivingWorker
import id.co.gits.workmanagerexample.sendandreceive.SendWorker
import id.co.gits.workmanagerexample.simpleworker.MyWorker
import kotlinx.android.synthetic.main.workmanager_activity.*
import java.util.concurrent.TimeUnit

class WorkmanagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.workmanager_activity)
        //This is the subclass of our WorkRequest
        //val oneTimeRequest = OneTimeWorkRequest.Builder(MyWorker::class.java).build()

        //A click listener for the button
        //inside the onClick method we will perform the work
        //btn_main.setOnClickListener {
        //Enqueuing the work request
        //WorkManager.getInstance().enqueue(oneTimeRequest)
        //}

        //Listening to the work status
        //WorkManager.getInstance().getWorkInfoByIdLiveData(oneTimeRequest.id)
        //.observe(this@MainActivity, Observer<WorkInfo> {
        //Displaying the status into TextVie
        //txt_main.append(it?.state?.name + "\n")
        //})

        //==============================================================================================================

        //creating a data object
        //to pass the data with workRequest
        //we can put as many variables needed
        val data = Data.Builder()
                .putString(SendWorker.TASK_DESC, "The task data passed from MainActivity")
                .build()

        //creating constraint
        val constraints = Constraints.Builder()
                .setRequiresCharging(true)
                .build()

        val workRequest = OneTimeWorkRequest.Builder(ReceivingWorker::class.java)
                .setInitialDelay(5, TimeUnit.SECONDS)
                .setInputData(data)
                .setConstraints(constraints)
                .build()

        val workRequest2 = OneTimeWorkRequest.Builder(ReceivingWorker::class.java)
                .setInitialDelay(10, TimeUnit.SECONDS)
                .setInputData(data)
                .setConstraints(constraints)
                .build()

        val workRequest3 = OneTimeWorkRequest.Builder(ReceivingWorker::class.java)
                .setInitialDelay(15, TimeUnit.SECONDS)
                .setInputData(data)
                .setConstraints(constraints)
                .build()

        val periodicWorkRequest = PeriodicWorkRequest.Builder(MyWorker::class.java, 5, TimeUnit.SECONDS)
                .build()

        btn_main.setOnClickListener {
            //canceling work
            //WorkManager.getInstance().cancelWorkById(workRequest.id)

            //single work
            // WorkManager.getInstance().enqueue(workRequest)

            //periodic work
            // WorkManager.getInstance().enqueue(periodicWorkRequest)

            //multiple works with chaining requesting
            WorkManager.getInstance()
                    .beginWith(workRequest)
                    .then(workRequest2)
                    .then(workRequest3)
                    .enqueue()
        }

        //WorkManager.getInstance().getWorkInfoByIdLiveData(workRequest.id)
        //  .observe(this,
        //    Observer<WorkInfo> { workInfo -> txt_main.append(workInfo?.state?.name + "\n") })

        //==============================================================================================================

        WorkManager.getInstance().getWorkInfoByIdLiveData(workRequest.id)
                .observe(this, Observer { workInfo ->
                    //receiving back the data
                    if (workInfo != null && workInfo.state.isFinished)
                        txt_main.append(workInfo.outputData.getString(ReceivingWorker.TASK_DESC) + "\n")

                    txt_main.append(workInfo?.state?.name + "\n")
                })
    }
}
