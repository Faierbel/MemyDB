package io.github.memydb.ui.modules.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem
import io.github.memydb.R
import io.github.memydb.ui.base.BaseActivity
import io.github.memydb.ui.modules.anonimowe.AnonimoweFragment
import io.github.memydb.ui.modules.demotywatory.DemotywatoryFragment
import io.github.memydb.ui.modules.jbzd.JbzdFragment
import io.github.memydb.ui.modules.kwejk.KwejkFragment
import io.github.memydb.ui.modules.mistrzowie.MistrzowieFragment
import io.github.memydb.ui.modules.ninegag.NinegagFragment
import io.github.memydb.ui.modules.ninegagnsfw.NinegagnsfwFragment
import io.github.memydb.ui.modules.thecodinglove.ThecodingloveFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private lateinit var drawer: Drawer

    companion object {
        fun getStartIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(mainToolbar)
        initView()
    }

    private fun initView() {
        drawer = DrawerBuilder().withActivity(this)
                .withToolbar(mainToolbar)
                .withHasStableIds(true)
                .addDrawerItems(
                        PrimaryDrawerItem().withName(R.string.anonimowe_title).withIdentifier(1),
                        PrimaryDrawerItem().withName(R.string.demotywatory_title).withIdentifier(2),
                        PrimaryDrawerItem().withName(R.string.jbzd_title).withIdentifier(3),
                        PrimaryDrawerItem().withName(R.string.kwejk_title).withIdentifier(4),
                        PrimaryDrawerItem().withName(R.string.mistrzowie_title).withIdentifier(5),
                        PrimaryDrawerItem().withName(R.string.ninegag_title).withIdentifier(6),
                        PrimaryDrawerItem().withName(R.string.ninegagnsfw_title).withIdentifier(7),
                        PrimaryDrawerItem().withName(R.string.thecodinglove_title).withIdentifier(8)
                )
                .withOnDrawerItemClickListener(object : Drawer.OnDrawerItemClickListener {
                    override fun onItemClick(view: View?, position: Int, drawerItem: IDrawerItem<*>): Boolean {
                        val transaction = supportFragmentManager.beginTransaction()

                        val fragment = when (drawerItem.identifier) {
                            1L -> AnonimoweFragment.newInstance()
                            2L -> DemotywatoryFragment.newInstance()
                            3L -> JbzdFragment.newInstance()
                            4L -> KwejkFragment.newInstance()
                            5L -> MistrzowieFragment.newInstance()
                            6L -> NinegagFragment.newInstance()
                            7L -> NinegagnsfwFragment.newInstance()
                            8L -> ThecodingloveFragment.newInstance()
                            else -> throw IllegalArgumentException()
                        }
                        transaction.replace(mainFragmentContainer.id, fragment)
                        transaction.commit()
                        drawer.closeDrawer()
                        return true
                    }
                })
                .build()
    }
}
