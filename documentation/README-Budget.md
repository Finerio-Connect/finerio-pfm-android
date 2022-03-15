# Finerio Budget SDK

![Version](https://img.shields.io/badge/version-1.0.0-blue.svg)
![](https://img.shields.io/badge/minSDK-16+-blue.svg)
![Language](https://img.shields.io/badge/Language-Java-orange.svg)
![Language](https://img.shields.io/badge/Language-Kotlin-purple.svg)


The `BudgetSDK` of Finerio Connect it's an easy way to include the visualization about your budgets. So that can be represented in your application.

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
implementation 'com.github.Finerio-Connect:finerio-connect-sdk-android:1.0.3'
implementation 'com.finerioconnect.sdk.budget:budget-ui:1.0.2'
```

## Pre-requirements

Add `FinerioConnectSDK` initialization code to your application. Please check the `FinerioConnectSDK`  [README](https://github.com/Finerio-Connect/finerio-connect-sdk-android#readme)  file before continue to get the entire configuration.

## Configure BudgetSDK

Java:

```java
final FinerioBudgetSDK finerioBudgetSDK = FinerioBudgetSDK.Companion.getShared();
finerioBudgetSDK.configure(this);
```

Kotlin:

```kotlin
val finerioBudgetSDK = FinerioBudgetSDK.shared
finerioBudgetSDK.configure(this)
```

## Budgets View

Let's get started by initializing the view and setting the budgets:

Add FCBudgetsView into your xml layout:

```xml
    <com.finerioconnect.sdk.budget.ui.FCBudgetsView
        android:id="@+id/budgetView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
```

Java:

```java
FCBudgetsView fcBudgetsView = findViewById(R.id.budgetView);
fcBudgetsView.setListener(this);

final List<FCBudget> budgets = new ArrayList<>();
final List<FCBudget> subBudgets1 = new ArrayList<>();
subBudgets1.add(new FCBudget("1", "Renta y Compra", "00000000-0000-0000-0000-000000000016", "#A3CB38", new BigDecimal(200), new BigDecimal(200), new BigDecimal(0), new BigDecimal(0), new BigDecimal(100), null, new FCImage("a_00000000_0000_0000_0000_000000000001", null)));
subBudgets1.add(new FCBudget("2", "Mascotas", "00000000-0000-0000-0000-000000000013", "#A3CB38", new BigDecimal(200), new BigDecimal(200), new BigDecimal(0), new BigDecimal(0), new BigDecimal(100), null, new FCImage("a_00000000_0000_0000_0000_000000000001", null)));
budgets.add(new FCBudget("1", "Hogar", "00000000-0000-0000-0000-000000000001", "#A3CB38", new BigDecimal(400), new BigDecimal(400), new BigDecimal(0), new BigDecimal(0), new BigDecimal(100), subBudgets1, new FCImage("a_00000000_0000_0000_0000_000000000001", null)));

budgets.add(new FCBudget("2", "Entretenimiento", "00000000-0000-0000-0000-000000000003", "#FF9F43", new BigDecimal(100), new BigDecimal(80), new BigDecimal(20), new BigDecimal(0), new BigDecimal(80),null, new FCImage("a_00000000_0000_0000_0000_000000000003", null)));


fcBudgetsView.setBudgets(null, budgets);
```

Kotlin:

```kotlin
val fcBudgetsView = findViewById(R.id.budgetView)
fcBudgetsView.setListener(this)

val budgets = arrayListOf<FCBudget>()
val subBudgets = arrayListOf<FCBudget>()

subBudgets.add(FCBudget("1", "Renta y Compra", "00000000-0000-0000-0000-000000000016", "#A3CB38", BigDecimal(200), BigDecimal(200), BigDecimal(0), BigDecimal(0), BigDecimal(100), null, FCImage("a_00000000_0000_0000_0000_000000000001", null)))
subBudgets.add(FCBudget("2", "Mascotas", "00000000-0000-0000-0000-000000000013", "#A3CB38", BigDecimal(200), BigDecimal(200), BigDecimal(0), BigDecimal(0), BigDecimal(100), null, FCImage("a_00000000_0000_0000_0000_000000000001", null)))
budgets.add(FCBudget("1", "Hogar", "00000000-0000-0000-0000-000000000001", "#A3CB38", BigDecimal(400), BigDecimal(400), BigDecimal(0), BigDecimal(0), BigDecimal(100), subBudgets, FCImage("a_00000000_0000_0000_0000_000000000001", null)))

fcBudgetsView.setBudgets(null, budgets)
```

### Listener methods

#### OnFCBudgetViewListener

```kotlin
fun didSelectedBudget(budget: FCBudget)
```

## Budgets Detail View

Let's get started by initializing the view and setting the budgets detail:

Add FCBudgetsView into your xml layout:

```xml
    <com.finerioconnect.sdk.budget.ui.FCBudgetsView
        android:id="@+id/budgetView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
```

Java:

```java
FCBudgetsView fcBudgetsView = findViewById(R.id.budgetView);
fcBudgetsView.setListener(this);

final FCBudget budget;
final List<FCBudget> subBudgets1 = new ArrayList<>();
subBudgets1.add(new FCBudget("1", "Renta y Compra", "00000000-0000-0000-0000-000000000016", "#A3CB38", new BigDecimal(200), new BigDecimal(200), new BigDecimal(0), new BigDecimal(0), new BigDecimal(100), null, new FCImage("a_00000000_0000_0000_0000_000000000001", null)));
subBudgets1.add(new FCBudget("2", "Mascotas", "00000000-0000-0000-0000-000000000013", "#A3CB38", new BigDecimal(200), new BigDecimal(200), new BigDecimal(0), new BigDecimal(0), new BigDecimal(100), null, new FCImage("a_00000000_0000_0000_0000_000000000001", null)));
budget = new FCBudget("1", "Hogar", "00000000-0000-0000-0000-000000000001", "#A3CB38", new BigDecimal(400), new BigDecimal(400), new BigDecimal(0), new BigDecimal(0), new BigDecimal(100), subBudgets1, new FCImage("a_00000000_0000_0000_0000_000000000001", null)));


fcBudgetsView.setBudgets(budget, budget.getSubcategories());
```

Kotlin:

```kotlin
val fcBudgetsView = findViewById(R.id.budgetView)
fcBudgetsView.setListener(this)

lateinit var budget: FCBudget
val subBudgets = arrayListOf<FCBudget>()
subBudgets.add(FCBudget("1", "Renta y Compra", "00000000-0000-0000-0000-000000000016", "#A3CB38", BigDecimal(200), BigDecimal(200), BigDecimal(0), BigDecimal(0), BigDecimal(100), null, FCImage("a_00000000_0000_0000_0000_000000000001", null)))
subBudgets.add(FCBudget("2", "Mascotas", "00000000-0000-0000-0000-000000000013", "#A3CB38", BigDecimal(200), BigDecimal(200), BigDecimal(0), BigDecimal(0), BigDecimal(100), null, FCImage("a_00000000_0000_0000_0000_000000000001", null)))
budget = FCBudget("1", "Hogar", "00000000-0000-0000-0000-000000000001", "#A3CB38", BigDecimal(400), BigDecimal(400), BigDecimal(0), BigDecimal(0), BigDecimal(100), subBudgets, FCImage("a_00000000_0000_0000_0000_000000000001", null)))

fcBudgetsView.setBudgets(budget, budget.getSubcategories())
```

## Budget Create View

Let's get started by initializing the view and setting budget creation:

Add FCBanksView into your xml layout:

```xml
    <com.finerioconnect.sdk.budget.ui.FCBudgetsInputView
        android:id="@+id/budgetInputView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
```

Java:

```java
FCBudgetsInputView budgetsInputView = findViewById(R.id.budgetInputView);

List<FCCategory> categories = new ArrayList<>();
List<FCCategory> subCategories = new ArrayList<>();
subCategories.add(new FCCategory("00000000-0000-0000-0000-000000000011", "Construción y Remodelación","#A3CB38", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000001", null), null, null, "00000000-0000-0000-0000-000000000001"));
subCategories.add(new FCCategory("00000000-0000-0000-0000-000000000012", "Artículos para el Hogar","#A3CB38", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000001", null),null, null, "00000000-0000-0000-0000-000000000001"));
categories.add(new FCCategory("00000000-0000-0000-0000-000000000001", "Hogar","#A3CB38", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000001", null),null, subCategories, null));

final List<FCBudget> budgets = new ArrayList<>();
final List<FCBudget> subBudgets = new ArrayList<>();
subBudgets.add(new FCBudget("1", "Renta y Compra", "00000000-0000-0000-0000-000000000016", "#A3CB38", new BigDecimal(200), new BigDecimal(200), new BigDecimal(0), new BigDecimal(0), new BigDecimal(100), null, new FCImage("a_00000000_0000_0000_0000_000000000001", null)));
subBudgets.add(new FCBudget("2", "Mascotas", "00000000-0000-0000-0000-000000000013", "#A3CB38", new BigDecimal(200), new BigDecimal(200), new BigDecimal(0), new BigDecimal(0), new BigDecimal(100), null, new FCImage("a_00000000_0000_0000_0000_000000000001", null)));
budgets.add(new FCBudget("1", "Hogar", "00000000-0000-0000-0000-000000000001", "#A3CB38", new BigDecimal(400), new BigDecimal(400), new BigDecimal(0), new BigDecimal(0), new BigDecimal(100), subBudgets, new FCImage("a_00000000_0000_0000_0000_000000000001", null)));

budgets.add(new FCBudget("2", "Entretenimiento", "00000000-0000-0000-0000-000000000003", "#FF9F43", new BigDecimal(100), new BigDecimal(80), new BigDecimal(20), new BigDecimal(0), new BigDecimal(80),null));

budgetsInputView.setBudgets(category, budget);
```

Kotlin:

```kotlin
val budgetsInputView = findViewById(R.id.budgetInputView)

val categories = arrayListOf<FCCategory>();
val subCategories = arrayListOf<FCCategory>();
subCategories.add(FCCategory("00000000-0000-0000-0000-000000000011", "Construción y Remodelación","#A3CB38", "#FFFFFF", FCImage("a_00000000_0000_0000_0000_000000000001", null), null, null, "00000000-0000-0000-0000-000000000001"));
subCategories.add(FCCategory("00000000-0000-0000-0000-000000000012", "Artículos para el Hogar","#A3CB38", "#FFFFFF", FCImage("a_00000000_0000_0000_0000_000000000001", null),null, null, "00000000-0000-0000-0000-000000000001"));
categories.add(FCCategory("00000000-0000-0000-0000-000000000001", "Hogar","#A3CB38", "#FFFFFF", FCImage("a_00000000_0000_0000_0000_000000000001", null),null, subCategories, null));

val budgets = arrayListOf<FCBudget>()
val subBudgets = arrayListOf<FCBudget>()
subBudgets.add(FCBudget("1", "Renta y Compra", "00000000-0000-0000-0000-000000000016", "#A3CB38", BigDecimal(200), BigDecimal(200), BigDecimal(0), BigDecimal(0), BigDecimal(100), null, FCImage("a_00000000_0000_0000_0000_000000000001", null)))
subBudgets.add(FCBudget("2", "Mascotas", "00000000-0000-0000-0000-000000000013", "#A3CB38", BigDecimal(200), BigDecimal(200), BigDecimal(0), BigDecimal(0), BigDecimal(100), null, FCImage("a_00000000_0000_0000_0000_000000000001", null)))
budgets.add(FCBudget("1", "Hogar", "00000000-0000-0000-0000-000000000001", "#A3CB38", BigDecimal(400), BigDecimal(400), BigDecimal(0), BigDecimal(0), BigDecimal(100), subBudgets, FCImage("a_00000000_0000_0000_0000_000000000001", null)))

budgetsInputView.setBudgets(category, budget)
```

### Get budget method

Java:

```java
FCBudget fcBudget = budgetInputView.getBudgetEdited();
```

Kotlin:

```kotlin
val fcBudget: FCBudget = budgetInputView.getBudgetEdited()
```

## FCCategoryView

Let's get started by initializing the view and setting categories budget:

Add FCCategoryView into your xml layout:

```xml
    <com.finerioconnect.sdk.ui.FCCategoryView
        android:id="@+id/categoryView"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
```

Java:

```java
FCCategoryView categoryView = findViewById(R.id.categoryView);

List<FCCategory> categories = new ArrayList<>();
List<FCCategory> subCategories = new ArrayList<>();
subCategories.add(new FCCategory("00000000-0000-0000-0000-000000000011", "Construción y Remodelación","#A3CB38", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000001", null), null, null, "00000000-0000-0000-0000-000000000001"));
subCategories.add(new FCCategory("00000000-0000-0000-0000-000000000012", "Artículos para el Hogar","#A3CB38", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000001", null),null, null, "00000000-0000-0000-0000-000000000001"));
categories.add(new FCCategory("00000000-0000-0000-0000-000000000001", "Hogar","#A3CB38", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000001", null),null, subCategories, null));

categoryView.setListener(this);
categoryView.setUpView(categories, FCCategoryType.SHOW_ALL_ONLY_ONE_CATEGORY, null);
```

Kotlin:

```kotlin
val categoryView = findViewById(R.id.categoryView);

val categories = arrayListOf<FCCategory>();
val subCategories = arrayListOf<FCCategory>();
subCategories.add(FCCategory("00000000-0000-0000-0000-000000000011", "Construción y Remodelación","#A3CB38", "#FFFFFF", FCImage("a_00000000_0000_0000_0000_000000000001", null), null, null, "00000000-0000-0000-0000-000000000001"));
subCategories.add(FCCategory("00000000-0000-0000-0000-000000000012", "Artículos para el Hogar","#A3CB38", "#FFFFFF", FCImage("a_00000000_0000_0000_0000_000000000001", null),null, null, "00000000-0000-0000-0000-000000000001"));
categories.add(FCCategory("00000000-0000-0000-0000-000000000001", "Hogar","#A3CB38", "#FFFFFF", FCImage("a_00000000_0000_0000_0000_000000000001", null),null, subCategories, null));

categoryView.setListener(this)
categoryView.setUpView(categories, FCCategoryType.SHOW_ALL_ONLY_ONE_CATEGORY, null)
```

### Customize Category View colors

You can create a new instance of `CategoryPalette` class and assign it to `categoryView` before `setUpView`

Java:

```java
FCCategoryView categoryView = findViewById(R.id.categoryView);

final CategoryPalette categoryPalette = new CategoryPalette();
categoryPalette.setSelectButtonText(Color.parseColor("#000000"));
categoryPalette.setSelectButtonBg(getResources().getColor(R.color.colorDarkBlue));
categoryPalette.setClearButtonText(getResources().getColor(R.color.white));
categoryPalette.setClearButtonBg(getResources().getColor(R.color.colorDarkBlue));
mBinding.categoryView.setPalette(categoryPalette);

categoryView.setPalette(categoryPalette);
```

Kotlin:

```kotlin
val categoryView = findViewById(R.id.categoryView);

val categoryPalette = CategoryPalette(
    Color.parseColor("#000000"),
    Color.GRAY,
    Color.parseColor("#858585"),
    ContextCompat.getColor(this, R.color.colorAccent)
)
categoryView.setPalette(categoryPalette)
```

### Customize CategoryView string texts

You can customize the CategoryView string texts to fit your app:

Java:

```java
FCCategoryView categoryView = findViewById(R.id.categoryView);

final CategoryTexts categoryTexts = new CategoryTexts();
categoryTexts.setClearButtonTitle("Limpiar");
categoryTexts.setSelectButtonTitle("Seleccionar");

categoryView.setTexts(categoryTexts);
```

Kotlin:

```kotlin
val categoryView = findViewById(R.id.categoryView);

val categoryTexts = CategoryTexts(
    "Seleccionar todo",
    "Limpiar",
    "Seleccionar"
)

categoryView.setTexts(categoryTexts);
```

### Listener methods

#### OnFCCategoriesListener

```kotlin
fun didSelectedCategories(category: ArrayList<FCCategory>?)
```

#### OnFCCategoryListener

```kotlin
fun didSelectedCategory(category: FCCategory?)
```

#### OnFCSubcategoryListener

```kotlin
fun didSelectedSubcategory(category: FCCategory?)
```

## Advanced integration

### Customize colors

You can create a new instance of `Palette` class and assign it to `FinerioBudgetSDK.shared.palette`

Java:

```java
final Palette palette = new Palette(
    Color.BLACK,
    Color.parseColor("#000000"),
    Color.parseColor("#858585"),
    ContextCompat.getColor(this, R.color.colorAccent)
    Color.GREEN,
    Color.YELLOW,
    Color.RED,
);
FinerioBudgetSDK.Companion.getShared().setPalette(palette);
```

Kotlin:

```kotlin
val palette = Palette(
    Color.BLACK,
    Color.parseColor("#000000"),
    Color.parseColor("#858585"),
    ContextCompat.getColor(this, R.color.colorAccent)
    Color.GREEN,
    Color.YELLOW,
    Color.RED,
)
FinerioBudgetSDK.shared.palette = palette
```

The SDK has FinerioBudgetSDK colors by default so, if you only need to change the text color, yo can do this:

Java:

```java
Palette palette = new Palette();
palette.setText(ContextCompat.getColor(this, R.color.colorAccent));
FinerioBudgetSDK.Companion.getShared().setPalette(palette);
```

Kotlin:

```kotlin
FinerioBudgetSDK.shared.palette = Palette(
    text = Color.BLUE
)
```

Or even directly change the property

Java:

```java
FinerioBudgetSDK.Companion.getShared().getPalette().setText(Color.BLUE);
```

Kotlin:

```kotlin
FinerioBudgetSDK.shared.palette.text = Color.BLUE
```

### Customize string texts

You can customize the SDK string texts to fit your app:

Java:

```java
FinerioBudgetSDK.Companion.getShared().setTexts(new BudgetTexts(
    "Total",
    "Categorías",
    "Presupuesto total",
    "Por ejecutar",
    "Excedido"
));
```

Kotlin:

```kotlin
FinerioBudgetSDK.shared.texts = BudgetTexts(
    sectionTitle: String = "Total",
    subSectionTitle: String = "Categorías",
    budgetNameTitle: String = "Presupuesto total",
    percentageLabel: String = "Por ejecutar",
    percentageExceededLabel: String = "Excedido"
)
```

The SDK has FinerioBudgetSDK wordings by default so, if you only need to change the budget title text, yo can do this:

Java:

```java
BudgetTexts budgetTexts = new BudgetTexts();
budgetTexts.setBudgetNameTitle("Presupuesto total");
FinerioBudgetSDK.Companion.getShared().setTexts(budgetTexts);
```

Kotlin:

```kotlin
FinerioBudgetSDK.shared.texts = BudgetTexts(
    budgetNameTitle = "Presupuesto total"
)
```

Or even directly change the property

Java:

```java
FinerioBudgetSDK.Companion.getShared().getTexts().setBudgetNameTitle("Presupuesto total");
```

Kotlin:

```kotlin
FinerioBudgetSDK.shared.texts.budgetNameTitle = "Presupuesto total"
```