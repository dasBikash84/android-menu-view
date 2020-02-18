package com.dasbikash.menu_view

import androidx.annotation.Keep
/**
 * Model class, an instance of which will be assigned to each
 * menu entry of <b>Menu View</b> custom view
 *
 * @author Bikash das(das.bikash.dev@gmail.com)
 * @property text Menu entry title that will shown on menu.
 * @property task Function that will be executed on main thread on menu item click.
 * */
@Keep
class MenuViewItem(
    val text:String,
    val task:()->Any?
)