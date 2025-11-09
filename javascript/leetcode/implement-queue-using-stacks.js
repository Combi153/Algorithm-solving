
var MyQueue = function() {
    stack = [];
    reverseStack = [];
};

/** 
 * @param {number} x
 * @return {void}
 */
MyQueue.prototype.push = function(x) {
    if (stack.length !== reverseStack.length) {
        const length = reverseStack.length;
        for(let i = 0; i < length; i++) {
                stack.push(reverseStack.pop());
            }
    } 
    stack.push(x);
};

/**
 * @return {number}
 */
MyQueue.prototype.pop = function() {
    if (stack.length !== reverseStack.length) {
        const length = stack.length;
        for(let i = 0; i < length; i++) {
         reverseStack.push(stack.pop());
        }
    }
    
    return reverseStack.pop();
};

/**
 * @return {number}
 */
MyQueue.prototype.peek = function() {
    if (stack.length !== reverseStack.length) {
        const length = stack.length;
        for(let i = 0; i < length; i++) {
            const popValue = stack.pop();
            reverseStack.push(popValue);
        }
    }
    return reverseStack[reverseStack.length - 1];
};

/**
 * @return {boolean}
 */
MyQueue.prototype.empty = function() {
    return reverseStack.length === 0 && stack.length === 0;
};

/** 
 * Your MyQueue object will be instantiated and called as such:
 * var obj = new MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */