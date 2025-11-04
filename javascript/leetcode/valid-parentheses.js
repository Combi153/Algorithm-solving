/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    const stack = [];
    const brackets = {
        '(': ')',
        '{': '}',
        '[': ']'
    }
    for(let i = 0; i < s.length; i++) {
        const char = s[i];
        if (Object.keys(brackets).includes(char)) {
            stack.push(char);
            continue;
        }
        if (stack.length === 0 || brackets[stack.pop()] !== char) {
            return false;
        }
    }
    return stack.length === 0;
};

console.log('123'[0]);