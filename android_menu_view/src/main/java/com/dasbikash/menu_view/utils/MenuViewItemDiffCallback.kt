package com.dasbikash.android_view_utils.custom_views.pop_up_menu

import androidx.recyclerview.widget.DiffUtil
import com.dasbikash.menu_view.MenuViewItem

internal object MenuViewItemDiffCallback:DiffUtil.ItemCallback<MenuViewItem>() {
    override fun areItemsTheSame(oldItem: MenuViewItem, newItem: MenuViewItem)= oldItem == newItem
    override fun areContentsTheSame(oldItem: MenuViewItem, newItem: MenuViewItem)= false
}