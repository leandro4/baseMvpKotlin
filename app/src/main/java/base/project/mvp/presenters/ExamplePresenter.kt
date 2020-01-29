package base.project.mvp.presenters

import base.project.api.ApiService
import base.project.api.CustomDisposableObserver
import base.project.mvp.views.ExampleView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ExamplePresenter: BasePresenter<ExampleView>() {

    fun exampleAction() {
        mvpView?.showProgressView()

        compositeSubscription?.add(ApiService.exampleService()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : CustomDisposableObserver<Void>() {
                    override fun onNoInternetConnection() {
                        mvpView?.onNoInternetConnection()
                        mvpView?.hideProgressView()
                    }

                    override fun onObserverError(e: Throwable) {
                        mvpView?.onError(e)
                        mvpView?.hideProgressView()
                    }

                    override fun onErrorCode(code: Int, message: String) {
                        mvpView?.onErrorCode(message)
                        mvpView?.hideProgressView()
                    }

                    override fun onNext(t: Void) {
                        mvpView?.hideProgressView()
                    }
                })
        )
    }

}