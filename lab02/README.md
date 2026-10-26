# Лабораторная работа 2: Классы и инкапсуляция

Условие: [`assignments/lab02-domain-model.md`](../assignments/lab02-domain-model.md).

Из корня репозитория запустите:

```bash
./mvnw -pl lab02 test
```

Windows PowerShell: `.\\mvnw.cmd -pl lab02 test`.

Основной код размещайте в `src/main/java/edu/course/lab02/`, тесты — в `src/test/java/edu/course/lab02/`. В начале каждого Java-файла укажите `package edu.course.lab02;`.

Модуль независим от остальных лабораторных. Если нужны модели из предыдущей работы, перенесите и при необходимости адаптируйте только нужные классы в этот модуль. Начальная успешная сборка не является выполнением задания: создайте реализацию и собственные тесты по условию.

## Вариант

Обязательная часть выполнена по направлению «Программная инженерия»: класс `ProjectTask`.

## Инварианты

### BankAccount

- Баланс всегда неотрицателен: `balance >= 0`.
- Начальный баланс не может быть отрицательным.
- `deposit(amount)` принимает только `amount > 0`; переполнение `int` запрещено.
- `withdraw(amount)` принимает только `0 < amount <= balance`.
- Баланс меняется только через `deposit` и `withdraw`; публичного setter нет.

### ProjectTask

- `id` и `title` не равны `null`, не пусты и не состоят только из пробелов.
- `estimatedHours > 0`.
- `status` не равен `null` и меняется только через `changeStatus`.
- Начальный статус задачи — `TaskStatus.NEW`.
- Задача считается завершенной, когда `status == TaskStatus.DONE`.
- `increaseEstimatedHours(extraHours)` принимает только `extraHours > 0`; переполнение `int` запрещено.
- Поля класса `private`; сеттеров нет. `id` и `title` неизменяемы (`final`).
