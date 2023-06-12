## 🚀 Quick start

1.  **Install Android Studio**

    Download and install Android Studio (<a href= "https://developer.android.com/studio">link</a>).

2.  **Make sure Java is Installed**

    In terminal run:

    ```shell
    java --version
    ```

    If Java is not installed, run the following lines:

    ```shell
    brew install java
    brew install oracle-jdk --cask
    ```

    If you need to install brew, go to this <a href="https://brew.sh">link</a> to learn how.

    Once you're done, confirm that Java is installed by running the following line in terminal:

    ```shell
    java --version
    ```

3.  **Install KLint**
    This project uses <a href="https://github.com/pinterest/ktlint">ktlint</a> and <a href="https://github.com/diffplug/spotless">Spotless</a> to maintain code consistency.

    For this to work you must have installed ktlint on your machine.

    ```shell
    brew install ktlint
    ```

    If you need to install brew, go to this <a href="https://brew.sh">link</a> to learn how.

4.  **That's it**

    Open this project in Android Studio and get started.

## 💻 Keyboard Shortcuts

**Select Many lines**
Option + Shift + Click

**Format**
Command + Option + L -> Format this file
Command + Option + Shift + L -> Format this file, with options

**Find**
Command + F -> Find in File
Command + Shift + F -> Find and Replace in Project

**Find and Replace**
Command + R -> Find and Replace in File
Command + Shift + R -> Find and Replace in Project

## 🖇️ Resources

1. <a href="https://developer.android.com/studio/intro/keyboard-shortcuts">All Keyboard Shortcuts 🔗</a>
2. <a href="https://convertingcolors.com/">Convert Colors to Android.Graphic.Color 🔗</a>
2. <a href="https://www.myfixguide.com/color-converter/">Convert Colors to ARGB 🔗</a>


## 📚 Tutorials

### **Basics**

1. <a href="https://www.delasign.com/blog/android-studio-clean-rebuild-project/?utm=github-starter-project">How to clean and rebuild an Android project in Android Studio 🔗</a>
2. <a href="https://delasign.com/blog/how-to-sync-an-android-project-with-its-gradle-files-in-android-studio/?utm=github-starter-project">How to sync an Android project with its Gradle files in Android Studio 🔗</a>
3. <a href="https://delasign.com/blog/android-studio-rename-project/?utm=github-starter-project">How to rename an Android Studio Project 🔗</a>
4. <a href="https://delasign.com/blog/how-to-enable-developer-mode-on-an-android-phone-or-tablet/?utm=github-starter-project">How to enable developer mode on an Android phone or tablet 🔗</a>
5. <a href="https://delasign.com/blog/android-studio-create-file-folder-resource?utm=github-starter-project">How to create a file, folder or resource in Android Studio 🔗</a>
6. <a href="https://delasign.com/blog/android-studio-custom-font/?utm=github-starter-project">How to add a custom font to an Android Studio project 🔗</a>
7. <a href="https://delasign.com/blog/android-studio-custom-color/?utm=github-starter-project">How to add and use custom colors in an Android project 🔗</a>

### **Coordinators / Managers**

1. <a href="https://delasign.com/blog/android-studio-kotlin-styleguide/?utm=github-starter-project">How to create a Styleguide in Android Studio and Kotlin 🔗</a>

### **Jetpack Compose**

1. <a href="https://delasign.com/blog/how-to-implement-custom-text-styles-using-kotlin-and-jetpack-compose/?utm=github-starter-project">How to implement custom Text Styles using Kotlin and Jetpack Compose 🔗</a>
2. <a href="https://delasign.com/blog/android-studio-kotlin-light-dark-mode/?utm=github-starter-project">How to use light mode and dark mode in Android Studio and Kotlin 🔗</a>
3. <a href="https://delasign.com/blog/android-studio-kotlin-light-dark-mode/?utm=github-starter-project">How to use light mode and dark mode in Android Studio and Kotlin 🔗</a>
4. <a href="https://delasign.com/blog/android-studio-kotlin-is-dark-mode/?utm=github-starter-project">How to determine if an Android app is using light mode or dark mode 🔗</a>


### **Settings**

1. <a href="https://delasign.com/blog/android-studio-soft-wrap-files/?utm=github-starter-project">How to Soft Wrap Files in Android Studio 🔗</a>
2. <a href="https://delasign.com/blog/android-studio-git-automation-settings/?utm=github-starter-project">How to change git version control automation settings 🔗</a>

### **Gradle**

1. <a href="https://delasign.com/blog/android-studio-create-gradle-file/?utm=github-starter-project">How to create a Gradle file in Android Studio 🔗</a>
2. <a href="https://delasign.com/blog/android-studio-gradle-pre-build-task/?utm=github-starter-project">How to run a Gradle Kotlin DSL build task in Android Studio 🔗</a>
3. <a href="https://delasign.com/blog/android-studio-run-build-task-any-stage/?utm=github-starter-project">How to run a task at any stage of an app Gradle build 🔗</a>


### **Linting**

1. <a href="https://www.delasign.com/blog/android-studio-ktlint-and-spotless/?utm=github-starter-project">How to add ktlint and spotless to an Android project 🔗</a>
2. <a href="https://github.com/diffplug/spotless/tree/main/plugin-gradle">Spotless Gradle Guide 🔗</a>
3. <a href="https://delasign.com/blog/android-ktlint-spotless-precommit-script/?utm=github-starter-project">How to run Spotless and ktlint in a pre-commit git hook 🔗</a>
4. <a href="https://delasign.com/blog/android-studio-gradle-precommit-git-script/?utm=github-starter-project">How to add a pre-commit git hook script using a Gradle task 🔗</a>

### **Errors**

1. <a href="https://delasign.com/blog/android-studio-fix-java-home-invalid-directory/?utm=github-starter-project">How to fix the JAVA_HOME invalid directory error on a Mac  🔗</a>
2. <a href="https://delasign.com/blog/android-studio-fix-sdk-location-error/?utm=github-starter-project">How to fix the SDK location not found error in Android Studio 🔗</a>


## 🧹 Spotless and ktlint

**Apply Spotless Check**
In Android Studio, open the terminal window and run the following line

```shell
./gradlew spotlessCheck
```

**Apply Spotless Apply**
In Android Studio, open the terminal window and run the following line

```shell
./gradlew spotlessApply
```

**Apply ktlint check**
In Android Studio, open the terminal window and run the following line

```shell
./gradlew ktlintCheck
```

**Apply ktlint format**
In Android Studio, open the terminal window and run the following line

```shell
./gradlew ktlintFormat
```

**Modify Spotless and ktlint**
Open the spotless.gradle to change the configuration using the <a href="https://github.com/diffplug/spotless/tree/main/plugin-gradle">Spotless Gradle Guide 🔗.</a>