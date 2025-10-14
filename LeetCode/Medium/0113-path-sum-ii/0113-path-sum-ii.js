/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} targetSum
 * @return {number[][]}
 */
var pathSum = function(root, targetSum) {
    if(!root) return []
    
    if(!root.left && !root.right && targetSum === root.val){
        return [[root.val]]
    }
    const remain = targetSum - root.val
    const left = pathSum(root.left, remain)
    const right = pathSum(root.right, remain)

    const allPaths = []

    for(const path of left){
        allPaths.push([root.val, ...path])
    }

    for(const path of right){
        allPaths.push([root.val, ...path])
    }

    return allPaths
};