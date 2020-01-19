import os

def listSizes(folder_dir="./"):
    print("{:<30}{:>16}".format("File", "Size"))
    for f in os.listdir(folder_dir):
        print("{:<30}{:>16}".format(f, os.stat(f).st_size))

listSizes()
