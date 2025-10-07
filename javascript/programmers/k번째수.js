function solution(array, commands) {
    const answer = [];
    for (let i = 0; i < commands.length; i++) {
        const [start, end, k] = commands[i];

        const target = array.slice(start - 1, end).sort((a, b) => a - b)[k - 1];

        answer.push(target);
    }
    return answer;
}