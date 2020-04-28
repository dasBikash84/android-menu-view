package com.dasbikash.menu_view

import android.content.Context
import android.graphics.Color

/**
 * Custom menu view class, where a task is attached with each menu item.
 *
 * Subject <b>Menu View</b> will have view and characteristics
 * similar to right click menu of Personal Computers.
 *
 * @author Bikash Das(das.bikash.dev@gmail.com)
 * */

class MenuView(
    //Text font size of menu item entry
    val menuItemFontSize:Float = 17.0f,
    //Back-ground color of menu item entry
    val menuItemFontBg:Int = Color.WHITE,
    //Text font color of menu item entry
    val menuItemFontColor:Int = Color.BLACK,
    //Back-ground color of menu item separator
    val menuSeparatorBg:Int = Color.GRAY){

    internal val mMenuViewItems = mutableListOf<MenuViewItem>()

    /**
     * Add MenuViewItem to MenuView
     *
     * @param menuViewItem | MenuViewItem instance for addition
     * */
    fun add(menuViewItem: MenuViewItem){
        mMenuViewItems.add(menuViewItem)
    }

    /**
     * Add MenuViewItem at specific position of MenuView
     *
     * @param index | 0(zero) based Position on MenuView for addition
     * @param menuViewItem | MenuViewItem instance for addition
     * */
    fun add(index:Int,menuViewItem: MenuViewItem){
        mMenuViewItems.add(index,menuViewItem)
    }

    /**
     * Remove item from specific position of MenuView
     *
     * @param index | Position on MenuView for removal
     * @return the element that has been removed.
     * */
    fun removeAt(index:Int):MenuViewItem?{
        return mMenuViewItems.removeAt(index)
    }

    /**
     * Remove MenuViewItem from MenuView
     *
     * @param index | Position on MenuView for removal
     * @return `true` if item has been removed.
     * */
    fun remove(menuViewItem: MenuViewItem):Boolean{
        return mMenuViewItems.remove(menuViewItem)
    }

    /**
     * Add collection of MenuViewItems on MenuView
     *
     * @param menuViewItems | collection of MenuViewItems for addition
     * @return `true` if the list was changed as the result of the operation.
     * */
    fun addAll(menuViewItems: Collection<MenuViewItem>):Boolean{
        return mMenuViewItems.addAll(menuViewItems)
    }

    /**
     * Remove collection of MenuViewItems on MenuView
     *
     * @param menuViewItems | collection of MenuViewItems for removal
     * @return `true` if the list was changed as the result of the operation.
     * */
    fun removeAll(menuViewItems: Collection<MenuViewItem>){
        mMenuViewItems.removeAll(menuViewItems)
    }

    /**
     * Remove all MenuViewItems on MenuView     *
     * */
    fun clear(){
        mMenuViewItems.clear()
    }

    /**
     * Display MenuView
     *
     * @param context | Android context
     * */
    fun show(context: Context){
        MenuViewUtils.launchMenuView(context,this)
    }
}