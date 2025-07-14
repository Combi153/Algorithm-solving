function solution(n, w, num) {
    const boxes = new Map();
    const maxLevel = Math.ceil(n / w);

    for (let i = 1; i <= maxLevel; i++) {
        boxes.set(i, []);
    }

    for (let i = 1; i <= n; i++) {
        const level = Math.ceil(i / w);
        const levelBoxes = boxes.get(level);
        levelBoxes.push(i)
    }

    for (let i = 1; i <= maxLevel; i++) {
        if (i === maxLevel) {
            const levelBoxes = boxes.get(i);
            if (levelBoxes.length < w) {
                const diff = w - levelBoxes.length;
                for (let j = 0; j < diff; j++) {
                    levelBoxes.push(0);
                }
            }
        }
        if (i % 2 === 0) {
            boxes.set(i, boxes.get(i).reverse());
        }
    }

    let targetIndex = 0;
    let targetLevel = 0;
    for (let i = 1; i <= maxLevel; i++) {
        const levelBoxes = boxes.get(i);
        if (levelBoxes.includes(num)) {
            targetIndex = levelBoxes.indexOf(num);
            targetLevel = i;
            break;
        }
    }

    if (boxes.get(maxLevel)[targetIndex] === 0) {
        return maxLevel - targetLevel;
    }
    return maxLevel - targetLevel + 1;
}

console.log(solution(22, 6, 8));
console.log(solution(13, 3, 6));