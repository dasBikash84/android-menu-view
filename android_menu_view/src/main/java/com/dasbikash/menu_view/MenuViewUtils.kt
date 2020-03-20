package com.dasbikash.menu_view

import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.dasbikash.menu_view.utils.DialogUtils
import com.dasbikash.menu_view.utils.MenuViewItemAdapter

/**
 * Utility class for displaying <b>Menu View</b>
 * Custom view class where a task is attached with each menu item.
 *
 * Subject <b>Menu View</b> will have view and characteristics
 * similar to right click menu of Personal Computers.
 *
 * @author Bikash Das(das.bikash.dev@gmail.com)
 * */
class MenuViewUtils {

    companion object {

        /**
         * Method to create and launch <b>Menu View</b>
         *
         * @param context | Android Context
         * @param menuView | MenuView instance for display
         * */
        internal fun launchMenuView(context: Context, menuView: MenuView) {
            if (menuView.mMenuViewItems.isEmpty()) {
                return
            }
            val menuViewForDialog =
                LayoutInflater.from(context).inflate(
                    R.layout.view_pop_up_menu_holder,
                    null,
                    false
                ) as RecyclerView
            val dialog = DialogUtils.createAlertDialog(
                context, DialogUtils.AlertDialogDetails(
                    positiveButtonText = "", negetiveButtonText = "",
                    view = menuViewForDialog
                )
            )
            dialog.getButton(DialogInterface.BUTTON_POSITIVE).visibility=View.GONE
            dialog.getButton(DialogInterface.BUTTON_NEGATIVE).visibility=View.GONE
            dialog.getButton(DialogInterface.BUTTON_NEUTRAL).visibility=View.GONE
            val menuAdapter = MenuViewItemAdapter(dialog, menuView)
            menuViewForDialog.adapter = menuAdapter
            menuAdapter.submitList(menuView.mMenuViewItems.toList())
            dialog.show()
        }

        /**
         * Method to attach <b>Menu View</b> with a view click.
         * Menu will be displayed on click of subject view.
         *
         * @param view | Subject view
         * @param menuView | MenuView instance for display
         * */
        @JvmStatic
        fun attachMenuViewForLongClick(view: View, menuView: MenuView) {
            view.setOnLongClickListener {
                launchMenuView(
                    it.context,
                    menuView
                )
                return@setOnLongClickListener true
            }
        }

        /**
         * Method to attach <b>Menu View</b> with a view long click.
         * Menu will be displayed on long click of subject view.
         *
         * @param view | Subject view
         * @param menuView | MenuView instance for display
         * */
        @JvmStatic
        fun attachMenuViewForClick(view: View, menuView: MenuView) {
            view.setOnClickListener {
                launchMenuView(
                    it.context,
                    menuView
                )
            }
        }
    }
}
/**
 * Extension function to attach <b>Menu View</b> with a view click.
 * Menu will be displayed on click of subject view.
 *
 * @param menuView | MenuView instance for display
 * */
fun View.attachMenuViewForLongClick(menuView: MenuView)
    = MenuViewUtils.attachMenuViewForLongClick(this,menuView)

/**
 * Method to attach <b>Menu View</b> with a view long click.
 * Menu will be displayed on long click of subject view.
 *
 * @param menuView | MenuView instance for display
 * */
fun View.attachMenuViewForClick(menuView: MenuView)
    = MenuViewUtils.attachMenuViewForClick(this,menuView)
