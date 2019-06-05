IOS Simulators - download install xcode and with that will have option start simulator: xcode -> open developer tool -> simulator
check all devices on mac terminal - for IOS - 'instruments -s devices'

Start device on simulator from appium:
{
  "app": "/Users/sagardodia/Downloads/HintMD.Beta.ipa",
  "deviceName": "iPhone Xʀ (12.2)",
  "udid": "E11C009C-3D7B-4596-90EC-8D37EF68F7ED",
  "automationName": "XCUITest",
  "platformName": "iOS"
}

device:
{
  "app": "/Users/sagardodia/Downloads/HintMD.Beta.ipa",
  "deviceName": "Sagar’s iPhone (12.1)",
  "udid": "3cca4f92cad4cf28263fb3f5748582ff11afb2c7",
  "automationName": "XCUITest",
  "platformName": "iOS",
  "xcodeOrgId": "GHUN3SK5J8",
  "xcodeSigningId": "iOS Development"
}

Find elements on IOS - once bring up your app on device simulator using appium ui - appium will show inspect element option.
You can also record as well.

CommonUtils -   is for all needed properties for Appium and your Application so make sure you keep and comment which one
				needed for respective cases.


***************--------------------------------------------------------**************************************
Troubleshooting: If Appium is not installed successfully through NPM
It happens some times that the Appium is not successfully installed using NPM, Please follow below troubleshooting steps and see if you get any success:

Uninstall the node:

go to /usr/local/lib and delete any node and node_modules
go to /usr/local/include and delete any node and node_modules directory
if you installed with brew install node, then run brew uninstall node in your terminal
check your Home directory for any local or lib or include folders, and delete any node ornode_modules from there
go to /usr/local/bin and delete any node executable
To unistall brew:

cd`brew--prefix`
rm-rf Cellar
brew prune
rm`git ls-files`
rm-rLibrary/Homebrew Library/Aliases Library/Formula Library/Contributions
rm-rf.git
rm-rf~/Library/Caches/Homebrew

Uninstall NPM

sudo npm uninstall npm -g

Or, if that fails, get the npm source code, and do:

sudo make uninstall

To remove everything npm-related manually:

rm -rf /usr/local/{lib/node{,/.npm,_modules},bin,share/man}/npm*

Uninstall Brew

/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/uninstall)"

install ideviceinstaller

brew install -v --fresh automake autoconf libtool wget libimobiledevice

brew install -v --HEAD --fresh --build-from-source ideviceinstaller

Follow the steps again mentioned in Lecture 18 under "Appium installation guide"

***************--------------------------------------------------------**************************************

Updating the Appium Version via NPM
To update to the latest Appium version just type, here I am updating to 1.4.0 which is the current version while adding this lecture:

npm install -g appium@1.4.0

Update Xcode to: 6.3+

support for iOS 8.3

***************--------------------------------------------------------**************************************


Few Useful commands and info:

check all ios devices: instruments -s devices

uiautomatorviewer - to open viewer
android
adb
adb devices


export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home
export PATH=$PATH:$JAVA_HOME
export PATH=${JAVA_HOME}/bin:$PATH
export ANDROID_HOME=Users/sagardodia/Library/Android/sdk
export PATH=$PATH:$ANDROID_HOME/platform-tools:$ANDROID_HOME/tools:$ANDROID_HOME/tools/bin

or 
touch .bash_profile
open .bash_profile
and add all above exports in that file and
source .bash_profile

npm install -g appium-doctor

npm install -g appium

brew install carthage

<dependency>
    <groupId>io.appium</groupId>
    <artifactId>java-client</artifactId>
    <version>6.1.0</version>
</dependency>


android list avd - to see all virtual devices

emulator -avd Nexus_6_API_27 - to launch device (Nexus_6_API_27 - name of device)

export ANDROID_SDK=$HOME/Library/Android/sdk
export PATH=$ANDROID_SDK/emulator:$ANDROID_SDK/tools:$PATH

export ANDROID_SDK_ROOT=/Users/sagardodia/Library/Android/sdk
export PATH=$ANDROID_SDK_ROOT/emulator:$ANDROID_SDK_ROOT/tools:$PATH

for your device compatible chrome version
npm install appium --chromedriver_version="2.43"

or
appium --chromedriver-executable /path/to/my/chromedriver
appium --chromedriver-executable /Users/sagardodia/Downloads/chromedriver2

To install latest chrome browser to adb device:
adb -s emulator-5554 install /Users/sagardodia/Downloads/com.android.chrome_74.0.3729.136-372913610_minAPI19\(x86\)\(nodpi\)_apkmirror.com.apk 

adb shell
dumpsys window windows | grep -E 'mCurrentFocus'
- Above command will give package and activity info of respective open app

in android phone enable pointer to check location coordinates 


Get a list of apps and their launchable activities from a command line
aapt dump badging abcd.apk

APK Files from Hint Project:
/Users/sagardodia/hintmd/android/Android/hintmdapp/app/build/intermediates/instant-run-apk/debug
/Users/sagardodia/hintmd/android/Android/hintmdapp/app/release


keytool -importkeystore -srckeystore {JKS_FILE_NAME} -srcstoretype JKS -deststoretype PKCS12 -destkeystore {NAME_YOU_WANT}.p12
keytool -importkeystore -srckeystore KeyStore2 -srcstoretype JKS -deststoretype PKCS12 -destkeystore KeyStore22.p12


Export report to run on Jenkins one more step with restart jenkins;
java -Dhudson.model.DirectoryBrowserSupport.CSP="" -jar jenkins.war


to run real device install bellow - IOS
brew install --HEAD libimobiledevice
brew install --HEAD ideviceinstaller
brew install carthage
npm install -g ios-deploy
brew install ios-deploy
npm install -g deviceconsole
gem install xcpretty

instruments -s devices

An unknown server-side error occurred while processing the command. Original error: Could not install app: 'Command 'ios-deploy --id 3cca4f92cad4cf28263fb3f5748582ff11afb2c7 --bundle /Users/sagardodia/Documents/workspace-sts-3.9.8.RELEASE/mvnappiumautojar/apps/BonusApp.app' exited with code 253'
An unknown server-side error occurred while processing the command. Original error: Unable to launch WebDriverAgent because of xcodebuild failure: xcodebuild failed with code 65 xcodebuild error message: 2019-05-29 09:53:21.736 xcodebuild[53758:265658] Error Domain=NSCocoaErrorDomain Code=260 "The file “WebDriverAgentRunner-Runner.app” couldn’t be opened because there is no such file." UserInfo={NSFilePath=/Users/sagardodia/Library/Developer/Xcode/DerivedData/WebDriverAgent-dikkwtrisltbeobjmfvpthwwekvs/Build/Products/Debug-iphoneos/WebDriverAgentRunner-Runner.app, NSUnderlyingError=0x7f8f7bee89d0 {Error Domain=NSPOSIXErrorDomain Code=2 "No such file or directory"}} Testing failed: "WebDriverAgentRunner" requires a provisioning profile. Select a provisioning profile for the "Debug" build configuration in the project editor. (in target 'WebDriverAgentRunner') No signing certificate "iOS Development" found: No "iOS Development" signing certificate matching team ID "Hint, Inc" with a private key was found. (in target 'WebDriverAgentLib') WebDriverAgentRunner: WebDriverAgentRunner-Runner.app encountered an error (Failed to install or launch the test runner. (Underlying error: The file “WebDriverAgentRunner-Runner.app” couldn’t be opened because there is no such file. The file doesn’t exist. (Underlying error: The operation couldn’t be completed. No such file or directory))) Test session results and logs: /Users/sagardodia/Library/Developer/Xcode/DerivedData/WebDriverAgent-dikkwtrisltbeobjmfvpthwwekvs/Logs/Test/Test-WebDriverAgentRunner-2019.05.29_09-53-21--0700.xcresult ** TEST EXECUTE FAILED ** Testing started on 'Sagar’s iPhone'. Make sure you follow the tutorial at https://github.com/appium/appium-xcuitest-driver/blob/master/docs/real-device-config.md. Try to remove the WebDriverAgentRunner application from the device if it is installed and reboot the device.
Vijaysudh Madhusoodhan (Personal Team)


From: /usr/local/lib/node_modules/appium/node_modules/appium-xcuitest-driver/WebDriverAgent
xcodebuild -project WebDriverAgent.xcodeproj -scheme WebDriverAgentRunner -destination 'id=3cca4f92cad4cf28263fb3f5748582ff11afb2c7' test
Failing

Find any application bundleId for iOS Automation:
Go to: https://pspdfkit.com/guides/ios/current/faq/finding-the-app-bundle-id/
Google search for: 'itune link for "app-name"' such as 'itune link for whatsapp'
Then: https://itunes.apple.com/us/app/whatsapp-messenger/id310633997?mt=8 - get only id '310633997' from link
Use: https://itunes.apple.com/lookup?id=361309726 for above found id which directly download txt file where search with 'bundleId' will give you respective
bundleId for your automation


For browser inspect element you can still use chrome browser inspect element with device mode with selecting your device

connect device without cable:
adb tcpip 5555 - this will restart tcp mode port:5555
adb connect 192.168.128.1 - this will connect to respective mentioned host which is wifi host
adb connect 192.168.128.1:5555

Get connected device ip address: adb shell "ip addr show wlan0 | grep -e wlan0$ | cut -d\" \" -f 6 | cut -d/ -f 1"
adb connect 10.237.36.195:5555 - not able to connect
You can now view logcat output by running - adb logcat

You cannot start two appium UI with mac - windows you can do that


Start Hub:
java -jar selenium-server-standalone-3.141.59.jar -role hub

GUI - server port, log file path, Node config file path, chromedriver port, bootstrap port:
Device 1:
appium -p 4725 --udid 192.168.1.5:5555 -bp 5556 --chromedriver-port 5645 --nodeconfig "C:\Users\WAY2AUTOMATION\Desktop\appiumgrid\all.json" -g "C:\Users\WAY2AUTOMATION\Desktop\appiumgrid\appium_1.log" --session-override

Device 2:
appium -p 4726 --udid 2973c08c291c7ece -bp 5556 --chromedriver-port 5645 --nodeconfig "/Users/sagardodia/Desktop/MobileTestRefs/appiumgridfiles/all.json" -g "/Users/sagardodia/Desktop/MobileTestRefs/appiumgridfiles/appium_2.log" --session-override

2nd Way:

appium -p 10000 --default-capabilities '{"systemPort": 8200, "udid": "571e1c5acf8c4e0d47c6d146186d8749c8fab5b0"}'

appium -p 10001 --default-capabilities '{"systemPort": 8201, "udid": "7ae544323f497983cf0729bc81d5e6128342a125"}'



https://saucelabs.com/rest/v1/storage/YOUR_USERNAME/new_app_name.apk
https://saucelabs.com/rest/v1/storage/sagardodia/hintmd

curl -u <sauce_username>:<sauce_access_key> -X POST -H "Content-Type: application/octet-stream" https://saucelabs.com/rest/v1/storage/<sauce_username>/<upload_filename>?overwrite=true --data-binary @<path/to/your_file_name>

Android:
curl -u sagardodia:c978dd02-e2ab-42e2-8bde-782300f73ccc -X POST -H "Content-Type: application/octet-stream" https://saucelabs.com/rest/v1/storage/sagardodia/myApp.apk?overwrite=true --data-binary @/Users/sagardodia/Documents/workspace-sts-3.9.8.RELEASE/mvnappiumautojar/apps/HintMDPatientApp.apk

IOS:
curl -u sagardodia:c978dd02-e2ab-42e2-8bde-782300f73ccc -X POST -H "Content-Type: application/octet-stream" https://saucelabs.com/rest/v1/storage/sagardodia/HintMD.zip?overwrite=true --data-binary @/Users/sagardodia/Downloads/HintMD.Beta.ipa

GET all:
curl -u sagardodia:c978dd02-e2ab-42e2-8bde-782300f73ccc \
    https://saucelabs.com/rest/v1/storage/sagardodia



Real Device uploads:
curl -u "your_username:your_api_key" -X POST https://app.testobject.com:443/api/storage/upload -H "Content-Type: application/octet-stream" --data-binary @your_app.apk

curl -u "sagardodia:c978dd02-e2ab-42e2-8bde-782300f73ccc" -X POST https://app.testobject.com:443/api/storage/upload -H "Content-Type: application/octet-stream" --data-binary @/Users/sagardodia/Documents/workspace-sts-3.9.8.RELEASE/mvnappiumautojar/apps/HintMDPatientApp.apk

Get - Not working
curl -u "sagardodia:c978dd02-e2ab-42e2-8bde-782300f73ccc" -X GET https://app.testobject.com:443/api/storage/app



