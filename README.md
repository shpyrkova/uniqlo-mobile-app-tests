# Запуск тестов
***
Для запуска тестов локально на реальном девайсе запустить команду:
```shell
gradle test -DdeviceHost=real
```
***
Для запуска тестов локально на эмуляторе запустить команду:
```shell
gradle test -DdeviceHost=emulation
```
***
Для запуска тестов в Browserstack запустить команду:
```shell
gradle test -DdeviceHost=browserstack
```
***
При запуске по кнопке в IDEA (или когда deviceHost не указан), тесты по умолчанию запускаются в Browserstack.