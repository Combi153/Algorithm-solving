function solution(schedules, timelogs, startday) {
    const weekends = new Map([[1, [5, 6]], [2, [4, 5]], [3, [3, 4]], [4, [2, 3]], [5, [1, 2]], [6, [0, 1]], [7, [0, 6]]]);
    const weekend = weekends.get(startday);
    let count = 0;

    for (let i = 0; i < schedules.length; i++) {
        const schedule = schedules[i];
        const logs = timelogs[i];

        const sTime = Math.floor(schedule / 100);
        const sMin = schedule % 100;

        let cMin = sMin + 10;
        let cTime = sTime;
        if (cMin >= 60) {
            cMin -= 60;
            cTime += 1;
        }
        let cCount = 0;

        for (let j = 0; j < logs.length; j++) {
            if (weekend.includes(j)) {
                continue;
            }

            const log = logs[j];
            let lMin = (log % 100);
            let lTime = Math.floor(log / 100);


            if (cTime > lTime || (cTime === lTime && cMin >= lMin)) {
                cCount++;
            }
        }
        if (cCount === 5) {
            count++;
        }
    }

    return count;
}

console.log(solution([700, 800, 1100], [[710, 2359, 1050, 700, 650, 631, 659], [800, 801, 805, 800, 759, 810, 809], [1105, 1001, 1002, 600, 1059, 1001, 1100]], 5))