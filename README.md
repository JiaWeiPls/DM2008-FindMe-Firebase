# DM2008 Final Project Android Application 2

This is an Android Application to show how the Find Me app will implement multiplayer using Firebase Realtime Database.

## Installation
Clone this repository and import into **Android Studio**
```bash
git clone git@github.com:JiaWeiPls/DM2008-FindMe-Firebase.git
```

## Configuration
### Keystores:
Create `app/keystore.gradle` with the following info:
```gradle
ext.key_alias='...'
ext.key_password='...'
ext.store_password='...'
```
And place both keystores under `app/keystores/` directory:
- `playstore.keystore`
- `stage.keystore`


## Build variants
Use the Android Studio *Build Variants* button to choose between **production** and **staging** flavors combined with debug and release build types


## Generating signed APK
From Android Studio:
1. ***Build*** menu
2. ***Generate Signed APK...***
3. Fill in the keystore information *(you only need to do this once manually and then let Android Studio remember it)*

## Usage
1. Create an account and log in.
2. Choose between Master or Slave by toggling the toggle button.
3. Enter a lobby code.
4. Enter "true" or "false" for ghostNear.
5. Tap send.
6. See the information you have sent on screen.
7. Try it out using 2 devices. One device set to Master and the other set to Slave.

## Maintainers
This project is mantained by:
* [Jia Wei](http://github.com/JiaWeiPls)


## Contributing

1. Fork it
2. Create your feature branch (git checkout -b my-new-feature)
3. Commit your changes (git commit -m 'Add some feature')
4. Run the linter (ruby lint.rb').
5. Push your branch (git push origin my-new-feature)
6. Create a new Pull Request
