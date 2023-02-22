## Лабораторная работа №5 по дисциплине «Программирование»
</p>
<p align="left">Преподаватель: <strong>Райла Мартин</strong></br>
Вариант 125610</strong></br>
Выполнили: <strong>Соколов Андрей и Соколова Анастасия</strong></br>
Группа: <strong>O3143</strong>
</p>

## Задание:

Реализовать консольное приложение, которое реализует управление коллекцией объектов в интерактивном режиме. В коллекции необходимо хранить объекты класса Dragon, описание которого приведено ниже.

## Разработанная программа должна удовлетворять следующим требованиям:

1. Класс, коллекцией экземпляров которого управляет программа, должен реализовывать сортировку по умолчанию.
2. Все требования к полям класса (указанные в виде комментариев) должны быть выполнены.
3. Для хранения необходимо использовать коллекцию типа java.util.LinkedHashSet
4. При запуске приложения коллекция должна автоматически заполняться значениями из файла.
5. Имя файла должно передаваться программе с помощью: аргумент командной строки.
6. Данные должны храниться в файле в формате csv
7. Чтение данных из файла необходимо реализовать с помощью класса java.util.Scanner
8. Запись данных в файл необходимо реализовать с помощью класса java.io.PrintWriter
9. Все классы в программе должны быть задокументированы в формате javadoc.
10. Программа должна корректно работать с неправильными данными (ошибки пользовательского ввода, отсутсвие прав доступа к файлу и т.п.).
11. В интерактивном режиме программа должна поддерживать выполнение следующих команд:

## Команды:

1. help : вывести справку по доступным командам
2. info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
3. show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении
4. add {element} : добавить новый элемент в коллекцию
5. update id {element} : обновить значение элемента коллекции, id которого равен заданному
6. remove_by_id id : удалить элемент из коллекции по его id
7. clear : очистить коллекцию
8. save : сохранить коллекцию в файл
9. execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
10. exit : завершить программу (без сохранения в файл)
11. add_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции
12. remove_greater {element} : удалить из коллекции все элементы, превышающие заданный
13. remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный
14. max_by_head : вывести любой объект из коллекции, значение поля head которого является максимальным
15. count_by_head head : вывести количество элементов, значение поля head которых равно заданному
16. print_ascending : вывести элементы коллекции в порядке возрастания

## Формат ввода команд:

1. Все аргументы команды, являющиеся стандартными типами данных (примитивные типы, классы-оболочки, String, классы для хранения дат), должны вводиться в той же строке, что и имя команды.
2. Все составные типы данных (объекты классов, хранящиеся в коллекции) должны вводиться по одному полю в строку.
3. При вводе составных типов данных пользователю должно показываться приглашение к вводу, содержащее имя поля (например, "Введите дату рождения:")
4. Если поле является enum'ом, то вводится имя одной из его констант (при этом список констант должен быть предварительно выведен).
5. При некорректном пользовательском вводе (введена строка, не являющаяся именем константы в enum'е; введена строка вместо числа; введённое число не входит в указанные границы и т.п.) должно быть показано сообщение об ошибке и предложено повторить ввод поля.
6. Для ввода значений null использовать пустую строку.
7. Поля с комментарием "Значение этого поля должно генерироваться автоматически" не должны вводиться пользователем вручную при добавлении.
