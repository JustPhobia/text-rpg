# text-rpg

A small text-based dungeon RPG: meet an NPC, then fight the boss **Lucy** in a
turn-based battle (attack / heal / items). Object-oriented design across
characters, items, inventory and a combat system.

> Built within my first ~4–5 months of learning Java (a coding course). Kept as a record of progress, not as polished production code.

## Run
```bash
find src -name '*.java' | xargs javac -d out
java -cp out Dungeons.GameEngine.GameRun
```
Follow the numbered menus. A fight ends in victory or defeat, then the program
exits.

## What was fixed to make it run
It had no entry point and did not compile. Added a `main`, made the combat loop
end when either side hits 0 HP, made the boss's turn logic actually run
(override, not overload), gave the player starting items, and guarded menu input
against non-numeric entries.

## Known limits
- The player's healing potions are never consumed (you can out-heal the boss).
- Feeding an exhausted input stream mid-fight throws `NoSuchElementException`
  (only reachable via piped input, not normal play).
