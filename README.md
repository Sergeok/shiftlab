# ShiftLab
 
### Тестовое задание.
### Back-End.

Для успешного участия в проектах лаборатории, требуется подтвердить минимальные знания и навыки в выбранной вами области. Для этого просим выполнить тестовое задание.

### Постановка задачи

Магазин, торгующий компьютерами и комплектующими со следующим типом товаров:
* Настольные компьютеры
* Ноутбуки
* Мониторы
* Жесткие диски

Каждый товар имеет следующие свойства:
* номер серии
* производитель
* цена
* количество единиц продукции на складе

Дополнительные свойства:
* Настольные компьютеры имеют форм-фактор: десктопы, неттопы, моноблоки
* Ноутбуки подразделяются по размеру: 13, 14, 15, 17 дюймовые
* Мониторы имеют диагональ
* Жесткие диски имеют объем

Необходимо реализовать back-end приложение, которое имеет RESTful HTTP методы выполняющие:
1) Добавление товара
2) Редактирование товара.
3) Просмотр всех существующих товаров по типу
4) Просмотр товара по идентификатору

Требования к реализации
1) Реализация должна быть выполнена на языке Java
2) В качестве базы данных использовать PostgreSQL с использованием инструмента Flyway

Передача решения
Результат тестового задания должен включать инструкцию по сборке, настройке, конфигурированию и развертыванию приложения (если необходимо), только программный код.

---

### Решение

Для сборки из исходников необходимо в директории проекта ввести следующую команду:
```
mvn package spring-boot:repackage
```
Для запуска необходимо в директории target ввести команду с сопутствующими параметрами:
```
java -jar shiftlab-1.0-SNAPSHOT.jar --spring.datasource.url=<JDBC URL of the database> --spring.datasource.username=<username of the database> --spring.datasource.password=<password of the database>
```

Json-формат всех свойств товаров описан следующим образом:
```
"id":             <bigserial>
"serialNumber":   <int8>
"manufacturer":   "<varchar(255)>"
"price":          <int8>
"unitsInStock":   <int8>

"formFactor":     <int4>
"screenDiagonal": <int4>
"diagonal"        <int8>
"capacity":       <int8>
```

На задаваемые свойства накладываются следующие ограничения:
* serialNumber не может повторяться в пределах продукции одного типа
* formFactor описан перечислением и ограничен вариациями чисел от 0 до 2 (десктопы, неттопы, моноблоки)
* screenDiagonal также описана перечислением и ограничена вариациями чисел от 0 до 3 (13, 14, 15, 17 дюймовые соответственно)
* id задается автоматически и, если не опущен, будет проигнорирован в запросах отличных от поиска по id.

Post-запросы на добавление товаров обрабатываются по адресам:
* http://localhost:8080/api/pc/add
* http://localhost:8080/api/laptop/add
* http://localhost:8080/api/monitor/add
* http://localhost:8080/api/hdd/add

Пример тела такого рода запроса на адрес "http://localhost:8080/api/pc/add":
```
{
    "serialNumber": 123,
    "manufacturer": "Manufactore Company",
    "price": 220,
    "unitsInStock": 1803,
    "formFactor": 1
}
```

Get-запросы на получение списка товаров по типу, а также Post-запросы на поиск товаров по одному из его свойств обрабатываются по адресам:
* http://localhost:8080/api/pc/all
* http://localhost:8080/api/laptop/all
* http://localhost:8080/api/monitor/all
* http://localhost:8080/api/hdd/all

Пример тела Post-запроса на адрес "http://localhost:8080/api/laptop/all":
```
{
    "manufacturer": "IDK Company"
}
```

Post-запросы на поиск товаров по серийному номеру или id в базе обрабатываются по адресам:
* http://localhost:8080/api/pc/find
* http://localhost:8080/api/laptop/find
* http://localhost:8080/api/monitor/find
* http://localhost:8080/api/hdd/find

Пример тела Post-запроса на адрес "http://localhost:8080/api/monitor/find":
```
{
    "serialNumber": 123
}
```

Post-запросы на изменение товара по серийному номеру обрабатываются по адресам:
* http://localhost:8080/api/pc/update
* http://localhost:8080/api/laptop/update
* http://localhost:8080/api/monitor/update
* http://localhost:8080/api/hdd/update

Пример тела Post-запроса на адрес "http://localhost:8080/api/hdd/update":
```
{
    "serialNumber": 123,
    "manufacturer": "Other Company name",
    "unitsInStock": 123
}
```
Опущенные свойства товара будут оставлены без изменений
