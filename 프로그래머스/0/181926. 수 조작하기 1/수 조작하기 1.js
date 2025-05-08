function solution(n, control) {
    for (c of control) {
    switch (c) {
        case "w" :
            n += 1;
            break;
        case "s" :
            n -= 1;
            break;
        case "d" :
            n += 10;
            break;
        case "a" :
            n -= 10;
            break;
        }
    }
    return n;
}