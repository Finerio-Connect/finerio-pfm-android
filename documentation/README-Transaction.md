# Finerio Transaction SDK

![Version](https://img.shields.io/badge/version-1.0.0-blue.svg)
![](https://img.shields.io/badge/minSDK-16+-blue.svg)
![Language](https://img.shields.io/badge/Language-Java-orange.svg)
![Language](https://img.shields.io/badge/Language-Kotlin-purple.svg)

TransactionSDK library of Finerio Connect is a practical and easy way to include the creation, update, delete and detail of a transaction list, it has a complete filter functionality too to facilite the interaction with them.

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
implementation 'com.finerioconnect.sdk.summary:transaction-ui:1.0.0'
```

## Pre-requirements

Add `FinerioConnectSDK` initialization code to your application. Please check the `FinerioConnectSDK`  [README]([GitHub - Finerio-Connect/finerio-connect-sdk-android](https://github.com/Finerio-Connect/finerio-connect-sdk-android#readme))  file before continue to get the entire configuration.

## Configure TransactionSDK

Java:

```java
final Configuration configuration = new Configuration();
configuration.setCredentials(new ArrayList<FCCredential>());
configuration.setCategories(new ArrayList<FCCategory>());

final FinerioTransactionSDK finerioTransactionSDK = FinerioTransactionSDK.Companion.getShared();
finerioTransactionSDK.init(configuration).configure(this);
```

Kotlin:

```kotlin
val configuration = Configuration()
configuration.setCredentials(arrayListOf<FCCredential>())
configuration.setCategories(arrayListOf<FCCategory>())

val finerioTransactionSDK = FinerioTransactionSDK.shared
finerioTransactionSDK.init(configuration).configure(this)
```

## FCTransactionListView

Let's get started by initializing the view and setting the transactions:

Add FCTransactionListView into your xml layout:

```xml
<com.finerioconnect.sdk.transaction.ui.FCTransactionListView
        android:id="@+id/fcTransactionListView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
```

Java:

```java
final FCTransactionListView fcTransactionListView = findViewById(R.id.fcTransactionListView);
fcTransactionListView.setListener(this);
fcTransactionListView.setFragmentActivity(this);

final List<FCTransaction> fcTransactions = new ArrayList<>();
final Date date1 = new Date(1632200400000L);
fcTransactions.add(new FCTransaction(
        "912fa2db-870b-484d-a190-e95b7d5a1cb3", date1, "Nuevo Mov", "Nuevo Mov", 2000, false, "ff41986b-89e3-48a0-aecd-02b19497e2c1", true,
        new FCBank("121", "DINERIO", "", new FCImage("debit_manual_account", -16098023), FCBankStatus.ACTIVE),
        new FCCategory("00000000-0000-0000-0000-00000000000e","Despensa", "#FECF58", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000002", null), null, null, null)));

final Date date2 = new Date(1632114000000L);
fcTransactions.add(new FCTransaction(
        "67ebe3d8-69d5-475a-bad2-e91cdf4ac38b", date2, "nuevo mov", "nuevo mov", -3500.0, false, "ff41986b-89e3-48a0-aecd-02b19497e2c1", null,
        new FCBank("121", "DINERIO", "", new FCImage("debit_manual_account", -16098023), FCBankStatus.ACTIVE),
        new FCCategory("00000000-0000-0000-0000-000000000035","Servicios Legales", "#BE5586", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000007", null), null, null, null)));

fcTransactionListView.setTransactions(fcTransactions);
```

Kotlin:

```kotlin
val fcTransactionListView = findViewById(R.id.fcTransactionListView)
fcTransactionListView.setListener(this)
fcTransactionListView.setFragmentActivity(this)

val fcTransactions = arrayListOf<FCTransaction>()
val date1 = Date(1632200400000L)
fcTransactions.add(FCTransaction(
        "912fa2db-870b-484d-a190-e95b7d5a1cb3", date1, "Nuevo Mov", "Nuevo Mov", 2000, false, "ff41986b-89e3-48a0-aecd-02b19497e2c1", true,
        FCBank("121", "DINERIO", "", FCImage("debit_manual_account", -16098023), FCBankStatus.ACTIVE),
        FCCategory("00000000-0000-0000-0000-00000000000e","Despensa", "#FECF58", "#FFFFFF", FCImage("a_00000000_0000_0000_0000_000000000002", null), null, null, null)))

val date2 = Date(1632114000000L)
fcTransactions.add(FCTransaction(
        "67ebe3d8-69d5-475a-bad2-e91cdf4ac38b", date2, "nuevo mov", "nuevo mov", -3500.0, false, "ff41986b-89e3-48a0-aecd-02b19497e2c1", null,
        FCBank("121", "DINERIO", "", FCImage("debit_manual_account", -16098023), FCBankStatus.ACTIVE),
        FCCategory("00000000-0000-0000-0000-000000000035","Servicios Legales", "#BE5586", "#FFFFFF", FCImage("a_00000000_0000_0000_0000_000000000007", null), null, null, null)))

fcTransactionListView.setTransactions(fcTransactions)
```

### Methods

#### Show or hide searcher view

```kotlin
showOrHideSearcher(isVisible: Boolean)
```

### Listener methods

#### OnFCTransactionListListener

```kotlin
fun didSelectedTransaction(transaction: FCTransaction)
```

## FCTransactionDetailView

Let's get started by initializing the view and setting the detail transaction:

Add FCTransactionDetailView into your xml layout:

```xml
<com.finerioconnect.sdk.transaction.ui.FCTransactionDetailView
        android:id="@+id/fcTransactionDetailView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
```

Java:

```java
final FCTransactionDetailView fcTransactionDetailView = findViewById(R.id.fcTransactionDetailView);
fcTransactionDetailView.setListener(this);
fcTransactionDetailView.fragmentActivity(this);
fcTransactionDetailView.setTransaction(fcTransaction);
```

Kotlin:

```kotlin
val fcTransactionDetailView = findViewById(R.id.fcTransactionDetailView)
fcTransactionDetailView.setListener(this)
fcTransactionDetailView.setFragmentActivity(this)
fcTransactionDetailView.setTransaction(fcTransaction)
```

### Methods

#### Show category progress

```kotlin
fun showCategoryProgress(textProgress: String)
```

#### Hide category progress

```kotlin
fun hideCategoryProgress()
```

#### Set category

```kotlin
fun setCategory(fcCategory: FCCategory)
```

#### Has valid fields

```kotlin
fun hasValidFields(): Boolean
```

#### EnableDisableSaveButton

```kotlin
fun enableDisableSaveButton(isEnable: Boolean)
```

#### Get transaction

```kotlin
fun getTransaction(): FCTransaction
```

### Listener methods

#### OnFCTransactionDetailListener

```kotlin
fun didDescriptionChanged(description: String, isIncome: Boolean)

fun didAccountChanged(accountId: String)

fun didCategoryChanged(categoryId: String)

fun didDateChanged(date: Date)

fun didTransactionTypeChanged(isIncome: Boolean)

fun didCreateTransaction(transaction: FCTransaction)
```

## Advanced integration

### Customize colors

You can create a new instance of `Palette` class and assign it to `FinerioTransactionSDK.shared.palette`

Java:

```java
final Palette palette = new Palette(
        new FilterPalette(Color.BLACK, ...),
        new TransactionListPalette(Color.BLACK, ...),
        null,
        ContextCompat.getColor(this, R.color.white),
        ContextCompat.getColor(this, R.color.colorAccent),
        null,
        null,
        null,
        null,
        null
);
FinerioTransactionSDK.Companion.getShared().setPalette(palette);
```

Kotlin:

```kotlin
val palette = Palette(
    FilterPalette(Color.BLACK, ...),
    TransactionListPalette(Color.BLACK, ...),
    null,
    ContextCompat.getColor(this, R.color.white),
    ContextCompat.getColor(this, R.color.colorAccent),
    null,
    null,
    null,
    null,
    null
)
FinerioTransactionSDK.shared.palette = palette
```

The SDK has FinerioTransactionSDK colors by default so, if you only need to change the segment button on color, yo can do this:

Java:

```java
Palette palette = new Palette();
palette.setSegmentButtonOn(ContextCompat.getColor(this, R.color.colorAccent));
FinerioTransactionSDK.Companion.getShared().setPalette(palette);
```

Kotlin:

```kotlin
FinerioTransactionSDK.shared.palette = Palette(
    segmentButtonOn = Color.BLUE
)
```

Or even directly change the property

Java:

```java
FinerioTransactionSDK.Companion.getShared().getPalette().setSegmentButtonOn(Color.BLUE);
```

Kotlin:

```kotlin
FinerioTransactionSDK.shared.palette.segmentButtonOn = Color.BLUE
```

### Customize string texts

You can customize the SDK string texts to fit your app:

Java:

```java
FinerioTransactionSDK.Companion.getShared().setTexts(new TransactionTexts(
    new FilterTexts(
        "Buscar",
        "Filtrar por:",
        "cuentas",
        "categorias",
        "tipo",
        "considerados",
        "no considerados",
        ...
    ),
    new AllFilterTexts(...),
    null,
    null
));
```

Kotlin:

```kotlin
FinerioTransactionSDK.shared.texts = TransactionTexts(
    FilterTexts(
        "Buscar",
        "Filtrar por:",
        "cuentas",
        "categorias",
        "tipo",
        "considerados",
        "no considerados",
        ...
    ),
    AllFilterTexts(...),
    null,
    null
))
```

The SDK has FinerioTransactionSDK wordings by default so, if you only need to change the search hint title text, yo can do this:

Java:

```java
TransactionTexts transactionTexts = new TransactionTexts();
FilterTexts filterTexts = new FilterTexts();
filterTexts.setSearchHintTitle("Buscar");
transactionTexts.setFilterTexts(filterTexts);
FinerioTransactionSDK.Companion.getShared().setTexts(transactionTexts);
```

Kotlin:

```kotlin
FinerioTransactionSDK.shared.texts = TransactionTexts(
    filterTexts = FilterTexts(searchHintTitle = "Buscar")
)
```

Or even directly change the property

Java:

```java
FinerioTransactionSDK.Companion.getShared().getTexts().setFilterTexts(new FilterTexts("Buscar", null, ...));
```

Kotlin:

```kotlin
FinerioTransactionSDK.shared.texts.filterTexts = FilterTexts(searchHintTitle = "Buscar")
```