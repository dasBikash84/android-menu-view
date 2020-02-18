package com.dasbikash.menu_view.utils

import android.content.Context
import android.util.TypedValue
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dasbikash.menu_view.MenuView
import com.dasbikash.menu_view.MenuViewItem
import com.dasbikash.menu_view.R

internal class MenuViewItemHolder(itemView: View,val menuView: MenuView):RecyclerView.ViewHolder(itemView) {

    val mMenuItemText:TextView = itemView.findViewById(R.id.menu_item_text)
    private val mSeparator:View = itemView.findViewById(R.id.seperator)

    init {
        mMenuItemText.setTextColor(menuView.menuItemFontColor)
        mMenuItemText.setBackgroundColor(menuView.menuItemFontBg)
        mMenuItemText.setTextSize(TypedValue.COMPLEX_UNIT_SP,menuView.menuItemFontSize)
        mSeparator.setBackgroundColor(menuView.menuSeparatorBg)
    }

    fun bind(menuViewItem: MenuViewItem?, position: Int, itemCount: Int) {
        menuViewItem?.apply {
            mMenuItemText.text = text
            if (position == (itemCount-1)){
                mSeparator.visibility = View.GONE
            }
        }
    }
}

internal fun dpToPx(dp: Int, context: Context): Float =
    (dp * context.getResources().getDisplayMetrics().density)