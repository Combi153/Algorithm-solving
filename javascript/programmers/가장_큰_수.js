function solution(numbers) {
    const answer = numbers.map((number) => String(number)).sort((a, b) => (b + a).localeCompare(a + b)).join('')
    return answer[0] === '0' ? '0' : answer;
}

console.log(solution([6, 10, 2]));
console.log(solution([3, 30, 31, 310, 333, 303, 34, 5, 9]));
console.log(solution([3, 30, 34, 5, 9]));
console.log(solution([1000, 199, 109, 101]))