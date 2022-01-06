# Finerio Summary SDK

![Version](https://img.shields.io/badge/version-1.0.0-blue.svg)
![](https://img.shields.io/badge/minSDK-16+-blue.svg)
![Language](https://img.shields.io/badge/Language-Java-orange.svg)
![Language](https://img.shields.io/badge/Language-Kotlin-purple.svg)

The `SummarySDK` of Finerio Connect it's an easy way to include the visualization about your incomes, expenses and balance. So that can be represented with graphs in your application.

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
implementation 'com.github.Finerio-Connect:finerio-connect-sdk-android:1.0.0'
implementation 'com.finerioconnect.sdk.summary:summary-ui:1.0.0'
```

## Pre-requirements

Add `FinerioConnectSDK` initialization code to your application. Please check the `FinerioConnectSDK` [README]([GitHub - Finerio-Connect/finerio-connect-sdk-android](https://github.com/Finerio-Connect/finerio-connect-sdk-android#readme)) file before continue to get the entire configuration.

## Configure SummarySDK

Java:

```java
final FinerioSummarySDK finerioSummarySDK = FinerioSummarySDK.Companion.getShared();
finerioSummarySDK.setDateFormat("yyyy-MM");
finerioSummarySDK.setSelectedChart(TransactionType.BALANCE);
finerioSummarySDK.configure(this);
```

Kotlin:

```kotlin
val finerioSummarySDK = FinerioSummarySDK.shared
finerioSummarySDK.dateFormat = "yyyy-MM"
finerioSummarySDK.selectedChart = TransactionType.BALANCE
finerioSummarySDK.configure(this)
```

## SummaryView

Let's get started by initializing the view and setting the transactions:

Add SummaryView into your xml layout:

```xml
<com.finerioconnect.sdk.summary.ui.SummaryView
        android:id="@+id/summaryView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
```

Java:

```java
SummaryView summaryView = findViewById(R.id.summaryView);
summaryView.configure(getSupportFragmentManager(), getLifecycle());
summaryView.setListener(this);

List<FCResumeTransaction> fcTransactions = new ArrayList<>();
fcTransactions.add(new FCResumeTransaction("1", "2021-07", "Pago de Servicio de Internet", 766.00, new FCCategory("3", "Educación y Trabajo", "#B33771", "", null, null, null, null)));
fcTransactions.add(new FCResumeTransaction("2", "2021-06", "Honorarios", 5600.00, new FCCategory("6", "Ingresos", "#099FE2", "", null, null, null, null)));
summaryView.setTransactions(fcTransactions);
```

Kotlin:

```kotlin
val summaryView = findViewById(R.id.summaryView)
summaryView.configure(supportFragmentManager, lifecycle)
summaryView.setListener(this)

val fcTransactions = arrayListOf<FCResumeTransaction>()
fcTransactions.add(FCResumeTransaction("1", "2021-07", "Pago de Servicio de Internet", 766.00, FCCategory("3", "Educación y Trabajo", "#B33771", "", null, null, null, null)))
fcTransactions.add(FCResumeTransaction("2", "2021-06", "Honorarios", 5600.00, FCCategory("6", "Ingresos", "#099FE2", "", null, null, null, null)))
summaryView.setTransactions(fcTransactions)
```

### Listener methods

#### OnSummaryViewListener

```kotlin
fun didTapBarChart(month: String)

fun didSelectedResume(resume: FCResume, transactionType: TransactionType)

fun emptyState(transactionType: TransactionType)
```

## Advanced integration

### Customize colors

You can create a new instance of `Palette` class and assign it to `FinerioSummarySDK.shared.palette`

Java:

```java
FinerioSummarySDK.Companion.getShared().setPalette(new Palette(ContextCompat.getColor(this, R.color.budget_green), Color.parseColor("#ffa02e36")));
```

Kotlin:

```kotlin
FinerioSummarySDK.shared.palette = Palette(ContextCompat.getColor(this, R.color.budget_green), Color.parseColor("#ffa02e36"))
```

The SDK has FinerioSummarySDK colors by default so, if you only need to change the incomes color, yo can do this:

Java:

```java
Palette palette = new Palette();
palette.setIncomes(ContextCompat.getColor(this, R.color.budget_green));
FinerioSummarySDK.Companion.getShared().setPalette(palette);
```

Kotlin:

```kotlin
FinerioSummarySDK.shared.palette = Palette(
    incomes = ContextCompat.getColor(this, R.color.budget_green)
)
```

Or even directly change the property

Java:

```java
FinerioSummarySDK.Companion.getShared().getPalette().setExpenses(Color.parseColor("#ffa02e36"));
```

Kotlin:

```kotlin
FinerioSummarySDK.shared.palette.incomes = Color.parseColor("#ffa02e36")
```

### Customize string texts

You can customize the SDK string texts to fit your app:

Java:

```java
FinerioSummarySDK.Companion.getShared().setTexts(new SummaryTexts(
    "Ingresos",
    "Gastoso",
    "Balance",
    "Total",
    "Ahorro",
    "Gastos"
));
```

Kotlin:

```kotlin
FinerioSummarySDK.shared.texts = SummaryTexts(
    incomesTitle = "Ingresos",
    expensesTitle = "Gastoso",
    balancesTitle = "Balance",
    totalTitle = "Total",
    savingTitle = "Ahorro",
    spendingTitle = "Gastos"
)
```

The SDK has FinerioSummarySDK wordings by default so, if you only need to change the balances title text, yo can do this:

Java:

```java
SummaryTexts summaryTexts = new SummaryTexts();
summaryTexts.setBalancesTitle("Saldos");
FinerioSummarySDK.Companion.getShared().setTexts(summaryTexts);
```

Kotlin:

```kotlin
FinerioSummarySDK.shared.texts = SummaryTexts(
    balancesTitle = "Saldos"
)
```

Or even directly change the property

Java:

```java
FinerioSummarySDK.Companion.getShared().getTexts().setBalancesTitle("Saldos");
```

Kotlin:

```kotlin
FinerioSummarySDK.shared.texts.balancesTitle = "Saldos"
```
