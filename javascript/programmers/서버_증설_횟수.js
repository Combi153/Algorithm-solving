class ServerHistory {
    constructor(life, count, isCurrent) {
        this.life = life;
        this.count = count;
        this.isCurrent = isCurrent;
    }

    plusLife() {
        this.life++;
    }

    turnOff() {
        this.isCurrent = false;
    }
}

function solution(players, m, k) {
    let x = 0;
    const histories = [];
    for (let i = 0; i < players.length; i++) {
        const playerCount = players[i];

        for (let history of histories) {
            history.plusLife();
            if (history.life > k && history.isCurrent) {
                x -= history.count;
                history.turnOff();
            }
        }

        const need = Math.floor(playerCount / m);
        if (need > x) {
            histories.push(new ServerHistory(1, need - x, true))
            x += need - x;
        }
    }
    let sum = 0;
    for (let history of histories) {
        sum += history.count;
    }
    return sum;
}

console.log(solution([0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5], 3, 5));
console.log(solution([0, 0, 0, 10, 0, 12, 0, 15, 0, 1, 0, 1, 0, 0, 0, 5, 0, 0, 11, 0, 8, 0, 0, 0], 5, 1));
console.log(solution([0, 0, 0, 0, 0, 2, 0, 0, 0, 1, 0, 5, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1], 1, 1));