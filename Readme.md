#Synchronized

Написать программу, приводящую к ситуации взаимной блокировки (deadlock).

В маленьком интернет кафе в деревне есть N компьютеров. Кафе работает по принципо FIFO,
т.е. когда все компьютеры заняты, то очередному желающему необходимо подождать.
В кафе приходит M туристов. Турист проводит за компьютером от 15 минут до 2 часов 
(время выбирается случайно). Напишите программу, которая имитирует порядок доступа 
к компьютерам в кафе и выводит журнал доступа на экран в процессе работы. 
Необходимо так выбрать масштаб для времени в имитации, чтобы время выполнение программы было меньше 3 минут.