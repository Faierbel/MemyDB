package io.github.memydb.ui.modules.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem
import io.github.memydb.R
import io.github.memydb.ui.base.BaseActivity
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
            ).withOnDrawerItemClickListener(object : Drawer.OnDrawerItemClickListener {
                override fun onItemClick(view: View?, position: Int, drawerItem: IDrawerItem<*>): Boolean {
                    val navigation = findNavController(R.id.mainFragmentContainer)
                    when (drawerItem.identifier) {
                        1L -> navigation.navigate(R.id.anonimoweFragment)
                        2L -> navigation.navigate(R.id.demotywatoryFragment)
                        3L -> navigation.navigate(R.id.jbzdFragment)
                        4L -> navigation.navigate(R.id.kwejkFragment)
                        5L -> navigation.navigate(R.id.mistrzowieFragment)
                        6L -> navigation.navigate(R.id.ninegagFragment)
                        7L -> navigation.navigate(R.id.ninegagnsfwFragment)
                        8L -> navigation.navigate(R.id.thecodingloveFragment)
                        else -> throw IllegalArgumentException()
                    }
                    drawer.closeDrawer()
                    return true
                }
            })
            .build()
    }
}
