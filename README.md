# Finerio Connect PFM UI Example Android

 ![](https://img.shields.io/badge/minSDK-16+-blue.svg) ![Language](https://img.shields.io/badge/Language-Java-orange.svg) ![Language](https://img.shields.io/badge/Language-Kotlin-purple.svg)

This repository contains a subset of the Finerio Connect PFM UI Android SDK example. It currently includes the following Finerio Connect UI SDK libraries

### Installation

1. Download the [latest PFM UI SDK release](https://https://github.com/Finerio-Connect/sdks-pfm-ui-android) zip file.
2. Unzip and take the `com` folder (containing the SDK's local maven dependencies) and put it in `~/.m2/repository/`.
3. Add `maven url` as repository in your root level settings.gradle file.

#### Using Settings Gradle

Add next configuration to project `settings.gradle`:

```settings.gradle
    repositories {
        maven {
            url 'C:/Users/user_name/.m2/repository'
        }
        maven { url 'https://jitpack.io' }
    }
```

#### Using Project Build Gradle

Add next configuration to project `build.gradle`:

```build.gradle
buildscript {
    ext.kotlin_version = "1.5.30"
    ...
    dependencies {
         classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
         ...
    }
}
```

#### Using Module Gradle

Add next configuration to module `build.gradle`:

```build.gradle
android {
    ...
    android.buildFeatures.viewBinding = true
}

dependencies {
    //SDK's
    implementation 'com.github.Finerio-Connect:finerio-connect-sdk-android:1.0.0'
    implementation 'com.finerioconnect.sdk.summary:summary-ui:1.0.0'
    implementation 'com.finerioconnect.sdk.analysis:analysis-ui:1.0.0'
    implementation 'com.finerioconnect.sdk.transaction:transaction-ui:1.0.0'
    implementation 'com.finerioconnect.sdk.budget:budget-ui:1.0.0'
    implementation 'com.finerioconnect.sdk.account:account-ui:1.0.0'
}
```

#### Using Manifest

Add next permission into manifest.xml:

```xml
<uses-permission android:name="android.permission.INTERNET"/> ```

#### **Import the module:**

```java
import com.finerioconnect.sdk.core.FinerioConnectSDK;
```

#### Initialize FinerioConnect Core SDK

Java:

```java
FinerioConnectSDK finerioConnectSDK = FinerioConnectSDK.Companion.getShared();
finerioConnectSDK.setApiKey("api_key");
finerioConnectSDK.configure();
```

Kotlin:

```kotlin
val finerioConnectSDK = FinerioConnectSDK.shared
finerioConnectSDK.apiKey = "api_key"
finerioConect.configure()
```

#### Dependencies:

| Product               | README                                                                                               | Description                                                                                                         | Gradle dependency                                                               |
| --------------------- | ---------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- |
| FinerioConnectSDK     | [README](https://github.com/Finerio-Connect/finerio-connect-sdk-android#readme)                      | Main SDK library, it is necessary for all libraries.                                                                | `implementation 'com.github.Finerio-Connect:finerio-connect-sdk-android:1.0.0'` |
| FinerioSummarySDK     | [README](https://github.com/Finerio-Connect/finerio-pfm-android/documentation/README-Summary.md)     | Library to manage transactions in different sections with graphs of expenses, incomes and transactions by category. | `com.finerioconnect.sdk.summary:summary-ui:1.0.0`                               |
| FinerioTransactionSDK | [README](https://github.com/Finerio-Connect/finerio-pfm-android/documentation/README-Transaction.md) | Library to manage a user transactions, it can be filtered by credentials, categories, etc.                          | `com.finerioconnect.sdk.transaction:transaction-ui:1.0.0`                       |
| FinerioAnalysisSDK    | [README](https://github.com/Finerio-Connect/finerio-pfm-android/documentation/README-Analysis.md)    | Library to manage a list of transactions categorized by categories                                                  | `com.finerioconnect.sdk.analysis:analysis-ui:1.0.0`                             |
| FinerioAccountSDK     | [README](https://github.com/Finerio-Connect/finerio-pfm-android/documentation/README-Account.md)     | Library to manage a list of user credentials                                                                        | `com.finerioconnect.sdk.account:account-ui:1.0.0`                               |
| FinerioBudgetSDK      | [README](https://github.com/Finerio-Connect/finerio-pfm-android/documentation/README-Budget.md)      | Library to manage user budgets.                                                                                     | `com.finerioconnect.sdk.budget:budget-ui:1.0.0`                                 |

### License
