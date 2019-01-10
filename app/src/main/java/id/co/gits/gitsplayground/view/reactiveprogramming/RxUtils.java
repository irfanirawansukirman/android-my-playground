package id.co.gits.gitsplayground.view.reactiveprogramming;

import android.util.Log;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

public class RxUtils {

    public RxUtils() {

    }

    public void loopsFromArray() {
        Integer[] array = new Integer[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        Observable.fromArray(array)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d("IRFAN", "On Subscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d("IRFAN", "Number " + integer.toString());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Log.d("IRFAN", "All number is emitted");
                    }
                });
    }

    public void loopsAndFilterData() {
        Observable.range(1, 20)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) {
                        return integer % 2 == 0;
                    }
                })
                .map(new Function<Integer, String>() {
                    @Override
                    public String apply(Integer integer) {
                        return integer + " is even number";
                    }
                })
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        Log.d("IRFAN", "on Value " + s);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Log.d("IRFAN ", "All items is emitted");
                    }
                });
    }

}
