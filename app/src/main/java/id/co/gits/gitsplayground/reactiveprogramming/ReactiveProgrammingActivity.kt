package id.co.gits.gitsplayground.reactiveprogramming

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import id.co.gits.belajarrx.ApiService
import id.co.gits.belajarrx.Capture
import id.co.gits.belajarrx.Movie
import id.co.gits.gitsplayground.R
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.reactive_programming_activity.*

class ReactiveProgrammingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.reactive_programming_activity)

        // Execute sample looping with fromArray operator
        btn_reactive_fromArray.setOnClickListener {
            RxUtils().loopsFromArray()
        }

        // Execute sample with range operator mixing with map and filter
        btn_reactive_rangeWithMultipleOperator.setOnClickListener {
            RxUtils().loopsAndFilterData()
        }

        // Call multiple request API
        // and handling all responses with zip operator
        btn_reactive_zip.setOnClickListener {
            callMultipleRequest()
        }

    }

    private fun callMultipleRequest() {
        val movie1 = ApiService.apiInstanceService.getMovies()
        val movie2 = ApiService.apiInstanceService.getMovies()

        Observable.zip(movie1, movie2,
                BiFunction<Movie, Movie, Capture> { t1, t2 -> captureMovies(t1, t2) })
                // Run on background thread
                .subscribeOn(Schedulers.io())
                // Be notified on main thread
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<Capture> {
                    override fun onComplete() {
                        Log.d("MOVIE", "onComplete")
                    }

                    override fun onSubscribe(d: Disposable) {
                        Log.d("MOVIE", "onSubscribe")
                    }

                    override fun onNext(t: Capture) {
                        Log.d("MOVIE A", Gson().toJson(t.movieA))
                        Log.d("MOVIE B", Gson().toJson(t.movieB))
                    }

                    override fun onError(e: Throwable) {
                        Log.d("MOVIE", e.message)
                    }
                })
    }

    private fun captureMovies(movieA: Movie, movieB: Movie): Capture {
        return Capture(movieA, movieB)
    }

}
