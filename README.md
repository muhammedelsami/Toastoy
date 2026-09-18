
# Toastoy


<img src="https://github.com/muhammedelsami/Toastoy/blob/main/toastoy/Screens/Default.png">

##  Dependency 
[![](https://jitpack.io/v/muhammedelsami/Toastoy.svg)](https://jitpack.io/#muhammedelsami/Toastoy)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/Apache-2.0)
![](https://img.shields.io/github/forks/muhammedelsami/Toastoy?label=Forks)
![](https://img.shields.io/github/stars/muhammedelsami/Toastoy?label=Stars&color=9cf)
![](https://visitor-badge.glitch.me/badge?page_id=muhammedelsami.Toastoy)

Add this in your root build.gradle file (or settings.gradle file):

```gradle  
repositories {  
 maven { url 'https://jitpack.io' }  
} 
``` 
  
Add this to your app build.gradle file:


```gradle  
dependencies {  
 implementation 'com.github.muhammedelsami:Toastoy:TAG'
}  
```

## Usage

To display a default Toast:

``` kotlin
Toastoy.showDefaultToast(this,"This is a default toast !")
```
To display a success Toast:

``` kotlin
Toastoy.showSuccessToast(this, "This is a success toast !")
```

To display the error Toast:

``` kotlin
Toastoy.showErrorToast(this,"This is an error toast !")
```

To display an info Toast:

``` kotlin
Toastoy.showInfoToast(this,"This is an info toast !")
```
To display a warning Toast:

``` kotlin
Toastoy.showWarningToast(this,"This is a warning toast !")
```

## Fonts, size and weight

Toastoy ships with free **variable** fonts from [Google Fonts](https://fonts.google.com) (SIL Open Font License).
Every font supports **English, Turkish and Arabic** out of the box, and any weight from thin to black
can be picked at runtime.

| `ToastoyFont`        | Font                                                                    |
|----------------------|-------------------------------------------------------------------------|
| `CAIRO` *(default)*  | [Cairo](https://fonts.google.com/specimen/Cairo)                        |
| `ALEXANDRIA`         | [Alexandria](https://fonts.google.com/specimen/Alexandria)              |
| `RUBIK`              | [Rubik](https://fonts.google.com/specimen/Rubik)                        |
| `READEX_PRO`         | [Readex Pro](https://fonts.google.com/specimen/Readex+Pro)              |
| `CHANGA`             | [Changa](https://fonts.google.com/specimen/Changa)                      |
| `VAZIRMATN`          | [Vazirmatn](https://fonts.google.com/specimen/Vazirmatn)                |
| `EL_MESSIRI`         | [El Messiri](https://fonts.google.com/specimen/El+Messiri)              |
| `NOTO_KUFI_ARABIC`   | [Noto Kufi Arabic](https://fonts.google.com/specimen/Noto+Kufi+Arabic)  |

Every `show*Toast` call takes three optional parameters after the message:

| Parameter    | Type                | Default  |
|--------------|---------------------|----------|
| `font`       | `ToastoyFont`       | `CAIRO`  |
| `textSize`   | `Float` (sp)        | `18f`    |
| `fontWeight` | `ToastoyFontWeight` | `BOLD`   |

`ToastoyFontWeight` covers `THIN (100)`, `EXTRA_LIGHT (200)`, `LIGHT (300)`, `NORMAL (400)`, `MEDIUM (500)`,
`SEMI_BOLD (600)`, `BOLD (700)`, `EXTRA_BOLD (800)` and `BLACK (900)`. Each font supports a different range
(for example El Messiri 400–700, Cairo 200–1000); out-of-range values are clamped to the nearest edge.

Style a single toast:

``` kotlin
Toastoy.showSuccessToast(this, "İşlem başarılı!", ToastoyFont.CAIRO)
Toastoy.showInfoToast(this, "تم الحفظ بنجاح", ToastoyFont.NOTO_KUFI_ARABIC, 20f, ToastoyFontWeight.MEDIUM)
Toastoy.showWarningToast(this, "Heads up", textSize = 16f, fontWeight = ToastoyFontWeight.SEMI_BOLD)
```

Or set the defaults once and every toast will use them:

``` kotlin
Toastoy.defaultFont = ToastoyFont.ALEXANDRIA
Toastoy.defaultTextSize = 16f
Toastoy.defaultFontWeight = ToastoyFontWeight.MEDIUM
Toastoy.showErrorToast(this, "Something went wrong")   // Alexandria, 16sp, medium
```

> Variable font weights need API 26+. On API 24–25 the font's default instance is used and
> `SEMI_BOLD` and heavier fall back to synthetic bold.


## Coffee
If this project help you reduce time to develop, you can give me a cup of coffee :) 

<a href="https://www.buymeacoffee.com/muhammed96" target="_blank"><img src="https://cdn.buymeacoffee.com/buttons/v2/default-yellow.png" alt="Buy Me A Coffee" style="height: 60px !important;width: 217px !important;" ></a>


## 🔗 Links
<h3 align="center">Connect with me:</h3>
<div align="center">
  
[![image](https://img.shields.io/badge/website-D14836?style=for-the-badge&logo=web&logoColor=white)](https://www.muhammedelsami.com/)
[![image](https://img.shields.io/badge/Instagram-E4405F?style=for-the-badge&logo=instagram&logoColor=white)](https://instagram.com/muhammed_elsami)
[![YouTube](https://img.shields.io/badge/YouTube-%23FF0000.svg?style=for-the-badge&logo=YouTube&logoColor=white)](https://www.youtube.com/channel/UComlhYSCEga40FwSv8MjVsw)
[![image](https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:muhammed97r@hotmail.com)
[![image](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/muhammed-el%C5%9Fami/)
</div>

## License

[MIT](https://choosealicense.com/licenses/mit/)
<!--
[Apache Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html) 
-->


```
Copyright 2023 Muhammed Elşami

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.



