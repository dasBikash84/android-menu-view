# android-menu-view

<h4>Library for Android custom menu view (options menu).</h4>


[![](https://jitpack.io/v/dasBikash84/android-menu-view.svg)](https://jitpack.io/#dasBikash84/android-menu-view)

## Dependency

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
        maven { url "https://jitpack.io" }
    }
}
```

Then, add the library to your module `build.gradle`
```gradle
dependencies {
    implementation 'com.github.dasBikash84:android-menu-view:latest.release.here'
}
```

## Features
- Custom [`menu view`](https://github.com/dasBikash84/android-menu-view/blob/master/android_menu_view/src/main/java/com/dasbikash/menu_view/MenuView.kt)(options menu) with very simple interface.
- Task assigned to menu items will run on UI/main thread.
- Can be attached to [`click/long-click`](https://github.com/dasBikash84/android-menu-view/blob/master/android_menu_view/src/main/java/com/dasbikash/menu_view/MenuViewUtils.kt) of any other view.
- For kotlin users extension functions provided on [`View`](https://developer.android.com/reference/android/view/View.html) for enabling Menu view launch on click/long-click.
- Menu item text color, size and back-ground is customizable. Also menu item seperator bg-color can be changed.

## Usage example

##### `Creating` a MenuView with `default` settings
```
    fun getDefaultMenuView(context: Context):MenuView{
        val menuViewItems = listOf<MenuViewItem>(
            MenuViewItem(
                text = "Menu item 1",
                task = { println("Menu item 1 clicked.")}
            ),
            MenuViewItem(
                text = "Menu item 2",
                task = { println("Menu item 2 clicked.")}
            ),
            MenuViewItem(
                text = "Menu item 3",
                task = { println("Menu item 3 clicked.")}
            ),
            MenuViewItem(
                text = "Menu item 4",
                task = { println("Menu item 4 clicked.")}
            )
        )

        val menuView = MenuView()
        menuView.addAll(menuViewItems)
        return menuView
    }
```

##### `Displaying` a MenuView with `default settings`
```
    val menuView = getDefaultMenuView(context)
    menuView.show()
```
### Image of MenuView with default settings:
![](https://github.com/dasBikash84/android-menu-view/raw/master/android_menu_view/src/main/res/drawable/default_menu.png)

##### Creating a `customized` MenuView

```
    fun getCustomMenuView(context: Context):MenuView{
        val menuViewItems = listOf<MenuViewItem>(
            MenuViewItem(
                text = "Menu item 1",
                task = { println("Menu item 1 clicked.")}
            ),
            MenuViewItem(
                text = "Menu item 2",
                task = { println("Menu item 2 clicked.")}
            ),
            MenuViewItem(
                text = "Menu item 3",
                task = { println("Menu item 3 clicked.")}
            ),
            MenuViewItem(
                text = "Menu item 4",
                task = { println("Menu item 4 clicked.")}
            )
        )

        val menuView = MenuView(
            menuItemFontSize = 18.0f,
            menuItemFontColor = Color.WHITE,
            menuItemFontBg = Color.BLACK,
            menuSeparatorBg = Color.BLUE
        )
        menuView.addAll(menuViewItems)
        return menuView
    }
```

##### `Displaying` a customized MenuView
```
    val menuView = getCustomMenuView(context)
    menuView.show()
```
### Image of MenuView with `custom settings`:
![](https://github.com/dasBikash84/android-menu-view/raw/master/android_menu_view/src/main/res/drawable/custom_menu.png)
---

##### Attaching a MenuView with `view click`:
```
     // view is instance of 'View' class
     // context is Android context
     
    MenuViewUtils.attachMenuViewForClick(view,getDefaultMenuView(context))
    
            // OR
            
    view.attachMenuViewForClick(view,getDefaultMenuView(context))
```
##### Attaching a MenuView with `view long click`:
```
    MenuViewUtils.attachMenuViewForLongClick(view,getDefaultMenuView(context))
    
            // OR
            
    view.attachMenuViewForLongClick(view,getDefaultMenuView(context))
```


License
--------

    Copyright 2020 Bikash Das(das.bikash.dev@gmail.com)

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
