# -*- coding: utf-8 -*-
__autor__ = "Francesco"
__version__ = "0101 2020/10/12"

import glob
import shutil

from inizializza import *


def rotate(lista: list, n):
    return lista[n:] + lista[:n]


boold = True
if __name__ == "__main__":
    if boold:
        print("Start")

    head, tail = os.path.split(__file__)
    os.chdir(head)
    percorso = os.getcwd()

    vettFile = glob.glob('*.java')
    for f in vettFile:
        headerMd = "# Program name: " + f + "\n" + \
                   "---\n" + \
                   "\n" + \
                   "## Consegna\n _________________"

        projectName = (f.split("."))[0]
        exist, perBin, perDoc = cartelle(projectName)

        filejava = open(perDoc + "//README.md", "w")
        filejava.write(headerMd)
        filejava.close()

        fjava = open(f, "r")
        vRighe = fjava.readlines()
        fjava.close()

        vRighe.append("package " + "demartini_F_" + projectName + ".bin;\n\n")
        vRighe = rotate(vRighe, -1)

        fjava = open(f, "w")
        fjava.writelines(vRighe)
        fjava.close()

        shutil.move(percorso + "\\" + f, perBin)

    if boold:
        print("End")
