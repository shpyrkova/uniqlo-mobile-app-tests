## Описание проекта
В проекте реализованы автотесты на мобильное приложение Uniqlo для Android.

**Особенности проекта**:
- Использование `Owner` для придания тестам легкости конфигурации
- Возможность запуска тестов: локально (на эмуляторе или реальном устройстве), удаленно на Browserstack.
- Возможность запуска тестов напрямую из Allure TestOps
- Уведомление о результатах прохождения в Telegram
- По результатам прохождения автотестов генерируется Allure отчет. Содержание отчета:
    - Шаги теста
    - Скриншот экрана на последнем шаге
    - Видео выполнения автотеста (при запуске из Browserstack)

## Технологии и инструменты

<div align="center">
<a href="https://www.jetbrains.com/idea/"><img alt="InteliJ IDEA" height="50" src="media/logo/Idea.svg" width="50"/></a>
<a href="https://github.com/"><img alt="GitHub" height="50" src="media/logo/GitHub.svg" width="50"/></a>  
<a href="https://www.java.com/"><img alt="Java" height="50" src="media/logo/Java.svg" width="50"/></a>
<a href="https://gradle.org/"><img alt="Gradle" height="50" src="media/logo/Gradle.svg" width="50"/></a>  
<a href="https://junit.org/junit5/"><img alt="JUnit 5" height="50" src="media/logo/Junit5.svg" width="50"/></a>
<a href="https://selenide.org/"><img alt="Selenide" height="50" src="media/logo/Selenide.svg" width="50"/></a>
<a href="https://appium.io/"><img alt="Appium" height="50" src="media/logo/Appium.svg" width="50"/></a>
<a href="https://developer.android.com/studio"><img alt="Android Studio" height="50" src="media/logo/Android_Studio.svg" width="50"/></a>
<a href="https://www.browserstack.com/"><img alt="Browserstack" height="50" src="media/logo/Browserstack.png" width="50"/></a>
<a href="https://www.jenkins.io/"><img alt="Jenkins" height="50" src="media/logo/Jenkins.svg" width="50"/></a>
<a href="https://github.com/allure-framework/"><img alt="Allure Report" height="50" src="media/logo/Allure.svg" width="50"/></a>
<a href="https://qameta.io/"><img alt="Allure TestOps" height="50" src="media/logo/Allure_TO.svg" width="50"/></a>
<a href="https://telegram.org/"><img alt="Telegram" height="50" src="media/logo/Telegram.svg" width="50"/></a>
</div>

## Реализованные проверки
- [x] Поиск продукта в каталоге по названию
- [x] Добавление продукта в вишлист
- [x] Просмотр гайда по размерам товара

# Запуск тестов
## Запуск на Browserstack 
По умолчанию через кнопку в InteliJ IDEA тесты запускаются в Browserstack.<br>
Также тесты по умолчанию запускаются в Browserstack командой запуска без параметров:
```shell
gradle test 
```
Для запуска тестов на Browserstack используется демо-учетка Browserstack, которая имеет ограничение на суммарное время запусков. По истечении времени необходимо обновить учетную запись.</br>
## Локальный запуск 
Для запуска тестов локально нужно:
1. Запустить Appium Server и устройство, на котором будут выполняться тесты.
2. Обновить параметры устройства в файлах <code>resources/real.properties</code> или <code>resources/emulation.properties</code>.

Для запуска тестов локально на реальном девайсе запустить команду:
```shell
gradle test -Denv=real
```
***
Для запуска тестов локально на эмуляторе запустить команду:
```shell
gradle test -Denv=emulation
```
#### Построение Allure отчета после локального запуска

Команда для открытия отчета в браузере:
```
gradle allureServe
```
## Пример выполнения теста в Browserstack

> К результатам прогонов тестов, запущенных на Browserstack, прикладывается видео выполнения теста.
<p align="center">
  <img src="media/screencasts/test_screencast.gif"> 
</p>
