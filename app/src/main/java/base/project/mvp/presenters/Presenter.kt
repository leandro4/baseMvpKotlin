package base.project.mvp.presenters

interface Presenter<MvpView> {

    fun attachMvpView(view: MvpView)

    fun dettachMvpView()
}