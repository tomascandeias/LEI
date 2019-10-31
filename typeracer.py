import time

def race(phrase):
    print(phrase)

    # SAVE PHRASE INTO A LIST OF WORDS
    wordLst = phrase.split()

    #  RACER ITSELF
    start = time.time()
    wrotedWords = 0
    for s in wordLst:
        wrotedWords += askStr(s)

    # DISPLAY THE FINAL RESULTS
    duration = float(time.time() - start)
    print("Time elapsed: {:.2f}s".format(duration))  # duration in seconds

    # wrotedWords  --- 100%
    # len(wordLst) --- x
    acc = (len(wordLst) * 100) / wrotedWords
    print("Accuracy: {:.1f}%".format(acc))  # accuracy %

    wps = len(wordLst) / float(duration)    # WPS = words per second
    print("WPS: {:.2f} ".format(wps))   # time elapsed
    wpm = wps*60
    print("WPM: {:.2f}".format(wpm))    # WPM = words per minute


def askStr(palavra):
    wroted_words = 1
    while True:
        wroted_input = str(input("--> {} : ".format(palavra)))  # --> {palavra} :

        if wroted_input != palavra:  # TYPE ERROR
            while True:
                print("\033[A                             \033[A")  # clear last output line
                wroted_input = str(input("-->False, {} : ".format(palavra)))
                wroted_words += 1

                if wroted_input == palavra:
                    print("\033[A                             \033[A")  # clear last output line
                    break
            break  # exit while True
        else:  # wroted_input == palavra
            print("\033[A                             \033[A")  # clear last output line
            wroted_words += 1

        break  # exit while True

    if wroted_words == 2:
        return wroted_words - 1
    else:
        return wroted_words

def main():
    print("--->WELCOME TO THE TYPERACER<--")
    race("I have a command line program")

main()