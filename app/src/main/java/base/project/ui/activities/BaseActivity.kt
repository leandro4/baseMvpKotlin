package base.project.ui.activities

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import base.project.R
import base.project.ui.fragments.BaseMvpFragment
import kotlinx.android.synthetic.main.activity_base_content.*

abstract class BaseActivity: AppCompatActivity(), BaseMvpFragment.ActivityProgress {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_content)
        setSupportActionBar(toolbar)
    }

    protected fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragmentContent, fragment)
        transaction.commit()
    }

    protected fun setToolbarTitle(resTitleId: Int) {
        toolbar.title = getString(resTitleId)
    }

    protected fun setToolbarTitle(resTitle: String) {
        toolbar.title = resTitle
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun showProgress() {
        progressView.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressView.visibility = View.GONE
    }
}