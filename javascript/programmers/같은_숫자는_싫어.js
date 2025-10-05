function solution(arr) {
  const answer = [arr[0]];
  let lastIndex = 0;
  for(let i = 1; i < arr.length; i++) {
    if (answer.at(-1) === arr[i]) {
      continue;
    }
    lastIndex += 1;
    answer.push(arr[i]);
  }
  return answer;
}
