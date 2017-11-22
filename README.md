# ProcessCleaner

Цель:

Предоставить пользователю консольный интерфейс для удаления доступных процессов,
потребляющих слишком много процессорных ресурсов.


Функциональные требования:

- При запуске программа должна выводить список процессов, видимых открытому приложению. 
- Список должен быть отсортирован по убыванию потребляемости процессорного времени,
и содержать лишь максимум 10 наиболее значимых элементов.
- Формат вывода следующий: %pid% %Путь_процесса% [%cputime%]
- После вывода списка пользователь должен ввести через запятую pid процессов, которые необходимо завершить.
- Приложение после пользовательской команды должно вывести строку: "Следующие процессы успешно завершены",
и далее перечислить pid успешно завершенных процессов. Если возникли ошибки, то также вывести строку 
"Не удалось завершить следующие процессы: " и соответственно перечислить их айдишники.



Технические рекомендации:

- Готовый код предлагать в качестве пул-реквеста (PR) в https://github.com/Generalus/ProcessCleaner
- Использовать Maven-проект с Java 9.
- Обратить внимание на возможности нового Process API Java 9.
- Желательно использовать Stream API.
- Тестами код покрывать необязательно.

https://www.javaworld.com/article/3176874/java-language/java-9s-other-new-enhancements-part-3.html