/**
 * @param {number[][]} rooms
 * @return {boolean}
 */
var canVisitAllRooms = function(rooms) {
    const answer = true

    const len = rooms.length
    const visited = Array.from({length : len}, () => false)

    const queue = []
    queue.push(0)
    visited[0] = true

    while(queue.length > 0){
        var r = queue.pop();
        visited[r] = true

        for(const room of rooms[r]){
            if(!visited[room]) queue.push(room)
        }
    }

    for(let i = 0; i < len; i++){
        if(!visited[i]) return false
    }
    return answer
};