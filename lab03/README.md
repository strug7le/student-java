# Лабораторная работа 3: Интерфейсы и полиморфизм

Условие: [`assignments/lab03-polymorphism.md`](../assignments/lab03-polymorphism.md).

Из корня репозитория запустите:

```bash
./mvnw -pl lab03 test
```

Windows PowerShell: `.\\mvnw.cmd -pl lab03 test`.

Основной код размещайте в `src/main/java/edu/course/lab03/`, тесты — в `src/test/java/edu/course/lab03/`. В начале каждого Java-файла укажите `package edu.course.lab03;`.

Модуль независим от остальных лабораторных. Если нужны модели из предыдущей работы, перенесите и при необходимости адаптируйте только нужные классы в этот модуль. Начальная успешная сборка не является выполнением задания: создайте реализацию и собственные тесты по условию.

## Вариант

Обязательная часть выполнена по направлению «Программная инженерия»: `PriorityPolicy`, `EffortPriorityPolicy`, `StatusPriorityPolicy`, `TaskPrioritizer`.

## Контракты и решения

### Скидки

- `DiscountPolicy.apply(price)` принимает только конечную неотрицательную цену.
- `NoDiscount` возвращает исходную цену.
- `PercentDiscount` принимает процент от 0 до 100 включительно и считает `price * (100 - percent) / 100`.
- `PriceCalculator` хранит `DiscountPolicy` в поле интерфейсного типа и получает реализацию через конструктор.

### Приоритеты

- `PriorityPolicy.calculatePriority(task)` возвращает приоритет: большее значение означает более высокий приоритет.
- `EffortPriorityPolicy` использует `estimatedHours`: больше часов — выше приоритет.
- `StatusPriorityPolicy` отображает статусы: `IN_PROGRESS` → 2, `NEW` → 1, `DONE` → 0.
- `TaskPrioritizer` хранит `PriorityPolicy` в поле интерфейсного типа и при равном приоритете возвращает первую задачу.
- `ProjectTask` — сокращенная модель из ЛР 2: `id`, `title`, `status`, `estimatedHours`; поля приватные, сеттеров нет.

## Полиморфизм

`PriceCalculator` и `TaskPrioritizer` не знают конкретных реализаций политик: они работают с `DiscountPolicy` и `PriorityPolicy`. Замена реализации выполняется передачей другого объекта в конструктор, без `instanceof`, имен классов и изменения обработчиков.
