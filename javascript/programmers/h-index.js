function solution(citations) {
    citations.sort((a, b) => b - a)
    let h = 0;
    for (let i = 0; i < citations.length; i++) {
        const citation = citations[i];
        if (citation >= i + 1) {
            h++;
        }
    }

    return h;
}