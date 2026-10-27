#!/usr/bin/env bash
# Compila tudo e roda o jogo. Uso: ./jogar.sh
cd "$(dirname "$0")"
rm -rf out && mkdir out
javac -encoding UTF-8 -d out src/*.java && java -cp out Main
