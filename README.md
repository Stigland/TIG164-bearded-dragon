# SCHEMAPP #

Open in browser to see rendered markup.

### Scheduling application for small companies, written in Java for Android ###

### How to install the application ###

There are two alternatives to run the provided APK installation file.

#####Alternative 1.#####
Install on your Android Device with Android version 4.2 or higher. 
To do this, enable developer options by entering settings > About Phone > Tap 'Build Number' 5 times. You should now have developer right to the phone.
After this, just open provided APK with package installer and accept. That's it!

#####Alternative 2.#####
Install an android virtual device on your computer. We've used Genymotion, but any emulator should do. 
A list of recomended emulators with links has been provided below. After installation, drag and drop APK-file in emulator, and the app should be ready to tock right away. 

>Genymotion: https://www.genymotion.com/      
>Andy:	     http://andyroid.net/     
>Bluestacks: http://www.bluestacks.com/      

If you have any questions, contact gusleajoa@student.gu.se

###To view source code### 

Open and compile in your favourite IDE. We've been working in Android Studio.

To pull recent update from the master branch, execute 'git pull origin master'

To publish updates to the code, execute 'git push origin master'


#### Naming conventions ####
All component for x activity must be start with activity name.

All component should have prefix or short name like btn for button.

For example,name for login activity component should be like following.

* activity_login_btn_login
* activity_login_et_username
* activity_login_et_password
* Short name of major components

* Button - btn
* EditText - et
* TextView - tv
* Checkbox - chk
* RadioButton - rb
* ToggleButton - tb
* Spinner - spn
* Menu - mnu
* ListView - lv
* GalleryView - gv
* LinearLayout -ll
* RelativeLayout - rl

#### Colors ####

To set predefined colors or use existing ones, check res/values/colors.xml and use designated color for intended element.

e.g.
>darkBlue uses Dark Blue color
