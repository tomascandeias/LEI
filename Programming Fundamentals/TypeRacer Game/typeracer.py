import time
import os

def fileSetUp(fname):
    s = ""
    with open(fname) as f:
        for line in f:
          s += line
    return s

def spacer():
    print(50*"-")
    print()

def race(phrase):
    spacer()
    print(phrase)

    # SAVE PHRASE INTO A LIST OF WORDS
    wordLst = phrase.split()

    #  RACER ITSELF
    start = time.time()
    wrotedWords = 0
    for s in wordLst:
        wrotedWords = askStr(s, wrotedWords)

    duration = float(time.time() - start) #total time

    # DISPLAY THE FINAL RESULTS
    print("\n{:^100}".format("--->FINAL RESULTS<---"))

    print("Time elapsed: {:.2f}s".format(duration))  # duration in seconds

    acc = ((wrotedWords * 100) / len(wordLst)) -100
    print("Accuracy: {:.1f}%".format(100-acc))  # accuracy %

    wps = len(wordLst) / float(duration)
    print("WPS: {:.2f} words per second".format(wps))   # WPS = words per second

    wpm = wps*60
    print("WPM: {:.2f} words per minute".format(wpm))    # WPM = words per minute


def askStr(palavra, wroted_words):

    while True:
        wroted_input = str(input("--> {} : ".format(palavra)))  # --> {palavra} :
        wroted_words += 1

        if wroted_input != palavra:  # TYPE ERROR
            while True:
                wroted_input = str(input("-->False, {} : ".format(palavra)))
                wroted_words += 1

                if wroted_input == palavra:
                    break
            break  # exit while True
        else:  # wroted_input == palavra
            break

        break  # exit while True

    return wroted_words


def main():
    print("--->WELCOME TO THE TYPERACER<--")
    while True:
        try:
            fname = str(input("File name: "))
            if (fname[len(fname)-4:len(fname)]) == ".txt":
                text = fileSetUp(fname)
                break
        except FileNotFoundError:
            print("File not found, please enter a valid file name")
    race(text)

main()