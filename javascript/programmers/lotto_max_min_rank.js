function solution(lottos, win_nums) {
    let zero = 0;
    let match = 0;
    const rank = [6, 6, 5, 4, 3, 2, 1];

    for (let i = 0; i < lottos.length; i++) {
        const lotto = lottos[i];
        if (lotto === 0) {
            zero++;
            continue;
        }
        for (let j = 0; j < win_nums.length; j++) {
            const win_num = win_nums[j];
            if (lotto === win_num) {
                match++;
                break;
            }
        }
    }
    return [rank[zero + match], rank[match]];
}

console.log(solution([44, 1, 0, 0, 31, 25], [31, 10, 45, 1, 6, 19]));
console.log(solution([0, 0, 0, 0, 0, 0], [38, 19, 20, 40, 15, 25]));
console.log(solution([45, 4, 35, 20, 3, 9], [20, 9, 3, 45, 4, 35]));
console.log(solution([0, 0, 0, 0, 0, 0], [6, 5, 4, 3, 2, 1]));