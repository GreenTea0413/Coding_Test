var romanToInt = function(s) {
    const map = new Map([
        ["I", 1], ["V", 5], ["X", 10], ["L", 50],
        ["C", 100], ["D", 500], ["M", 1000]
    ]);

    let total = 0;
    for (let i = 0; i < s.length; i++) {
        const cur = map.get(s[i]);
        const next = map.get(s[i + 1]);

        if (next > cur) {
            total += next - cur;
            i++;
        } else {
            total += cur;
        }
    }
    return total;
};