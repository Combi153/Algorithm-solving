function solution(bandage, health, attacks) {
    const [t, x, y] = bandage;
    const maxHealth = health;
    const [lastAttackTime, _] = attacks[attacks.length - 1];

    let attackIndex = 0;
    let bandageTime = 0;
    for (let i = 1; i <= lastAttackTime; i++) {
        const [time, damage] = attacks[attackIndex];
        if (time === i) {
            health -= damage;
            if (health <= 0) {
                return -1;
            }
            attackIndex++;
            bandageTime = 0;
            continue;
        }
        bandageTime++;
        if (bandageTime === t) {
            health += x + y;
            health = health > maxHealth ? maxHealth : health;
            bandageTime = 0;
            continue;
        }
        health += x;
        health = health > maxHealth ? maxHealth : health;
    }

    return health;
}