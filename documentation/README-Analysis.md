# Finerio Analysis SDK

![Version](https://img.shields.io/badge/version-1.0.0-blue.svg)
![](https://img.shields.io/badge/minSDK-16+-blue.svg)
![Language](https://img.shields.io/badge/Language-Java-orange.svg)
![Language](https://img.shields.io/badge/Language-Kotlin-purple.svg)


The `AnalysisSDK` of Finerio Connect it's an easy way to include the visualization about your transactions analysis. So that can be represented in your application.

## Installation

### Using Gradle

Add next configuration to project `build.gradle` for supporting kotlin language:

```gradle
buildscript {
    ext.kotlin_version = "1.5.30"
    ...
    dependencies {
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
    }
}

allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Edit your app `build.gradle` and specify the dependencies:

```gradle
implementation 'com.github.Finerio-Connect:finerio-connect-sdk-android:1.0.2'
implementation 'com.finerioconnect.sdk.analysis:analysis-ui:1.0.1'
```

## Pre-requirements

Add `FinerioConnectSDK` initialization code to your application. Please check the `FinerioConnectSDK`  [README](https://github.com/Finerio-Connect/finerio-connect-sdk-android#readme)  file before continue to get the entire configuration.

## Configure AnalysisSDK

Java:

```java
final FinerioAnalysisSDK finerioAnalysisSDK = FinerioAnalysisSDK.Companion.getShared();
finerioAnalysisSDK.configure(this);
```

Kotlin:

```kotlin
val finerioAnalysisSDK = FinerioAnalysisSDK.shared
FinerioAnalysisSDK.configure(this)
```

## FCAnalysisView

Let's get started by initializing the view and setting the transactions:

Add FCAnalysisView into your xml layout:

```xml
<com.finerioconnect.sdk.analysis.ui.FCAnalysisView
        android:id="@+id/fcAnalysisView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
```

Java:

```java
final FCAnalysisView fcAnalysisView = findViewById(R.id.fcAnalysisView);
fcAnalysisView.setListener(this);

final List<FCAnalysis> analysisList = new ArrayList<>();
final Date date = new Date(1627794000000L);
final List<FCAnalysisCategory> fcAnalysisCategoryList = new ArrayList<>();
//Second Section
//First item
final List<FCAnalysisSubCategory> fcAnalysisSubCategoryList = new ArrayList<>();
final List<FCAnalysisTransaction> fcAnalysisTransactionList = new ArrayList<>();
//Transactions
fcAnalysisTransactionList.add(new FCAnalysisTransaction("MOVIMIENTO DE PRUEBA 21", new BigDecimal("20000.0"), 1, new BigDecimal("20000.0")));
//Sub categories
fcAnalysisSubCategoryList.add(new FCAnalysisSubCategory(new FCCategory("00000000-0000-0000-0000-00000000003c","Donaciones","#F477E3","#FFFFFF", new FCImage("a_00000000_0000_0000_0000_00000000003c", -755741), null, new ArrayList<>(), null), new BigDecimal("20000.0"), 1, new BigDecimal("20000.0"), fcAnalysisTransactionList));
//Category
final FCCategory fcCategory = new FCCategory("00000000-0000-0000-0000-000000000008","Regalos y Ayuda","#F368E0","#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000008", -825120), null, new ArrayList<>(), null);

fcAnalysisCategoryList.add(new FCAnalysisCategory(fcCategory, new BigDecimal("20000.0"), fcAnalysisSubCategoryList));
analysisList.add(new FCAnalysis(date, fcAnalysisCategoryList));

fcAnalysisView.setAnalysis(analysisList);
```

Kotlin:

```kotlin
val fcAnalysisView = findViewById(R.id.fcAnalysisView)
fcAnalysisView.setListener(this)

val analysisList = arrayListOf<FCAnalysis>()
val date = Date(1627794000000L)
val fcAnalysisCategoryList = arrayListOf<FCAnalysisCategory>()
//Second Section
//First item
val fcAnalysisSubCategoryList = arrayListOf<FCAnalysisSubCategory>()
val fcAnalysisTransactionList = arrayListOf<FCAnalysisTransaction>()
//Transactions
fcAnalysisTransactionList.add(FCAnalysisTransaction("MOVIMIENTO DE PRUEBA 21", BigDecimal("20000.0"), 1, BigDecimal("20000.0")))
//Sub categories
fcAnalysisSubCategoryList.add(FCAnalysisSubCategory(FCCategory("00000000-0000-0000-0000-00000000003c","Donaciones","#F477E3","#FFFFFF", FCImage("a_00000000_0000_0000_0000_00000000003c", -755741), null, arrayListOf<>(), null), BigDecimal("20000.0"), 1, BigDecimal("20000.0"), fcAnalysisTransactionList))
//Category
val fcCategory = FCCategory("00000000-0000-0000-0000-000000000008","Regalos y Ayuda","#F368E0","#FFFFFF", FCImage("a_00000000_0000_0000_0000_000000000008", -825120), null, arrayListOf<>(), null)

fcAnalysisCategoryList.add(FCAnalysisCategory(fcCategory, BigDecimal("20000.0"), fcAnalysisSubCategoryList))
analysisList.add(FCAnalysis(date, fcAnalysisCategoryList))

fcAnalysisView.setAnalysis(analysisList)
```

### Listener methods

#### OnFCAnalysisClickListener

```kotlin
fun didSelectedAnalysis(fcAnalysisCategory: FCAnalysisCategory)
```

## FCAnalysisDetailView

Let's get started by initializing the view and setting the transaction:

Add FCAnalysisDetailView into your xml layout:

```xml
<com.finerioconnect.sdk.analysis.ui.FCAnalysisDetailView
        android:id="@+id/fcAnalysisDetailView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
```

Java:

```java
final FCAnalysisDetailView fcAnalysisDetailView = findViewById(R.id.fcAnalysisDetailView);
fcAnalysisDetailView.setAnalysis(new FCAnalysisCategory());
```

Kotlin:

```kotlin
val fcAnalysisDetailView = findViewById(R.id.fcAnalysisDetailView)
fcAnalysisDetailView.setAnalysis(FCAnalysisCategory())
```

## Advanced integration

### Customize colors

You can create a new instance of `Palette` class and assign it to `FinerioAnalysisSDK.shared.palette`

Java:

```java
final Palette palette = new Palette(
    new TransactionListPalette(
        Color.BLUE,
        ContextCompat.getColor(this, R.color.white)
    )
);
FinerioAnalysisSDK.Companion.getShared().setPalette(palette);
```

Kotlin:

```kotlin
val palette = Palette(
    TransactionListPalette(
        Color.BLUE,
        ContextCompat.getColor(this, R.color.white)
    )
)
FinerioAnalysisSDK.shared.palette = palette
```

The SDK has FinerioAnalysisSDK colors by default so, if you only need to change the header background color, yo can do this:

Java:

```java
Palette palette = new Palette();
TransactionListPalette transactionListPalette = new TransactionListPalette();
transactionListPalette.setHeaderBackground(ContextCompat.getColor(this, R.color.colorAccent));
palette.setTransactionListPalette(transactionListPalette);
FinerioAnalysisSDK.Companion.getShared().setPalette(palette);
```

Kotlin:

```kotlin
FinerioAnalysisSDK.shared.palette = Palette(
    TransactionListPalette(
        headerBackground = Color.BLUE
    )
)
```

Or even directly change the property

Java:

```java
FinerioAnalysisSDK.Companion.getShared().getPalette().setTransactionListPalette(new TransactionListPalette(Color.BLUE, null));
```

Kotlin:

```kotlin
FinerioAnalysisSDK.shared.palette.transactionListPalette = TransactionListPalette(headerBackground = Color.BLUE)
```