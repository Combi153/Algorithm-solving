function solution(w, h) {
    const x = Math.max(w, h);
    const y = Math.min(w, h);

    let gcd = 0;
    for (let i = y; i >= 1; i--) {
        if (x % i === 0 && y % i === 0) {
            gcd = i;
            break;
        }
    }

    const xx = x / gcd;
    const yy = y / gcd;
    const zz = xx - 1 + yy - 1 + 1;

    return x * y - (zz * gcd);
}

console.log(solution(8, 12));