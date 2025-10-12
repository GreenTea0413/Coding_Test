/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */
var lowestCommonAncestor = function dfs(root, p, q) {
    if(root === null || root === p || root === q) return root

    const left = dfs(root.left, p ,q)
    const right = dfs(root.right, p, q)

    if(left !== null && right !== null) return root

    return left !== null ? left : right
};