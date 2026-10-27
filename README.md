# RPG de Batalha (Java)

Trabalho de POO I. Jogo de terminal com batalhas por turnos.

## Como rodar

No Codespaces (ou em qualquer PC com Java 17+), no terminal:

```bash
./jogar.sh
```

Sem o script:

```bash
javac -encoding UTF-8 -d out src/*.java
java -cp out Main
```

## Quem faz o quê

| Membro | Arquivo(s) |
|---|---|
| 1 | `Personagem.java` |
| 2 | `Guerreiro.java`, `Mago.java`, `Arqueiro.java` |
| 3 | `Inimigo.java` |
| 4 | `Batalha.java` |
| 5 | `Main.java` + README |

Procure por `TODO` no seu arquivo: é o que falta fazer.
Não mude os **nomes dos métodos** sem avisar o grupo, porque os outros dependem deles.

## Regras do jogo

- Dano = ataque + sorteio (0 a 5) - defesa / 2, no mínimo 1.
- Mana: começa com 50, o especial custa 20, regenera +10 por turno.
- Especiais: Guerreiro 40, Mago 50, Arqueiro 25 + 25.
- Poção cura 30 de vida; todos começam com 3.
- Fugir: 50% de chance. Se falhar, o inimigo ataca.
- Inimigos: Goblin (50 HP, ataque 10, 50 XP), Orc (90, 18, 80 XP), Dragão (200, 30, 200 XP).
- Sobe de nível a cada 100 XP: +20 de vida máxima e +5 de ataque.
- Se o jogador morrer, volta ao menu sem personagem. Vencer o Dragão termina o jogo.

## Git (resumo)

```bash
git pull                              # antes de começar
git add .
git commit -m "Implementa Inimigo"
git push                              # depois de terminar
```

Cada um mexe só no seu arquivo, assim não há conflito.
