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

<a href="https://developer.android.com/studio/intro/keyboard-shortcuts">All Keyboard Shortcuts 🔗</a>

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

## 📚 Tutorials

### **Basics**

1. <a href="https://www.delasign.com/blog/android-studio-clean-rebuild-project/?utm=github-starter-project">How to clean and rebuild an Android project in Android Studio 🔗</a>
2. <a href="https://delasign.com/blog/how-to-sync-an-android-project-with-its-gradle-files-in-android-studio/?utm=github-starter-project">How to sync an Android project with its Gradle files in Android Studio 🔗</a>
3. <a href="https://delasign.com/blog/android-studio-rename-project/?utm=github-starter-project">How to rename an Android Studio Project 🔗</a>
4. <a href="https://delasign.com/blog/how-to-enable-developer-mode-on-an-android-phone-or-tablet/?utm=github-starter-project">How to enable developer mode on an Android phone or tablet 🔗</a>

### **Linting**

1. <a href="https://www.delasign.com/blog/android-studio-ktlint-and-spotless/?utm=github-starter-project">How to add ktlint and spotless to an Android project 🔗</a>
2. <a href="https://github.com/diffplug/spotless/tree/main/plugin-gradle">Spotless Gradle Guide 🔗</a>
