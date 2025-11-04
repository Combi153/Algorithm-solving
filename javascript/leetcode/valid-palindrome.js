/**
 * @param {string} s
 * @return {boolean}
 */
var isPalindrome = function(s) {
    const cleanString = s.toLowerCase().replaceAll(/[^a-zA-Z0-9]/g, '');
    let bottom = 0;
    let top = cleanString.length - 1;

    while(bottom < top) {
        const bottomChar = cleanString[bottom];
        const topChar = cleanString[top];

        if (bottomChar.toLowerCase() !== topChar.toLowerCase()) {
            return false;
        }
        bottom++;
        top--;
    }
    return true;
};