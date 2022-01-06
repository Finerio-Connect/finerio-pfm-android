# Finerio Account SDK

![Version](https://img.shields.io/badge/version-1.0.0-blue.svg)
![](https://img.shields.io/badge/minSDK-16+-blue.svg)
![Language](https://img.shields.io/badge/Language-Java-orange.svg)
![Language](https://img.shields.io/badge/Language-Kotlin-purple.svg)

AccountSDK library of Finerio Connect is a practical and easy way to include the visualization and managment of detail balance and account list.

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
implementation 'com.finerioconnect.sdk.account:account-ui:1.0.0'
```

## Pre-requirements

Add `FinerioConnectSDK` initialization code to your application. Please check the `FinerioConnectSDK` [README]([GitHub - Finerio-Connect/finerio-connect-sdk-android](https://github.com/Finerio-Connect/finerio-connect-sdk-android#readme)) file before continue to get the entire configuration.



## Configure AccountSDK

Java:

```java
final FinerioAccountSDK finerioAccountSDK = FinerioAccountSDK.Companion.getShared();
finerioAccountSDK.configure(this);
```

Kotlin:

```kotlin
val finerioAccountSDK = FinerioAccountSDK.shared
finerioAccountSDK.configure(this)
```

## Account Balance View

Let's get started by initializing the view and setting the balance and accounts:

Add FCAccountBalanceView into your xml layout:

```xml
<com.finerioconnect.sdk.account.ui.FCAccountBalanceView
        android:id="@+id/accountBalanceView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:visibility="gone"
        tools:visibility="visible" />
```

Java:

```java
FCAccountBalanceView accountBalanceView = findViewById(R.id.accountBalanceView);
accountBalanceView.setListener(this);

final List<FCCredential> credentials = new ArrayList<>();

final List<FCAccount> accountsCiti = new ArrayList<>();
accountsCiti.add(new FCAccount("ID001", "Cuenta Perfiles", "Cheques", 1200.00, "2"));
accountsCiti.add(new FCAccount("ID002", "AHORRO FACIL", "Inversión", 55.30, "2"));
final FCImage fcImageCiti = new FCImage("https://cdn.finerio.mx/widget/bank_2_shield.png", -1);
final FCCredential fcCredentialCiti = new FCCredential("CR01", "Citibanamex", 1255.30, "anakin", FCCredentialStatus.ACTIVE, FCBankStatus.ACTIVE, "Actualizada: Hoy, 08:00", fcImageCiti, accountsCiti);
credentials.add(fcCredentialCiti);

final FCAccountBalance accountBalance = new FCAccountBalance(1890.07, -4500.56, 1890.07, 20000.0, 0, 20000.0, 21890.07, credentials);
accountBalanceView.setAccountBalance(accountBalance);
```

Kotlin:

```kotlin
val accountBalanceView = findViewById(R.id.accountBalanceView)
accountBalanceView.setListener(this)

val credentials = arrayListOf<FCCredential>()

val accountsCiti = arrayListOf<FCAccount>()
accountsCiti.add(FCAccount("ID001", "Cuenta Perfiles", "Cheques", 1200.00, "2"))
accountsCiti.add(FCAccount("ID002", "AHORRO FACIL", "Inversión", 55.30, "2"))
val fcImageCiti = FCImage("https://cdn.finerio.mx/widget/bank_2_shield.png", -1)
val fcCredentialCiti = FCCredential("CR01", "Citibanamex", 1255.30, "anakin", FCCredentialStatus.ACTIVE, FCBankStatus.ACTIVE, "Actualizada: Hoy, 08:00", fcImageCiti, accountsCiti)
credentials.add(fcCredentialCiti)

val accountBalance = FCAccountBalance(1890.07, -4500.56, 1890.07, 20000.0, 0, 20000.0, 21890.07, credentials)
accountBalanceView.setAccountBalance(accountBalance)
```

### ### Methods

#### Refresh credential item

```kotlin
fun refreshCell(credential: FCCredential)
```

### Listener methods

#### OnFCAccountBalanceListener

```kotlin
fun didSelectedAccount(credential: FCCredential)

fun didRefreshButton(credential: FCCredential)
```

## Banks View

Let's get started by initializing the view and setting the banks list:

Add FCBanksView into your xml layout:

```xml
<com.finerioconnect.sdk.account.ui.FCBanksView
        android:id="@+id/fcBanksView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
```

Java:

```java
FCBanksView fcBanksView = findViewById(R.id.fcBanksView);
fcBanksView.setListener(this);

final List<FCBank> fcBanks = new ArrayList<>();
fcBanks.add(new FCBank("1","BBVA","BBVA Bancomer", new FCImage("https://cdn.finerio.mx/widget/bank_1_on.png", -1), FCBankStatus.ACTIVE));
fcBanks.add(new FCBank("2","BNMX","Citibanamex", new FCImage("https://cdn.finerio.mx/widget/bank_2_on.png", -1), FCBankStatus.ACTIVE));

fcBanksView.setBanks(fcBanks);
```

Kotlin:

```kotlin
val fcBanksView = findViewById(R.id.fcBanksView)
fcBanksView.setListener(this)

val fcBanks = arrayListOf<FCBank>()
fcBanks.add(FCBank("1","BBVA","BBVA Bancomer", FCImage("https://cdn.finerio.mx/widget/bank_1_on.png", -1), FCBankStatus.ACTIVE))
fcBanks.add(FCBank("2","BNMX","Citibanamex", FCImage("https://cdn.finerio.mx/widget/bank_2_on.png", -1), FCBankStatus.ACTIVE))

fcBanksView.setBanks(fcBanks)
```

### Listener methods

#### OnFCBanksViewListener

```kotlin
fun didSelectedBank(bank: FCBank)
```

## FCAccountsDetailView

Let's get started by initializing the view and setting account detail:

Add FCAccountsDetailView into your xml layout:

```xml
<com.finerioconnect.sdk.account.ui.FCAccountsDetailView
        android:id="@+id/accountsDetailView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
```

Java:

```java
FCAccountsDetailView accountsDetailView = findViewById(R.id.accountsDetailView);
accountsDetailView.setListener(this);

final List<FCBankField> fcBankFields = new ArrayList<>();
fcBankFields.add(new FCBankField("username", "Número de cliente", 1, FCFieldType.USERNAME, false, "2", null));
fcBankFields.add(new FCBankField("password", "Clave de BancaNet", 2, FCFieldType.PASSWORD, false, "2", null));

final FCAccountDetail accountDetail = new FCAccountDetail("rene.sandoval", "paco", new FCCredential(), fcBankFields);
accountsDetailView.setAccountsDetail(accountDetail);
```

Kotlin:

```kotlin
val accountsDetailView = findViewById(R.id.accountsDetailView)
accountsDetailView.setListener(this)

val fcBankFields = arrayListOf<FCBankField>()
fcBankFields.add(FCBankField("username", "Número de cliente", 1, FCFieldType.USERNAME, false, "2", null))
fcBankFields.add(FCBankField("password", "Clave de BancaNet", 2, FCFieldType.PASSWORD, false, "2", null))

val accountDetail = FCAccountDetail("rene.sandoval", "paco", new FCCredential(), fcBankFields)
accountsDetailView.setAccountsDetail(accountDetail)
```

### Methods

#### Get Bank Fields

```kotlin
val bankFields = accountsDetailView.getBankFields()
```

#### Get Bank Fields Values

```kotlin
val bankFieldsValues = accountsDetailView.getBankFieldsValues()
```

### Listener methods

#### OnFCAccountsDetailViewListener

```kotlin
fun didSelectedDeleteAccount(account: FCAccount)
```

## BankFieldsView

Let's get started by initializing the view and setting fields:

Add FCBankFieldsView into your xml layout:

```xml
<com.finerioconnect.sdk.account.ui.FCBankFieldsView
        android:id="@+id/fcBankFieldsView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>
```

Java:

```java
FCBankFieldsView fcBankFieldsView = findViewById(R.id.fcBankFieldsView);
fcBankFieldsView.setListener(this);
fcBankFieldsView.config(this);

final List<FCBankField> bankFields = new ArrayList<>();
bankFields.add(new FCBankField("username", "Número de cliente", 1, FCFieldType.USERNAME,  false, "2", null));
bankFields.add(new FCBankField("password", "Clave de BancaNet", 2, FCFieldType.PASSWORD,  false, "2", null));

fcBankFieldsView.setBankFields(bankFields, true);
```

Kotlin:

```kotlin
val fcBankFieldsView = findViewById(R.id.fcBankFieldsView)
fcBankFieldsView.setListener(this)
fcBankFieldsView.config(this)

val bankFields = arrayListOf<FCBankField>()
bankFields.add(FCBankField("username", "Número de cliente", 1, FCFieldType.USERNAME,  false, "2", null))
bankFields.add(FCBankField("password", "Clave de BancaNet", 2, FCFieldType.PASSWORD,  false, "2", null))

fcBankFieldsView.setBankFields(bankFields, true)
```

### Methods

#### Get Bank Fields

```kotlin
val bankFields = accountsDetailView.getBankFields()
```

#### Get Bank Fields Values

```kotlin
val bankFieldsValues = accountsDetailView.getBankFieldsValues()
```

### Listener methods

#### OnBankFieldsViewListener

```kotlin
fun didActionButton(credentialFields: FCCredentialBankField)
```

## Advanced integration

### Customize colors

You can create a new instance of `Palette` class and assign it to `FinerioAccountSDK.shared.palette`

Java:

```java
final Palette palette = new Palette(
        Color.BLACK,
        Color.GRAY,
        Color.parseColor("#000000"),
        Color.parseColor("#858585"),
        ContextCompat.getColor(this, R.color.white),
        ContextCompat.getColor(this, R.color.colorAccent)
);
FinerioAccountSDK.Companion.getShared().setPalette(palette);
```

Kotlin:

```kotlin
val palette = Palette(
    Color.BLACK,
    Color.GRAY,
    Color.parseColor("#000000"),
    Color.parseColor("#858585"),
    ContextCompat.getColor(this, R.color.white),
    ContextCompat.getColor(this, R.color.colorAccent)
)
FinerioAccountSDK.shared.palette = palette
```

The SDK has FinerioAccountSDK colors by default so, if you only need to change the sync button background color, yo can do this:

Java:

```java
Palette palette = new Palette();
palette.setSyncButtonBackground(ContextCompat.getColor(this, R.color.colorAccent));
FinerioAccountSDK.Companion.getShared().setPalette(palette);
```

Kotlin:

```kotlin
FinerioAccountSDK.shared.palette = Palette(
    syncButtonBackground = Color.BLUE
)
```

Or even directly change the property

Java:

```java
FinerioAccountSDK.Companion.getShared().getPalette().setSyncButtonBackground(Color.BLUE);
```

Kotlin:

```kotlin
FinerioAccountSDK.shared.palette.syncButtonBackground = Color.BLUE
```

### Customize string texts

You can customize the SDK string texts to fit your app:

Java:

```java
FinerioAccountSDK.Companion.getShared().setTexts(new AccountTexts(
    "Débito y efectivo",
    "Tarjeta de crédito",
    "Saldo a corto plazo",
    "Inversiones",
    "Créditos",
    "Saldo a largo plazo",
    "Patrimonio neto",
    "Credenciales",
    "Cuentas",
    "Sincronizar"
));
```

Kotlin:

```kotlin
FinerioAccountSDK.shared.texts = AccountTexts(
    debitTitle = "Débito y efectivo",
    creditTitle = "Tarjeta de crédito",
    shortTermBalanceTitle = "Saldo a corto plazo",
    investmentTitle = "Inversiones",
    creditsTitle = "Créditos",
    longTermBalanceTitle = "Saldo a largo plazo",
    balanceTitle = "Patrimonio neto",
    credentialsTitle = "Credenciales",
    accountsTitle = "Cuentas",
    syncButtonTitle = "Sincronizar"
)
```

The SDK has FinerioAccountSDK wordings by default so, if you only need to change the balance title text, yo can do this:

Java:

```java
AccountTexts accountTexts = new AccountTexts();
accountTexts.setBalanceTitle("Saldo total de mis cuentas");
FinerioAccountSDK.Companion.getShared().setTexts(accountTexts);
```

Kotlin:

```kotlin
FinerioAccountSDK.shared.texts = AccountTexts(
    balanceTitle = "Saldo total de mis cuentas"
)
```

Or even directly change the property

Java:

```java
FinerioAccountSDK.Companion.getShared().getTexts().setBalanceTitle("Saldo total de mis cuentas");
```

Kotlin:

```kotlin
FinerioAccountSDK.shared.texts.balanceTitle = "Saldo total de mis cuentas"
```