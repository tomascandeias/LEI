# Exercise 5 on "How to think...", ch. 11.

import turtle

t = turtle.Turtle()

# Use t.up(), t.down() and t.goto(x, y)

# Put your code here

#Ler ficheiro
with open("mystery.txt", "r") as cmds:
    for line in cmds:
        if line == "UP\n":
            t.up()
        elif line == "DOWN\n":
            t.down()
        else:
            t.goto(int(line.split()[0]), int(line.split()[1]))


#wait
turtle.Screen().exitonclick()
