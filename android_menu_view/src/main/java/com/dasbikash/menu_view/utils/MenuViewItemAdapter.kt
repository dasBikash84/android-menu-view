package com.dasbikash.menu_view.utils


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.ListAdapter
import com.dasbikash.android_view_utils.custom_views.pop_up_menu.MenuViewItemDiffCallback
import com.dasbikash.menu_view.MenuView
import com.dasbikash.menu_view.MenuViewItem
import com.dasbikash.menu_view.R

internal class MenuViewItemAdapter(val alertDialog: AlertDialog,val menuView: MenuView):
    ListAdapter<MenuViewItem, MenuViewItemHolder>(
    MenuViewItemDiffCallback
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewItemHolder {
        return MenuViewItemHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.view_pop_up_menu_item, parent, false
            ),menuView
        )
    }
    override fun onBindViewHolder(holderView: MenuViewItemHolder, position: Int) {
        val menuItem = getItem(position)
        holderView.mMenuItemText.setOnClickListener {
            runOnMainThread({
                alertDialog.hide()
                menuItem.task()
            }, ClickUtils.DIMMING_DURATION)
        }
        holderView.bind(getItem(position),position,itemCount)
    }
}